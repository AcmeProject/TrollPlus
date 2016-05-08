package net.poweredbyhate.trollplus.managers;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.command.trolls.*;

public class CommandManager extends Manager {

    private final CommandConsumer[] commandConsumers = new CommandConsumer[] {
            new JarcodeTrollCommand(plugin),
            new BoltTrollCommand(plugin),
            new BurnTrollCommand(plugin),
            new FakeopTrollCommand(plugin),
            new FreezeTrollCommand(plugin),
            new FakeRestartCommand(plugin),
            new SwitchTrollCommand(plugin)
    };

    public CommandManager(TrollPlus plugin) {
        super(plugin);
        loadCommands();
    }

    private void loadCommands() {
        for (CommandConsumer commandConsumer : commandConsumers) {
            register(commandConsumer);
        }
    }

    private void register(CommandConsumer commandConsumer) {
        plugin.getCommand(commandConsumer.getCommand()).setExecutor(commandConsumer);
    }

}
