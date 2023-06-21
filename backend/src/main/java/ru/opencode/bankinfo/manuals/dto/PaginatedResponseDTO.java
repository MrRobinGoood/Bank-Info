package ru.opencode.bankinfo.manuals.dto;

import lombok.*;
import ru.opencode.bankinfo.manuals.entity.ConfigPagination;
import ru.opencode.bankinfo.manuals.entity.Manual;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PaginatedResponseDTO {

    private Object items;
    private Object config;
}
