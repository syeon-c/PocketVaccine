package com.pocketvaccine.PocketVaccine.domain.common;

import lombok.Getter;

public class FreeBoardException extends RuntimeException {

    @Getter
    private BaseExceptionType baseExceptionType;

    public FreeBoardException(BaseExceptionType baseExceptionType) {
        super(baseExceptionType.getErrorMessage());
        this.baseExceptionType = baseExceptionType;
    }
}
