package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;

import java.util.ArrayList;

/**
 * Created by Lax on 4/18/2016.
 */
public class FakeopTrollCommand extends CommandConsumer {

    private final ArrayList<String> fakeopz;

    public FakeopTrollCommand(TrollPlus plugin) {
        super(plugin);
        fakeopz = new ArrayList<>();
    }

    @Override
    protected void onCommand(TrollPlayer player, String label, String[] args) {

    }

    @Override
    public String getCommand() {
        return "fakeop";
    }

}
