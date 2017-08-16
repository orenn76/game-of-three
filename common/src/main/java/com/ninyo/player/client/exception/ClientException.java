package com.ninyo.player.client.exception;

public class ClientException extends RuntimeException {

    private static final long serialVersionUID = -1072876147605096472L;

    public ClientException(String message) {
        super(message);
    }

    public ClientException(Throwable throwable) {
        super(throwable);
    }
}
