package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandStopGame extends CustomCommand {
    public CommandStopGame() {
        super("stopGame");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            MontagsBauerGamesManager.getInstance().getGame(strings[1]).stopGame();
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
    return true;
    }
}
