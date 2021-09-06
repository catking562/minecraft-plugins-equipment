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
		name = "&7�׽�Ʈ�� ����";
		level = 0;
		maxtighten = 8;
		equipmentcategorie = "����";
		lore = "&f�׽�Ʈ�� �����̴�.";
		itemmaterial = Material.WOOD_SWORD;
		defaultAttributable.put("���ݷ�", new intdistence(0, 5));
		tightenAttributable.put("���ݷ�", new intdistence(0, 1));
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
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(getlore());
		if(equipmentcategorie.equalsIgnoreCase("����")) {
			lore.add(main.getString("����з�"));
		}else if(equipmentcategorie.equalsIgnoreCase("���")) {
			lore.add(main.getString("���з�"));
		}else if(equipmentcategorie.equalsIgnoreCase("��ű�")) {
			lore.add(main.getString("��ű��з�"));
		}else {
			lore.add(main.getString("�з�"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().random() + ""));
		}
		lore.add(main.getString("��ȭȽ��").replace("<Value>", "0").replace("<MaxValue", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("�Ϲݵ��"));
		}else if(level == 1) {
			lore.add(main.getString("��͵��"));
		}else if(level == 2) {
			lore.add(main.getString("������"));
		}else if(level == 3) {
			lore.add(main.getString("���ȵ��"));
		}else if(level == 4) {
			lore.add(main.getString("��������"));
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
		if(equipmentcategorie.equalsIgnoreCase("����")) {
			lore.add(main.getString("����з�"));
		}else if(equipmentcategorie.equalsIgnoreCase("���")) {
			lore.add(main.getString("���з�"));
		}else if(equipmentcategorie.equalsIgnoreCase("��ű�")) {
			lore.add(main.getString("��ű��з�"));
		}else {
			lore.add(main.getString("�з�"));
		}
		for(Entry<String, intdistence> entry : defaultAttributable.entrySet()) {
			lore.add(main.getString(entry.getKey()).replace("<Value>", entry.getValue().getmax() + ""));
		}
		lore.add(main.getString("��ȭȽ��").replace("<Value>", "0").replace("<MaxValue", maxtighten + ""));
		if(level == 0) {
			lore.add(main.getString("�Ϲݵ��"));
		}else if(level == 1) {
			lore.add(main.getString("��͵��"));
		}else if(level == 2) {
			lore.add(main.getString("������"));
		}else if(level == 3) {
			lore.add(main.getString("���ȵ��"));
		}else if(level == 4) {
			lore.add(main.getString("��������"));
		}
		m.setLore(Arrays.asList(getlore()));
		i.setItemMeta(m);
		return i;
	}
}
