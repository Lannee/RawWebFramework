package code.manage.cli.commands;

import code.manage.cli.commands.arguments.CommandArgument;
import code.manage.cli.commands.arguments.InvalidArgumentsException;
import code.server.Server;

public class TerminateServerCommand implements Command {

    public static final CommandArgument[] args = new CommandArgument[0];


    @Override
    public String execute(Object[] args) throws InvalidArgumentsException {
        checkArgumentConformity(args);
        if(Server.getInstance().terminate()) {
            return "Server was successfully terminated";
        }
        return "Error via server terminating";
    }

    @Override
    public CommandArgument[] getArgs() {
        return args;
    }
}
