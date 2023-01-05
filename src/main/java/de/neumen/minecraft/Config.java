package de.neumen.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.FileWriter;
import java.io.IOException;

public class Config {
    private static Config instance = null;
    private FileConfiguration config;

    private Config() {};

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void setConfig(FileConfiguration config) {
        this.config = config;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public boolean saveConfig() {
        Bukkit.getPluginManager().getPlugin("MontagsBauer").saveConfig();
        return true;
    }

}
