package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListGamePlayers extends de.neumen.minecraft.Commands.CustomCommand {

    public CommandListGamePlayers() {
        super("listGamePlayers");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Player player: MontagsBauerGamesManager.getInstance().getGame(strings[1]).getPlayers()) {
                stringBuilder.append(player.getName());
                stringBuilder.append(", ");
            }
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");

            commandSender.sendMessage(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
