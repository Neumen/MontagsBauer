package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCreateMontagsBauerGame implements CommandExecutor {

    private MontagsBauerGamesManager mbgManager;

    public CommandCreateMontagsBauerGame(MontagsBauerGamesManager mgbManager) {
        this.mbgManager = mgbManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("No name was provided.");
            return false;
        }

        try {
            mbgManager.newGame(strings[0]);
            commandSender.sendMessage("Created new game" +  " " + strings[0]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return false;
    }
}
