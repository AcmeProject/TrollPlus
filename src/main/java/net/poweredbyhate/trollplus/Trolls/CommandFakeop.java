package net.poweredbyhate.trollplus.Trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

/**
 * Created by Lax on 4/18/2016.
 */
public class CommandFakeop implements CommandExecutor {

    ArrayList<String> fakeopz = new ArrayList<>();

    TrollPlus plugin;
    public CommandFakeop(TrollPlus trollPlus) {
        this.plugin = trollPlus;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        return false;
    }

}
