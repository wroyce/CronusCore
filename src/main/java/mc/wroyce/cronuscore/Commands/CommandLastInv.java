package main.java.mc.wroyce.cronuscore.Commands;

import main.java.mc.wroyce.cronuscore.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.java.mc.wroyce.cronuscore.Util.Util.color;
import static main.java.mc.wroyce.cronuscore.Util.Util.config;

public class CommandLastInv implements CommandExecutor {

    private Core main;

    public CommandLastInv(Core main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("lastinv") && p.hasPermission("cronuscore.lastinv")) {
                int length = args.length;
                if (length == 0) {
                    p.sendMessage(color("&c[!] &c/Lastinv <player>"));
                    p.sendMessage(color("&7Fully restores a player inventory from a pvp death."));
                    return false;
                }
                if (length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        p.sendMessage(color(config.getString("PlayerNotFound")));
                        return false;
                    }
                    if (!p.hasPermission("cronuscore.lastinv")) {
                        p.sendMessage(color(config.getString("No-Permission")));
                        return false;
                    }
                    if (main.itemsMap.containsKey(target.getName()) && main.armorMap.containsKey(target.getName())) {
                        main.restoreInventory(target);
                        p.sendMessage(color(config.getString("PlayerRestored"))
                                .replace("%Target%", target.getName()));
                        target.sendMessage(color(config.getString("TargetRestored")));
                    } else {
                        p.sendMessage(color(config.getString("UnableToRestore")));
                    }
                }
            }
        }

        return false;
    }
}