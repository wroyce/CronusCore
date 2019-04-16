package main.java.mc.wroyce.cronuscore.premium;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AntiTNTDamage implements Listener {

    @EventHandler
    public void onPlayerTntDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof TNTPrimed) {
            Player p = (Player) e.getEntity();
            if(p.hasPermission("cronus.antitntdamage")) {
                e.setCancelled(true);
            } else {
                return;
            }
        }
    }
}
