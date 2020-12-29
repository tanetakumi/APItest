package net.serveron.mcstar.apireader;
//import com.sk89q.worldedit.bukkit.WorldEditPlugin;
//import com.sk89q.worldedit.bukkit;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor/*, TabCompleter*/{
    private APIreader plugin;

    public Command(APIreader plugin){
        this.plugin = plugin;
        plugin.getCommand("cg").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot use commands with the console.");
            return true;
        }
        Player player = (Player) sender;


        if (args.length > 0) {
            if (player.hasPermission("cg")){
                WorldEditPlugin p = plugin.getWorldEdit();
                if(p==null)player.sendMessage("null");
                else player.sendMessage("getPlugin");
            }
        }
        return true;
    }
}
