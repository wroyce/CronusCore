package mc.wroyce.cronuscore.Commands;

import main.java.mc.wroyce.cronuscore.Listeners.PingListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class CommandPing implements CommandExecutor {
    public Map<String, String> oto;

    public CommandPing() {
        this.oto = new HashMap<String, String>();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player) && args.length == 0) {
            sender.sendMessage("§cCan only be used in-game");
        }
        else if (!sender.hasPermission("cronuscore.ping")) {
            sender.sendMessage("§cYou are not allowed to use that command.");
        }
        else if (args.length == 0) {
            try {
                sender.sendMessage("§7Your ping is: §c" + PingListener.getPlayerPing((Player)sender) + "§7ms.");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            final Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                try {
                    sender.sendMessage("§4§l» §c" + player.getName() + "'s §7ping is: §c" + PingListener.getPlayerPing(player) + "§7ms");
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            else {
                sender.sendMessage("§4§l» §cPlayer §4" + args[0] + " §cis not online.");
            }
        }
        return true;
    }
}

