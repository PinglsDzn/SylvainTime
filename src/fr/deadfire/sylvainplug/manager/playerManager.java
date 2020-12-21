package fr.deadfire.sylvainplug.manager;

import org.bukkit.entity.Player;

import com.earth2me.essentials.Essentials;

import fr.deadfire.sylvainplug.Main;


public class playerManager {
	
	private static Main main;
	
    public playerManager(Main main) {
        this.main = main;
    }
	
	public static void addMinute(Player p) {
		Essentials ess = (Essentials) main.getServer().getPluginManager().getPlugin("Essentials");
		
		System.out.println(ess.broadcastMessage("Tadaaa !"));
		
		if(!ess.getUser(p).isAfk()) {
			System.out.println(p.getName()+" a gagné 1 point");
		} else {
			System.out.println(p.getName()+" est AFK donc pas de point pour lui");
		}
	}
}
