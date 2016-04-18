package net.poweredbyhate.trollplus;

import net.poweredbyhate.trollplus.listeners.PlayerListener;
import net.poweredbyhate.trollplus.managers.CommandManager;
import net.poweredbyhate.trollplus.managers.TrollPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lax on 4/18/2016.
 */
public class TrollPlus extends JavaPlugin {

    private final Listener[] listeners = {
            new PlayerListener(this)
    };

    private TrollPlayerManager playerManager;
    private CommandManager commandManager;

    //@Override // You better annotate every bloody override or I will end you. - Hope you're happy.
    public void onEnable() {
        loadManagers();
        loadListeners();
        //List of command to make: http://q.awsmpwrd.com/iVZx.png
    }

    //@Override
    private void loadManagers() {
        playerManager = new TrollPlayerManager(this);
        commandManager = new CommandManager(this);
    }

    //@Override
    private void loadListeners() {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    //@Override
    public TrollPlayerManager getPlayerManager() {
        return playerManager;
    }

    //@Override
    public CommandManager getCommandManager() {
        return commandManager;
    }
}
