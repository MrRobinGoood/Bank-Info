package ru.opencode.bankinfo.messages.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.opencode.bankinfo.messages.dto.MessageDTO;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageDTO messageToDTO(EMessageEntity message);

    EMessageEntity DTOToMessage(MessageDTO dto);

    List<MessageDTO> messagesToDTO(List<EMessageEntity> entities);

    Set<MessageDTO> messagesToDTO(Set<EMessageEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMessageFromDTO(MessageDTO dto, @MappingTarget EMessageEntity entity);
}
