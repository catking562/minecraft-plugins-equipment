package equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class equipment {
	
	private String name;
	private int level;
	private int maxtighten;
	private String equipmentcategorie;
	private String lore;
	private Material itemmaterial;
	
	Map<String, intdistence> defaultAttributable = new HashMap<String, intdistence>();
	Map<String, intdistence> tightenAttributable = new HashMap<String, intdistence>();
	
	public equipment() {
		name = "&7테스트용 무기";
		level = 0;
		maxtighten = 8;
		equipmentcategorie = "무기";
		lore = "&f테스트용 무기이다.";
		itemmaterial = Material.WOOD_SWORD;
		defaultAttributable.put("공격력", new intdistence(0, 5));
		tightenAttributable.put("공격력", new intdistence(0, 1));
	}
	
	public String getname() {
		return name.replace("&", "§");
	}
	
	public String getlore() {
		return lore.replace("&", "§");
	}
	
	public ItemStack getitem() {
		ItemStack i = new ItemStack(itemmaterial);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(getname());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(getlore());
		if(equipmentcategorie.equalsIgnoreCase("무기")) {
			lore.add(main.getString("무기분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장비")) {
			lore.add(main.getString("장비분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장신구")) {
			lore.add(main.getString("장신구분류"));
		}else {
			lore.add(main.getString("분류"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().random() + ""));
		}
		lore.add(main.getString("강화횟수").replace("<Value>", "0").replace("<MaxValue>", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("일반등급"));
		}else if(level == 1) {
			lore.add(main.getString("희귀등급"));
		}else if(level == 2) {
			lore.add(main.getString("레어등급"));
		}else if(level == 3) {
			lore.add(main.getString("에픽등급"));
		}else if(level == 4) {
			lore.add(main.getString("레전드등급"));
		}
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}
	
	public ItemStack getitemfull() {
		ItemStack i = new ItemStack(itemmaterial);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(getname());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(getlore());
		if(equipmentcategorie.equalsIgnoreCase("무기")) {
			lore.add(main.getString("무기분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장비")) {
			lore.add(main.getString("장비분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장신구")) {
			lore.add(main.getString("장신구분류"));
		}else {
			lore.add(main.getString("분류"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().getmax() + ""));
		}
		lore.add(main.getString("강화횟수").replace("<Value>", maxtighten + "").replace("<MaxValue>", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("일반등급"));
		}else if(level == 1) {
			lore.add(main.getString("희귀등급"));
		}else if(level == 2) {
			lore.add(main.getString("레어등급"));
		}else if(level == 3) {
			lore.add(main.getString("에픽등급"));
		}else if(level == 4) {
			lore.add(main.getString("레전드등급"));
		}
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}
	
	public ItemStack getitemsystem() {
		ItemStack i = new ItemStack(itemmaterial);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(getname());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(getlore());
		if(equipmentcategorie.equalsIgnoreCase("무기")) {
			lore.add(main.getString("무기분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장비")) {
			lore.add(main.getString("장비분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장신구")) {
			lore.add(main.getString("장신구분류"));
		}else {
			lore.add(main.getString("분류"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().getmin() + "~" + entry.getValue().getmax()));
		}
		lore.add(main.getString("강화횟수").replace("<Value>", "0").replace("<MaxValue>", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("일반등급"));
		}else if(level == 1) {
			lore.add(main.getString("희귀등급"));
		}else if(level == 2) {
			lore.add(main.getString("레어등급"));
		}else if(level == 3) {
			lore.add(main.getString("에픽등급"));
		}else if(level == 4) {
			lore.add(main.getString("레전드등급"));
		}
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}
	
	/*public ItemStack getitemfulltighten() {
		ItemStack i = new ItemStack(itemmaterial);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(getname());
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(getlore());
		if(equipmentcategorie.equalsIgnoreCase("무기")) {
			lore.add(main.getString("무기분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장비")) {
			lore.add(main.getString("장비분류"));
		}else if(equipmentcategorie.equalsIgnoreCase("장신구")) {
			lore.add(main.getString("장신구분류"));
		}else {
			lore.add(main.getString("분류"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().getmax() + ""));
		}
		lore.add(main.getString("강화횟수").replace("<Value>", maxtighten + "").replace("<MaxValue>", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("일반등급"));
		}else if(level == 1) {
			lore.add(main.getString("희귀등급"));
		}else if(level == 2) {
			lore.add(main.getString("레어등급"));
		}else if(level == 3) {
			lore.add(main.getString("에픽등급"));
		}else if(level == 4) {
			lore.add(main.getString("레전드등급"));
		}
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}*/
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setlevel(int level) {
		this.level = level;
	}
	
	public void setmaxtighten(int maxtighten) {
		this.maxtighten = maxtighten;
	}
	
	public void setequipmentcategorie(String equipmentcategorie) {
		this.equipmentcategorie = equipmentcategorie;
	}
	
	public void setlore(String lore) {
		this.lore = lore;
	}
	
	public void setitemmaterial(Material itemmaterial) {
		this.itemmaterial = itemmaterial;
	}
	
	public void setdefaultAttributable(String string, intdistence i) {
		if(i.getmin() == i.getmax() && i.getmax() == 0) {
			defaultAttributable.put(string, null);
		}else {
			defaultAttributable.put(string, i);
		}
	}
	
	public void settightenAttributable(String string, intdistence i) {
		if(i.getmin() == i.getmax() && i.getmax() == 0) {
			tightenAttributable.put(string, null);
		}else {
			tightenAttributable.put(string, i);
		}
	}
}
