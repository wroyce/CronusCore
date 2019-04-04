package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cronuscore")) {
            try {
                if (!(args.length == 1)) {
                    sender.sendMessage(Color.toColor("&cInvalid args. use /cronuscore reload"));
                }
                if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("cronuscore.admin")) {
                    Core.getInstance().reloadConfig();
                    sender.sendMessage(Color.toColor("&a[!] Configuration reloaded."));
                } else {
                    sender.sendMessage(Color.toColor("&c[!] No Permission"));
                }
            } catch (IndexOutOfBoundsException ex) {
            }

        }
        return true;
    }
}
