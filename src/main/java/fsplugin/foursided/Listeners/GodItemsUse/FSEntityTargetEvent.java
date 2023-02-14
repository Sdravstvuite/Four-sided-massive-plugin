package fsplugin.foursided.Listeners.GodItemsUse;

import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FSEntityTargetEvent implements Listener {
    @EventHandler
    public void onTarget(EntityTargetEvent e){
        Entity target = e.getTarget();
        Entity targeter = e.getEntity();
        if (target instanceof Player) {
            Player p = (Player) target;
            Inventory inv = p.getInventory();
            if(p.getInventory().getItemInMainHand().hasItemMeta()) {
                if (p.getInventory().getItemInMainHand().getItemMeta().equals(SmallLordGodItems.SmallSwampBook.getItemMeta())) {
                    e.setCancelled(true);
                }
            }
            if(p.hasPermission("god")) {
                for (int i = 0; i < inv.getSize(); i++) {
                    if (inv.getItem(i) != null) {
                        ItemStack is = inv.getItem(i);
                        if (is.getItemMeta().equals(LordGodItems.SwampBook.getItemMeta())) {
                            e.setCancelled(true);
                            break;
                        }
                    }
                }
            }
        }
    }
}
