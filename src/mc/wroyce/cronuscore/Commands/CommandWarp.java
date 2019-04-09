package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Listeners.WarpItems;
import mc.wroyce.cronuscore.Util.Color;
import mc.wroyce.cronuscore.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandWarp implements CommandExecutor {

    int size = Core.getInstance().getConfig().getInt("GUI.Warp.Size");
    public static String title = Color.toColor(Core.getInstance().getConfig().getString("GUI.Warp.Title"));

    int CrateSlot = Core.getInstance().getConfig().getInt("GUI.Warp.Items.Crates.Slot");
    int NetherSlot = Core.getInstance().getConfig().getInt("GUI.Warp.Items.Nether.Slot");
    int EndSlot = Core.getInstance().getConfig().getInt("GUI.Warp.Items.End.Slot");
    int WastelandsSlot = Core.getInstance().getConfig().getInt("GUI.Warp.Items.Wastelands.Slot");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) || (!sender.hasPermission("cronuscore.warp"))) {
            sender.sendMessage(Color.toColor(Core.getInstance().getConfig().getString("No-Permission")));
            return true;
        } else {
            Player player = (Player) sender;
            Inventory inventory = Bukkit.createInventory(null, size, title);
            player.openInventory(inventory);

            inventory.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE, 1));
            ItemStack background = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(Color.toColor("&9")).setDurability((short) 15).build();
            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, background);
            }

            inventory.setItem(NetherSlot, WarpItems.NetherWarp);
            inventory.setItem(EndSlot, WarpItems.EndWarp);
            inventory.setItem(WastelandsSlot, WarpItems.Wastelands);
            inventory.setItem(CrateSlot, WarpItems.CrateWarp);
            inventory.setItem(32, WarpItems.Soon);

        }
        return true;
    }
}