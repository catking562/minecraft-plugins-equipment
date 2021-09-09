package equipment;

import java.util.Map;
import org.bukkit.OfflinePlayer;

public class equip {
	
	public equip() {
		
	}
	
	public Map<String, equipment> getequipmentlist() {
		return main.equipmentlist;
	}
	
	public playerequipment getplayerequipment(OfflinePlayer player) {
		return main.playerequi.get(player);
	}

}
