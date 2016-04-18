package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Lax on 4/18/2016.
 */
public class FakeRestartCommand extends CommandConsumer {

    public FakeRestartCommand(TrollPlus plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(final TrollPlayer player, String label, String[] args) {
        if(!player.hasPermissionOrIsOp("trollplus.fakerestart")) {
            noPermz(player);
            return;
        }
        if(args.length == 0) {
            player.sendMessage("&cUsage: /" + label + " [time in seconds]");
            return;
        }
        if (!StringUtils.isNumeric(args[0])) {
            player.sendMessage("&cUsage: /" + label + " [time in seconds]");
            return;
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.getName().equalsIgnoreCase(player.getPlayer().getName())) {
                        p.kickPlayer(ChatColor.RED + "Server restarting!");
                    }
                }
            }
        }.runTaskLater(plugin, 20*Integer.valueOf(args[0]));
    }

    @Override
    public String getCommand() {
        return "fakerestart"; //Literally kickall command.
    }
}
