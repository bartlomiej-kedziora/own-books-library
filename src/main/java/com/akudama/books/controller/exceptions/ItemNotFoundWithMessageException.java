package com.akudama.books.controller.exceptions;

public class ItemNotFoundWithMessageException extends RuntimeException {

    public ItemNotFoundWithMessageException(String message) {
        super(message);
    }
}
