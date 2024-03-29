package com.ericlam.mc.bungee.dnmc.permission;


import net.md_5.bungee.api.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Perm {
    public static final String ADMIN = "dragonite.admin";
    public static final String HELPER = "dragonite.helper";
    public static final String MOD = "dragonite.mod";
    public static final String BUILDER = "dragonite.builder";
    public static final String DONOR = "dragonite.donor";
    public static final String DEVELOPER = "dragonite.developer";
    public static final String OWNER = "*";

    public static boolean hasPermission(CommandSender sender, String permission) {
        boolean reuslt = false;
        if (permission == null) return true;
        for (String Pnode : getPermHierarchy(permission)) {
            reuslt = reuslt || sender.hasPermission(Pnode);
        }
        return reuslt;
    }

    public static List<String> getPermHierarchy(String string) {
        String[] node = string.split("\\.");
        List<String> permissionNode = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < node.length; i++) {
            stringBuilder.append(node[i]);
            permissionNode.add(stringBuilder.toString());
            if (i != node.length - 1) stringBuilder.append(".");
        }
        return permissionNode;
    }
}
