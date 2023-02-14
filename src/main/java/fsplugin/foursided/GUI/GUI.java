package fsplugin.foursided.GUI;

import fsplugin.foursided.Items.LordGod.CraftLordGodItems;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.MagicItems.MagicItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    public static Inventory sgui = null;
    public static void createSGUI() {
        sgui = Bukkit.createInventory(null, 45, ChatColor.GOLD + "" + ChatColor.BOLD + "Сила всех богов!");

        ItemStack nothing = new ItemStack(Material.BEDROCK);
        ItemMeta meta = nothing.getItemMeta();

        nothing.setType(Material.BARRIER);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "" + ChatColor.BOLD + "ПРЕДМЕТ ЕЩЕ НЕ ГОТОВ!");
        meta.setLore(lore);
        nothing.setItemMeta(meta);

        sgui.setItem(0, LordGodItems.SwampBook);
        sgui.setItem(9, LordGodItems.SwampTrident);
        sgui.setItem(2, LordGodItems.FireSword);
        sgui.setItem(11, LordGodItems.FireRod);
        sgui.setItem(4, LordGodItems.SnowAxe);
        sgui.setItem(13, LordGodItems.SnowShield);
        sgui.setItem(6, LordGodItems.LongBowJungle);
        sgui.setItem(15, LordGodItems.JungleScythe);
        sgui.setItem(8, LordGodItems.MachineGunHoe);
        sgui.setItem(17, LordGodItems.BossItem);
        sgui.setItem(26, MagicItems.ScreamerBone);

        sgui.setItem(18, CraftLordGodItems.SwampItem1);
        sgui.setItem(27, CraftLordGodItems.SwampItem2);
        sgui.setItem(20, CraftLordGodItems.DesertItem1);
        sgui.setItem(29, CraftLordGodItems.DesertItem2);
        sgui.setItem(22, CraftLordGodItems.SnowItem1);
        sgui.setItem(31, CraftLordGodItems.SnowItem2);
        sgui.setItem(24, CraftLordGodItems.JungleItem1);
        sgui.setItem(33, CraftLordGodItems.JungleItem2);

        sgui.setItem(36, SmallLordGodItems.SmallSwampBook);
        sgui.setItem(38, SmallLordGodItems.SmallFireSword);
        sgui.setItem(40, SmallLordGodItems.SmallSnowAxe);
        sgui.setItem(42, SmallLordGodItems.SmallJungleBow);
    }
}