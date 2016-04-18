package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Lax on 4/18/2016.
 */
public class BurnTrollCommand extends CommandConsumer {

    public BurnTrollCommand(TrollPlus plugin) {
        super(plugin);
    }

    @Override
    protected void onCommand(TrollPlayer player, String label, String[] args) {
        if (!player.hasPermissionOrIsOp("trollplus.burn")) {
            noPermz(player);
            return;
        }
        if (args.length == 0) {
            player.getPlayer().setFireTicks(200);
            return;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage("&cUsage: /" + label + " [player]");
            return;
        }
        target.setFireTicks(200);
    }

    @Override
    public String getCommand() {
        return "burn";
    }
}
