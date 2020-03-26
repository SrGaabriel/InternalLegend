package net.gabriel.internal.legend.com.storage;

import net.gabriel.internal.legend.com.InternalLegend;
import net.gabriel.internal.legend.com.managers.LegendManager;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class ConfigManager {

    private static HashMap<String, String> idMessage = new HashMap<>();

    @SuppressWarnings("deprecation")
    public static void loadConfig() {
        Config settings = new Config(InternalLegend.getInstance().getDataFolder().getPath(), "settings.yml", InternalLegend.getInstance());

        ConfigValue cv1 = new ConfigValue(settings, "Lenda", "Notch");
        if (!cv1.getString().equalsIgnoreCase("Notch")) {
            LegendManager.setLegend(Bukkit.getOfflinePlayer(cv1.getString()));
        }

        Config messages = new Config(InternalLegend.getInstance().getDataFolder().getPath(), "messages.yml", InternalLegend.getInstance());

        ConfigValue c2 = new ConfigValue(messages, "Jogador-Invalido", "&cO jogador inserido é inválido");
        idMessage.put("player-couldnt-be-find", c2.getString());

        ConfigValue c3 = new ConfigValue(messages, "Configuracao-Recarregada", "&aAs configuracoes foram recarregadas com sucesso!");
        idMessage.put("config-was-reloaded", c3.getString());

        ConfigValue c4 = new ConfigValue(messages, "Lenda-Info", "&aA lenda é &f%player%&a!");
        idMessage.put("legend-info", c4.getString());

        ConfigValue c5 = new ConfigValue(messages, "Lenda-Nao-Existe", "&cNao temos uma lenda no momento!");
        idMessage.put("no-legend", c5.getString());

        ConfigValue c6 = new ConfigValue(messages, "Nova-Lenda", "&4Temos uma nova lenda! O nome dela é %player%");
        idMessage.put("new-legend", c6.getString());
    }

    public static String getMessage(String id) {
        return idMessage.get(id).replace("&", "§");
    }

}
