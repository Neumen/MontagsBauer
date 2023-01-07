package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGame;
import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAddPlayerMontagsBauerGame extends de.neumen.minecraft.Commands.CustomCommand {
    public CommandAddPlayerMontagsBauerGame() {
        super("addPlayer");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if (strings[2] == null) {
                throw new Exception("No player was provided.");
            }

            Player player = Bukkit.getPlayer(strings[2]);

            if (player == null) {
                throw new Exception("Player may not be null.");
            }

            for (MontagsBauerGame game:MontagsBauerGamesManager.getInstance().getGames()) {
                if (game.getPlayers().contains(player)) {
                    throw new Exception(player.getName() + " " + "is already part of: " + game.getGameTitle());
                }
            }

            MontagsBauerGamesManager.getInstance().getGame(strings[1]).addPlayer(player);

            commandSender.sendMessage("Added player" + " " + strings[2] + " to game" + " " + strings[1]);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
