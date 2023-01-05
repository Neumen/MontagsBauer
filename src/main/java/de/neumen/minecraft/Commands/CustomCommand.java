package de.neumen.minecraft.Commands;

import org.bukkit.command.CommandSender;

public abstract class CustomCommand {
    private String commandTitle;

    public CustomCommand(String commandTitle) {
        this.commandTitle = commandTitle;
    }

    public String getCommandTitle() {
        return this.commandTitle;
    };

    public abstract boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings);
}
