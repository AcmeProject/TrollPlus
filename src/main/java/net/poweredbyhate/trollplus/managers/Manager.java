package net.poweredbyhate.trollplus.managers;

import net.poweredbyhate.trollplus.TrollPlus;

public abstract class Manager {

    protected final TrollPlus plugin;

    public Manager(TrollPlus plugin) {
        this.plugin = plugin;
    }

}
