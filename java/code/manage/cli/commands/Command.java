package code.manage.cli.commands;

import code.manage.cli.commands.arguments.CommandArgument;
import code.manage.cli.commands.arguments.InvalidArgumentsException;

public interface Command {

    String execute(Object[] args) throws InvalidArgumentsException;

    CommandArgument[] getArgs();

    default void checkArgumentConformity(Object[] args) throws InvalidArgumentsException {
//        for(int i = 0; i < args.length; i++) {
//
//        }

    }
}
