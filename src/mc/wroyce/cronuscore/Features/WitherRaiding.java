package mc.wroyce.cronuscore.Features;


import java.util.List;

import mc.wroyce.cronuscore.Core;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class WitherRaiding implements Listener {
    @EventHandler
    public void onWitherCreated(EntitySpawnEvent e) {
        List<String> disabled = Core.getInstance().getConfig().getStringList("Wither-disabled-worlds");
        if ((disabled.contains(e.getLocation().getWorld().getName())) && (e.getEntityType().equals(EntityType.WITHER))) {
            e.setCancelled(true);
        }
    }
}