package fr.deadfire.sylvainplug.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.deadfire.sylvainplug.Main;

public class PlayerQuitListener implements Listener {
	
	private Main main;

    public PlayerQuitListener(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
    	Player p = event.getPlayer();
    	
    	System.out.println(p.getName()+" s'est déconnecté !");
    }
}
