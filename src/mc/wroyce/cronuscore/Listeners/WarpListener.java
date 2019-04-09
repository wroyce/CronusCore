package mc.wroyce.cronuscore.Listeners;

import mc.wroyce.cronuscore.Commands.CommandWarp;
import mc.wroyce.cronuscore.Util.Color;
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
    }
}
