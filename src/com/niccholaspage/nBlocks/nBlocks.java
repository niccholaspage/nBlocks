package com.niccholaspage.nBlocks;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class nBlocks extends JavaPlugin {
	//Links the Block Listener
    private final nBlocksBlockListener blockListener = new nBlocksBlockListener(this);
    //Links Player Listener
    private final nBlocksPlayerListener playerListener = new nBlocksPlayerListener(this);
    //Create the hashmap debugees
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public static PermissionHandler Permissions;
    @Override
	public void onDisable() {
		//Print "Basic Disabled" on the log.
		System.out.println("nBlocks Disabled");
		
	}
    @Override
	public void onEnable() {
		//Create the pluginmanage pm.
		PluginManager pm = getServer().getPluginManager();
		//Create BlockBreak listener
	    pm.registerEvent(Event.Type.BLOCK_BREAK, this.blockListener, Event.Priority.Normal, this);
	    //Create BlockPlace listener
	    pm.registerEvent(Event.Type.BLOCK_PLACED, this.blockListener, Event.Priority.Normal, this);
	    //
	    pm.registerEvent(Event.Type.PLAYER_PICKUP_ITEM, this.playerListener, Event.Priority.Normal, this);
       //Get the infomation from the yml file.
        PluginDescriptionFile pdfFile = this.getDescription();
        //Setup Permissions
        setupPermissions();
        //Print that the plugin has been enabled!
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
		
	}
    private void setupPermissions() {
        Plugin perm = this.getServer().getPluginManager().getPlugin("Permissions");

        if (nBlocks.Permissions == null) {
            if (perm != null) {
                nBlocks.Permissions = ((Permissions)perm).getHandler();
            } else {
            	System.out.println("Permissions system not detected, disabling plugin.");
            	this.getPluginLoader().disablePlugin(this);
            }
    }
    }
	//Used when debugging
	  public boolean isDebugging(final Player player) {
	        if (debugees.containsKey(player)) {
	            return debugees.get(player);
	        } else {
	            return false;
	        }
	    }

	    public void setDebugging(final Player player, final boolean value) {
	        debugees.put(player, value);
	    }
}
