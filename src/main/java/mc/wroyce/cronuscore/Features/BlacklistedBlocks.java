package mc.wroyce.cronuscore.Features;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static mc.wroyce.cronuscore.Util.Util.color;

public class BlacklistedBlocks implements Listener {

    @EventHandler
    public void onBedrockPlacement (BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (e.getBlockPlaced().getType().equals(Material.BEDROCK) && !player.isOp()) {
            player.sendMessage(color("&c&l[!] You are not allowed to place bedrock as a non-op."));
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBarrierPlacement (BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (e.getBlockPlaced().getType().equals(Material.BARRIER) && !player.isOp()) {
            player.sendMessage(color("&c&l[!] You are not allowed to place Barriers as a non-op."));
            e.setCancelled(true);
        }
    }
}
