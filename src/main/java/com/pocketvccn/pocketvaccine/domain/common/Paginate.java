package com.pocketvccn.pocketvaccine.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Builder
@Getter
@Setter
public class Paginate {
    private long totalCount;

    private long page;

    private long size;

    public static <T> Paginate setPaginate(Page<T> page) {
        return Paginate.builder()
                .totalCount(page.getTotalElements())
                .size(page.getSize())
                .page(page.getNumber())
                .build();
    }
}
