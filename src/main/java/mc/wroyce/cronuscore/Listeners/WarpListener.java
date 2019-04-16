package mc.wroyce.cronuscore.Listeners;

import mc.wroyce.cronuscore.Commands.CommandWarp;
import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static mc.wroyce.cronuscore.Util.Util.color;

public class WarpListener implements Listener {


    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        try {
            if (e.getClickedInventory() == null) {
                return;
            }

            if (e.getClickedInventory().getName() == null) {
                return;
            }

            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getClickedInventory().getName().equalsIgnoreCase(color(CommandWarp.title))) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Name")))) {
                Util.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Command")
                        .replace("%player%", player.getName()));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Name"))))) {
                Util.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Command")
                        .replace("%player%", player.getName()));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Name"))))) {
                Util.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Command")
                        .replace("%player%", player.getName()));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Name"))))) {
                Util.sendConsole(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Command")
                        .replace("%player%", player.getName()));
            }
        } catch (NullPointerException exception) {
            return;
        }

    }
}
