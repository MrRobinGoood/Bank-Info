package ru.opencode.bankinfo.messages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.opencode.bankinfo.exception.InvalidParametersException;
import ru.opencode.bankinfo.exception.NotFoundException;
import ru.opencode.bankinfo.messages.dto.MessageDTO;
import ru.opencode.bankinfo.messages.dto.subDTO.EntryDTO;
import ru.opencode.bankinfo.messages.entity.Account;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;
import ru.opencode.bankinfo.messages.entity.Entry;
import ru.opencode.bankinfo.messages.entity.SWBIC;
import ru.opencode.bankinfo.messages.mapper.MessageMapper;
import ru.opencode.bankinfo.messages.repository.AccountRepository;
import ru.opencode.bankinfo.messages.repository.EntryRepository;
import ru.opencode.bankinfo.messages.repository.MessageRepository;
import ru.opencode.bankinfo.messages.repository.SWBICSRepository;
import ru.opencode.bankinfo.parser.XmlToPOJO;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private MessageRepository messageRepo;
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private SWBICSRepository swbicsRepo;

    private final MessageMapper mapper = new MessageMapper();

    public EMessageEntity getMessageById(Long id) {
        return messageRepo.findById(id).orElseThrow(() -> new NotFoundException("Message not found"));
    }

    public List<EMessageEntity> getMessages() {
        return messageRepo.findAll();
    }


    public void createMessage(MessageDTO dto) {
        try {

            EMessageEntity message = mapper.DTOToMessage(dto);
            messageRepo.save(message);

            List<Entry> entries = createEntriesForMessage(dto, message);
            entryRepo.saveAll(entries);

            List<Account> accounts = new ArrayList<>();
            List<SWBIC> swbics = new ArrayList<>();
            for (Entry entry : entries) {
                if (entry.getAccounts() != null) {
                    accounts.addAll(entry.getAccounts());
                }
                if (entry.getSwbics() != null) {
                    swbics.addAll(entry.getSwbics());
                }
            }
            accountRepo.saveAll(accounts);
            swbicsRepo.saveAll(swbics);

            fillMessage(entries, message);
            messageRepo.save(message);
        } catch (RuntimeException e) {
            System.out.println(e);
            throw new InvalidParametersException("Invalid parameters for creating message");
        }
    }

    public void updateMessageName(Long id, String name) {
        EMessageEntity message = getMessageById(id);
        message.setEMessageName(name);
        messageRepo.save(message);
    }

    public void deleteMessage(Long id) {
        EMessageEntity message = getMessageById(id);
        message.setIsDeleted(true);
        messageRepo.save(message);
    }

    public void restoreMessage(Long id) {
        EMessageEntity message = getMessageById(id);
        message.setIsDeleted(false);
        messageRepo.save(message);
    }

    public Entry getEntry(Long id) {
        return entryRepo.findById(id).orElseThrow(() -> new NotFoundException("Entry not found"));
    }

    public List<Entry> getEntriesByMessageId(Long id) {
        List<Long> entriesId = getMessageById(id).getEntriesId();
        return entriesId.stream().map(this::getEntry).toList();
    }

    public void createMessageByXml(MultipartFile multifile) throws JAXBException, IOException, ParserConfigurationException, SAXException {
        File file = XmlToPOJO.convertMultipartFileToFile(multifile);
        Document document = XmlToPOJO.fileToDocument(file);
        MessageDTO dto = XmlToPOJO.xmlToPOJO(XmlToPOJO.documentToString(document));
        createMessage(dto);
    }

    private List<Entry> createEntriesForMessage(MessageDTO dto, EMessageEntity message) {
        Set<EntryDTO> entriesDTO = dto.getEntries();
        List<Entry> entries = new LinkedList<>();

        entriesDTO.stream().map(d -> mapper.DTOToEntry(d, message.getId())).forEach(entries::add);

        return entries;
    }

    private void fillMessage(List<Entry> entries, EMessageEntity message) {
        message.setEntriesId(entries.stream().map(Entry::getId).toList());
    }
}
