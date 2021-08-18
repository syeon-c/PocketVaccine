package com.pocketvaccine.PocketVaccine.domain.common;

import lombok.Getter;

@Getter
public enum BoardExceptionType implements BaseExceptionType {
    NO_QUALIFICATION_USER(2001, 200, "권한없는 유저입니다."),
    NOT_MATCH_WRITER(2002, 200, "작성자만 수행가능한 작업입니다."),
    NOT_FOUND_CONTENTS(2003, 200, "존재하지 않는 게시글입니다.");

    private int errorCode;
    private int httpStatus;
    private String errorMessage;

    BoardExceptionType(int errorCode, int httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
