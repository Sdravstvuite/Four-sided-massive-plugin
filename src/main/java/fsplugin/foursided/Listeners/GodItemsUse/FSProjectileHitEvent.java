package fsplugin.foursided.Listeners.GodItemsUse;

import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FSProjectileHitEvent implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) { // HITTED by Entity
        if (e.getEntity().getShooter() instanceof Player) {
            Player p = (Player) e.getEntity().getShooter();
            Inventory inv = p.getInventory();
            if (e.getEntityType().equals(EntityType.TRIDENT)) {
                if (p.getInventory().getItemInMainHand().getItemMeta() != null) {
                    if (p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.SwampTrident.getItemMeta())) {
                        if (e.getHitEntity() != null) {
                            if (e.getHitEntity() instanceof LivingEntity) {
                                Location loc = e.getHitEntity().getLocation();
                                LivingEntity HitedEntity = (LivingEntity) e.getHitEntity();
                                HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 255));
                                HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 255));
                                for (Entity ent : loc.getChunk().getEntities()) {
                                    if (ent.getLocation().distance(loc) < 10.0) {
                                        if (ent.getType().isAlive()) {
                                            if (!(ent == p)) {
                                                LivingEntity le = (LivingEntity) ent;
                                                le.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 255));
                                                le.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 255));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (e.getHitBlock() != null) {
                            Location BlockLoc = e.getHitBlock().getLocation();
                            for (Entity ent : BlockLoc.getChunk().getEntities()) {
                                if (ent.getLocation().distance(BlockLoc) < 10.0) {
                                    if (ent.getType().isAlive()) {
                                        if (!(ent == p)) {
                                            LivingEntity le = (LivingEntity) ent;
                                            le.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 255));
                                            le.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 255));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (e.getEntityType().equals(EntityType.SNOWBALL)) {
                if (e.getHitEntity() != null) {
                    if (p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.SnowAxe.getItemMeta()) || p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.MachineGunHoe.getItemMeta())) {
                        if (e.getHitEntity() instanceof LivingEntity) {
                            LivingEntity HitedEntity = (LivingEntity) e.getHitEntity();
                            HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 5));
                            HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 80, 2));
                            HitedEntity.setVelocity(p.getLocation().getDirection().multiply(10));
                            HitedEntity.damage(10);
                        }
                    }

                    if (!p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.SnowAxe.getItemMeta())) { // instant Leviathan snowball damage
                        if (e.getHitEntity() instanceof LivingEntity) {
                            for (int i = 0; i < inv.getSize(); i++) {
                                if (inv.getItem(i) != null) {
                                    ItemStack is = inv.getItem(i);
                                    if (is.getItemMeta().equals(LordGodItems.SnowAxe.getItemMeta())) {
                                        LivingEntity HitedEntity = (LivingEntity) e.getHitEntity();
                                        HitedEntity.setVelocity(p.getLocation().getDirection().multiply(2));
                                        HitedEntity.damage(2);
                                        p.getInventory().addItem(new ItemStack(Material.SNOWBALL, 2));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (p.getInventory().getItemInMainHand().getItemMeta().equals(SmallLordGodItems.SmallSnowAxe.getItemMeta()) || p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.MachineGunHoe.getItemMeta())) {
                        if (e.getHitEntity() instanceof LivingEntity) {
                            LivingEntity HitedEntity = (LivingEntity) e.getHitEntity();
                            HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 2));
                            HitedEntity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 60, 2));
                            HitedEntity.setVelocity(p.getLocation().getDirection().multiply(4));
                            HitedEntity.damage(4);
                        }
                    }
                }
            }
        }
    }
}



