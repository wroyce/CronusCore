package mc.wroyce.cronuscore.Listeners;

import mc.wroyce.cronuscore.Commands.CommandWarp;
import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.Color;
import mc.wroyce.cronuscore.Util.Utilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WarpListener implements Listener {

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }

        if (e.getClickedInventory().getName() == null) {
            return;
        }

        if (e.getCurrentItem() == null) {
            return;
        }

        if (e.getClickedInventory().getName().equalsIgnoreCase(Color.toColor(CommandWarp.title))) {
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.toColor(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Name")))) {
            Utilities.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Command")
                    .replace("%player%", player.getName()));
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((Color.toColor(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Name"))))) {
            Utilities.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Command")
                    .replace("%player%", player.getName()));
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((Color.toColor(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Name"))))) {
            Utilities.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Command")
                    .replace("%player%", player.getName()));
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((Color.toColor(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Name"))))) {
            Utilities.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Command")
                    .replace("%player%", player.getName()));
        }
    }
}
