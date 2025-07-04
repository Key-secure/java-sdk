package io.github.keysecure.exception;

/**
 * @author Cusotdy
 */
public class ArgsNullException extends RuntimeException {

    private static final long serialVersionUID = -1859928557432340788L;

    public ArgsNullException() {
        super();
    }

    public ArgsNullException(String msg) {
        super(msg);
    }
}
