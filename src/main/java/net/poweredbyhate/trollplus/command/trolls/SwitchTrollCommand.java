package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Lax on 4/23/2016.
 */
public class SwitchTrollCommand extends CommandConsumer {

    public SwitchTrollCommand(TrollPlus plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(TrollPlayer player, String label, String[] args) {
        if (player.hasPermissionOrIsOp("trollplus.switch")) {
            noPermz(player);
            return;
        }
        if (args.length <= 1) {
            player.sendMessage("&cUsage: /" + label + " <player1> <player2>");
            return;
        }
        if (Bukkit.getPlayer(args[0]) == null || Bukkit.getPlayer(args[1]) == null || args[0].equalsIgnoreCase(args[1])) {
            player.sendMessage("&cUsage: /" + label + " <player1> <player2>");
            return;
        }
        switchPlayers(Bukkit.getPlayer(args[0]), Bukkit.getPlayer(args[1]));
    }

    @Override
    public String getCommand() {
        return "switch";
    }

    public void switchPlayers(final Player one, final Player two) {
        final Location lOne;
        final Location lTwo;
        lOne = one.getLocation();
        lTwo = two.getLocation();
        new BukkitRunnable() {
            @Override
            public void run() {
                one.teleport(lTwo);
                two.teleport(lOne);
            }
        }.runTaskLater(plugin, 1);
    }
}
