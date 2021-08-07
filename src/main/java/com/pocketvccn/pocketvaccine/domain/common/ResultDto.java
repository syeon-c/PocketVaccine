package com.pocketvccn.pocketvaccine.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class ResultDto<T> {
    private T data;

    private Paginate paginate;

    private String code;

    private String message;
}
