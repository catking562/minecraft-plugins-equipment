package equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class equipmentdata {
	
	private ItemStack i;
	private String name;
	private String lore;
	private String categorie;
	private int level;
	
	Map<String, intdistence> defaultAttributable = new HashMap<String, intdistence>();
	Map<String, intdistence> tightenAttributable = new HashMap<String, intdistence>();
	
	public equipmentdata(ItemStack i) {
		this.i = i;
		if(i.hasItemMeta()) {
			if(i.getItemMeta().hasDisplayName()) {
				name = i.getItemMeta().getDisplayName();
			}else {
				name = i.getType().toString();
			}
			if(i.getItemMeta().hasLore()) {
				ArrayList<String> lorelist = (ArrayList<String>) i.getItemMeta().getLore();
				if(lorelist.size() >= 1) {
					if(lorelist.get(0).equalsIgnoreCase(main.getString("����з�"))) {
						categorie = "����";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("���з�"))) {
                    	categorie = "���";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("��ű��з�"))) {
                    	categorie = "��ű�";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("�з�"))) {
                    	categorie = "����";
					}
				}
				if(lorelist.size() >= 2) {
					lore = lorelist.get(1);
				}
				if(lorelist.size() >= 3) {
                    if(lorelist.contains(main.getString("�Ϲ�"))) {
						
					}
                    if(lorelist.contains(main.getString("���"))) {
						
					}
                    if(lorelist.contains(main.getString("����"))) {
						
					}
                    if(lorelist.contains(main.getString("����"))) {
						
					}
                    if(lorelist.contains(main.getString("������"))) {
						
					}
				}
			}
		}
	}

}
