package code.manage.cli.commands;

public class UnknownCommandException extends RuntimeException {

    public UnknownCommandException() {
        this("Unknown command name");
    }

    public UnknownCommandException(String message) {
        super(message);
    }

    public UnknownCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCommandException(Throwable cause) {
        super(cause);
    }
}
