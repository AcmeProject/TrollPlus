package net.poweredbyhate.trollplus.managers;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrollPlayerManager {

    private final TrollPlus plugin;
    private final Map<UUID, TrollPlayer> players;

    public TrollPlayerManager(TrollPlus plugin) {
        this.plugin = plugin;
        players = new HashMap<>();
    }

    public TrollPlayer register(Player player) {
        return players.put(player.getUniqueId(), new TrollPlayer(plugin, player.getUniqueId()));
    }

    public void deregister(Player player) {
        players.remove(player.getUniqueId());
    }

    public TrollPlayer getPlayer(Player player) {
        TrollPlayer tPlayer = players.get(player.getUniqueId());
        if (tPlayer == null) {
            // This will never happen. I hope.
            tPlayer = players.put(player.getUniqueId(), register(player));
        }
        return tPlayer;
    }

    private void registerPlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            register(player);
        }
    }

}
