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
public class CommandBurn implements CommandExecutor {

    TrollPlus plugin;

    public CommandBurn(TrollPlus trollPlus) {
        this.plugin = trollPlus;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("trollplus.burn")) {
            if(args.length == 0 && sender instanceof Player) {
                ((Player) sender).setFireTicks(200);
            } else if (Bukkit.getPlayer(args[0]) != null && sender.hasPermission("trollplus.burn.others")) {
                Bukkit.getPlayer(args[0]).setFireTicks(200);
            }
        }
        sender.sendMessage(ChatColor.RED+ "No Permz");
        return false;
    }
}
