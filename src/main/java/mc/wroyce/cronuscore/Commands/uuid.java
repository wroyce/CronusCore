package mc.wroyce.cronuscore.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class uuid implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCan only be used in-game");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("uuid") && sender.hasPermission("cronuscore.admin")) {
            final Player player = (Player)sender;
            if (args.length < 1) {
                sender.sendMessage("§7Your UUID: §c" + player.getUniqueId());
                return true;
            }
        }
        if (args.length >= 1) {
            final String targetName = args[0];
            final Player player2 = (Player)sender;
            final Player target = Bukkit.getPlayer(targetName);
            if (target == null) {
                player2.sendMessage("§4§l» §4" + targetName + " §cis offline!");
                return true;
            }
            sender.sendMessage("§c" + targetName + "'s §7UUID: §c" + target.getUniqueId());
        }
        else {
            sender.sendMessage(color(config.getString("No-Permission")));
        }
        return false;
    }
}