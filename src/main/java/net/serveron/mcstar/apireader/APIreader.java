package net.serveron.mcstar.apireader;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class APIreader extends JavaPlugin {

    WorldEditPlugin wePlugin;
    @Override
    public void onEnable() {
        initFolder();
        wePlugin = getWorldEdit();
        if(wePlugin==null)getLogger().info("getWorldEdit");
        else getLogger().info("CPuld not find");
        new Command(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public WorldEditPlugin getWorldEdit(){
        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if(p instanceof WorldEditPlugin) return (WorldEditPlugin)p;
        else return null;
    }

    private void initFolder(){
        File pluginMainFolder = new File(this.getDataFolder().getPath());
        File pluginSchematicsFolder = new File(this.getDataFolder().getPath()+ File.separator + "Schematics");

        if (!pluginMainFolder.exists()) {
            getLogger().info("Could not find the plugin folder");
            pluginMainFolder.mkdir();
        } else {
            getLogger().info("Plugin Folder exists");
        }
        if (!pluginSchematicsFolder.exists()) {
            getLogger().info("Could not find the Schematics folder");
            pluginSchematicsFolder.mkdir();
        } else {
            getLogger().info("Schematics Folder exists");
        }
    }
}
