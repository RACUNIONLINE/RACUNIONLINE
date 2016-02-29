package io.github.RaCuNi.RACUNIONLINE;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		PluginDescriptionFile pdf = getDescription();
		this.getLogger().info(pdf.getName() + pdf.getVersion() + "has been enabled!");
	}
	
	public void onDisable(){
		PluginDescriptionFile pdf = getDescription();
		this.getLogger().info(pdf.getName() + pdf.getVersion() + "has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("shutdown")){
			Bukkit.shutdown();
			getLogger().info(sender.getName() + "used shutdown command!");
			Bukkit.broadcastMessage(sender.getName() + "used shutdown command!");
			return true;
		}
		return false;
	}

}
