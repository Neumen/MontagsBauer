package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGame;
import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandDeleteGame extends CustomCommand {
    public CommandDeleteGame() {
        super("deleteGame");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            MontagsBauerGame game = MontagsBauerGamesManager.getInstance().getGame(strings[0]);
            MontagsBauerGamesManager.getInstance().removeGame(game);
            commandSender.sendMessage(ChatColor.GREEN + "Successfully" + ChatColor.WHITE + " " + "removed " + game.getGameTitle());
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
