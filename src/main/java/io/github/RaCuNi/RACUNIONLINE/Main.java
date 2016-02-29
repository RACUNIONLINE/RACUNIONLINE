package io.github.RaCuNi.RACUNIONLINE;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		PluginDescriptionFile pdf = getDescription();
		this.getLogger().info(pdf.getName() + " " + pdf.getVersion() + " has been enabled!");
	}
	
	public void onDisable(){
		PluginDescriptionFile pdf = getDescription();
		this.getLogger().info(pdf.getName() + " " + pdf.getVersion() + " has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("shutdown")){
			Bukkit.shutdown();
			getLogger().info(sender.getName() + " used shutdown command!");
			Bukkit.broadcastMessage(sender.getName() + " used shutdown command!");
			return true;
		}
		else if(cmd.getName().equalsIgnoreCase("messenger")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only run by a player.");
			} else {
				Player player = (Player) sender;
				Bukkit.broadcastMessage(ChatColor.GOLD+"["+ChatColor.BLUE+player.getName()+ChatColor.GOLD+"]" + " " + ChatColor.RESET + args);
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("raonitem")){
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only run by a player.");
			} else {
				Player player = (Player) sender;
				ItemStack leatherhelm = new ItemStack(Material.LEATHER_HELMET);
				ItemStack leatherchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemStack leatherleggings = new ItemStack(Material.LEATHER_LEGGINGS);
				ItemStack leatherboots = new ItemStack(Material.LEATHER_BOOTS);
				ItemStack ironsword = new ItemStack(Material.IRON_SWORD);
				ItemStack ironaxe = new ItemStack(Material.IRON_AXE);
				ItemStack ironpickaxe = new ItemStack(Material.IRON_PICKAXE);
				ItemStack ironspade = new ItemStack(Material.IRON_SPADE);
				ItemStack milk = new ItemStack(Material.MILK_BUCKET);
				player.getInventory().setHelmet(leatherhelm);
				player.getInventory().setChestplate(leatherchestplate);
				player.getInventory().setLeggings(leatherleggings);
				player.getInventory().setBoots(leatherboots);
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 3);
				player.getInventory().addItem(ironsword, ironaxe, ironpickaxe, ironspade, milk);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 2, 3);
				player.sendMessage(ChatColor.GOLD + "RA"+ ChatColor.BLUE + "ON" + " " + ChatColor.GREEN + "First Item" + " " + ChatColor.YELLOW + "has given!");
				return true;
			}
		}
		return false;
	}
}
