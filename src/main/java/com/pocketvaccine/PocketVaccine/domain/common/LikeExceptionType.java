package com.pocketvaccine.PocketVaccine.domain.common;

import lombok.Getter;

@Getter
public enum LikeExceptionType implements BaseExceptionType {
    CANNOT_FIND_HISTORY(3001, 200, "해당 글에 대한 좋아요 내역을 찾을 수 없습니다."),
    HISTORY_ALREADY_EXISTS(3002, 200, "이미 좋아요한 글입니다.");

    private int errorCode;
    private int httpStatus;
    private String errorMessage;

    LikeExceptionType (int errorCode, int httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

}
