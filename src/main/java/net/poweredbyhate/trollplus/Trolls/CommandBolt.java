package net.poweredbyhate.trollplus.Trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lax on 4/18/2016.
 */
public class CommandBolt implements CommandExecutor {

    TrollPlus plugin;

    public CommandBolt(TrollPlus trollPlus) {
        this.plugin = trollPlus;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("trollplus.bolt")) {
            if(args.length == 0 && sender instanceof Player) {
                Player p = (Player) sender;
                p.getLocation().getWorld().strikeLightning(p.getLocation());
            } else if (Bukkit.getPlayer(args[0]) != null && sender.hasPermission("trollplus.bolt.others")) {
                Player p = Bukkit.getPlayer(args[0]);
                p.getLocation().getWorld().strikeLightning(p.getLocation());
            }
        }
        sender.sendMessage(ChatColor.RED+ "No Permz");
        return false;
    }
}
