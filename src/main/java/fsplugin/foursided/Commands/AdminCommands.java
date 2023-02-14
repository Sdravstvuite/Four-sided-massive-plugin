package fsplugin.foursided.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fsplugin.foursided.GUI.GUI.createSGUI;
import static fsplugin.foursided.GUI.GUI.sgui;

public class AdminCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("sitem")) {
            if (player.hasPermission("god")) {
                createSGUI();
                player.openInventory(sgui);
            }
        }

        return true;
    }
}
