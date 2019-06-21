package com.challenge.documentStorageService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentNotFoundException extends RuntimeException {

    public DocumentNotFoundException() {
        super();
    }

    public DocumentNotFoundException(String message) {
        super(message);
    }
}