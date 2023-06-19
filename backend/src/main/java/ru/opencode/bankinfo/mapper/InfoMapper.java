package ru.opencode.bankinfo.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.opencode.bankinfo.dto.InfoDTO;
import ru.opencode.bankinfo.entity.Info;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfoMapper {
    InfoDTO infoToDTO(Info info);
    Info dtoToInfo(InfoDTO infoDTO);
    List<InfoDTO> infosToDTO(List<Info> infos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInfoFromDTO(InfoDTO infoDTO, @MappingTarget Info info);
}
