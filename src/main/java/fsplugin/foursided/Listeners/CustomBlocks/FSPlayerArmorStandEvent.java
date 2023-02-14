package fsplugin.foursided.Listeners.CustomBlocks;

import fsplugin.foursided.Items.LordGod.CraftLordGodItems;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FSPlayerArmorStandEvent implements Listener {
    public static HashMap<ItemMeta, ItemMeta> CraftItemsMap;

    public static void setupCraftMap() {
        CraftItemsMap = new HashMap<>();
        int listSize = CraftLordGodItems.craftItemsMeta.size();

        for (int i = 0; i < listSize; i += 2) {
            CraftItemsMap.put(CraftLordGodItems.craftItemsMeta.get(i), CraftLordGodItems.craftItemsMeta.get(i + 1));
        }
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @EventHandler
    public void onPlayerASEvent1(PlayerArmorStandManipulateEvent e){
        EulerAngle rightArm = new EulerAngle(Math.toRadians(0f), Math.toRadians(270f), Math.toRadians(270f));
        EulerAngle rightLeg = new EulerAngle(Math.toRadians(284f), Math.toRadians(47f), Math.toRadians(38f));
        EulerAngle rightArmNew = new EulerAngle(Math.toRadians(270f), Math.toRadians(0f), Math.toRadians(270f));
        Location loc = e.getRightClicked().getLocation();
        Player p = e.getPlayer();
        if (e.getRightClicked().getRightArmPose().equals(rightArm)) {
            if (e.getPlayerItem().hasItemMeta()) {
                if (CraftItemsMap.containsKey(e.getPlayerItem().getItemMeta()) || CraftItemsMap.containsValue(e.getPlayerItem().getItemMeta())) {
                    for (Entity ent : loc.getChunk().getEntities()) {
                        if (ent instanceof ArmorStand) {
                            if (ent.getLocation().distance(loc) < 5.0) {
                                if (((ArmorStand) ent).getRightArmPose().equals(rightArm)) {
                                    if (((ArmorStand) ent).getRightLegPose().equals(rightLeg)) {
                                        ItemMeta itemTwo = null;
                                        if (CraftItemsMap.containsKey(e.getPlayerItem().getItemMeta())) {
                                            itemTwo = CraftItemsMap.get(e.getPlayerItem().getItemMeta());
                                        } else if (CraftItemsMap.containsValue(e.getPlayerItem().getItemMeta())) {
                                            itemTwo = getKeyByValue(CraftItemsMap, e.getPlayerItem().getItemMeta());
                                        }
                                        if (((ArmorStand) ent).getEquipment().getItemInMainHand().hasItemMeta()) {
                                            if (((ArmorStand) ent).getEquipment().getItemInMainHand().getItemMeta().equals(itemTwo)) {
                                                for (Entity ent1 : loc.getChunk().getEntities()) {
                                                    if (ent1 instanceof ArmorStand) {
                                                        if (ent1.getLocation().distance(loc) < 5.0) {
                                                            if (((ArmorStand) ent1).getRightArmPose().equals(rightArmNew)) {
                                                                if (CraftLordGodItems.DesertItem1.getItemMeta().equals(itemTwo) || CraftLordGodItems.DesertItem2.getItemMeta().equals(itemTwo)) {
                                                                    ((ArmorStand) ent1).getEquipment().setHelmet(SmallLordGodItems.SmallFireSword);
                                                                }
                                                                else if (CraftLordGodItems.JungleItem1.getItemMeta().equals(itemTwo) || CraftLordGodItems.JungleItem2.getItemMeta().equals(itemTwo)) {
                                                                    ((ArmorStand) ent1).getEquipment().setHelmet(SmallLordGodItems.SmallJungleBow);
                                                                }
                                                                else if (CraftLordGodItems.SwampItem1.getItemMeta().equals(itemTwo) || CraftLordGodItems.SwampItem2.getItemMeta().equals(itemTwo)) {
                                                                    ((ArmorStand) ent1).getEquipment().setHelmet(SmallLordGodItems.SmallSwampBook);
                                                                }
                                                                else if (CraftLordGodItems.SnowItem1.getItemMeta().equals(itemTwo) || CraftLordGodItems.SnowItem2.getItemMeta().equals(itemTwo)) {
                                                                    ((ArmorStand) ent1).getEquipment().setHelmet(SmallLordGodItems.SmallSnowAxe);
                                                                }
                                                                if (p.getInventory().getItemInMainHand().getAmount() > 1){
                                                                    p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                                                                }
                                                                else p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                                                ((ArmorStand) ent).getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                                                                e.setCancelled(true);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
