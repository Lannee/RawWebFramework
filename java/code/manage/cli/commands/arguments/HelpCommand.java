package code.manage.cli.commands.arguments;

import code.manage.cli.commands.Command;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HelpCommand implements Command {

    public static final CommandArgument[] args = new CommandArgument[0];

    private String commandText;

    public HelpCommand(Map<String, Command> commands) {
        StringBuilder result = new StringBuilder();

        commands.forEach((u, v) -> {
            result.append(u).append("  ");

            List<CommandArgument> requiredArguments = new LinkedList<>();
            List<CommandArgument> optionalArguments = new LinkedList<>();

            for(CommandArgument commandArgument : v.getArgs()) {
                if(commandArgument.getArgumentType() == CommandArgumentType.OPTIONAL)
                    optionalArguments.add(commandArgument);
                else
                    requiredArguments.add(commandArgument);
            }

            requiredArguments.forEach(e -> result.append(e.getArgumentName()).append(" "));
            result.append("[");
            optionalArguments.forEach(e -> result.append(e.getArgumentName()));
            result.append("]");

            result.append("\n");
        });

        commandText = result.toString();
    }

    @Override
    public String execute(Object[] args) throws InvalidArgumentsException {
        checkArgumentConformity(args);
        return commandText;
    }

    @Override
    public CommandArgument[] getArgs() {
        return args;
    }
}
