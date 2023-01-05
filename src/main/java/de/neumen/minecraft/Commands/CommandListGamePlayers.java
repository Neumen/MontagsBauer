package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListGamePlayers implements CommandExecutor {
    private MontagsBauerGamesManager mbgManager;

    public CommandListGamePlayers(MontagsBauerGamesManager mgbManager) {
        this.mbgManager = mgbManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            commandSender.sendMessage(mbgManager.getGame(strings[0]).getPlayers().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
