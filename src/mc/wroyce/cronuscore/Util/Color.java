package mc.wroyce.cronuscore.Util;

import org.bukkit.command.CommandSender;

public class Color {

    public static String toColor(String message) {
        message = message.replaceAll("&", "§");
        return message;
    }
}
