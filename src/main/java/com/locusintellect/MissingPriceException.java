package com.locusintellect;

public class MissingPriceException extends RuntimeException {

    public MissingPriceException(final String message) {
        super(message);
    }

    public MissingPriceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
