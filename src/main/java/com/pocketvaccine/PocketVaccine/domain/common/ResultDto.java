package com.pocketvaccine.PocketVaccine.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResultDto<T> {

    private T data;

    private Paginate paginate;

    private String code;

    private String message;

    @Builder
    public ResultDto(T data, Paginate paginate, String code, String message) {

        this.data = data;
        this.paginate = paginate;
        this.code = code;
        this.message = message;

    }
}
