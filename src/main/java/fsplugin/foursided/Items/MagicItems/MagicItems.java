package fsplugin.foursided.Items.MagicItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicItems {
    public static ItemStack ScreamerBone;


    public static void init(){
        createScreamerBone();

    }

    public static List<ItemMeta> magicItemsMeta = new ArrayList<>();

    private static void createScreamerBone(){
        ItemStack item = new ItemStack(Material.BONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA  + "Кость повелителя");
        List<String> lore = new ArrayList<>();
        lore.add("§7Это кость одного из §eПовелителей§7!");
        lore.add("");
        lore.add("§7Никто не знает, какого из повелителей эта кость,");
        lore.add("§7но её сила настолько страшна, что один её вид пугает все вокруг!");
        lore.add("");
        lore.add("§eСила древнего повелителя в твоих руках!");
        lore.add("");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ScreamerBone = item;
        magicItemsMeta.add(item.getItemMeta());
    }
}
