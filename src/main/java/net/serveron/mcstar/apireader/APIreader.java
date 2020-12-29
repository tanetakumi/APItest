package net.serveron.mcstar.apireader;

import org.bukkit.plugin.java.JavaPlugin;

public final class APIreader extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getLogger("init");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
