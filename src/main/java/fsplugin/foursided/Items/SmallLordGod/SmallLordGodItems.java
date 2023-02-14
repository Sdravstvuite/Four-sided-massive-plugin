package fsplugin.foursided.Items.SmallLordGod;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SmallLordGodItems {

    public static ItemStack SmallFireSword;
    public static ItemStack SmallJungleBow;
    public static ItemStack SmallSwampBook;
    public static ItemStack SmallSnowAxe;

    public static void init(){
        createSmallFireSword();
        createSmallJungleBow();
        createSmallSwampBook();
        createSmallSnowAxe();
    }

    public static List<ItemMeta> smallSuperItemsMeta = new ArrayList<>();

    private static void createSmallFireSword(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Огненный Меч Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это меч повелителя §eПесков§7!");
        lore.add("§7Владелец этого меча способен создавать огненный луч!");
        lore.add("");
        lore.add("§6У вас вышло вернуть артефакту прошлый вид");
        lore.add("§6но вашей силы не достаточно для его полного функционала!");
        lore.add("§eСила повелителя песков в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SmallFireSword = item;
        smallSuperItemsMeta.add(item.getItemMeta());
    }

    private static void createSmallJungleBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Длинный Лук Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это лук повелтилея §eДжунглей§7!");
        lore.add("§7Владелец этого лука способен стрелять несколькими стрелами!");
        lore.add("");
        lore.add("§6У вас вышло вернуть артефакту прошлый вид");
        lore.add("§6но вашей силы не достаточно для его полного функционала!");
        lore.add("§eСила повелителя джунглей в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, false);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SmallJungleBow = item;
        smallSuperItemsMeta.add(item.getItemMeta());
    }

    private static void createSmallSwampBook(){
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Книга Заклинаний Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это книга заклинаний повелителя §eБолот§7!");
        lore.add("§7Владельца этой книги побоится атаковать любая нечесть!");
        lore.add("");
        lore.add("§6У вас вышло вернуть артефакту прошлый вид");
        lore.add("§6но вашей силы не достаточно для его полного функционала!");
        lore.add("§eСила повелителя болот в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SmallSwampBook = item;
        smallSuperItemsMeta.add(item.getItemMeta());
    }

    private static void createSmallSnowAxe(){
        ItemStack item = new ItemStack(Material.GOLDEN_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Ледяной Топор Повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это великий топор повелителя §eСнегов§7!");
        lore.add("§7Любой снежок, что будет кинут его владельцем нанесет доп. урон!");
        lore.add("");
        lore.add("§6У вас вышло вернуть артефакту прошлый вид");
        lore.add("§6но вашей силы не достаточно для его полного функционала!");
        lore.add("§eСила повелителя снегов в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
        meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SmallSnowAxe = item;
        smallSuperItemsMeta.add(item.getItemMeta());
    }
}
