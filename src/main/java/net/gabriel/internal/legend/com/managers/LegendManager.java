package net.gabriel.internal.legend.com.managers;

import net.gabriel.internal.legend.com.storage.ConfigManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class LegendManager {
    private static OfflinePlayer legend;

    public static void setLegend(OfflinePlayer player) {
        legend = player;
    }

    public static OfflinePlayer getLegend() {
        return legend;
    }

    public static boolean existsLegend() {
        return legend != null;
    }

    public static void broadcastLegend(OfflinePlayer player) {
        String title = "§4§lLENDA";
        String subtitle = "§fTemos uma nova lenda por aqui!";
        PacketPlayOutTitle packetPlayOutTitle1 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + title +"\"}"));
        PacketPlayOutTitle packetPlayOutTitle2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + subtitle +"\"}"));
        for (Player x : Bukkit.getOnlinePlayers()) {
            (((CraftPlayer) x).getHandle()).playerConnection.sendPacket((Packet) packetPlayOutTitle1);
            (((CraftPlayer) x).getHandle()).playerConnection.sendPacket((Packet) packetPlayOutTitle2);
            x.sendMessage("");
            x.sendMessage(ConfigManager.getMessage("new-legend").replace("%player%", player.getName()));
            x.sendMessage("");
        }
    }

    public static boolean isLegend(Player player) {
        if (legend == null) {
            return false;
        } else {
            return legend.getName().equals(player.getName());
        }
    }

}
