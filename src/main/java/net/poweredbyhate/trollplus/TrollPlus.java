package net.poweredbyhate.trollplus;

import net.poweredbyhate.trollplus.Trolls.CommandBolt;
import net.poweredbyhate.trollplus.Trolls.CommandBurn;
import net.poweredbyhate.trollplus.Trolls.CommandFakeop;
import net.poweredbyhate.trollplus.Trolls.CommandFreeze;
import net.poweredbyhate.trollplus.Trolls.CommandJarcode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lax on 4/18/2016.
 */
public class TrollPlus extends JavaPlugin implements Listener{

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        enableCommands(); //List of commands to make: http://q.awsmpwrd.com/iVZx.png
    }

    public void enableCommands() {
        getCommand("burn").setExecutor(new CommandBurn(this));
        getCommand("freeze").setExecutor(new CommandFreeze(this));
        getCommand("bolt").setExecutor(new CommandBolt(this));
        //getCommand("special").setExecutor(new CommandSpecial(this)); I have yet to check what a fucking AK-47 is.
        getCommand("fakeop").setExecutor(new CommandFakeop(this)); //not done
        getCommand("jarcode").setExecutor(new CommandJarcode(this));
    }

    String[] ad = {
           "&d____----====[ &cSponsored by GNU/Emacs&d ]====----____",
            "&aGet emacs for your linux distro now!",
            "&bhttps://www.gnu.org/software/emacs/",

            "&aThis troll plugin is sponsored by Emacs!",
            "&aEmacs is the one true editor that respects your software freedoms",
            " "
    };


    @EventHandler
    public void onJoin(PlayerJoinEvent ev) {
        for (String s : ad) {
            ev.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
        }
    }
}
