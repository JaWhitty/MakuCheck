package ru.mironxx.makuCheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MakuCheck extends JavaPlugin {

    public String prefix = "[MakuCheck]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(prefix + " Started!");

        getCommand("check").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(prefix + "Bye-bye!");
    }
}
