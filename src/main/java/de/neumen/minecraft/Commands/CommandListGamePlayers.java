package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandListGamePlayers extends de.neumen.minecraft.Commands.CustomCommand {

    public CommandListGamePlayers() {
        super("listGamePlayers");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            commandSender.sendMessage(MontagsBauerGamesManager.getInstance().getGame(strings[1]).getPlayers().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
