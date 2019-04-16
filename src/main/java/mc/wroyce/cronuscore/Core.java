package mc.wroyce.cronuscore;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import mc.wroyce.cronuscore.Commands.CommandChats;
import mc.wroyce.cronuscore.Commands.CommandReload;
import mc.wroyce.cronuscore.Commands.CommandWarp;
import mc.wroyce.cronuscore.Commands.uuid;
import mc.wroyce.cronuscore.Features.*;
import mc.wroyce.cronuscore.Listeners.WarpListener;
import mc.wroyce.cronuscore.premium.AntiTNTDamage;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    private static Core instance;
    private static Logger logger;
    public WorldGuardPlugin wg;
    public Economy econ = null;

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
                new AntiTNTDamage(),
                new Sponge(),
                new BlockedEnchants(),
                new FactionAlerts(),
                new CommandChats(),
                new WitherRaiding(),
                new uuid(),
                new WarpListener(),
                new BlacklistedBlocks()
        };
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    public void registerCommands() {
        getCommand("cronuscore").setExecutor(new CommandReload());
        getCommand("uuid").setExecutor(new uuid());
        getCommand("warp").setExecutor(new CommandWarp());
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
}
