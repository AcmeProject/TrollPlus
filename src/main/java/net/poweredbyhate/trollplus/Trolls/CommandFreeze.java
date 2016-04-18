package net.poweredbyhate.trollplus.Trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Lax on 4/18/2016.
 */
public class CommandFreeze implements CommandExecutor {

    TrollPlus plugin;
    public CommandFreeze(TrollPlus trollPlus) {
        this.plugin = trollPlus;
    }

    @Override
    public boolean onCommand(final CommandSender sender, Command command, String s, final String[] args) {
        if (sender.hasPermission("trollplus.freeze")) {
            if (args.length == 0 && sender instanceof Player) {
                ((Player) sender).setWalkSpeed(0);
                ((Player) sender).setFlySpeed(0);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ((Player) sender).setWalkSpeed(0.2F);
                        ((Player) sender).setFlySpeed(0.1F);
                    }
                }.runTaskLater(plugin, 200);
            } else if (Bukkit.getPlayer(args[0]) != null && sender.hasPermission("trollplus.freeze.others")) {
                Bukkit.getPlayer(args[0]).setWalkSpeed(0);
                Bukkit.getPlayer(args[0]).setFlySpeed(0);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getPlayer(args[0]).setWalkSpeed(0.2F);
                        Bukkit.getPlayer(args[0]).setFlySpeed(0.1F);
                    }
                }.runTaskLater(plugin, 200);
            }
            sender.sendMessage(ChatColor.RED+ "No Permz");
        }
        return false;
    }
}
