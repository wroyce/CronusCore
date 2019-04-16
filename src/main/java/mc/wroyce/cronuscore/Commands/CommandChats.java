package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class CommandChats implements Listener
{
    @EventHandler
    public void onChatEvent(PlayerCommandPreprocessEvent e) {
        String message = e.getMessage();
        if (message.equalsIgnoreCase("/Discord")) {
            List<String> help = config.getStringList("Discord");
            e.setCancelled(true);
            for (String s : help) {
                e.getPlayer().sendMessage(color(s));
            }
        }
    }
}
