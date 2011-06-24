package zonedabone.ArrowBombs;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class ArrowBombs extends JavaPlugin {

	Logger log = Logger.getLogger("minecraft");
	public int POWER;
	public boolean SET_FIRE;
	
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName()+" v"+pdf.getVersion()+" DISABLED.");

	}

	@Override
	public void onEnable() {
		
		ArrowBombsEntityListener entityListener = new ArrowBombsEntityListener(this);
		
		Configuration config = this.getConfiguration();
		POWER = config.getInt("power", 4);
		config.setProperty("power", POWER);
		SET_FIRE = config.getBoolean("setfire", false);
		config.setProperty("setfire", SET_FIRE);
		config.save();
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PROJECTILE_HIT, entityListener, Event.Priority.Normal, this);
		
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName()+" v"+pdf.getVersion()+" ENABLED.");

	}

}
