package mc.wroyce.cronuscore.Features;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import static mc.wroyce.cronuscore.Util.Util.color;

public class FlyListener implements Listener {

    public FlyListener() {
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (e.getPlayer().isOp()) {
            return;
        }
        if (e.getTo().getY() > 280.05577) {
            e.setCancelled(true);
            p.setVelocity(new Vector(p.getVelocity().getX(), (-0.1), p.getVelocity().getZ()));
            e.getPlayer().sendMessage(color("&cYou have flown too high."));
        }
    }
}
