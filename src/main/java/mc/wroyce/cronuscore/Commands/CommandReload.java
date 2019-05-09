package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class CommandReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cronuscore")) {
            try {
                if (!(args.length == 1)) {
                    sender.sendMessage(color("&cInvalid args. use /cronuscore reload"));
                }
                if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("cronuscore.admin")) {
                    Core.getInstance().reloadConfig();
                    sender.sendMessage(color(config.getString("Reload")));
                } else {
                    sender.sendMessage(color(config.getString("No-Permission")));
                }
            } catch (IndexOutOfBoundsException ex) {
            }

        }
        return true;
    }
}
