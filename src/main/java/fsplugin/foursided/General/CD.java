package fsplugin.foursided.General;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CD {
    public static HashMap<UUID, Double> FScd;
    public static HashMap<UUID, Double> FRcd;
    public static HashMap<UUID, Double> JScd;
    public static HashMap<UUID, Double> JBcd;
    public static HashMap<UUID, Double> SBcd;
    public static HashMap<UUID, Double> STcd;
    public static HashMap<UUID, Double> WAcd;
    public static HashMap<UUID, Double> WScd;

    public static HashMap<UUID, Double> SFScd;
    public static HashMap<UUID, Double> SJBcd;
    public static HashMap<UUID, Double> SSBcd;
    public static HashMap<UUID, Double> SWAcd;
    public static HashMap<UUID, Double> ScreamBcd;

    public static void setupCooldown(){
        FScd = new HashMap<>();
        FRcd = new HashMap<>();
        JScd = new HashMap<>();
        JBcd = new HashMap<>();
        SBcd = new HashMap<>();
        STcd = new HashMap<>();
        WAcd = new HashMap<>();
        WScd = new HashMap<>();

        SFScd = new HashMap<>();
        SJBcd = new HashMap<>();
        SSBcd = new HashMap<>();
        SWAcd = new HashMap<>();
        ScreamBcd = new HashMap<>();
    }

    public static void setCooldowns(HashMap hm, Player player, int seconds){
        double delay = System.currentTimeMillis() + (seconds*1000);
        hm.put(player.getUniqueId(), delay);
    }

    public static int getCooldown(HashMap hm, Player player){
        return Math.toIntExact(Math.round((((Double) hm.get(player.getUniqueId())/1000) - (System.currentTimeMillis()/1000))));
    }

    public static boolean checkCooldown(HashMap hm, Player player){
        if(!hm.containsKey(player.getUniqueId()) || (Double) hm.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }

}