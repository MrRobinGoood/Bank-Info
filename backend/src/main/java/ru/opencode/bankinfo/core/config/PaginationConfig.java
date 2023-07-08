package ru.opencode.bankinfo.core.config;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PaginationConfig {
    private Integer countOfPages;
    private Long countOfItems;

}
