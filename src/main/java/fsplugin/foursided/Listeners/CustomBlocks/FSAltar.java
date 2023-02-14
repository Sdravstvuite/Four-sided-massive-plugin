package fsplugin.foursided.Listeners.CustomBlocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class FSAltar implements Listener {
    private ArmorStand getNewArmorStand(Location loc, boolean visible, boolean mini, ItemStack helmet) {
        ArmorStand as = loc.getWorld().spawn(loc, ArmorStand.class);

        as.setBasePlate(false);
        as.setArms(true);
        as.setVisible(visible);
        as.setInvulnerable(true);
        as.setMarker(true);
        as.setGravity(false);
        as.setSmall(mini);
        as.getEquipment().setHelmet(helmet);

        as.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        as.addEquipmentLock(EquipmentSlot.OFF_HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        as.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING_OR_CHANGING);
        as.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING_OR_CHANGING);
        as.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING_OR_CHANGING);
        as.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);

        return as;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock() == null) return;
            if (e.getClickedBlock().getType() == Material.OBSIDIAN) {
                if (p.getItemInHand().equals(new ItemStack(Material.NETHER_STAR))) {
                    e.getClickedBlock().setType(Material.END_PORTAL_FRAME);
                    Location loc1 = e.getClickedBlock().getLocation();
                    Location loc2 = e.getClickedBlock().getLocation();
                    float yaw = 0;
                    yaw += loc2.getYaw();
                    float num = 0.8f;
                    float numb = 0.8f;
                    getNewArmorStand(loc1.clone().add(0.5f, -0.075f, 0.5f), false, true, new ItemStack(Material.BEACON));//C

                    loc2.setYaw((yaw / 10) + 52);

                    getNewArmorStand(loc2.clone().add(0.15f, -0.15, 0.15f), false, true, new ItemStack(Material.OBSIDIAN));//LD
                    getNewArmorStand(loc2.clone().add(num + 0.05, -0.15, 0.15f), false, true, new ItemStack(Material.OBSIDIAN));//LU
                    getNewArmorStand(loc2.clone().add(0.15f, -0.15, num + 0.05), false, true, new ItemStack(Material.OBSIDIAN));//RD
                    getNewArmorStand(loc2.clone().add(num + 0.05, -0.15, num + 0.05), false, true, new ItemStack(Material.OBSIDIAN));//RU

                    getNewArmorStand(loc1.clone().add(0.5f, -0.15, 0.2f), false, true, new ItemStack(Material.OBSIDIAN));//LD
                    getNewArmorStand(loc1.clone().add(num, -0.15, 0.5f), false, true, new ItemStack(Material.OBSIDIAN));//LU
                    getNewArmorStand(loc1.clone().add(0.5f, -0.15, num), false, true, new ItemStack(Material.OBSIDIAN));//RD
                    getNewArmorStand(loc1.clone().add(0.2f, -0.15, 0.5f), false, true, new ItemStack(Material.OBSIDIAN));//RU

                    getNewArmorStand(loc1.clone().add(0.20f, -1.4, 0.20f), false, false, new ItemStack(Material.END_STONE));//LD
                    getNewArmorStand(loc1.clone().add(numb, -1.4, 0.20f), false, false, new ItemStack(Material.END_STONE));//LU
                    getNewArmorStand(loc1.clone().add(0.20f, -1.4, numb), false, false, new ItemStack(Material.END_STONE));//RD
                    getNewArmorStand(loc1.clone().add(numb, -1.4, numb), false, false, new ItemStack(Material.END_STONE));//RU

                    ArmorStand ENDROD1 = getNewArmorStand(loc1.clone().add(0.5f, -1.15f, 0.1f), false, false, new ItemStack(Material.END_ROD));
                    ENDROD1.setHeadPose(new EulerAngle(Math.toRadians(-150f), Math.toRadians(0f), Math.toRadians(0f)));
                    ArmorStand ENDROD2 = getNewArmorStand(loc1.clone().add(0.5f, -1.57f, 0.9f), false, false, new ItemStack(Material.END_ROD));
                    ENDROD2.setHeadPose(new EulerAngle(Math.toRadians(30f), Math.toRadians(0f), Math.toRadians(0f)));

                    getNewArmorStand(loc1.clone().add(0.5f, -1.35f, -1.05f), false, false, new ItemStack(Material.SPAWNER));//L
                    getNewArmorStand(loc1.clone().add(0.5f, -1.35f, 2.05f), false, false, new ItemStack(Material.SPAWNER));//R

                    loc2.setYaw((yaw / 10) + 90);

                    ArmorStand itemL = getNewArmorStand(loc2.clone().add(0.5f, -0.53f, -1.2f), false, true, new ItemStack(Material.AIR));//L
                    ArmorStand itemR = getNewArmorStand(loc2.clone().add(0.5f, -0.53f, 1.9f), false, true, new ItemStack(Material.AIR));//R

                    itemL.setRightArmPose(new EulerAngle(Math.toRadians(0f), Math.toRadians(270f), Math.toRadians(270f)));
                    itemR.setRightArmPose(new EulerAngle(Math.toRadians(0f), Math.toRadians(270f), Math.toRadians(270f)));
                    itemL.setRightLegPose(new EulerAngle(Math.toRadians(284f), Math.toRadians(47f), Math.toRadians(38f)));
                    itemR.setRightLegPose(new EulerAngle(Math.toRadians(284f), Math.toRadians(47f), Math.toRadians(38f)));
                    itemL.removeEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
                    itemR.removeEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
                    itemL.setMarker(false);
                    itemR.setMarker(false);

                    ArmorStand itemNew = getNewArmorStand(loc2.clone().add(1.05f, 0.19f, 0.5f), false, true, new ItemStack(Material.AIR));//C NEW ITEM
                    itemNew.setRightArmPose(new EulerAngle(Math.toRadians(270f), Math.toRadians(0f), Math.toRadians(270f)));
                    itemNew.setHeadPose(new EulerAngle(Math.toRadians(90f), Math.toRadians(0f), Math.toRadians(0f)));
                    itemNew.removeEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
                    itemNew.setMarker(false);

                }
            }
        }
    }
}