package mc.wroyce.cronuscore.Listeners;

import mc.wroyce.cronuscore.Core;
import mc.wroyce.cronuscore.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static mc.wroyce.cronuscore.Util.Util.*;


public class WarpItems {

    public static ItemStack CrateWarp = new ItemBuilder(Material.CHEST)
            .setName(color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Name")))
            .setLore(colorList(config.getStringList("GUI.Warp.Items.Crates.Lore"))).build();

    public static ItemStack NetherWarp = new ItemBuilder(Material.NETHER_BRICK)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Name"))))
            .setLore(colorList(config.getStringList("GUI.Warp.Items.Nether.Lore"))).build();

    public static ItemStack EndWarp = new ItemBuilder(Material.ENDER_STONE)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Name"))))
            .setLore(colorList(config.getStringList("GUI.Warp.Items.End.Lore"))).build();

    public static ItemStack Wastelands = new ItemBuilder(Material.DIAMOND_SWORD)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Name"))))
            .setLore(colorList(config.getStringList("GUI.Warp.Items.Wastelands.Lore"))).build();

    public static ItemStack Soon = new ItemBuilder(Material.BARRIER)
            .setName(color("&cComing Soon"))
            .setLore(color("&7Keep active on our discord and forums"), color("&7for more updates on this!"), color(""),
                    color("&7Website: &eCronuspvp.net/forums"), color("&7Discord: &eDiscord.io/cronuspvp")).build();
}
