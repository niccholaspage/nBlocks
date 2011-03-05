package com.niccholaspage.nBlocks;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class nBlocksBlockListener extends BlockListener{
	 public static nBlocks plugin;
	  public nBlocksBlockListener(nBlocks instance) {
	        plugin = instance;
	    }
	  public void onBlockBreak(BlockBreakEvent event) {
		  Player player = event.getPlayer();
		  Block block = event.getBlock();
		  if ((!(nBlocks.Permissions.has(player, "nBlocks." + block.getType().name().toLowerCase()))) && (block.getTypeId() < 254)){
			  player.sendMessage("You do not have permissions to break that block!");
			  event.setCancelled(true);
		  }
	  }
	  public void onBlockPlace(BlockPlaceEvent event){
		  Player player = event.getPlayer();
		  Block block = event.getBlock();
		  if ((!(nBlocks.Permissions.has(player, "nBlocks." + block.getType().name().toLowerCase()))) && (block.getTypeId() < 254)){
			  player.sendMessage("You do not have permissions to place that block!");
			  event.setCancelled(true);
		  }
	  }
}
