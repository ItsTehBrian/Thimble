package xyz.tehbrian.maventehplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import xyz.tehbrian.maventehplugin.MavenTehPlugin;
import xyz.tehbrian.maventehplugin.util.MsgBuilder;

public class BucketListener implements Listener {

    private final MavenTehPlugin main;

    public BucketListener(MavenTehPlugin main) {
        this.main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {
        event.getPlayer().sendMessage(new MsgBuilder().msgKey("msg.bucket.careful").prefixKey("prefix.bucket").build());
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
        event.getPlayer().sendMessage(new MsgBuilder().msgKey("msg.bucket.glad").prefixKey("prefix.bucket").build());
    }
}
