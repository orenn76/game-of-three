package com.ninyo.player.client.exception;

public class ClientTimeoutException extends RuntimeException {

    private static final long serialVersionUID = 8458417785209341858L;

    public ClientTimeoutException(Throwable cause) {
        super(cause);
    }
}
