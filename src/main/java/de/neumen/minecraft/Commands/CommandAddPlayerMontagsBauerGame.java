package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandAddPlayerMontagsBauerGame implements CommandExecutor {
    private MontagsBauerGamesManager mbgManager;

    public CommandAddPlayerMontagsBauerGame(MontagsBauerGamesManager mbgManager) {
        this.mbgManager = mbgManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            mbgManager.getGame(strings[0]).addPlayer(strings[1]);
            commandSender.sendMessage("Added player" + " " + strings[1] + " to game" + " " + strings[0]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
