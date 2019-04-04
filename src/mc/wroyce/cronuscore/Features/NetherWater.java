package mc.wroyce.cronuscore.Features;

import java.util.ArrayList;
import java.util.List;

import mc.wroyce.cronuscore.Core;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NetherWater implements Listener {
    private static List<String> disabledWorlds = new ArrayList();

    public boolean canBuild(Player p, Block b) {
        if (Core.getInstance().wg == null) {
            return true;
        }
        return Core.getInstance().wg.canBuild(p, b);
    }

    public List<String> getDisabledWorlds() {
        disabledWorlds = Core.getInstance().getConfig().getStringList("Nether-Water.disabled");
        return disabledWorlds;
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onWaterPlaced(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (e.getItem() == null) {
            return;
        }
        World w = e.getClickedBlock().getWorld();
        Player p = e.getPlayer();
        if ((w.getEnvironment() == World.Environment.NETHER) && (e.getItem().getType() == Material.WATER_BUCKET) &&
                ((p.hasPermission("cronuscore.netherwater." + w.getName())) || (p.hasPermission("cronuscore.netherwater.all"))) &&
                ((!getDisabledWorlds().contains(w.getName())) || (p.hasPermission("cronuscore.netherwater.bypass"))) &&
                (canBuild(p, e.getClickedBlock().getRelative(e.getBlockFace()))))
        {
            e.setCancelled(true);
            e.getClickedBlock().getRelative(e.getBlockFace()).setType(Material.WATER);
        }
    }
}