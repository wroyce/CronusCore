package mc.wroyce.cronuscore.Features;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class FactionAlerts implements Listener {

    @EventHandler
    public void facMemberLeaves(PlayerQuitEvent e) {
        Faction fac = null;
        Player player = e.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(e.getPlayer());
        fac = fplayer.getFaction();
        if ((Core.getInstance().getConfig().getBoolean("FactionAlerts")) && (fplayer.hasFaction())) {
            for (Player fmembers : fac.getOnlinePlayers()) {
                fmembers.sendMessage(Color.toColor(Core.getInstance().getConfig().getString("Faction-Alerts.Left")
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
        if ((Core.getInstance().getConfig().getBoolean("FactionAlerts")) && (fplayer.hasFaction())) {
            for (Player fmembers : fac.getOnlinePlayers()) {
                fmembers.sendMessage(Color.toColor(Core.getInstance().getConfig().getString("Faction-Alerts.Joined")
                        .replaceAll("%Player%", player.getName())
                        .replaceAll("%Faction%", fplayer.getFaction().getTag())));
            }
        }
    }
}
