package ru.opencode.bankinfo.manuals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfigPagination {
    private Integer countOfPages;
    private Long countOfItems;

}
