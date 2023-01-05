package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGame;
import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListGames implements CommandExecutor {


    private MontagsBauerGamesManager mbgManager;

    public CommandListGames(MontagsBauerGamesManager mgbManager) {
        this.mbgManager = mgbManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (MontagsBauerGame game: mbgManager.getGames()) {
            builder.append(game.getGameTitle());
            builder.append(", ");
        }
        builder.replace(builder.length() - 2, builder.length(), "");

        commandSender.sendMessage(builder.toString());
        return true;
    }
}
