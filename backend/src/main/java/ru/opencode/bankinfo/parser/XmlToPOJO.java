package ru.opencode.bankinfo.parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.opencode.bankinfo.messages.dto.MessageDTO;
import ru.opencode.bankinfo.messages.dto.subDTO.AccountDTO;
import ru.opencode.bankinfo.messages.dto.subDTO.EntryDTO;
import ru.opencode.bankinfo.messages.dto.subDTO.SWBICDTO;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;


public class XmlToPOJO {
    public static Document getDocument(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(new File(path));
    }
    public static String documentToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public void deleteFile(LocalDate date) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedString = date.format(formatter);
        Path path = Path.of(String.format("src/main/resources/%s_ED807_full.xml", formattedString));
        Files.delete(path);
    }

    public static void unzip(final URL url, final Path decryptTo) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(Channels.newInputStream(Channels.newChannel(url.openStream())))) {
            for (ZipEntry entry = zipInputStream.getNextEntry(); entry != null; entry = zipInputStream.getNextEntry()) {
                Path toPath = decryptTo.resolve(entry.getName());
                if (entry.isDirectory()) {
                    Files.createDirectory(toPath);
                } else try (FileChannel fileChannel = FileChannel.open(toPath, WRITE, CREATE/*, DELETE_ON_CLOSE*/)) {
                    fileChannel.transferFrom(Channels.newChannel(zipInputStream), 0, Long.MAX_VALUE);
                }
            }
        }
    }

    public static void downoloadXML(LocalDate date) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedString = date.format(formatter);
        URL url = new URL(String.format("http://cbr.ru/vfs/mcirabis/BIKNew/%sED01OSBR.zip", formattedString));
        Path path = Path.of("backend/src/main/resources/xml_data");
        unzip(url, path);
    }

//    public static Object xmlToPOJO(LocalDate localDate, Class clazz) throws JAXBException, ParserConfigurationException, IOException, SAXException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        String formattedString = localDate.format(formatter);
//        Document document = getDocument("backend/src/main/resources/xml_data/20230629_ED807_full.xml");
//        String xml = documentToString(document);
//        StringReader reader = new StringReader(xml);
//
//        JAXBContext context = JAXBContext.newInstance(clazz);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        clazz message = (clazz) unmarshaller.unmarshal(reader);
//    }
    public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException, SAXException {
//        LocalDate localDate = LocalDate.now();
//        downoloadXML(localDate);
        Document document = getDocument("backend/src/main/resources/xml_data/20230629_ED807_full.xml");
        String xml = documentToString(document);
        StringReader reader = new StringReader(xml);

        JAXBContext context = JAXBContext.newInstance(EntryDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        EntryDTO message = (EntryDTO) unmarshaller.unmarshal(reader);
    }
}
