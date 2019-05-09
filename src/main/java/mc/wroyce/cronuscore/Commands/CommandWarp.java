package mc.wroyce.cronuscore.Commands;

import mc.wroyce.cronuscore.Listeners.WarpItems;
import mc.wroyce.cronuscore.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static mc.wroyce.cronuscore.Util.Util.color;
import static mc.wroyce.cronuscore.Util.Util.config;

public class CommandWarp implements CommandExecutor {

    int size = config.getInt("GUI.Warp.Size");
    public static String title = color(config.getString("GUI.Warp.Title"));

    int CrateSlot = config.getInt("GUI.Warp.Items.Crates.Slot");
    int NetherSlot = config.getInt("GUI.Warp.Items.Nether.Slot");
    int EndSlot = config.getInt("GUI.Warp.Items.End.Slot");
    int WastelandsSlot = config.getInt("GUI.Warp.Items.Wastelands.Slot");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) || (!sender.hasPermission("cronuscore.warp"))) {
            sender.sendMessage(color(config.getString("No-Permission")));
            return true;
        } else {
            Player player = (Player) sender;
            Inventory inventory = Bukkit.createInventory(null, size, title);
            player.openInventory(inventory);

            inventory.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE, 1));
            ItemStack background = new ItemBuilder(Material.STAINED_GLASS_PANE).setName(color("&9")).setDurability((short) 15).build();
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
