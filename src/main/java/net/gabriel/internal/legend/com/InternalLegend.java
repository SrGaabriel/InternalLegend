package net.gabriel.internal.legend.com;

import net.gabriel.internal.legend.com.commands.LegendCommand;
import net.gabriel.internal.legend.com.listeners.LegendListener;
import net.gabriel.internal.legend.com.storage.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class InternalLegend extends JavaPlugin {

    public void onEnable() {
        ConfigManager.loadConfig();
        getCommand("lenda").setExecutor(new LegendCommand());
        Bukkit.getPluginManager().registerEvents(new LegendListener(), this);
        print("§9[InternalLegend] §aPlugin habilitado com sucesso!");
    }

    public void onDisable() {
        print("§9[InternalLegend] §cPlugin desabilitado com sucesso!");
    }

    private void print(String s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }

    public static InternalLegend getInstance() {
        return InternalLegend.getPlugin(InternalLegend.class);
    }

}
