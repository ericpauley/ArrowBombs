package zonedabone.ArrowBombs;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowBombsEntityListener extends EntityListener {
	
	public static ArrowBombs plugin;
	
	public ArrowBombsEntityListener(ArrowBombs instance){
		plugin = instance;
	}
	
	public void onProjectileHit(ProjectileHitEvent e){
		plugin.log.info("time to boom!");
		if(e.getEntity() instanceof Arrow){
			Location loc = e.getEntity().getLocation();
			double x = loc.getX();
			double y = loc.getY();
			double z = loc.getZ();
			loc.getWorld().createExplosion(x, y, z, plugin.POWER, plugin.SET_FIRE);
			plugin.log.info("ARROW GO BOOM!");
		}
	}

}
