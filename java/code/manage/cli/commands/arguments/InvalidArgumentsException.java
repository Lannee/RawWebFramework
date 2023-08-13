package code.manage.cli.commands.arguments;

public class InvalidArgumentsException extends Exception {
    public InvalidArgumentsException() {
        this("Invalid command arguments");
    }

    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }
}
