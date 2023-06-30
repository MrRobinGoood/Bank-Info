package ru.opencode.bankinfo.manuals.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PaginatedResponseDTO {

    private Object items;
    private Object config;
}
