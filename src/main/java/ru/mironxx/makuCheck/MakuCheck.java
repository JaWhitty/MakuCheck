package ru.mironxx.makuCheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MakuCheck extends JavaPlugin {

    public String prefix = getConfig().getString("prefix")
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {

        getLogger().info("Запущено!");

        saveDefaultConfig();

        getCommand("check").setExecutor(new CheckCommandExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Пока-пока!");
    }

    // Вынесем обработку команды в отдельный класс
    public class CheckCommandExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
            if (args.length == 0) {
                commandSender.sendMessage(prefix + " Запущен MakuCheck версии 1.0.0 SNAPSHOT");
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                commandSender.sendMessage(prefix + " Plugin reloaded!");
                return true;
            }

            if (args[0].equalsIgnoreCase("help")) {
                commandSender.sendMessage("Usage:");
                commandSender.sendMessage("/check help - Shows this list");
                commandSender.sendMessage("/check reload - Reload plugin");
                return true;
            }

            return false;
        }
    }
}
