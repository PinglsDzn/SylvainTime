package fr.deadfire.sylvainplug;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.deadfire.sylvainplug.cmd.resethcmd;
import fr.deadfire.sylvainplug.event.PlayerJoinListener;
import fr.deadfire.sylvainplug.event.PlayerQuitListener;
import fr.deadfire.sylvainplug.manager.playerManager;
import fr.deadfire.sylvainplug.sys.DatabaseManager;


public class Main extends JavaPlugin {
	public static Main instance;
	private static DatabaseManager databaseManager;
	
	public static int newsScheduler = -1;
	
	@Override
    public void onEnable() {
        instance = this;
        
        databaseManager = new DatabaseManager();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoinListener(this), this);
        pm.registerEvents(new PlayerQuitListener(this), this);
        
        //getCommand("reseth").setExecutor(new resethcmd());
        
      //Every 2 Min
    	new BukkitRunnable() {
        	@Override
        	public void run(){
        		System.out.println("Run !");
        		for(Player p : Bukkit.getOnlinePlayers()){
        			System.out.println(p.getName()+" trouvé");
        			playerManager.addMinute(p);
        		}
        	}
    	}.runTaskTimer(this, 0L, 5*20L);
    }

	
	@Override
	public void onDisable() {
		//TO DO
	}
	
	public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

	public static Plugin getInstance() {
		return instance;
	}

	public static String ucFirst(String value) {
		if (value == null) {
			return null;
		}
		if (value.length() == 0) {
			return value;
		}
		StringBuilder result = new StringBuilder(value);
		result.replace(0, 1, result.substring(0, 1).toUpperCase());
		return result.toString();
	}
}
