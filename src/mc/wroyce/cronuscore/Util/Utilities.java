package mc.wroyce.cronuscore.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import static mc.wroyce.cronuscore.Util.Color.toColor;

public class Utilities {

    public static void sendConsole(String command)
    {
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
    }

    public static void log(String message)
    {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(toColor(message));
    }

    public static void sendMessage(String message, CommandSender sender)
    {
        sender.sendMessage(toColor(message));
    }

    public static void SendMainframeMessage(String message, CommandSender player)
    {
        message = message.replaceAll("&", "§");
        player.sendMessage(message);
    }
}
