package me.luckkyyz.resourcepack;

import me.luckkyyz.resourcepack.config.SettingConfig;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "LuckResourcePack", version = "1.0-SNAPSHOT")
@Author("luckkyyz")
@ApiVersion(ApiVersion.Target.v1_16)
@Commands(
        @Command(name = "luckresourcepack", aliases = {"luckrp", "luckresource"})
)
public final class ResourcePackPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        SettingConfig config = new SettingConfig(this);

        new LuckResourcePackCommand(config);
        new ResourcePackListener(this, config);
    }
}
