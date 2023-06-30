package ru.opencode.bankinfo.messages.controller;

import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;
import ru.opencode.bankinfo.messages.entity.Entry;
import ru.opencode.bankinfo.messages.service.MessageService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/emessages")
public class MessageController {

    @Autowired
    private MessageService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<EMessageEntity> getMessages() {
        return service.getMessages();
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
}
