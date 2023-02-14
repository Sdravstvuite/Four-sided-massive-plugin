package fsplugin.foursided.Listeners.MagicItems;

import fsplugin.foursided.General.CD;
import fsplugin.foursided.Items.MagicItems.MagicItems;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ScreamerBone implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.hasItem()) {
                if (e.getItem().hasItemMeta()) {
                    if (e.getItem().getItemMeta().equals(MagicItems.ScreamerBone.getItemMeta())) {
                        if (CD.checkCooldown(CD.ScreamBcd, p)) {
                            for (Entity ent : p.getNearbyEntities(15, 40, 15)) {
                                if (!ent.equals(p)) {
                                    if (ent.getType().isAlive()) {
                                        LivingEntity le = (LivingEntity) ent;
                                        le.damage(2);
                                        le.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 3));
                                        if (ent instanceof Player) {
                                            ((Player) ent).playSound(ent.getLocation(), Sound.ENTITY_GHAST_HURT, 5, 5);
                                            ((Player) ent).playSound(ent.getLocation(), Sound.ENTITY_PHANTOM_SWOOP, 5, 5);
                                        }
                                    }
                                }
                            }
                            if (!p.hasPermission("nocd")) {
                                CD.setCooldowns(CD.ScreamBcd, p, 15);
                            }
                        } else {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.ScreamBcd, p) + " секунд!"));
                        }
                    }
                }
            }
        }
    }
}
