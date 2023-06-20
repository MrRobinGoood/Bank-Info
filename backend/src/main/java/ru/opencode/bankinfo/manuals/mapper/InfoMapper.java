package ru.opencode.bankinfo.manuals.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.opencode.bankinfo.manuals.dto.InfoDTO;
import ru.opencode.bankinfo.manuals.entity.Info;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfoMapper {
    InfoDTO infoToDTO(Info info);
    Info dtoToInfo(InfoDTO infoDTO);
    List<InfoDTO> infosToDTO(List<Info> infos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInfoFromDTO(InfoDTO infoDTO, @MappingTarget Info info);
}
