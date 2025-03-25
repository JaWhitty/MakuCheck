package ru.mironxx.makuCheck;

import org.bukkit.plugin.java.JavaPlugin;

public final class MakuCheck extends JavaPlugin {

    public String prefix = "[MakuCheck]";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(prefix + " Started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Bye-bye!");
    }
}
