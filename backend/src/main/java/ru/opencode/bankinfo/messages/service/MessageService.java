package ru.opencode.bankinfo.messages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opencode.bankinfo.core.exception.InvalidParametersException;
import ru.opencode.bankinfo.core.exception.NotFoundException;
import ru.opencode.bankinfo.messages.dto.MessageDTO;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;
import ru.opencode.bankinfo.messages.entity.Entry;
import ru.opencode.bankinfo.messages.mapper.MessageMapper;
import ru.opencode.bankinfo.messages.repository.EntryRepository;
import ru.opencode.bankinfo.messages.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private MessageMapper mapper;

    public EMessageEntity getMessageById(Long id) {
        return messageRepo.findById(id).orElseThrow(() -> new NotFoundException("Message not found"));
    }

    public List<EMessageEntity> getMessages() {
        return messageRepo.findAll();
    }

    public void createMessage(MessageDTO dto) {
        try {
            messageRepo.save(mapper.DTOToMessage(dto));
        } catch (RuntimeException e) {
            throw new InvalidParametersException("Invalid parameters for creating message");
        }
    }

    public void updateMessage(Long id, MessageDTO dto) {
        EMessageEntity message = getMessageById(id);
        mapper.updateMessageFromDTO(dto, message);
        messageRepo.save(message);
    }

    public void updateMessageName(Long id, String name){
        EMessageEntity message = getMessageById(id);
        message.setEMessageName(name);
        messageRepo.save(message);
    }

    public void deleteMessage(Long id) {
        EMessageEntity message = getMessageById(id);
        message.getAuditFields().setIsDeleted(true);
        messageRepo.save(message);
    }

    public void restoreMessage(Long id) {
        EMessageEntity message = getMessageById(id);
        message.getAuditFields().setIsDeleted(false);
        messageRepo.save(message);
    }

    public Entry getEntry(Long id) {
        return entryRepo.findById(id).orElseThrow(() -> new NotFoundException("Entry not found"));
    }

    public List<Entry> getEntriesByMessageId(Long id) {
        List<Long> entriesId = getMessageById(id).getEntriesId();
        return entriesId.stream().map(this::getEntry).toList();
    }
}
