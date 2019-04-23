package main.java.mc.wroyce.cronuscore;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import main.java.mc.wroyce.cronuscore.Commands.*;
import main.java.mc.wroyce.cronuscore.Features.*;
import main.java.mc.wroyce.cronuscore.Listeners.DeathListener;
import main.java.mc.wroyce.cronuscore.Listeners.WarpListener;
import main.java.mc.wroyce.cronuscore.premium.AntiDamage;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    private static Core instance;
    private static Logger logger;
    public WorldGuardPlugin wg;
    public Economy econ = null;
    public Map<String, ItemStack[]> itemsMap = new HashMap<String, ItemStack[]>();
    public Map<String, ItemStack[]> armorMap = new HashMap<String, ItemStack[]>();
    private DeathListener listener = null;
    private CommandLastInv command = null;

    public static Core getInstance() {
        return instance;
    }

    public static void log(String message) {
        logger.log(Level.INFO, message);
    }

    public static void log(Level level, String message) { logger.log(level, message); }

    @Override
    public void onEnable() {
        instance = this;
        logger = this.getLogger();
        registerListeners();
        registerCommands();
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }
    }

    @Override
    public void onDisable() {

    }

    public void registerListeners() {
        Listener[] listeners = {
                new NetherWater(),
                new ChatFilter(),
                new FlyListener(),
                new AntiMineSpawner(),
                new AntiDamage(),
                new Sponge(),
                new BlockedEnchants(),
                new FactionAlerts(),
                new CommandChats(),
                new WitherRaiding(),
                new uuid(),
                new WarpListener(),
                new BlacklistedBlocks(),
                new DeathListener(this)
        };
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    public void registerCommands() {
        getCommand("cronuscore").setExecutor(new CommandReload());
        getCommand("uuid").setExecutor(new uuid());
        getCommand("warp").setExecutor(new CommandWarp());
        getCommand("lastinv").setExecutor(new CommandLastInv(this));
    }

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer()
                .getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        this.econ = rsp.getProvider();
        return this.econ != null;
    }

    public void restoreInventory(Player p) {
        PlayerInventory inventory = p.getInventory();
        inventory.setContents(itemsMap.get(p.getName()));
        inventory.setArmorContents(armorMap.get(p.getName()));
    }

    public void storeContents(Player p, ItemStack[] items, ItemStack[] armor) {
        itemsMap.put(p.getName(), items);
        armorMap.put(p.getName(), armor);
    }
}
