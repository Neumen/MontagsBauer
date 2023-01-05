package de.neumen.minecraft;

import de.neumen.minecraft.Commands.CustomCommand;
import java.util.ArrayList;

public class CommandManager {
    private static CommandManager instance = null;
    private final ArrayList<CustomCommand> commands = new ArrayList<>();

    private CommandManager() {}

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public boolean registerCommand(CustomCommand command) {
        return commands.add(command);
    }

    public ArrayList<CustomCommand> getCommands() {
        return commands;
    }
}
