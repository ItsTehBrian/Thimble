package xyz.tehbrian.maventehplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.tehbrian.maventehplugin.MavenTehPlugin;

import java.util.Objects;

public class MiscUtils {

    private MiscUtils() {}

    public static String color(String string) {
        return string == null ? null : ChatColor.translateAlternateColorCodes('&', string);
    }

    public static Location getSpawn() {
        FileConfiguration config = MavenTehPlugin.getInstance().getConfig();
        return new Location(Bukkit.getWorld(Objects.requireNonNull(config.getString("spawn.world"))), config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"));
    }
}
