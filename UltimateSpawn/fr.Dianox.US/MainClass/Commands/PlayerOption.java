package fr.Dianox.US.MainClass.Commands;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;
import fr.Dianox.US.MainClass.config.messages.ConfigMFly;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

public class PlayerOption implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
            return true;
        }

		 Player p = (Player) sender;
		 UUID pU = p.getUniqueId();
		 
		 if (cmd.getName().equalsIgnoreCase("playeroption") || cmd.getName().equalsIgnoreCase("playeroptions") || cmd.getName().equalsIgnoreCase("playersoption") || cmd.getName().equalsIgnoreCase("playersoptions") || cmd.getName().equalsIgnoreCase("poption") || cmd.getName().equalsIgnoreCase("poptions") || cmd.getName().equalsIgnoreCase("option") || cmd.getName().equalsIgnoreCase("options")) {
			 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Enable")) {
				 if (args.length == 0) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Help.Use_Permission")) {
						 if (p.hasPermission("ultimatespawn.command.playeroption.help")) {
							 sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bPlayerOption§3] §8//§7§m---------------§r§8\\\\");
			                 sender.sendMessage("");
			                 sender.sendMessage("     §l>> §e§o§lPlayer option Help");
			                 sender.sendMessage("");
			                 sender.sendMessage(" §8>> §7/option fly - §eSet the fly");
			                 sender.sendMessage(" §8>> §7/option doublejump - §eEnable or disable the doublejump");
			                 sender.sendMessage("");
			                 sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bPlayerOption§3] §8\\\\§7§m---------------§r§8//");
						 } else {
							 for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
			                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							 }
						 }
					 } else {
						 sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bPlayerOption§3] §8//§7§m---------------§r§8\\\\");
		                 sender.sendMessage("");
		                 sender.sendMessage("     §l>> §e§o§lPlayer option Help");
		                 sender.sendMessage("");
		                 sender.sendMessage(" §8>> §7/option fly - §eSet the fly");
		                 sender.sendMessage(" §8>> §7/option doublejump - §eEnable or disable the doublejump");
		                 sender.sendMessage("");
		                 sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bPlayerOption§3] §8\\\\§7§m---------------§r§8//");
					 }
				 } else if (args[0].equalsIgnoreCase("fly")) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Enable")) {
						 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Use_Permission")) {
							 if (p.hasPermission("ultimatespawn.command.playeroption.fly")) {
								 if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
									 for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
										 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
									 }
				                    	
									 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
					       				
									 ConfigTemp.saveConfigFile();
					       	        	
									 p.setAllowFlight(false);
									 p.setFlying(false);
								 } else {
									 for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
										 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
									 }
					       				
									 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
					       				
									 ConfigTemp.saveConfigFile();
					       	        	
									 p.setAllowFlight(true);
									 p.setFlying(true);
									 
									 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
										 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
										 
										 ConfigTemp.saveConfigFile();
									 }
								 }
							 } else {
								 for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
				                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
								 }
							 }
						 } else {
							 if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
								 for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
									 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
								 }
			                    	
								 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
				       				
								 ConfigTemp.saveConfigFile();
				       	        	
								 p.setAllowFlight(false);
								 p.setFlying(false);
								 
								 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
									 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
									 
									 ConfigTemp.saveConfigFile();
								 }
							 } else {
								 for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
									 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
								 }
				       				
								 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
				       				
								 ConfigTemp.saveConfigFile();
				       	        	
								 p.setAllowFlight(true);
								 p.setFlying(true);
							 }
						 }
					 } else {
						 if (ConfigCPlayerOption.getConfig().getBoolean("Announce.Broadcast.Disable-Message")) {
							 for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
								 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							 }
						 }
					 }
				 } else if (args[0].equalsIgnoreCase("doublejump") || args[0].equalsIgnoreCase("dj")) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.DoubleJump.Use_Permission")) {
						 if (p.hasPermission("ultimatespawn.command.playeroption.doublejump")) {
							 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
								 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
								 
								 ConfigTemp.saveConfigFile();
							 } else {
								 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(true));
								 
								 ConfigTemp.saveConfigFile();
							 }
						 } else {
							 for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
			                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							 }
						 }
					 } else {
						 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
							 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
							 
							 ConfigTemp.saveConfigFile();
						 } else {
							 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(true));
							 
							 ConfigTemp.saveConfigFile();
						 }
					 }
				 }
			 } else {
				 if (ConfigCPlayerOption.getConfig().getBoolean("Announce.Broadcast.Disable-Message")) {
					 for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
						 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
					 }
				 }
			 }
		 }
		
		return true;
	}

}
