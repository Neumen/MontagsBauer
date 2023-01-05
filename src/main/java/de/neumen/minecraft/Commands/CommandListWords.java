package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandListWords extends de.neumen.minecraft.Commands.CustomCommand {


    public CommandListWords() {
        super("listWords");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(Config.getInstance().getConfig().getStringList("words").toString());
        return true;
    }
}
