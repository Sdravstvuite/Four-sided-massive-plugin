package fsplugin.foursided.Listeners.GodItemsUse;

import fsplugin.foursided.Items.LordGod.LordGodItems;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FSEntityDamageByEntityEvent implements Listener {
    @EventHandler
    public void onPlayerDamage(org.bukkit.event.entity.EntityDamageByEntityEvent e) {
        Entity damager = e.getDamager();
        Entity damageTaker = e.getEntity();
        if (damager instanceof Player) {
            Player damagePlayer = (Player) damager;
            if (damagePlayer.getInventory().getItemInMainHand().getItemMeta() != null) {
                if (damagePlayer.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.SwampTrident.getItemMeta())) {
                    if (damageTaker instanceof LivingEntity) {
                        LivingEntity le = (LivingEntity) damageTaker;
                        le.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 3));
                    }
                }
            }
        }
    }
}
