package jm.task.core.DAO;

import java.util.ArrayList;
import java.util.List;

public enum Commands {
    LISTOFCOMMANDS("help"),
    NOTENEW("note-new"),
    NOTELIST("note-list"),
    NOTEREMOVE("note-remove"),
    NOTEEXPORT("note-export"),
    EXIT("exit");
    private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
    public static List<String> getAllCommands() {
        Commands[] values = Commands.values();
        List<String> commands = new ArrayList<>();
        for (Commands value: values) {
            commands.add(value.getCommand());
        }
        return commands;
    }
}
