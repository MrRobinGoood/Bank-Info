package ru.opencode.bankinfo.manuals.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ConfigPagination {
    private Integer countOfPages;
    private Long countOfItems;

}
