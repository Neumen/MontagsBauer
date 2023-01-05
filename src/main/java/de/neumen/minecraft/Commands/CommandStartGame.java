package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandStartGame implements CommandExecutor {
    private MontagsBauerGamesManager mbgManager;

    public CommandStartGame(MontagsBauerGamesManager mbgManager) {
        this.mbgManager = mbgManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            mbgManager.getGame(strings[0]).startGame();
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
