package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandAddPlayerMontagsBauerGame extends de.neumen.minecraft.Commands.CustomCommand {
    public CommandAddPlayerMontagsBauerGame() {
        super("addPlayer");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            MontagsBauerGamesManager.getInstance().getGame(strings[1]).addPlayer(Bukkit.getPlayer(strings[2]));
            commandSender.sendMessage("Added player" + " " + strings[2] + " to game" + " " + strings[1]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
