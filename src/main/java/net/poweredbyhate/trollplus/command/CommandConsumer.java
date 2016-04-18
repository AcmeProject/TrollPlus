package net.poweredbyhate.trollplus.command;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class CommandConsumer implements CommandExecutor {

    protected final TrollPlus plugin;

    protected CommandConsumer(TrollPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // Commands can only be executed by Players because fuck the console
            sender.sendMessage(ChatColor.RED + "Are ye serious mate? Too stingy to log on to the bloody server are ya?");
            sender.sendMessage(ChatColor.RED + "You can take your bloody console and piss right off mate.");
            return false;
        }
        TrollPlayer player = plugin.getPlayerManager().getPlayer((Player) sender);
        onCommand(player, label, args);
        return false;
    }

    // Only use label to resend the command to the player, no checks are needed
    protected abstract void onCommand(TrollPlayer player, String label, String[] args);

    public abstract String getCommand();

    protected void noPermz(TrollPlayer player) {
        player.sendMessage("&cNo Permz");
    }

}
