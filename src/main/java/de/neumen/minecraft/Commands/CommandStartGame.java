package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandStartGame extends de.neumen.minecraft.Commands.CustomCommand {
    public CommandStartGame() {
        super("startGame");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            MontagsBauerGamesManager.getInstance().getGame(strings[1]).startGame();
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
