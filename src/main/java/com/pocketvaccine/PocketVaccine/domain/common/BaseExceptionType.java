package com.pocketvaccine.PocketVaccine.domain.common;

public interface BaseExceptionType {
    int getErrorCode();
    int getHttpStatus();
    String getErrorMessage();
}
