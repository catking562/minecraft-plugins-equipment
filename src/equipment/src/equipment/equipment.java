package equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		name = "&7�׽�Ʈ�� ����";
		level = 0;
		maxtighten = 8;
		equipmentcategorie = "����";
		lore = "&f�׽�Ʈ�� �����̴�.";
		itemmaterial = Material.WOOD_SWORD;
		defaultAttributable.put("���ݷ�", new intdistence(0, 5));
		tightenAttributable.put("���ܰ�", new intdistence(0, 1));
	}
	
	public String getname() {
		return name.replace("&", "��");
	}
	
	public String getlore() {
		return lore.replace("&", "��");
	}
	
	public ItemStack getitem() {
		ItemStack i = new ItemStack(itemmaterial);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(getname());
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}
}
