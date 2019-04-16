package mc.wroyce.cronuscore.Util;

import mc.wroyce.cronuscore.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

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

    public static void sendMessage(String message, CommandSender sender) {
        sender.sendMessage(color(message));
    }

    public static void SendMainframeMessage(String message, CommandSender player) {
        message = message.replaceAll("&", "§");
        player.sendMessage(message);
    }
}
