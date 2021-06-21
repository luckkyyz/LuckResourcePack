package me.luckkyyz.resourcepack.config;

import me.luckkyyz.luckapi.message.Message;
import me.luckkyyz.luckapi.message.serialize.MessageSerializers;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingConfig extends me.luckkyyz.luckapi.config.SettingConfig {

    private String resourcePackUrl;
    private Message kickMessage;
    private boolean required;

    public SettingConfig(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void reload() {
        super.reload();
    }

    @Override
    protected void load(YamlConfiguration yaml) {
        resourcePackUrl = yaml.getString("url");
        kickMessage = MessageSerializers.yaml().deserialize(yaml, "kickMessage");
        required = config.getBoolean("required");
    }

    public String getResourcePackUrl() {
        return resourcePackUrl;
    }

    public boolean isRequired() {
        return required;
    }

    public Message getKickMessage() {
        return kickMessage;
    }

}
