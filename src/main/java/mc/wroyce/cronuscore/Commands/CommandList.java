package main.java.mc.wroyce.cronuscore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static main.java.mc.wroyce.cronuscore.Util.Util.color;

public class CommandList implements CommandExecutor {

    private final String staffList = "cronuscore.list.staff";
    private final String donatorList = "cronuscore.list.donator";
    private final String hiddenList = "cronuscore.list.hidden";
    private final String youtubeList = "cronuscore.list.youtube";
    private final String partnerList = "cronuscore.list.partner";

    private final String line;
    private final String all;
    private final String donators;
    private final String staff;
    private final String hidden;
    private final String youtube;
    private final String partner;
    private final String separator = ", ";

    public CommandList() {
        this.line = color("&6&m&l---------------------------------------------");
        this.all = color("&cConnected players: &4");
        this.donators = color("&cConnected donators: &4");
        this.staff = color("&cConnected staff: &4");
        this.youtube = color("&cConnected YouTubers: &4");
        this.partner = color("&cConnected Partners: &4");
        this.hidden = color("&cHidden players: &4");
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (label.equalsIgnoreCase("list")) {
            final Player player = (Player) sender;
            final List aList = new ArrayList();
            final List dList = new ArrayList();
            final List sList = new ArrayList();
            final List hList = new ArrayList();
            final List yList = new ArrayList();
            final List pList = new ArrayList();
            for (final Player p : Bukkit.getOnlinePlayers()) {
                aList.add(p.getName());
                if (p.hasPermission(staffList)) {
                    sList.add(p.getName());
                }

                if (p.hasPermission(donatorList)) {
                    dList.add(p.getName());
                }

                if (p.hasPermission(youtubeList)) {
                    yList.add(p.getName());
                }

                if (p.hasPermission(partnerList)) {
                    pList.add(p.getName());
                }

                if (p.isOp() || p.hasPermission("*")) {
                    dList.remove(p.getName());
                    yList.remove(p.getName());
                    pList.remove(p.getName());
                }

                if (isVanished(p)) {
                    aList.remove(p.getName());
                    sList.remove(p.getName());
                    dList.remove(p.getName());
                    pList.remove(p.getName());
                    yList.remove(p.getName());
                    hList.add(p.getName());
                }
            }
            sender.sendMessage(this.line);
            sender.sendMessage("");
            sender.sendMessage(this.countSentence(aList.size(), "player", "players"));
            sender.sendMessage(this.countSentence(sList.size(), "staff member", "staff members"));
            sender.sendMessage(this.countSentence(dList.size(), "donator", "donators"));
            sender.sendMessage(this.countSentence(yList.size(), "youtuber", "youtubers"));
            sender.sendMessage(this.countSentence(pList.size(), "partner", "partners"));
            if (player.hasPermission(hiddenList)) {
                sender.sendMessage(this.countSentence(hList.size(), "hidden player", "hidden players"));
            }

            final StringBuilder sb = new StringBuilder();
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("donator") || args[0].equalsIgnoreCase("donators")) {
                    sb.append(this.donators).append(this.implode(dList));
                } else if (args[0].equalsIgnoreCase("staff")) {
                    sb.append(this.staff).append(this.implode(sList));
                } else if (args[0].equalsIgnoreCase("players") || args[0].equals("player")) {
                    sb.append(this.all).append(this.implode(aList));
                } else if (args[0].equalsIgnoreCase("youtube") || args[0].equalsIgnoreCase("yt")) {
                   sb.append(this.youtube).append(this.implode(yList));
                } else if (args[0].equalsIgnoreCase("partner") || args[0].equalsIgnoreCase("partners")) {
                    sb.append(this.partner).append(this.implode(pList));
                } else if (args[0].equalsIgnoreCase("hidden") && player.hasPermission(hiddenList)) {
                    sb.append(this.hidden).append(this.implode(hList));
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

    private boolean isVanished (Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }
}
