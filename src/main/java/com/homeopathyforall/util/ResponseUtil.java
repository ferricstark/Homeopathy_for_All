package com.homeopathyforall.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(true, HttpStatus.OK.value(), message, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Method to handle error response
    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status) {
        ApiResponse<T> response = new ApiResponse<>(false, status.value(), message, null);
        return new ResponseEntity<>(response, status);
    }

    // Method to handle created response
    public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(true, HttpStatus.CREATED.value(), message, data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Method to handle no content response (for delete operations)
    public static <T> ResponseEntity<ApiResponse<T>> noContent(String message) {
        ApiResponse<T> response = new ApiResponse<>(true, HttpStatus.NO_CONTENT.value(), message, null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message) {
        ApiResponse<T> response = new ApiResponse<>(false , HttpStatus.BAD_REQUEST.value() ,message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
