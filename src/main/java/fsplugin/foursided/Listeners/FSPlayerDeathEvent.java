package fsplugin.foursided.Listeners;

import fsplugin.foursided.Items.LordGod.CraftLordGodItems;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;

public class FSPlayerDeathEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.hasPermission("god")) {
            List<ItemStack> list = e.getDrops();
            if (list.contains(LordGodItems.FireSword) && list.contains(LordGodItems.FireRod) && list.contains(LordGodItems.BossItem) ||
                    list.contains(LordGodItems.JungleScythe) && list.contains(LordGodItems.LongBowJungle) && list.contains(LordGodItems.BossItem) ||
                    list.contains(LordGodItems.SnowAxe) && list.contains(LordGodItems.SnowShield) && list.contains(LordGodItems.BossItem) ||
                    list.contains(LordGodItems.SwampTrident) && list.contains(LordGodItems.SwampBook) && list.contains(LordGodItems.BossItem))

            {
                if (list.contains(LordGodItems.FireSword) && list.contains(LordGodItems.FireRod) && list.contains(LordGodItems.BossItem)) {
                    p.getWorld().dropItem(p.getLocation(), CraftLordGodItems.DesertItem2);
                }
                else if (list.contains(LordGodItems.JungleScythe) && list.contains(LordGodItems.LongBowJungle) && list.contains(LordGodItems.BossItem)) {
                    p.getWorld().dropItem(p.getLocation(), CraftLordGodItems.JungleItem2);
                }
                else if (list.contains(LordGodItems.SnowAxe) && list.contains(LordGodItems.SnowShield) && list.contains(LordGodItems.BossItem)) {
                    p.getWorld().dropItem(p.getLocation(), CraftLordGodItems.SnowItem2);
                }
                else if (list.contains(LordGodItems.SwampTrident) && list.contains(LordGodItems.SwampBook) && list.contains(LordGodItems.BossItem)) {
                    p.getWorld().dropItem(p.getLocation(), CraftLordGodItems.SwampItem2);
                }
                Iterator<ItemStack> i = list.iterator();
                while (i.hasNext()) {
                    ItemStack item = i.next();
                    i.remove();
                }
            }
        }
    }
}
