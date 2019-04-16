package mc.wroyce.cronuscore.Features;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Relation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class AntiMineSpawner implements Listener {

    @EventHandler
    public void onSpawnerMine(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if(e.getBlock().getType().equals(Material.MOB_SPAWNER)) {
            if (isEnemyNearby(p)) {
                e.setCancelled(true);
            }
        }
    }

    public boolean isEnemyNearby(Player player) {
        Location loc = player.getLocation();
        for (Player enemyPlayer : Bukkit.getOnlinePlayers()) {
            Location enemyLoc = enemyPlayer.getLocation();
            if (player == enemyPlayer || enemyPlayer.isOp() || !player.canSee(enemyPlayer) || loc.getWorld() != enemyLoc.getWorld()) {
                continue;
            }
            FPlayer other = FPlayers.getInstance().getByPlayer(enemyPlayer);
            Relation relation = other.getRelationTo(FPlayers.getInstance().getByPlayer(player));
            if (relation.isMember() || relation.isTruce() || relation.isAlly()) {
                continue;
            }
            double distX = Math.abs(loc.getX() - enemyLoc.getX());
            double distZ = Math.abs(loc.getZ() - enemyLoc.getZ());
            int radius = config.getInt("Spawners.radius-check");
            if (distX <= radius && distZ <= radius) {
                player.sendMessage(color("&c&l[!] &cYou cannot mine spawners with enemies nearby!"));
                return true;
            }
        }
        return false;
    }
}
