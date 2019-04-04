package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class CommandChats implements Listener
{
    @EventHandler
    public void onChatEvent(PlayerCommandPreprocessEvent e) {
        String message = e.getMessage();
        if (message.equalsIgnoreCase("/Discord")) {
            List<String> help = Core.getInstance().getConfig().getStringList("Discord");
            e.setCancelled(true);
            for (String s : help) {
                e.getPlayer().sendMessage(Color.toColor(s));
            }
        }
    }
}
