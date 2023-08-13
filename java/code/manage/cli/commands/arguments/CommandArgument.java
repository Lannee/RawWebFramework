package code.manage.cli.commands.arguments;

public class CommandArgument {
    private final String argumentName;
    private final CommandArgumentType argumentType;
    private final Class<?> argumentClass;

    private final int duplicates;

    public CommandArgument(String argumentName, CommandArgumentType argumentType, Class<?> argumentClass, int duplicates) {
        this.argumentName = argumentName;
        this.argumentType = argumentType;
        this.argumentClass = argumentClass;
        this.duplicates = duplicates;
    }

    public CommandArgument(String argumentName, CommandArgumentType argumentType, Class<?> argumentClass) {
        this(argumentName, argumentType, argumentClass, 1);
    }

    public String getArgumentName() {
        return argumentName;
    }

    public CommandArgumentType getArgumentType() {
        return argumentType;
    }

    public Class<?> getArgumentClass() {
        return argumentClass;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public CommandArgument(String argumentName, CommandArgumentType argumentType, int duplicates) {
        this(argumentName, argumentType, String.class, duplicates);
    }

    public CommandArgument(String argumentName, CommandArgumentType argumentType) {
        this(argumentName, argumentType, 1);
    }

    public CommandArgument(String argumentName, Class<?> argumentClass, int duplicates) {
        this(argumentName, CommandArgumentType.REQUIRED, argumentClass, duplicates);
    }

    public CommandArgument(String argumentName, Class<?> argumentClass) {
        this(argumentName, argumentClass, 1);
    }

    public CommandArgument(String argumentName, int duplicates) {
        this(argumentName, CommandArgumentType.REQUIRED, duplicates);
    }

    public CommandArgument(String argumentName) {
        this(argumentName, 1);
    }
}
