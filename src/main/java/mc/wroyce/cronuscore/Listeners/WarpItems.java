package main.java.mc.wroyce.cronuscore.Listeners;

import main.java.mc.wroyce.cronuscore.Core;
import main.java.mc.wroyce.cronuscore.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static main.java.mc.wroyce.cronuscore.Util.Util.color;


public class WarpItems {

    public static ItemStack CrateWarp = new ItemBuilder(Material.CHEST)
            .setName(color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Crates.Name")))
            .setLore(color("&7Try your luck with the crates!"), "", color("&7Right click to warp to &e/warp crates")).build();

    public static ItemStack NetherWarp = new ItemBuilder(Material.NETHER_BRICK)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Nether.Name"))))
            .setLore(color("&7Warp the nether realm."), color("&7This is 5000x5000 blocks of pure nothingless,"),
                    color("&7Do you think you can conquer it? Try your luck!"),
                    color(""), color("&7Right click to warp to &e/warp nether")).build();

    public static ItemStack EndWarp = new ItemBuilder(Material.ENDER_STONE)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.End.Name"))))
            .setLore(color("&7Warp the end realm."), color("&7This is 5000x5000 blocks of pure nothingless,"),
                    color("&7Do you think you can conquer it? Try your luck!"),
                    color(""), color("&7Right click to warp to &e/warp end")).build();

    public static ItemStack Wastelands = new ItemBuilder(Material.DIAMOND_SWORD)
            .setName((color(Core.getInstance().getConfig().getString("GUI.Warp.Items.Wastelands.Name"))))
            .setLore(color("&7Warp the wasteland realm."), color("&7This is 2500x2500 blocks of pure nothingless,"),
                    color("&7Do you think you can conquer it? Try your luck!"),
                    color(""), color("&7Right click to warp to &e/warp wastelands")).build();

    public static ItemStack Soon = new ItemBuilder(Material.BARRIER)
            .setName(color("&cComing Soon"))
            .setLore(color("&7Keep active on our discord and forums"), color("&7for more updates on this!"), color(""),
                    color("&7Website: &eCronuspvp.net/forums"), color("&7Discord: &eDiscord.io/cronuspvp")).build();
}
