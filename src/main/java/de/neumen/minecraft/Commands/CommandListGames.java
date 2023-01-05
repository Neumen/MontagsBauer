package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGame;
import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandListGames extends de.neumen.minecraft.Commands.CustomCommand {

    public CommandListGames() {
        super("listGames");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (MontagsBauerGame game: MontagsBauerGamesManager.getInstance().getGames()) {
            builder.append(game.getGameTitle());
            builder.append(", ");
        }
        builder.replace(builder.length() - 2, builder.length(), "");

        commandSender.sendMessage(builder.toString());
        return true;
    }
}
