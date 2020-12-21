package fr.deadfire.sylvainplug.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.deadfire.sylvainplug.Main;

public class PlayerJoinListener implements Listener {
	
	private Main main;

    public PlayerJoinListener(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    	Player p = event.getPlayer();
    	
    	System.out.println(p.getName()+" s'est connecté !");
    }
}
