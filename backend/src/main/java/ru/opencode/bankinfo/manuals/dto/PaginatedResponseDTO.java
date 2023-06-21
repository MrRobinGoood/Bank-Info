package ru.opencode.bankinfo.manuals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.opencode.bankinfo.manuals.entity.ConfigPagination;
import ru.opencode.bankinfo.manuals.entity.Manual;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginatedResponseDTO {

    private Object items;
    private Object config;
}
