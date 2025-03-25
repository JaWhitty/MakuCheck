package ru.mironxx.makuCheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MakuCheck extends JavaPlugin {

    public String prefix = getConfig().getString("prefix");
    public ConsoleCommandSender console = getServer().getConsoleSender();

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

            if (args.length > 1 && (args[0].equalsIgnoreCase("discord") || getServer().getPlayer(args[1]) != null)) {
                getServer().dispatchCommand(console, "freeze " + args[1]);
                getServer().dispatchCommand(console, "/tellraw " + args[1] + " [\"\",{\"text\":\"!! \\u041f\\u0420\\u041e\\u0412\\u0415\\u0420\\u041a\\u0410 \\u041d\\u0410 \\u0427\\u0418\\u0422\\u042b !!\",\"bold\":true,\"color\":\"green\"},{\"text\":\"\\n\\n\\u0423 \\u0432\\u0430\\u0441 \\u0435\\u0441\\u0442\\u044c 2 \\u043c\\u0438\\u043d\\u0443\\u0442\\u044b \\u0447\\u0442\\u043e\\u0431 \\u0441\\u043a\\u0438\\u043d\\u0443\\u0442\\u044c \\u0432\\u0430\\u0448 \",\"color\":\"white\"},{\"text\":\"Discord\",\"color\":\"blue\"},{\"text\":\"\\n\\u041f\\u043e \\u0438\\u0441\\u0442\\u0435\\u0447\\u0435\\u043d\\u0438\\u0435 \\u0432\\u044b \\u0431\\u0443\\u0434\\u0435\\u0442\\u0435 \\u0437\\u0430\\u0431\\u0430\\u043d\\u0435\\u043d\\u044b.\\n\\u0427\\u0442\\u043e\\u0431 \\u043e\\u0442\\u043f\\u0440\\u0430\\u0432\\u0438\\u0442\\u044c Discord \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0443 \\u0432\\u043f\\u0438\\u0448\\u0438\\u0442\\u0435 \\u043a\\u043e\\u043c\\u0430\\u043d\\u0434\\u0443:\\n- /msg <\\u043d\\u0438\\u043a \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0430> <\\u0432\\u0430\\u04488\"}]");
            }

            return false;
        }
    }
}
