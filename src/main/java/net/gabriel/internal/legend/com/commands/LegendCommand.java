package net.gabriel.internal.legend.com.commands;

import net.gabriel.internal.legend.com.storage.ConfigManager;
import net.gabriel.internal.legend.com.managers.LegendManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LegendCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sendLegend(s);
            return false;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (s.hasPermission("internal.lenda")) {
                ConfigManager.loadConfig();
                s.sendMessage(ConfigManager.getMessage("config-was-reloaded"));
                return false;
            } else {
                sendLegend(s);
                return false;
            }
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("set") && s.hasPermission("internal.lenda")) {
            OfflinePlayer x;
            try {
                x = Bukkit.getOfflinePlayer(args[1]);
            } catch (Exception e) {
                s.sendMessage(ConfigManager.getMessage("player-couldnt-be-find"));
                return false;
            }
            if (x == null || !x.isOnline()) {
                s.sendMessage(ConfigManager.getMessage("player-couldnt-be-find"));
            } else {
                LegendManager.setLegend(x);
                LegendManager.broadcastLegend(x);
            }
        }
        return false;
    }


    private void sendLegend(CommandSender s) {
        String message = LegendManager.existsLegend() ? ConfigManager.getMessage("legend-info") : ConfigManager.getMessage("no-legend");
        s.sendMessage(message);
    }

}
