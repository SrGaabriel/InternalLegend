package net.gabriel.internal.legend.com.listeners;

import net.gabriel.internal.legend.com.managers.LegendManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LegendListener implements Listener {

    @EventHandler
    public void aoEntrar(PlayerJoinEvent e) {
        if (LegendManager.isLegend(e.getPlayer())) {
            Bukkit.broadcastMessage("§4§lLENDA §fA lenda chegou, o nome dela é §4" + e.getPlayer().getName() + "§f!");
        }
    }

    @EventHandler
    public void aoMorrer(PlayerDeathEvent e) {
        EntityDamageEvent.DamageCause dc = e.getEntity().getLastDamageCause().getCause();
        if (LegendManager.isLegend(e.getEntity()) && dc == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            LegendManager.setLegend(e.getEntity().getKiller());
            LegendManager.broadcastLegend(e.getEntity().getKiller());
        }
    }

}

