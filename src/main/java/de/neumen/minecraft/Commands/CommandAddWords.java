package de.neumen.minecraft.Commands;

import de.neumen.minecraft.Config;
import de.neumen.minecraft.MontagsBauer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandAddWords extends CustomCommand {

    public CommandAddWords() {
        super("addWords");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        try {
            if (strings.length < 2) {
                throw new Exception("No words provided");
            }

            ArrayList<String> words = (ArrayList<String>) Config.getInstance().getConfig().getStringList("words");
            words.addAll(Arrays.asList(strings).subList(1, strings.length));

            Set<String> withoutDoublicates = new HashSet<>();
            withoutDoublicates.addAll(words);

            Config.getInstance().getConfig().set("words", words);
            Config.getInstance().saveConfig();

            commandSender.sendMessage(ChatColor.GREEN + "Successfully" + ChatColor.WHITE + " added words.");
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
        }
        return true;
    }
}
