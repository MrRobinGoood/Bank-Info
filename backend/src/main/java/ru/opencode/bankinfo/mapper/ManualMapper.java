package ru.opencode.bankinfo.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.opencode.bankinfo.dto.InfoDTO;
import ru.opencode.bankinfo.dto.ManualDTO;
import ru.opencode.bankinfo.entity.Info;
import ru.opencode.bankinfo.entity.Manual;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManualMapper {
    ManualDTO manualToDTO(Manual manual);

    Manual dtoToManual(ManualDTO manualDTO);

    List<ManualDTO> manualsToDTO(List<Manual> manuals);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateManualFromDTO(ManualDTO manualDTO, @MappingTarget Manual manual);
}
