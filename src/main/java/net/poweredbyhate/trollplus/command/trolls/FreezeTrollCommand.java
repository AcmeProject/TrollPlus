package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Lax on 4/18/2016.
 */
public class FreezeTrollCommand extends CommandConsumer {

    public FreezeTrollCommand(TrollPlus plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(final TrollPlayer player, String label, String[] args) {
        if (!player.hasPermissionOrIsOp("trollplus.freeze")) {
            noPermz(player);
            return;
        }
        if (args.length == 0) {
            player.getPlayer().setWalkSpeed(0);
            player.getPlayer().setFlySpeed(0);
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.getPlayer().setWalkSpeed(0.2F);
                    player.getPlayer().setFlySpeed(0.1F);
                }
            }.runTaskLater(plugin, 200);
            return;
        }
        if (!player.hasPermissionOrIsOp("trollplus.freeze.others")) {
            noPermz(player);
            return;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage("&cUsage: /" + label + " [player]");
            return;
        }
        target.setWalkSpeed(0);
        target.setFlySpeed(0);
        new BukkitRunnable() {
            @Override
            public void run() {
                target.setWalkSpeed(0.2F);
                target.setFlySpeed(0.1F);
            }
        }.runTaskLater(plugin, 200);
    }

    @Override
    public String getCommand() {
        return "freeze";
    }
}
