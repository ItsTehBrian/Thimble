package xyz.tehbrian.maventehplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tehbrian.maventehplugin.commands.TestCommand;
import xyz.tehbrian.maventehplugin.listeners.BucketListener;
import xyz.tehbrian.maventehplugin.listeners.PlayerListener;

public final class MavenTehPlugin extends JavaPlugin {

    private static MavenTehPlugin instance;

    public static MavenTehPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        setupConfig();
        setupEvents();
        setupCommands();
    }

    @Override
    public void onDisable() {
        getLogger().info("See you later!");
    }

    private void setupConfig() {
        saveDefaultConfig();
    }

    private void setupEvents() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new BucketListener(this), this);
        pluginManager.registerEvents(new PlayerListener(this), this);
    }

    private void setupCommands() {
        getCommand("test").setExecutor(new TestCommand(this));
    }
}

