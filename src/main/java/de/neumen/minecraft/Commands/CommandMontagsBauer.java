package de.neumen.minecraft.Commands;

import de.neumen.minecraft.CommandManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMontagsBauer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for (CustomCommand com: CommandManager.getInstance().getCommands()) {
            if (com.getCommandTitle().equals(strings[0])) {
                com.onCommand(commandSender, command, s, strings);
                return true;
            }
        }
        commandSender.sendMessage("No such command.");
        return false;
    }
}
