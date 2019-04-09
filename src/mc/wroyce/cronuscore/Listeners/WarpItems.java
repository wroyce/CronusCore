package mc.wroyce.cronuscore.Listeners;

import mc.wroyce.cronuscore.Util.Color;
import mc.wroyce.cronuscore.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WarpItems {

    public static ItemStack CrateWarp = new ItemBuilder(Material.CHEST)
            .setName(Color.toColor("&bCrates"))
            .setLore(Color.toColor("&7Try your luck with the crates!"), "", Color.toColor("&7Right click to warp to &e/warp crates")).build();

    public static ItemStack NetherWarp = new ItemBuilder(Material.NETHER_BRICK)
            .setName(Color.toColor("&cNether"))
            .setLore(Color.toColor("&7Warp the nether realm."), Color.toColor("&7This is 5000x5000 blocks of pure nothingless,"),
                    Color.toColor("&7Do you think you can conquer it? Try your luck!"),
                    Color.toColor(""), Color.toColor("&7Right click to warp to &e/warp nether")).build();

    public static ItemStack EndWarp = new ItemBuilder(Material.ENDER_STONE)
            .setName(Color.toColor("&eEnd"))
            .setLore(Color.toColor("&7Warp the end realm."), Color.toColor("&7This is 5000x5000 blocks of pure nothingless,"),
                    Color.toColor("&7Do you think you can conquer it? Try your luck!"),
                    Color.toColor(""), Color.toColor("&7Right click to warp to &e/warp end")).build();

    public static ItemStack Battlefield = new ItemBuilder(Material.DIAMOND_SWORD)
            .setName(Color.toColor("&2Wastelands"))
            .setLore(Color.toColor("&7Warp the battlefield realm."), Color.toColor("&7This is 2500x2500 blocks of pure nothingless,"),
                    Color.toColor("&7Do you think you can conquer it? Try your luck!"),
                    Color.toColor(""), Color.toColor("&7Right click to warp to &e/warp battlefield")).build();

    public static ItemStack Soon = new ItemBuilder(Material.BARRIER)
            .setName(Color.toColor("&cComing Soon"))
            .setLore(Color.toColor("&7Keep active on our discord and forums"), Color.toColor("&7for more updates on this!"), Color.toColor(""),
                    Color.toColor("&7Website: &eCronuspvp.net/forums"), Color.toColor("&7Discord: &eDiscord.io/cronuspvp")).build();
}
