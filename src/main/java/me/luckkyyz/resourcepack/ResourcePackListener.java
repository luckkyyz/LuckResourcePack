package me.luckkyyz.resourcepack;

import me.luckkyyz.luckapi.event.ExtendedListener;
import me.luckkyyz.resourcepack.config.SettingConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.Plugin;

class ResourcePackListener extends ExtendedListener {

    private SettingConfig config;

    ResourcePackListener(Plugin plugin, SettingConfig config) {
        super(plugin);
        this.config = config;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setResourcePack(config.getResourcePackUrl());
    }

    @EventHandler
    public void onResourcePackStatus(PlayerResourcePackStatusEvent event) {
        Player player = event.getPlayer();
        PlayerResourcePackStatusEvent.Status status = event.getStatus();
        if(status == PlayerResourcePackStatusEvent.Status.ACCEPTED || status == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {
            return;
        }

        if(config.isRequired()) {
            player.kickPlayer(config.getKickMessage().toRawText());
        }
    }
}
