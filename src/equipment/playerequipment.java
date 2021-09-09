package equipment;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.inventory.ItemStack;

public class playerequipment {
	
	private ItemStack weapon;
	private ItemStack head;
	private ItemStack body;
	private ItemStack leg;
	private ItemStack foot;
	private ItemStack accessory1;
	private ItemStack accessory2;
	private ItemStack accessory3;
	
	public playerequipment() {
		
	}
	
	public boolean hasweapon() {
		return weapon != null;
	}
	
	public boolean hashead() {
		return head != null;
	}
	
	public boolean hasbody() {
		return body != null;
	}
	
	public boolean hasleg() {
		return leg != null;
	}
	
	public boolean hasfoot() {
		return foot != null;
	}
	
	public boolean hasaccessory1() {
		return accessory1 != null;
	}
	
	public boolean hasaccessory2() {
		return accessory2 != null;
	}
	
	public boolean hasaccessory3() {
		return accessory3 != null;
	}
	
	public ItemStack getweapon() {
		return weapon;
	}
	
	public ItemStack gethead() {
		return head;
	}
	
	public ItemStack getbody() {
		return body;
	}
	
	public ItemStack getleg() {
		return leg;
	}
	
	public ItemStack getfoot() {
		return foot;
	}
	
	public ItemStack getaccessory1() {
		return accessory1;
	}
	
	public ItemStack getaccessory2() {
		return accessory2;
	}
	
	public ItemStack getaccessory3() {
		return accessory3;
	}
	
	public void setweapon(ItemStack i) {
		this.weapon = i;
	}
	
	public void sethead(ItemStack i) {
		this.head = i;
	}
	
	public void setbody(ItemStack i) {
		this.body = i;
	}
	
	public void setleg(ItemStack i) {
		this.leg = i;
	}
	
	public void setfoot(ItemStack i) {
		this.foot = i;
	}
	
	public void setaccessory1(ItemStack i) {
		this.accessory1 = i;
	}
	
	public void setaccessory2(ItemStack i) {
		this.accessory2 = i;
	}
	
	public void setaccessory3(ItemStack i) {
		this.accessory3 = i;
	}
	
	public Map<String, Integer> getheadattr() {
		equipmentdata data = new equipmentdata(head);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getbodyattr() {
		equipmentdata data = new equipmentdata(body);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getlegattr() {
		equipmentdata data = new equipmentdata(leg);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getfootattr() {
		equipmentdata data = new equipmentdata(foot);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getweaponattr() {
		equipmentdata data = new equipmentdata(weapon);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getacc1attr() {
		equipmentdata data = new equipmentdata(accessory1);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getacc2attr() {
		equipmentdata data = new equipmentdata(accessory2);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getacc3attr() {
		equipmentdata data = new equipmentdata(accessory3);
		return data.getAttributable();
	}
	
	public Map<String, Integer> getatt() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("공격력", 0);
		map.put("크리티컬확률", 0);
		map.put("크리티컬데미지", 0);
		map.put("회피확률", 0);
		map.put("이동속도", 0);
		map.put("체력", 0);
		for(Entry<String, Integer> entry : map.entrySet()) {
			for(Entry<String, Integer> entry1 : getheadattr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getbodyattr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getlegattr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getfootattr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getweaponattr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getacc1attr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getacc2attr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
			for(Entry<String, Integer> entry1 : getacc3attr().entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					map.put(entry.getKey(), map.get(entry.getKey()) + entry1.getValue());
				}
			}
		}
		return map;
	}

}
