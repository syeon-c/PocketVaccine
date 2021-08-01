package com.pocketvaccine.PocketVaccine.domain.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SuppressWarnings("unchecked")
public class ResultEntity {

    /**
     * Return Status OK
     * <p> ResultCode Non SUCCESS  </p>
     *
     * @param <T> - (Response Data null)
     * @return response ok including non success
     */
    public static <T> ResponseEntity<ResultDto<T>> ok(
            ResultCode resultCode) {
        return new ResponseEntity<>(
                createResultDto(resultCode, null, null, null),
                HttpStatus.OK
        );
    }

    /**
     * Return Status OK
     * <p> ResultCode SUCCESS  </p>
     *
     * @param <T> - (Response Data null)
     * @return response ok including success result code only
     */
    public static <T> ResponseEntity<ResultDto<T>> ok() {
        return new ResponseEntity<>(
                createResultDto(ResultCode.SUCCESS, null, null,
                        null),
                HttpStatus.OK
        );
    }

    /**
     * Return Status OK
     * <p> ResultCode SUCCESS  </p>
     *
     * @param data - Response Data
     * @param <T>
     * @return response ok including success result code, data
     */
    public static <T> ResponseEntity<ResultDto<T>> ok(
            T data) {
        return new ResponseEntity<>(
                createResultDto(ResultCode.SUCCESS, null, data,
                        null),
                HttpStatus.OK
        );
    }

    /**
     * Return Status OK
     * <p> ResultCode SUCCESS  </p>
     *
     * @param data     - Response Data
     * @param paginate - Response Page Info
     * @param <T>
     * @return response ok including success result code, data, paginate
     */
    public static <T> ResponseEntity<ResultDto<T>> ok(T data,
                                                      Paginate paginate) {
        return new ResponseEntity<>(
                createResultDto(ResultCode.SUCCESS, null, data,
                        paginate),
                HttpStatus.OK
        );
    }

    /**
     * Return Status OK
     * <p> ResultCode Custom ResultCode  </p>
     *
     * @param resultCode
     * @return response ok including fail result code only
     */
    public static <T> ResponseEntity<ResultDto<T>> fail(
            ResultCode resultCode) {
        return new ResponseEntity<>(
                createResultDto(resultCode, null, null, null),
                HttpStatus.OK
        );
    }

    /**
     * Return Status OK
     * <p> ResultCode Custom ResultCode  </p>
     *
     * @param resultCode
     * @param message
     * @return response ok including fail result code, message
     */
    public static <T> ResponseEntity<ResultDto<T>> fail(
            ResultCode resultCode, String message) {
        return new ResponseEntity<>(
                createResultDto(resultCode, message, null, null),
                HttpStatus.OK
        );
    }

    /**
     * Return Status CREATED
     *
     * @param <T> - (Response Data null)
     * @return response created
     */
    public static <T> ResponseEntity<ResultDto<T>> created() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Return Status CREATED
     * <p> Set Created location </p>
     *
     * @param location - Created Location
     * @param <T>
     * @return response created including location
     */
    public static <T> ResponseEntity<ResultDto<T>> created(
            String location) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create(location));
        return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
    }

    /**
     * Return Status CREATED
     * <p> Set Created location </p>
     *
     * @param location - Created Location
     * @param <T>
     * @param data     - Response Data
     * @return response created including data and location
     */
    public static <T> ResponseEntity<ResultDto<T>> created(
            String location, T data) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create(location));
        return new ResponseEntity<>(
                createResultDto(ResultCode.CREATED, null, data,
                        null),
                responseHeaders, HttpStatus.CREATED);
    }

    /**
     * Return Status BAD_REQUEST
     *
     * @param <T>
     * @return response bad request
     */
    public static <T> ResponseEntity<ResultDto<T>> badRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Return Status BAD_REQUEST
     *
     * @param resultCode
     * @param message
     * @param <T>
     * @return response bad request including result code, message
     */
    public static <T> ResponseEntity<ResultDto<T>> badRequest(
            ResultCode resultCode, String message) {
        return new ResponseEntity<>(
                createResultDto(resultCode, message, null, null),
                HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Return Status NOT_FOUND
     *
     * @param <T>
     * @return response not found
     */
    public static <T> ResponseEntity<ResultDto<T>> notFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Return Status NOT_FOUND
     *
     * @param resultCode
     * @param message
     * @param <T>
     * @return response not found including result code, message
     */
    public static <T> ResponseEntity<ResultDto<T>> notFound(
            ResultCode resultCode, String message) {
        return new ResponseEntity<>(
                createResultDto(resultCode, message, null, null),
                HttpStatus.NOT_FOUND);
    }

    /**
     * Make ResultDto
     *
     * @param data     - Result Object
     * @param paginate - Result Page Info
     * @param <T>
     * @return response body object
     */
    private static <T> ResultDto<T> createResultDto(
            ResultCode resultCode, String message, T data,
            Paginate paginate) {

        return ResultDto.<T>builder()
                .data(data)
                .paginate(paginate)
                .code(resultCode.name())
                .message(message)
                .build();
    }

}
