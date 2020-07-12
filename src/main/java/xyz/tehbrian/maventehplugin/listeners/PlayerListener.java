package xyz.tehbrian.maventehplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.tehbrian.maventehplugin.MavenTehPlugin;
import xyz.tehbrian.maventehplugin.util.MiscUtils;
import xyz.tehbrian.maventehplugin.util.MsgBuilder;

public class PlayerListener implements Listener {

    private final MavenTehPlugin main;

    public PlayerListener(MavenTehPlugin main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getName().equals("TehBrian")) {
            player.sendMessage(new MsgBuilder().def("msg.famous").build());
        }

        player.teleport(MiscUtils.getSpawn());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        event.getPlayer().sendMessage(new MsgBuilder().def("msg.goodnight").build());
    }
}
