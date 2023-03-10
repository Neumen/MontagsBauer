package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGame;
import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetGameArena extends CustomCommand {

    public CommandSetGameArena() {
        super("setGameArena");
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            Player p = Bukkit.getPlayer(commandSender.getName());
            MontagsBauerGame game = MontagsBauerGamesManager.getInstance().getGame(strings[1]);
            game.setArena(strings[2], p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
        }
}
