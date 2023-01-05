package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCreateMontagsBauerGame extends de.neumen.minecraft.Commands.CustomCommand {

    public CommandCreateMontagsBauerGame() {
        super("createGame");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("No name was provided.");
            return false;
        }

        try {
            MontagsBauerGamesManager.getInstance().newGame(strings[1]);
            commandSender.sendMessage("Created new game" +  " " + strings[1]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return false;
    }
}
