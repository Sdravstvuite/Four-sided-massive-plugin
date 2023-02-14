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
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LordGodItems {
    public static ItemStack SnowAxe;
    public static ItemStack SnowShield;
    public static ItemStack MachineGunHoe;
    public static ItemStack SwampBook;
    public static ItemStack FireSword;
    public static ItemStack LongBowJungle;
    public static ItemStack JungleScythe;
    public static ItemStack SwampTrident;
    public static ItemStack FireRod;
    public static ItemStack BossItem;

    public static void init(){
        createSnowAxe();
        createSnowShield();
        createMachineGunHoe();
        createSwampBook();
        createFireSword();
        createLongBowJungle();
        createJungleScythe();
        createSwampTrident();
        createFireRod();
        createBossItem();
    }

    public static List<ItemMeta> superItemsMeta = new ArrayList<>();



    // SWAMP GOD ITEMS
    private static void createSwampBook(){
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Книга Заклинаний Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это книга заклинаний повелителя §eБолот§7!");
        lore.add("§7Владелец этой книги способен призывать мертвых и §eникто не посмеет его тронуть!");
        lore.add("§eСила повелителя болот в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SwampBook = item;
        superItemsMeta.add(item.getItemMeta());
    }

    private static void createSwampTrident(){
        ItemStack item = new ItemStack(Material.TRIDENT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Трезубец Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это трезубец повелителя §eБолот§7!");
        lore.add("§eСила повелителя болот в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LOYALTY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SwampTrident = item;
        superItemsMeta.add(item.getItemMeta());
    }
    // SWAMP GOD ITEMS

    // DESERT GOD ITEMS
    private static void createFireSword(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Огненный меч Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это меча повелителя §eПесков§7!");
        lore.add("§7Владелец этого меча способен создавать огненный луч!");
        lore.add("§eСила повелителя песков в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        FireSword = item;
        superItemsMeta.add(item.getItemMeta());
    }

    private static void createFireRod(){
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Посох Повелителя огня");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это посох повелителя §eПесков§7!");
        lore.add("§7Владелец этого посоха способен вызывать лаву!");
        lore.add("§eСила повелителя песков в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
        FireRod = item;
        superItemsMeta.add(item.getItemMeta());
    }
    // DESERT GOD ITEMS

    // SNOW GOD ITEMS
    private static void createSnowAxe(){
        ItemStack item = new ItemStack(Material.GOLDEN_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Топор снегов");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это великий топор повелителя §eСнегов!");
        lore.add("§7Любой снежок, что будет кинут его владельцем нанесет доп. урон!");
        lore.add("§eСила повелителя снегов в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SnowAxe = item;
        superItemsMeta.add(item.getItemMeta());
    }
    private static void createSnowShield(){
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Снежный щит");
        List<String> lore = new ArrayList<>();
        lore.add("§6Щит, что отталкивает врагов.");
        lore.add("§eСила повелителя снегов в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SnowShield = item;
        superItemsMeta.add(item.getItemMeta());
    }
    // SNOW GOD ITEMS


    // JUNGLE GOD ITEMS
    private static void createLongBowJungle(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Длинный лук джунглей");
        List<String> lore = new ArrayList<>();
        lore.add("§7Лук, что способен стрелять несколькими стрелами!");
        lore.add("§eСила повелителя джунглей в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        LongBowJungle = item;
        superItemsMeta.add(item.getItemMeta());
    }

    private static void createJungleScythe() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Коса Повелителя джунглей");
        List<String> lore = new ArrayList<>();
        lore.add("§7Коса, что способна создавать паутину!");
        lore.add("§eСила повелителя джунглей в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        JungleScythe = item;
        superItemsMeta.add(item.getItemMeta());
    }
    // JUNGLE GOD ITEMS

    private static void createMachineGunHoe(){
        ItemStack item = new ItemStack(Material.GOLDEN_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Machine Gun Hoe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Снежный Пулемет");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        MachineGunHoe = item;
        superItemsMeta.add(item.getItemMeta());
    }

    private static void createBossItem(){
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Boss Item");
        List<String> lore = new ArrayList<>();
        lore.add("§7Предмет босса.");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor",
                30.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND));
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), "generic.max.health",
                100.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND));
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.speed",
                0.20, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.OFF_HAND));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "generic.attack",
                0.50, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.OFF_HAND));
        item.setItemMeta(meta);
        BossItem = item;
        superItemsMeta.add(item.getItemMeta());
    }

}
