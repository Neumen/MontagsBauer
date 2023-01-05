package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauer;
import de.neumen.minecraft.MontagsBauerGame;
import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetGameArenaTeleportLocation extends CustomCommand {

    public CommandSetGameArenaTeleportLocation() {
        super("setGameArenaTeleportLocation");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            Player p = Bukkit.getPlayer(commandSender.getName());
            MontagsBauerGame game = MontagsBauerGamesManager.getInstance().getGame(strings[1]);
            if (p == null) {
                throw new Exception("P may not be null!");
            }
            game.setArenaTeleportLocation(p.getLocation());
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
