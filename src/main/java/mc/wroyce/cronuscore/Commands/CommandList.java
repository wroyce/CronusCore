package main.java.mc.wroyce.cronuscore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.mc.wroyce.cronuscore.Util.Util.color;

public class CommandList implements CommandExecutor {

    private final String line;
    private final String all;
    private final String donators;
    private final String staff;
    private final String separator = ", ";

    public CommandList() {
        this.line = color("&6&m&l---------------------------------------------");
        this.all = color("&cConnected players: &4");
        this.donators = color("&cConnected donators: &4");
        this.staff = color("&cConnected staff: &4");
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (label.equalsIgnoreCase("list")) {
            final List aList = new ArrayList();
            final List dList = new ArrayList();
            final List sList = new ArrayList();
            for (final Player p : Bukkit.getOnlinePlayers()) {
                aList.add(p.getName());
                if (!p.canSee(p)) {
                    sList.remove(p.getName());
                    aList.remove(p.getName());
                    dList.remove(p.getName());
                }

                if (p.hasPermission("cronuscore.list.staff")) {
                    sList.add(p.getName());
                }

                if (p.hasPermission("cronuscore.list.donator")) {
                    dList.add(p.getName());
                }
            }
            sender.sendMessage(this.line);
            sender.sendMessage("");
            sender.sendMessage(this.countSentence(aList.size(), "player", "players"));
            sender.sendMessage(this.countSentence(sList.size(), "staff member", "staff members"));
            sender.sendMessage(this.countSentence(dList.size(), "donator", "donators"));
            final StringBuilder sb = new StringBuilder();
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("donator")) {
                    sb.append(this.donators).append(this.implode(dList));
                } else if (args[0].equalsIgnoreCase("staff")) {
                    sb.append(this.staff).append(this.implode(sList));
                } else if (args[0].equalsIgnoreCase("players")) {
                    sb.append(this.all).append(this.implode(aList));
                }
            }
            sender.sendMessage(sb.toString());
            sender.sendMessage(this.line);
            return true;
        }
        return false;
    }

    private String countSentence(final int number, final String type, final String typePlural) {
        return color("&cThere " + ((number == 1) ? "is " : "are ") + "&4" + number + "&c " + ((number == 1) ? type : typePlural)) + " online";
    }

    private String implode(final Collection<String> strs) {
        final StringBuilder result = new StringBuilder();
        for (final String s : strs) {
            result.append(s).append(", ");
        }
        if (result.length() < 2) {
            return "";
        }
        return result.substring(0, result.length() - ", ".length());
    }
}
