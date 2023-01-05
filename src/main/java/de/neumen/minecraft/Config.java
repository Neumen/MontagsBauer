package de.neumen.minecraft;

import org.bukkit.configuration.file.FileConfiguration;

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
}
