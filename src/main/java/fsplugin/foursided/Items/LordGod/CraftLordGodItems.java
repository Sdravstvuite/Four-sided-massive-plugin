package fsplugin.foursided.Items.LordGod;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CraftLordGodItems {
    public static ItemStack SwampItem1;
    public static ItemStack SwampItem2;
    public static ItemStack DesertItem1;
    public static ItemStack DesertItem2;
    public static ItemStack SnowItem1;
    public static ItemStack SnowItem2;
    public static ItemStack JungleItem1;
    public static ItemStack JungleItem2;

    public static void init(){
        createSwampItem1();
        createSwampItem2();
        createDesertItem1();
        createDesertItem2();
        createSnowItem1();
        createSnowItem2();
        createJungleItem1();
        createJungleItem2();
    }

    public static List<ItemMeta> craftItemsMeta = new ArrayList<>();



    // SWAMP GOD ITEMS
    private static void createSwampItem1(){
        ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Обложка книги заклинаний Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Болот!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SwampItem1 = item;
        craftItemsMeta.add(item.getItemMeta());
    }

    private static void createSwampItem2(){
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Порванные страницы Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Болот!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SwampItem2 = item;
        craftItemsMeta.add(item.getItemMeta());
    }
    // SWAMP GOD ITEMS

    // DESERT GOD ITEMS
    private static void createDesertItem1(){
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Рукоятка артефакта огня");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Песков!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        DesertItem1 = item;
        craftItemsMeta.add(item.getItemMeta());
    }

    private static void createDesertItem2(){
        ItemStack item = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Огонь Повелителя песков");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Песков!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        DesertItem2 = item;
        craftItemsMeta.add(item.getItemMeta());
    }
    // DESERT GOD ITEMS

    // SNOW GOD ITEMS
    private static void createSnowItem1(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Рукоять топора");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Снегов!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SnowItem1 = item;
        craftItemsMeta.add(item.getItemMeta());
    }

    private static void createSnowItem2(){
        ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Слиток божественного снега");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Снегов!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SnowItem2 = item;
        craftItemsMeta.add(item.getItemMeta());
    }
    // SNOW GOD ITEMS


    // JUNGLE GOD ITEMS
    private static void createJungleItem1(){
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Стрела повелителя джунглей");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Джунглей!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        JungleItem1 = item;
        craftItemsMeta.add(item.getItemMeta());
    }

    private static void createJungleItem2(){
        ItemStack item = new ItemStack(Material.STRING, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Тетива лука джунглей");
        List<String> lore = new ArrayList<>();
        lore.add("§7Часть от артефакта повелителя Джунглей!");
        lore.add("§7Возможно получится создать что-то из этого поврежденного предмета.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        JungleItem2 = item;
        craftItemsMeta.add(item.getItemMeta());
    }
    // JUNGLE GOD ITEMS

}