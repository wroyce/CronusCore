package main.java.mc.wroyce.cronuscore.Features;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import static main.java.mc.wroyce.cronuscore.Util.Util.config;

public class Sponge implements Listener {
    double radius = config.getDouble("sponge-radius") / 2.0D;

    @EventHandler(priority=EventPriority.HIGHEST)
    public void spongePlace(BlockPlaceEvent e) {
        Block block = e.getBlock();
        World w = block.getWorld();
        if (block.getType() == Material.SPONGE) {
            FPlayer fPlayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
            if (fPlayer.isInOwnTerritory()) {
                int bx = block.getX();
                int by = block.getY();
                int bz = block.getZ();
                for (int fx = (int)-this.radius; fx <= this.radius; fx++) {
                    for (int fy = (int)-this.radius; fy <= this.radius; fy++) {
                        for (int fz = (int)-this.radius; fz <= this.radius; fz++) {
                            Block b = w.getBlockAt(bx + fx, by + fy, bz + fz);
                            if ((b.getType().equals(Material.STATIONARY_LAVA)) || (b.getType().equals(Material.LAVA)) ||
                                    (b.getType().equals(Material.STATIONARY_WATER)) || (b.getType().equals(Material.WATER))) {
                                b.setType(Material.AIR);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void on(BlockFromToEvent e) {
        Block block = e.getBlock();
        World world = block.getWorld();

        int blockX = block.getX();
        int blockY = block.getY();
        int blockZ = block.getZ();
        for (int fromX = (int)-(this.radius + 1.0D); fromX <= this.radius + 1.0D; fromX++) {
            for (int fromY = (int)-(this.radius + 1.0D); fromY <= this.radius + 1.0D; fromY++) {
                for (int fromZ = (int)-(this.radius + 1.0D); fromZ <= this.radius + 1.0D; fromZ++) {
                    Block b = world.getBlockAt(blockX + fromX, blockY + fromY, blockZ + fromZ);
                    if (b.getType().equals(Material.SPONGE)) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}