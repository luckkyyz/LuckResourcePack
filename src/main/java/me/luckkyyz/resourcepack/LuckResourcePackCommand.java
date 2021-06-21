package me.luckkyyz.resourcepack;

import me.luckkyyz.luckapi.command.ChatCommand;
import me.luckkyyz.luckapi.command.ExecutingChecks;
import me.luckkyyz.luckapi.command.ExecutingStrategy;
import me.luckkyyz.resourcepack.config.SettingConfig;
import me.luckkyyz.resourcepack.util.ResourcePackPermissions;

public class LuckResourcePackCommand {

    public LuckResourcePackCommand(SettingConfig config) {
        ChatCommand.registerCommand("luckresourcepack", ExecutingStrategy.newBuilder()
                .subCommandStrategy()
                .addCheck(ExecutingChecks.permission(ResourcePackPermissions.RESOURCE_PACK_COMMAND), session -> session.send("&cУ Вас нет прав!"))
                .whenSubCommandAbsent(session -> session.send("&cТакой команды не существует!"))
                .whenArgumentAbsent(session -> session.send(
                        "&7[&cLuck&fResourcePack&7] &7&l| &fПомощь по командам:",
                        "&7/luckresourcepack reload &7- перезагрузить плагин"))
                .addSubCommand(ExecutingStrategy.newBuilder()
                        .commandStrategy()
                        .addCheck(ExecutingChecks.permission(ResourcePackPermissions.RESOURCE_PACK_RELOAD_COMMAND), session -> session.send("&cУ Вас нет прав!"))
                        .addAction(session -> {
                            config.reload();
                            session.send("&fВы успешно перезагрузили плагин!");
                        })
                )
        );
    }

}
