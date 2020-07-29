package com.twu.exception;

public class VoteFailException extends RuntimeException {
    public VoteFailException(String message) {
        super(message);
    }
}
