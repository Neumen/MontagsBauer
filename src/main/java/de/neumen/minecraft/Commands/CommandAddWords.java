package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandAddWords extends CustomCommand {

    public CommandAddWords() {
        super("addWords");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> words = (ArrayList<String>) Config.getInstance().getConfig().getStringList("words");
        words.addAll(Arrays.asList(strings).subList(1, strings.length));
        Config.getInstance().getConfig().set("words", words);
        return true;
    }
}
