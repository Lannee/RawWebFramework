package code.manage.cli.commands;

import code.manage.cli.commands.arguments.CommandArgument;
import code.manage.cli.commands.arguments.CommandArgumentType;
import code.manage.cli.commands.arguments.InvalidArgumentsException;
import code.server.Server;
import code.utils.StringConverter;

public class RunServerCommand implements Command {

    private final static CommandArgument[] args = new CommandArgument[]{
            new CommandArgument("port", CommandArgumentType.OPTIONAL, 1)};


    @Override
    public String execute(Object[] args) throws InvalidArgumentsException {
        checkArgumentConformity(args);
        Server server = Server.getInstance();

        boolean isStarted = false;

        try {
            if (args.length != 0) {
                int port = Integer.parseInt((String) args[0]);
                isStarted = server.start(port);
            } else {
                isStarted = server.start();
            }

        } catch (NumberFormatException e) {
            isStarted = false;
        }


        return isStarted
                    ? "Server was started"
                    : "Cannot start the server";
    }

    @Override
    public CommandArgument[] getArgs() {
        return args;
    }
}
