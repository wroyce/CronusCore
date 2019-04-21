package main.java.mc.wroyce.cronuscore.premium;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiDamage implements Listener {

    @EventHandler
    public void onPlayerDamage (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed) {
            Player p = (Player) e.getEntity();
            if(p.hasPermission("cronuscore.antitntdamage")) {
                e.setCancelled(true);
            } else {
                return;
            }
        }

        if (e.getEntity() instanceof Player && e.getDamager() instanceof Creeper) {
            Player p = (Player) e.getEntity();
            if (p.hasPermission("cronuscore.anticreeperdamage")) {
                e.setCancelled(true);
            } else {
                return;
            }
        }
    }
}
