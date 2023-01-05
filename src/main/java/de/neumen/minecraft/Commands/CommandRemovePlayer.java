package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandRemovePlayer extends CustomCommand {
    public CommandRemovePlayer() {
        super("removePlayer");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if (strings.length < 2) {
                throw new Exception("Missing argument.");
            }
            MontagsBauerGamesManager.getInstance().getGame(strings[1]).removePlayer(Bukkit.getPlayer(strings[2]));
            commandSender.sendMessage("Removed player" + " " + strings[2] + " from game" + " " + strings[1]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
