package code.manage.cli;

import code.manage.cli.commands.Command;
import code.manage.cli.commands.RunServerCommand;
import code.manage.cli.commands.TerminateServerCommand;
import code.manage.cli.commands.UnknownCommandException;
import code.manage.cli.commands.arguments.HelpCommand;
import code.manage.cli.commands.arguments.InvalidArgumentsException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    private final static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("run-server", new RunServerCommand());
        commands.put("terminate-server", new TerminateServerCommand());
        commands.put("help", new HelpCommand(commands));
    }


    public static String parseLine(String line) {
        line = line.trim();
        if(line.equals("")) return "";

        String[] words = line.split(" +");
        return executeCommand(words[0], Arrays.copyOfRange(words, 1, words.length));
    }

    public static String executeCommand(String command, String[] args) {
        if(!commands.containsKey(command)) return "Unknown command. Type help to get the information about all commands";

        try {
            return commands.get(command).execute(args);
        } catch (InvalidArgumentsException e) {
            throw new RuntimeException(e);
        }

    }
}
