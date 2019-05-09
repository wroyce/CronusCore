package mc.wroyce.cronuscore.Features;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Iterator;

import static mc.wroyce.cronuscore.Util.Util.config;

public class ChatFilter implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        String message = e.getMessage();

        boolean sendWarning = false;
        boolean bypassPerm = p.hasPermission(config.getString("cronuscore.chatfilter.bypass"));

        char star = config.getString("Replace-Symbol").charAt(0);
        Iterator<String> stuff = config.getStringList("Muted-Words").iterator();
        while (stuff.hasNext()) {
            String str = stuff.next();
            if (message.toLowerCase().contains(str.toLowerCase()) && !bypassPerm) {
                message = message.replace(str, new String(new char[str.length()]).replace('\0', star));
                if (!sendWarning) {
                    sendWarning = true;
                }
            }
        }

        if (sendWarning)
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("ChatFilter.Message1")));
        e.setMessage(message);

    }
}
