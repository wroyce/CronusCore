package mc.wroyce.cronuscore.Features;

import java.util.Map;

import mc.wroyce.cronuscore.Core;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class BlockedEnchants implements Listener {

    @EventHandler
    public void onEnchantItem(EnchantItemEvent e) {
        Map<Enchantment, Integer> enchants = e.getEnchantsToAdd();
        try {
            for (String enchant : Core.getInstance().getConfig().getStringList("BlockedEnchants")) {
                String[] parse = enchant.split(":");
                Enchantment enchantment = Enchantment.getByName(parse[0]);
                int level = Integer.parseInt(parse[1]);
                if ((enchants.containsKey(enchantment)) && (((Integer)enchants.get(enchantment)).intValue() > level)) {
                    enchants.remove(enchantment);
                    if (level > 0) {
                        enchants.put(enchantment, Integer.valueOf(level));
                    }
                }
            }
        } catch (Exception ex) {
        }
    }
}
