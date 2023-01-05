package de.neumen.minecraft.Commands;

import de.neumen.minecraft.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandGetGameArena extends CustomCommand {

    public CommandGetGameArena() {
        super("getGameArena");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (double d:MontagsBauerGamesManager.getInstance().getGame(strings[1]).getArena()) {
                stringBuilder.append(d);
                stringBuilder.append(", ");
            }

            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");

        commandSender.sendMessage(stringBuilder.toString());
    } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
