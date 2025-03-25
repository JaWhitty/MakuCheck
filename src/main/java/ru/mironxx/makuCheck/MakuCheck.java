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
        getLogger().info("Started!");

        getCommand("check").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                if (args.length == 0) {
                    commandSender.sendMessage( prefix + "Running MakuCheck version 1.0.0 SNAPSHOT");
                    return true;
                }

                if(args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    commandSender.sendMessage(prefix + " Plugin reloaded!");
                    return true;
                }

                if(args[0].equalsIgnoreCase("help")) {
                    commandSender.sendMessage("Usage:");
                    commandSender.sendMessage("/check help - Shows this list");
                    commandSender.sendMessage("/check reload - Reload plugin");
                    return true;
                }

                return true;
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Bye-bye!");
    }
}
