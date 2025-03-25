package ru.mironxx.makuCheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MakuCheck extends JavaPlugin {

    public String prefix;
    public ConsoleCommandSender console;

    @Override
    public void onEnable() {
        getLogger().info("Запущено!");
        saveDefaultConfig();
        prefix = getConfig().getString("prefix", "§6[MakuCheck]§r ");
        console = getServer().getConsoleSender();
        getCommand("check").setExecutor(new CheckCommandExecutor());
    }

    @Override
    public void onDisable() {
        getLogger().info("Пока-пока!");
    }

    public class CheckCommandExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
            if (args.length == 0) {
                commandSender.sendMessage(prefix + " Запущен MakuCheck версии 1.0.0 SNAPSHOT");
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                prefix = getConfig().getString("prefix", "§6[MakuCheck]§r ");
                commandSender.sendMessage(prefix + " Plugin reloaded!");
                return true;
            }

            if (args[0].equalsIgnoreCase("help")) {
                commandSender.sendMessage(prefix + " Usage:");
                commandSender.sendMessage(prefix + " /check help - Shows this list");
                commandSender.sendMessage(prefix + " /check reload - Reload plugin");
                return true;
            }

            if (args.length > 1 && args[0].equalsIgnoreCase("discord")) {
                String targetName = args[1];
                if (getServer().getPlayer(targetName) != null) {
                    getServer().dispatchCommand(console, "freeze " + targetName);
                    getServer().dispatchCommand(console, "tellraw " + targetName + " [\"\",{\"text\":\"!! \\u041f\\u0420\\u041e\\u0412\\u0415\\u0420\\u041a\\u0410 \\u041d\\u0410 \\u0427\\u0418\\u0422\\u042b !!\",\"bold\":true,\"color\":\"green\"},{\"text\":\"\\n\\n\\u0423 \\u0432\\u0430\\u0441 \\u0435\\u0441\\u0442\\u044c 2 \\u043c\\u0438\\u043d\\u0443\\u0442\\u044b \\u0447\\u0442\\u043e\\u0431 \\u0441\\u043a\\u0438\\u043d\\u0443\\u0442\\u044c \\u0432\\u0430\\u0448 \",\"color\":\"white\"},{\"text\":\"Discord\",\"color\":\"blue\"},{\"text\":\"\\n\\u041f\\u043e \\u0438\\u0441\\u0442\\u0435\\u0447\\u0435\\u043d\\u0438\\u0435 \\u0432\\u044b \\u0431\\u0443\\u0434\\u0435\\u0442\\u0435 \\u0437\\u0430\\u0431\\u0430\\u043d\\u0435\\u043d\\u044b.\\n\\u0427\\u0442\\u043e\\u0431 \\u043e\\u0442\\u043f\\u0440\\u0430\\u0432\\u0438\\u0442\\u044c Discord \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0443 \\u0432\\u043f\\u0438\\u0448\\u0438\\u0442\\u0435 \\u043a\\u043e\\u043c\\u0430\\u043d\\u0434\\u0443:\\n- /msg <\\u043d\\u0438\\u043a \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0430> <\\u0432\\u0430\\u0448\"}]");
                    return true;
                } else {
                    commandSender.sendMessage(prefix + " Игрок " + targetName + " не найден!");
                    return true;
                }
            }

            if (args.length > 1 && args[0].equalsIgnoreCase("anydesk")) {
                String targetName = args[1];
                if (getServer().getPlayer(targetName) != null) {
                    getServer().dispatchCommand(console, "freeze " + targetName);
                    getServer().dispatchCommand(console, "tellraw " + targetName + " [\"\",{\"text\":\"!! \\u041f\\u0420\\u041e\\u0412\\u0415\\u0420\\u041a\\u0410 \\u0427\\u0415\\u0420\\u0415\\u0417 \",\"bold\":true},{\"text\":\"ANYDESK\",\"bold\":true,\"color\":\"red\"},{\"text\":\" !!\\n\\n\\u0422\\u0440\\u0435\\u0431\\u0443\\u0435\\u0442\\u0441\\u044f \\u0441\\u043a\\u0430\\u0447\\u0430\\u0442\\u044c \",\"bold\":true},{\"text\":\"Anydesk\",\"bold\":true,\"color\":\"red\"},{\"text\":\" \\u0441 \",\"bold\":true},{\"text\":\"\\u043e\\u0444\\u0444\\u0438\\u0446\\u0438\\u0430\\u043b\\u044c\\u043d\\u043e\\u0433\\u043e \\u0441\\u0430\\u0439\\u0442\\u0430\\n\\u041e\\u0442\\u043f\\u0440\\u0430\\u0432\\u044c\\u0442\\u0435 \\u0432\\u0430\\u0448 \\u043a\\u043e\\u0434 \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0443 (msg <\\u0438\\u043c\\u044f \\u0430\\u0434\\u043c\\u0438\\u043d\\u0430> <\\u0432\\u0430\\u0448 \\u043a\\u043e\\u0434>)\\n\\u0412\\u044b\\u0434\\u0430\",\"bold\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://anydesk.com\"}},{\"text\":\"\\u0439\\u0442\\u0435 \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440\\u0443 \\u043f\\u0440\\u0430\\u0432\\u043e \\u0443\\u043f\\u0440\\u0430\\u0432\\u043b\\u044f\\u0442\\u044c \\u0432\\u0430\\u0448\\u0435\\u0439 \\u043c\\u044b\\u0448\\u043a\\u043e\\u0439 \\u0438 \\u043a\\u043b\\u0430\\u0432\\u0438\\u0430\\u0442\\u0443\\u0440\\u043e\\u0439.\",\"bold\":true},{\"text\":\"\\n\"},{\"text\":\"P.S \\u0415\\u0441\\u043b\\u0438 \\u0430\\u0434\\u043c\\u0438\\u043d\\u0438\\u0441\\u0442\\u0440\\u0430\\u0442\\u043e\\u0440 \\u043e\\u0442\\u043a\\u0440\\u044b\\u0432\\u0430\\u0435\\u0442 \\u0422\\u0435\\u0440\\u043c\\u0438\\u043d\\u0430\\u043b - \\u0417\\u0430\\u043a\\u0440\\u044b\\u0432\\u0430\\u0439\\u0442\\u0435 \\u0435\\u043c\\u0443 \\u0434\\u043e\\u0441\\u0442\\u0443\\u043f \\u0438 \\u041f\\u0438\\u0448\\u0438\\u0442\\u0435 \\u0432 \\u043f\\u043e\\u0434\\u0434\\u0435\\u0440\\u0436\\u043a\\u0443!\",\"color\":\"dark_gray\"}]");
                    return true;
                } else {
                    commandSender.sendMessage(prefix + " Игрок " + targetName + " не найден!");
                    return true;
                }
            }

            commandSender.sendMessage(prefix + " Неизвестная команда. Используйте /check help");
            return false;
        }
    }
}