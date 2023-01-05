package de.neumen.minecraft;

import de.neumen.minecraft.Commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MontagsBauer extends JavaPlugin {


    FileConfiguration config = getConfig();
    private MontagsBauerGamesManager mbgManager = new MontagsBauerGamesManager();

    @Override
    public void onEnable() {

        getLogger().info("MontagsBauer is loaded!");

        // Create default config
        config.addDefault("words", new String[]{"Affe", "Auto", "Jonas S"});
        config.options().copyDefaults(true);
        saveConfig();

        // Enable our class to check for new players using onPlayerJoin()
        getServer().getPluginManager().registerEvents(new EventListener(config), this);

        // Register words command
        this.getCommand("words").setExecutor(new CommandWords(config));

        // Register newGame command
        this.getCommand("createGame").setExecutor(new CommandCreateMontagsBauerGame(mbgManager));

        // Register listgames command
        this.getCommand("listGames").setExecutor(new CommandListGames(mbgManager));

        // Register addPlayer command
        this.getCommand("addPlayer").setExecutor(new CommandAddPlayerMontagsBauerGame(mbgManager));

        // Register listGamePlayers command
        this.getCommand("listGamePlayers").setExecutor(new CommandListGamePlayers(mbgManager));

        // Register startGame command
        this.getCommand("startGame").setExecutor(new CommandStartGame(mbgManager));
    }
}
