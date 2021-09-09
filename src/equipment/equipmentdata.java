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
	
	Map<String, Integer> Attributable = new HashMap<String, Integer>();
	
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
						level = 0;
					}else
                    if(lorelist.contains(main.getString("���"))) {
                    	level = 1;
					}else
                    if(lorelist.contains(main.getString("����"))) {
                    	level = 2;
					}else
                    if(lorelist.contains(main.getString("����"))) {
                    	level = 3;
					}else
                    if(lorelist.contains(main.getString("������"))) {
                    	level = 4;
					}else {
						level = 5;
					}
				}
				for(String string : lorelist) {
					String s1 = main.getString("���ݷ�").replace("<Value>", "");
					String s2 = main.getString("ũ��Ƽ��Ȯ��").replace("<Value>", "");
					String s3 = main.getString("ũ��Ƽ�õ�����").replace("<Value>", "");
					String s4 = main.getString("����").replace("<Value>", "");
					String s5 = main.getString("ȸ��Ȯ��").replace("<Value>", "");
					String s6 = main.getString("�̵��ӵ�").replace("<Value>", "");
					String s7 = main.getString("ü��").replace("<Value>", "");
					String string1  = string;
					if(string.length() >= s1.length() && string.substring(0, s1.length()).equalsIgnoreCase(s1)) {
						int len = s1.length();
						Attributable.put(s1.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s2.length() && string.substring(0, s2.length()).equalsIgnoreCase(s2)) {
						int len = s2.length();
						Attributable.put(s2.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s3.length() && string.substring(0, s3.length()).equalsIgnoreCase(s3)) {
						int len = s3.length();
						Attributable.put(s3.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s4.length() && string.substring(0, s4.length()).equalsIgnoreCase(s4)) {
						int len = s4.length();
						Attributable.put(s4.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s5.length() && string.substring(0, s5.length()).equalsIgnoreCase(s5)) {
						int len = s5.length();
						Attributable.put(s5.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s6.length() && string.substring(0, s6.length()).equalsIgnoreCase(s6)) {
						int len = s6.length();
						Attributable.put(s6.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
					if(string.length() >= s7.length() && string.substring(0, s7.length()).equalsIgnoreCase(s7)) {
						int len = s7.length();
						Attributable.put(s7.replace(" : ", ""), Integer.valueOf(string1.substring(len, string1.length())));
					}
				}
			}
		}
	}
	
	public boolean isequipment() {
		return (name != null) && (lore != null) && (categorie != null) && (level != 5);
	}
	

}
