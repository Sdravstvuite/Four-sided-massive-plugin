package fsplugin.foursided.Listeners.GodItemsUse;

import fsplugin.foursided.General.CD;
import fsplugin.foursided.FourSided;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FSPlayerInteractEvent_RightClick_AIR implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta() != null) {
                    if (e.getItem().getItemMeta().equals(LordGodItems.LongBowJungle.getItemMeta())) { //
                        new BukkitRunnable() {
                            public void run() {
                                if (p.getInventory().getItemInMainHand().getItemMeta() != null) {
                                    if (p.getInventory().getItemInMainHand().getItemMeta().equals(LordGodItems.LongBowJungle.getItemMeta())) {
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 50, 1), true);
                                    } else {
                                        this.cancel();
                                    }
                                } else {
                                    this.cancel();
                                }
                            }
                        }.runTaskTimer(FourSided.getInstance(), 0, 0);
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.SnowAxe.getItemMeta())) { // Snow Axe Circle
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.WAcd, p)) {
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 5);
                                p.spawnParticle(Particle.SNOWBALL, p.getEyeLocation(), 10);
                                Snowball snowball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
                                snowball.setShooter(p);
                                Vector snowDirection = p.getLocation().getDirection();
                                snowball.setVelocity(snowDirection);
                                for (int t = 0; t < 3; t++) {
                                    new BukkitRunnable() {
                                        float i = 1f;

                                        public void run() {
                                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 5);
                                            p.spawnParticle(Particle.SNOWBALL, p.getEyeLocation(), 5);
                                            Snowball snowballnew = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
                                            snowballnew.setShooter(p);
                                            snowballnew.setVelocity(snowDirection.rotateAroundY(Math.toRadians(10f)));
                                            i += 1f;
                                            if (i > 36) {
                                                this.cancel();
                                            }
                                        }
                                    }.runTaskTimer(FourSided.getInstance(), 0, 1);
                                }
                                if (!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.WAcd, p, 15);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.WAcd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.SwampBook.getItemMeta())) {
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.SBcd, p)) {
                                World world = p.getWorld();
                                Location loc = p.getLocation();
                                world.spawnEntity(loc.clone().add(0, 0, 2), EntityType.ZOMBIE);
                                world.spawnEntity(loc.clone().add(0, 0, -2), EntityType.ZOMBIE);
                                if (!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.SBcd, p, 5);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.SBcd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.FireSword.getItemMeta())) {
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.FScd, p)) {
                                new BukkitRunnable() {
                                    Vector dir = p.getLocation().getDirection().normalize();
                                    Location loc = p.getLocation();
                                    double t = 0;

                                    public void run() {
                                        t += 0.5;
                                        double x = dir.getX() * t;
                                        double y = dir.getY() * t + 1.5;
                                        double z = dir.getZ() * t;
                                        loc.add(x, y, z);
                                        p.getWorld().spawnParticle(Particle.LAVA, loc, 5);
                                        for (Entity ent : loc.getChunk().getEntities()) {
                                            if (ent.getLocation().distance(loc) < 2.0) {
                                                if (!ent.equals(p)) {
                                                    if (ent.getType().isAlive()) {
                                                        LivingEntity le = (LivingEntity) ent;
                                                        le.damage(3);
                                                        le.setFireTicks(20 * 5);
                                                    }
                                                }
                                            }
                                        }
                                        loc.subtract(x, y, z);
                                        if (t > 40) {
                                            this.cancel();
                                        }
                                    }
                                }.runTaskTimer(FourSided.getInstance(), 0, (long) 0.5);
                                if(!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.FScd, p, 10);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.FScd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.SnowShield.getItemMeta())) { // Snow Shield
                        final int points = 30;
                        final double radius = 1.2d;
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.WScd, p)) {
                                for (int i = 0; i <= 4; i++) {
                                    new BukkitRunnable() {
                                        int t = 0;
                                        public void run() {
                                            for (double r = 2; r <= 4; r += 2) {
                                                Location origin = p.getEyeLocation();
                                                double angle = r * Math.PI * t / points;
                                                Location point = origin.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
                                                p.getWorld().spawnParticle(Particle.SNOWBALL, point, 1);
                                                t += 1;
                                                if (t > 72) {
                                                    this.cancel();
                                                }
                                                for (Entity ent : point.getChunk().getEntities()) {
                                                    if (ent.getLocation().distance(point) < 2.0) {
                                                        if (!ent.equals(p)) {
                                                            if (ent.getType().isAlive()) {
                                                                LivingEntity le = (LivingEntity) ent;
                                                                le.damage(5);
                                                                le.setVelocity(le.getLocation().getDirection().multiply(-5));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }.runTaskTimer(FourSided.getInstance(), 20, 5);
                                }
                                if(!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.WScd, p, 15);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.WScd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.MachineGunHoe.getItemMeta())) { // WTF Gun
                        if (p.hasPermission("god")) {
                            new BukkitRunnable() {
                                float i = 1f;
                                public void run() {
                                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 5);
                                    Snowball snowball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
                                    snowball.setShooter(p);
                                    Vector snowDirection = p.getLocation().getDirection().multiply(10);
                                    snowball.setVelocity(snowDirection);
                                    i += 1f;
                                    if (i > 36) {
                                        this.cancel();
                                    }
                                }
                            }.runTaskTimer(FourSided.getInstance(), 0, 1);
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.JungleScythe.getItemMeta())) { // Scythe of Jungle
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.JScd, p)) {
                                new BukkitRunnable() {
                                    Vector dir = p.getLocation().getDirection().normalize();
                                    Location loc = p.getLocation();
                                    double t = 0;
                                    public void run() {
                                        t += 0.5;
                                        double x = dir.getX() * t;
                                        double y = dir.getY() * t + 1.5;
                                        double z = dir.getZ() * t;
                                        loc.add(x, y, z);
                                        p.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc, 20, Material.COBWEB.createBlockData());
                                        if (loc.getBlock().getType().equals(Material.AIR)) {
                                            loc.getBlock().setType(Material.COBWEB);
                                        }
                                        for (Entity ent : loc.getChunk().getEntities()) {
                                            if (ent.getLocation().distance(loc) < 2.0) {
                                                if (ent.getType().isAlive()) {
                                                    LivingEntity le = (LivingEntity) ent;
                                                    le.damage(5);
                                                }
                                            }
                                        }
                                        loc.subtract(x, y, z);
                                        if (t > 40) {
                                            this.cancel();
                                        }
                                    }
                                }.runTaskTimer(FourSided.getInstance(), 0, (long) 0.5);
                                if(!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.JScd, p, 15);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.JScd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }

                    if (e.getItem().getItemMeta().equals(LordGodItems.FireRod.getItemMeta())) {
                        if (p.hasPermission("god")) {
                            if (CD.checkCooldown(CD.FRcd, p)) {
                                new BukkitRunnable() {
                                    double t = 0;
                                    public void run() {
                                        t += 0.5;
                                        Location loc = p.getEyeLocation();
                                        FallingBlock FalBlock = loc.getWorld().spawnFallingBlock(loc, Material.FIRE, (byte) 0);
                                        FalBlock.setVelocity(p.getEyeLocation().getDirection().multiply(1.5));
                                        if (t > 7) {
                                            this.cancel();
                                        }
                                    }
                                }.runTaskTimer(FourSided.getInstance(), 0, 2);
                                if(!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.FRcd, p, 15);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.FRcd, p) + " секунд!"));
                            }
                        }else{
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "" + ChatColor.BOLD + "Ты слишком слаб для этого артефакта!"));
                        }
                    }


                    if (e.getItem().getItemMeta().equals(SmallLordGodItems.SmallSnowAxe.getItemMeta())) { // Snow Axe Circle
                            if (CD.checkCooldown(CD.SWAcd, p)) {
                                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 5);
                                p.spawnParticle(Particle.SNOWBALL, p.getEyeLocation(), 3);
                                Snowball snowball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
                                snowball.setShooter(p);
                                Vector snowDirection = p.getLocation().getDirection();
                                snowball.setVelocity(snowDirection);
                                for (int t = 0; t < 3; t++) {
                                    new BukkitRunnable() {
                                        float i = 1f;
                                        public void run() {
                                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 5);
                                            p.spawnParticle(Particle.SNOWBALL, p.getEyeLocation(), 3);
                                            Snowball snowballnew = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
                                            snowballnew.setShooter(p);
                                            snowballnew.setVelocity(snowDirection.rotateAroundY(Math.toRadians(7f)));
                                            i += 1f;
                                            if (i > 30) {
                                                this.cancel();
                                            }
                                        }
                                    }.runTaskTimer(FourSided.getInstance(), 0, 1);
                                }
                                if (!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.SWAcd, p, 15);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.SWAcd, p) + " секунд!"));
                            }
                        }
                    if (e.getItem().getItemMeta().equals(SmallLordGodItems.SmallFireSword.getItemMeta())) {
                            if (CD.checkCooldown(CD.SFScd, p)) {
                                new BukkitRunnable() {
                                    Vector dir = p.getLocation().getDirection().normalize();
                                    Location loc = p.getLocation();
                                    double t = 0;
                                    public void run() {
                                        t += 0.5;
                                        double x = dir.getX() * t;
                                        double y = dir.getY() * t + 1.5;
                                        double z = dir.getZ() * t;
                                        loc.add(x, y, z);
                                        p.getWorld().spawnParticle(Particle.LAVA, loc, 5);
                                        for (Entity ent : loc.getChunk().getEntities()) {
                                            if (ent.getLocation().distance(loc) < 2.0) {
                                                if (!ent.equals(p)) {
                                                    if (ent.getType().isAlive()) {
                                                        LivingEntity le = (LivingEntity) ent;
                                                        le.damage(3);
                                                        le.setFireTicks(20 * 5);
                                                    }
                                                }
                                            }
                                        }
                                        loc.subtract(x, y, z);
                                        if (t > 20) {
                                            this.cancel();
                                        }
                                    }
                                }.runTaskTimer(FourSided.getInstance(), 0, (long) 0.5);
                                if(!p.hasPermission("nocd")) {
                                    CD.setCooldowns(CD.SFScd, p, 10);
                                }
                            } else {
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Ты не сможешь использовать его еще " + CD.getCooldown(CD.SFScd, p) + " секунд!"));
                            }
                        }
                    }
                }
            }
        }
    }
