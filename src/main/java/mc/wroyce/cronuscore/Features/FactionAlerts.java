package mc.wroyce.cronuscore.Features;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class FactionAlerts implements Listener {

    @EventHandler
    public void facMemberLeaves(PlayerQuitEvent e) {
        Faction fac = null;
        Player player = e.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
        fac = fplayer.getFaction();
        if ((config.getBoolean("FactionAlerts")) && (fplayer.hasFaction())) {
            for (Player fmembers : fac.getOnlinePlayers()) {
                fmembers.sendMessage(color(config
                        .getString("Faction-Alerts.Left")
                        .replaceAll("%Player%", player.getName())
                        .replaceAll("%Faction%", fplayer.getFaction().getTag())));
            }
        }
    }

    @EventHandler
    public void facMemberJoins(PlayerJoinEvent e) {
        Faction fac = null;
        Player player = e.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
        fac = fplayer.getFaction();
        if ((config.getBoolean("FactionAlerts")) && (fplayer.hasFaction())) {
            for (Player fmembers : fac.getOnlinePlayers()) {
                fmembers.sendMessage(color(config
                        .getString("Faction-Alerts.Joined")
                        .replaceAll("%Player%", player.getName())
                        .replaceAll("%Faction%", fplayer.getFaction().getTag())));
            }
        }
    }
}
