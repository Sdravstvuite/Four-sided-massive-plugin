package fsplugin.foursided;

import fsplugin.foursided.Commands.AdminCommands;
import fsplugin.foursided.Items.LordGod.CraftLordGodItems;
import fsplugin.foursided.Items.LordGod.LordGodItems;
import fsplugin.foursided.Items.MagicItems.MagicItems;
import fsplugin.foursided.Items.SmallLordGod.SmallLordGodItems;
import fsplugin.foursided.Listeners.CustomBlocks.FSAltar;
import fsplugin.foursided.Listeners.CustomBlocks.FSPlayerArmorStandEvent;
import fsplugin.foursided.Listeners.GodItemsUse.*;
import fsplugin.foursided.Listeners.FSPlayerDeathEvent;
import fsplugin.foursided.Listeners.MagicItems.ScreamerBone;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static fsplugin.foursided.General.CD.setupCooldown;

public final class FourSided extends JavaPlugin {

    private static FourSided instance;

    public void onLoad(){
        instance = this;
    }

    public static FourSided getInstance(){
        return instance;
    }


    @Override
    public void onEnable() {
        getCommand("sitem").setExecutor(new AdminCommands());

        setupCooldown();
        CraftLordGodItems.init();
        LordGodItems.init();
        SmallLordGodItems.init();
        MagicItems.init();
        FSPlayerArmorStandEvent.setupCraftMap();
        getServer().getPluginManager().registerEvents(new FSAltar(), this);
        getServer().getPluginManager().registerEvents(new FSPlayerArmorStandEvent(), this);
        getServer().getPluginManager().registerEvents(new FSEntityDamageByEntityEvent(), this);
        getServer().getPluginManager().registerEvents(new FSEntityTargetEvent(), this);
        getServer().getPluginManager().registerEvents(new FSPlayerInteractEvent_LeftClick(), this);
        getServer().getPluginManager().registerEvents(new FSPlayerInteractEvent_RightClick_AIR(), this);
        getServer().getPluginManager().registerEvents(new FSProjectileHitEvent(), this);
        getServer().getPluginManager().registerEvents(new FSPlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new ScreamerBone(), this);

        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[FourSidedPlugin]" + ChatColor.DARK_GREEN + " +==============+");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[FourSidedPlugin]" + ChatColor.DARK_GREEN + " |  " + ChatColor.DARK_AQUA + "Four-Sided" + ChatColor.DARK_GREEN + "  |");
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[FourSidedPlugin]" + ChatColor.DARK_GREEN + " +==============+");
    }
}
