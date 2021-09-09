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
					if(lorelist.get(0).equalsIgnoreCase(main.getString("무기분류"))) {
						categorie = "무기";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("장비분류"))) {
                    	categorie = "장비";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("장신구분류"))) {
                    	categorie = "장신구";
					}
                    if(lorelist.get(0).equalsIgnoreCase(main.getString("분류"))) {
                    	categorie = "무엇";
					}
				}
				if(lorelist.size() >= 2) {
					lore = lorelist.get(1);
				}
				if(lorelist.size() >= 3) {
                    if(lorelist.contains(main.getString("일반"))) {
						level = 0;
					}else
                    if(lorelist.contains(main.getString("희귀"))) {
                    	level = 1;
					}else
                    if(lorelist.contains(main.getString("레어"))) {
                    	level = 2;
					}else
                    if(lorelist.contains(main.getString("에픽"))) {
                    	level = 3;
					}else
                    if(lorelist.contains(main.getString("레전드"))) {
                    	level = 4;
					}else {
						level = 5;
					}
				}
				for(String string : lorelist) {
					String s1 = main.getString("공격력").replace("<Value>", "");
					String s2 = main.getString("크리티컬확률").replace("<Value>", "");
					String s3 = main.getString("크리티컬데미지").replace("<Value>", "");
					String s4 = main.getString("방어력").replace("<Value>", "");
					String s5 = main.getString("회피확률").replace("<Value>", "");
					String s6 = main.getString("이동속도").replace("<Value>", "");
					String s7 = main.getString("체력").replace("<Value>", "");
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
