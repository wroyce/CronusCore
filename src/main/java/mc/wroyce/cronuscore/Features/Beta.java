package main.java.mc.wroyce.cronuscore.Features;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static main.java.mc.wroyce.cronuscore.Util.Util.color;
import static main.java.mc.wroyce.cronuscore.Util.Util.config;

public class Beta implements Listener {

    @EventHandler
    public void onPlayerConnected (PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!config.getBoolean("Beta.enabled")) {
        }
        else if (config.getBoolean("Beta.enabled") && player.hasPlayedBefore()) {
            for (String welcomeBack : config.getStringList("Beta.welcome-back")) {
                player.sendMessage(color(welcomeBack).replace("%Player%", player.getName()));
            }
        }
        else {
            for (String welcome : config.getStringList("Beta.welcome")) {
                player.sendMessage(color(welcome).replace("%Player%", player.getName()));
            }

            for (String command : config.getStringList("Beta.rewards")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%Player%", player.getName()));
            }
        }
    }
}
