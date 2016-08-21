package com.example.mysimpleproject;

/**
 * Created by Ian on 5/18/2016.
 */
public class DuplicatePetNameException extends RuntimeException {

    public DuplicatePetNameException() {
    }

    public DuplicatePetNameException(String detailMessage) {
        super(detailMessage);
    }

    public DuplicatePetNameException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DuplicatePetNameException(Throwable throwable) {
        super(throwable);
    }
}
