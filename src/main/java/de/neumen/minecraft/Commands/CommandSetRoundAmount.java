package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Gamemode.MontagsBauerGamesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandSetRoundAmount extends CustomCommand {

    public CommandSetRoundAmount() {
        super("setRoundAmount");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if (strings[1] == null) {
                throw new Exception("No round amount was provided.");
            }
            MontagsBauerGamesManager.getInstance().getGame(strings[0]).setRoundAmount(Integer.parseInt(strings[1]));
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
