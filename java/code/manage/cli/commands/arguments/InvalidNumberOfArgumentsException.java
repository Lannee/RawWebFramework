package code.manage.cli.commands.arguments;

public class InvalidNumberOfArgumentsException extends InvalidArgumentsException {

    public InvalidNumberOfArgumentsException() {
        super("Invalid number of arguments");
    }
}
