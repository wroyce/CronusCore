package main.java.mc.wroyce.cronuscore.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class PingListener implements Listener {

    private static Class<?> craftPlayer;
    private static Method handle;
    private static Field pingField;

    static {
        try {
            final String serverVersion = getServerVersion();
            PingListener.craftPlayer = Class.forName("org.bukkit.craftbukkit." + serverVersion + ".entity.CraftPlayer");
            final Class<?> entityPlayer = Class.forName("net.minecraft.server." + serverVersion + ".EntityPlayer");
            PingListener.handle = PingListener.craftPlayer.getMethod("getHandle", (Class<?>[])new Class[0]);
            PingListener.pingField = entityPlayer.getField("ping");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void msg(final CommandSender target, final String message) {
    }

    public static int getPlayerPing(final Player player) throws Exception {
        int ping = 0;
        final Object converted = PingListener.craftPlayer.cast(player);
        final Object entityPlayer = PingListener.handle.invoke(converted, new Object[0]);
        ping = PingListener.pingField.getInt(entityPlayer);
        return ping;
    }

    public static String getServerVersion() {
        final Pattern brand = Pattern.compile("(v|)[0-9][_.][0-9][_.][R0-9]*");
        final String pkg = Bukkit.getServer().getClass().getPackage().getName();
        String version = pkg.substring(pkg.lastIndexOf(46) + 1);
        if (!brand.matcher(version).matches()) {
            version = "";
        }
        return version;
    }
}
