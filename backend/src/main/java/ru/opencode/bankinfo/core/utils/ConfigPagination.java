package ru.opencode.bankinfo.core.utils;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ConfigPagination {
    private Integer countOfPages;
    private Long countOfItems;

}
