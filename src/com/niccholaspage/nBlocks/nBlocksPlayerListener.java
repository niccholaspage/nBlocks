package com.niccholaspage.nBlocks;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class nBlocksPlayerListener extends PlayerListener {
	 public static nBlocks plugin;
	 public nBlocksPlayerListener(nBlocks instance) {
		 plugin = instance;
		 }
	 public void onPlayerPickupItem(PlayerPickupItemEvent event){
		 Player player = event.getPlayer();
		 Item item = event.getItem();
		  if (!(nBlocks.Permissions.has(player, "nBlocks." + item.getItemStack().getType().name().toLowerCase()))){
			  event.setCancelled(true);
		  }
	 }
}
