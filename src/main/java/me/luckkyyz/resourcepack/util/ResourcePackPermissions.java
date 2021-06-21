package me.luckkyyz.resourcepack.util;

import me.luckkyyz.luckapi.util.permission.PermissionNode;

public final class ResourcePackPermissions {

    private ResourcePackPermissions() {
        throw new UnsupportedOperationException();
    }

    public static final PermissionNode RESOURCE_PACK_COMMAND = PermissionNode.node("LuckResourcePack.command");

    public static final PermissionNode RESOURCE_PACK_RELOAD_COMMAND = PermissionNode.node("LuckResourcePack.command.reload");

}
