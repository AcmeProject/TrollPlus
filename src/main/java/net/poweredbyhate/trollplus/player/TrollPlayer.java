package net.poweredbyhate.trollplus.player;

import net.poweredbyhate.trollplus.TrollPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TrollPlayer {

    private final TrollPlus plugin;
    private final UUID uuid;

    public TrollPlayer(TrollPlus plugin, UUID uuid) {
        this.plugin = plugin;
        this.uuid = uuid;
    }

    public void sendMessage(String... messages) {
        if (messages == null) {
            return;
        }
        for (String message : messages) {
            if (message != null) {
                getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
        }
    }

    public boolean hasPermissionOrIsOp(String permission) {
        return getPlayer().isOp() || getPlayer().hasPermission(permission);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
