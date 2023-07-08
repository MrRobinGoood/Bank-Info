package ru.opencode.bankinfo.messages.mapper;

import lombok.Data;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import ru.opencode.bankinfo.messages.dto.MessageDTO;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;

import java.util.List;
import java.util.Set;

public class MessageMapper {

    @Autowired
    private EntryMapper entryMapper;

    //MessageDTO messageToDTO(EMessageEntity message);

    public EMessageEntity DTOToMessage(MessageDTO dto){
        EMessageEntity message = new EMessageEntity(dto.getEdNo(), dto.getEdDate(), dto.getEdAuthor(),
                dto.getCreationReason(), dto.getCreationTime(), dto.getInfoTypeCode(), dto.getBusinessDay());
        message.setEMessageName(dto.getEMessageName());
        message.setEdReceiver(dto.getEdReceiver());

//        message.setAuditFields(dto.getAuditFields());

        message.setEntriesId(dto.getEntries().stream()
                .map(e -> entryMapper.DTOToEntry(e).getId())
                .toList());

        return message;
    };

    //List<MessageDTO> messagesToDTO(List<EMessageEntity> entities);

    //Set<MessageDTO> messagesToDTO(Set<EMessageEntity> entities);

    //void updateMessageFromDTO(MessageDTO dto, EMessageEntity entity);
}
