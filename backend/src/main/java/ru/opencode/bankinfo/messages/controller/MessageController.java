package ru.opencode.bankinfo.messages.controller;

import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;
import ru.opencode.bankinfo.messages.entity.Entry;
import ru.opencode.bankinfo.messages.service.MessageService;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/emessages")
public class MessageController {

    @Autowired
    private MessageService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String getMessages() {
        return "{\"items\":[{\"id\":1,\"eMessageName\":\"NAME1\",\"fileUrl\":\"20230518_ED807_full.xml\",\"edNo\":1,\"edDate\":\"2023-05-17\",\"edAuthor\":4583001999,\"creationReason\":\"FCBD\",\"creationDateTime\":\"2023-05-17T18:31:47Z\",\"infoTypeCode\":\"FIRR\",\"businessDay\":\"2022-07-05\",\"isDeleted\":false,\"createdBy\":0,\"createDateTime\":\"2023-05-18T14:52:05Z\",\"changedBy\":0,\"changeDateTime\":\"2023-05-18T14:53:05Z\"},{\"id\":2,\"eMessageName\":\"NAME2\",\"fileUrl\":\"20230518_ED807_full.xml\",\"edNo\":1,\"edDate\":\"2023-05-17\",\"edAuthor\":4583001999,\"creationReason\":\"FCBD\",\"creationDateTime\":\"2023-05-17T18:31:47Z\",\"infoTypeCode\":\"FIRR\",\"businessDay\":\"2022-07-05\",\"isDeleted\":false,\"createdBy\":0,\"createDateTime\":\"2023-05-18T14:52:05Z\",\"changedBy\":0,\"changeDateTime\":\"2023-05-18T14:53:05Z\"},{\"id\":3,\"eMessageName\":\"NAME3\",\"fileUrl\":\"20230518_ED807_full.xml\",\"edNo\":1,\"edDate\":\"2023-05-17\",\"edAuthor\":4583001999,\"creationReason\":\"FCBD\",\"creationDateTime\":\"2023-05-17T18:31:47Z\",\"infoTypeCode\":\"FIRR\",\"businessDay\":\"2022-07-05\",\"isDeleted\":false,\"createdBy\":0,\"createDateTime\":\"2023-05-18T14:52:05Z\",\"changedBy\":0,\"changeDateTime\":\"2023-05-18T14:53:05Z\"},{\"id\":4,\"eMessageName\":\"NAME4\",\"fileUrl\":\"20230518_ED807_full.xml\",\"edNo\":1,\"edDate\":\"2023-05-17\",\"edAuthor\":4583001999,\"creationReason\":\"FCBD\",\"creationDateTime\":\"2023-05-17T18:31:47Z\",\"infoTypeCode\":\"FIRR\",\"businessDay\":\"2022-07-05\",\"isDeleted\":false,\"createdBy\":0,\"createDateTime\":\"2023-05-18T14:52:05Z\",\"changedBy\":0,\"changeDateTime\":\"2023-05-18T14:53:05Z\"}],\"config\":{\"countOfPages\":5,\"countOfItems\":50}}";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}")
    public void updateMessageName
            (
                    @PathVariable @Min(1) Long id,
                    @RequestBody String name
            ) {
        service.updateMessageName(id, name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteMessage(@PathVariable @Min(1) Long id) {
        service.deleteMessage(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}")
    public void restoreMessage(@PathVariable @Min(1) Long id) {
        service.restoreMessage(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/bics")
    public List<Entry> getEntries(@PathVariable @Min(1) Long id) {
        return service.getEntriesByMessageId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/xml")
    public void createMessage(
            @RequestPart("file") MultipartFile file
            ) throws JAXBException, IOException, ParserConfigurationException, SAXException {
        service.createMessageByXml(file);
    }
}
