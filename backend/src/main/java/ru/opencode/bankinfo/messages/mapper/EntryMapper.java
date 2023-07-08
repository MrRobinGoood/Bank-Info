package ru.opencode.bankinfo.messages.mapper;

import org.mapstruct.Mapper;
import ru.opencode.bankinfo.messages.dto.subDTO.EntryDTO;
import ru.opencode.bankinfo.messages.entity.Entry;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    Entry DTOToEntry(EntryDTO dto);

    List<Entry> DTOToEntries(List<EntryDTO> dtoList);

    Set<Entry> DTOToEntries(Set<EntryDTO> dtoList);
}
