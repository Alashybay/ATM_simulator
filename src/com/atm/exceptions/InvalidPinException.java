package com.atm.exceptions;

public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}