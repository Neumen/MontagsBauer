package de.neumen.minecraft;

import de.neumen.minecraft.Commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MontagsBauer extends JavaPlugin {


    @Override
    public void onEnable() {
        Config.getInstance().setConfig(getConfig());

        // Create default config
        Config.getInstance().getConfig().addDefault("words", new String[]{});
        Config.getInstance().getConfig().options().copyDefaults(true);
        saveConfig();

        // Enable our class to check for new players using onPlayerJoin()
        getServer().getPluginManager().registerEvents(EventListenerOnPlayerChat.getInstance(), this);

        CommandManager.getInstance().registerCommand(new CommandAddPlayerMontagsBauerGame());
        CommandManager.getInstance().registerCommand(new CommandCreateMontagsBauerGame());
        CommandManager.getInstance().registerCommand(new CommandListGamePlayers());
        CommandManager.getInstance().registerCommand(new CommandListGames());
        CommandManager.getInstance().registerCommand(new CommandListWords());
        CommandManager.getInstance().registerCommand(new CommandStartGame());
        CommandManager.getInstance().registerCommand(new CommandSetGameArena());
        CommandManager.getInstance().registerCommand(new CommandGetGameArena());
        CommandManager.getInstance().registerCommand(new CommandSetGameArenaTeleportLocation());
        CommandManager.getInstance().registerCommand(new CommandStopGame());

        // Register startGame command
        this.getCommand("montagsBauer").setExecutor(new CommandMontagsBauer());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MontagsBauer is loaded!");
    }
}
