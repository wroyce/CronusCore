package main.java.mc.wroyce.cronuscore.Util;

import main.java.mc.wroyce.cronuscore.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Util {


    public static FileConfiguration config = Core.getInstance().getConfig();

    public static void sendConsole(String command) {
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
    }

    public static void log(String message) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(color(message));
    }

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> colorList (List<String> input) {
        List<String> ret = new ArrayList<String>();
        for (String line : input) ret.add(ChatColor.translateAlternateColorCodes('&', line));
        return ret;
    }

    public static void sendMessage(String message, CommandSender sender) {
        sender.sendMessage(color(message));
    }

    public static void SendMainframeMessage(String message, CommandSender player) {
        message = message.replaceAll("&", "§");
        player.sendMessage(message);
    }
}
