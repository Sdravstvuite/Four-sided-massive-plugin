package fsplugin.foursided.Listeners.GodItemsUse;

import fsplugin.foursided.General.CD;
import fsplugin.foursided.FourSided;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FSPlayerInteractEvent_LeftClick implements Listener {
    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta() != null) {
                    if (e.getItem().getItemMeta().equals(LordGodItems.LongBowJungle.getItemMeta())) {
                        Player p = e.getPlayer();
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.JBcd, p)) {
                                Vector playerDirection = p.getLocation().getDirection();
                                Arrow arrow = p.launchProjectile(Arrow.class, playerDirection);
                                arrow.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 120, 3), true);
                                arrow.setDamage(1);
                                arrow.setShooter(p);
                                arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                                Vector ArrowDirection = p.getLocation().getDirection().multiply(5);
                                arrow.setVelocity(ArrowDirection.rotateAroundY(Math.toRadians(40)));
                                new BukkitRunnable() {
                                    int i = 0;

                                    public void run() {
                                        Arrow arrow1 = p.launchProjectile(Arrow.class, playerDirection);
                                        arrow1.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 120, 3), true);
                                        arrow1.setDamage(1);
                                        arrow1.setShooter(p);
                                        arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                                        arrow1.setVelocity(ArrowDirection.rotateAroundY(Math.toRadians(-10f)));
                                        i = i + 1;
                                        if (i > 7) {
                                            this.cancel();
                                        }
                                    }
                                }.runTaskTimer(FourSided.getInstance(), 0, 0);
                                if (!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.JBcd, p, 10);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.JBcd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }
                    if(e.getItem().getItemMeta().equals(SmallLordGodItems.SmallJungleBow.getItemMeta())){
                        Player p = e.getPlayer();
                        if (CD.checkCooldown(CD.SJBcd, p)) {
                            Vector playerDirection = p.getLocation().getDirection();
                            Arrow arrow = p.launchProjectile(Arrow.class, playerDirection);
                            arrow.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 120, 3), true);
                            arrow.setDamage(1);
                            arrow.setShooter(p);
                            arrow.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                            Vector ArrowDirection = p.getLocation().getDirection().multiply(3);
                            arrow.setVelocity(ArrowDirection.rotateAroundY(Math.toRadians(40)));
                            new BukkitRunnable() {
                                int i = 0;
                                public void run() {
                                    Arrow arrow1 = p.launchProjectile(Arrow.class, playerDirection);
                                    arrow1.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 60, 2), true);
                                    arrow1.setDamage(2);
                                    arrow1.setShooter(p);
                                    arrow1.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                                    arrow1.setVelocity(ArrowDirection.rotateAroundY(Math.toRadians(-10f)));
                                    i = i + 1;
                                    if (i > 7) {
                                        this.cancel();
                                    }
                                }
                            }.runTaskTimer(FourSided.getInstance(), 0, 0);
                            if (!p.hasPermission("nocd")) {
                                CD.setCooldowns(CD.SJBcd, p, 10);
                            }
                        } else {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.SJBcd, p) + " секунд!"));
                        }
                    }
                }
            }
        }
    }
}
