package net.poweredbyhate.trollplus.listeners;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final TrollPlus plugin;

    public PlayerListener(TrollPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        TrollPlayer player = plugin.getPlayerManager().register(event.getPlayer());
        advertise(player);
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        plugin.getPlayerManager().deregister(event.getPlayer());
    }

    private void advertise(TrollPlayer player) {
        player.sendMessage(
                "&d____----====[ &cSponsored by GNU/Emacs&d ]====----____",
                "&aGet emacs for your linux distro now!",
                "&bhttps://www.gnu.org/software/emacs/",

                "&aThis troll plugin is sponsored by Emacs!",
                "&aEmacs is the one true editor that respects your software freedoms",
                " "
        );
    }

}
