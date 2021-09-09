package equipment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
	Map<String, File> file = new HashMap<String, File>();
	Map<String, YamlConfiguration> config = new HashMap<String, YamlConfiguration>();
    static Map<String, String> message = new HashMap<String, String>();
    static Map<String, equipment> equipmentlist = new HashMap<String, equipment>();
    static Map<OfflinePlayer, playerequipment> playerequi = new HashMap<OfflinePlayer, playerequipment>();
	
	public void messageconfig() {
		File file = this.file.get("message");
		YamlConfiguration config = this.config.get("message");
		if(config.getString("접두어") == null) {
			config.set("접두어", "&f[ &a장비 &f] ");
		}
		if(config.getString("무기분류") == null) {
			config.set("무기분류", "&f----------무기----------");
		}
		if(config.getString("장비분류") == null) {
			config.set("장비분류", "&f----------장비----------");
		}
		if(config.getString("장신구분류") == null) {
			config.set("장신구분류", "&f---------장신구---------");
		}
		if(config.getString("분류") == null) {
			config.set("분류", "&f----------------------");
		}
		if(config.getString("일반등급") == null) {
			config.set("일반등급", "&f일반");
		}
		if(config.getString("희귀등급") == null) {
			config.set("희귀등급", "&a희귀");
		}
		if(config.getString("레어등급") == null) {
			config.set("레어등급", "&9레어");
		}
		if(config.getString("에픽등급") == null) {
			config.set("에픽등급", "&5에픽");
		}
		if(config.getString("레전드등급") == null) {
			config.set("레전드등급", "&6레전드");
		}
		if(config.getString("강화횟수") == null) {
			config.set("강화횟수", "&f강화횟수 : <Value>/<MaxValue>");
		}
		if(config.getString("명령어오류") == null) {
			config.set("명령어오류", "무슨명령어죠? 잘모르겠어요!");
		}
		if(config.getString("개발중") == null) {
			config.set("개발중", "아직... 개발중이에요!");
		}
		if(config.getString("없는장비") == null) {
			config.set("없는장비", "존재하지 않는 장비입니다.");
		}
		if(config.getString("있는장비") == null) {
			config.set("있는장비", "이미 존재하는 장비입니다.");
		}
		if(config.getString("생성완료") == null) {
			config.set("생성완료", "장비를 생성하였습니다.");
		}
		if(config.getString("삭제완료") == null) {
			config.set("삭제완료", "장비를 삭제하였습니다.");
		}
		if(config.getString("이름설정완료") == null) {
			config.set("이름설정완료", "장비의 이름을 설정하였습니다.");
		}
		if(config.getString("설명설정완료") == null) {
			config.set("설명설정완료", "장비의 설명을 설정하였습니다.");
		}
		if(config.getString("정수입력") == null) {
			config.set("정수입력", "정수를 입력해주세요.");
		}
		if(config.getString("아이템설정완료") == null) {
			config.set("아이템설정완료", "장비의 아이템을 설정하였습니다.");
		}
		if(config.getString("등급설정완료") == null) {
			config.set("등급설정완료", "장비의 등급을 설정하였습니다.");
		}
		if(config.getString("0~4") == null) {
			config.set("0~4", "0 ~ 4의 정수만 입력하세요.");
		}
		if(config.getString("최대강화횟수설정완료") == null) {
			config.set("최대강화횟수설정완료", "장비의 최대강화횟수를 설정하였습니다.");
		}
		if(config.getString("0이상") == null) {
			config.set("0이상", "0이상의 정수만 입력해주세요");
		}
		if(config.getString("템지급") == null) {
			config.set("템지급", "장비를 지급하였습니다.");
		}
		if(config.getString("명령어값오류") == null) {
			config.set("명령어값오류", "값을 제대로 입력해주세요.");
		}
		if(config.getString("기본능력치설정완료") == null) {
			config.set("기본능력치설정완료", "기본능력치를 설정하였습니다.");
		}
		if(config.getString("강화설정완료") == null) {
			config.set("강화설정완료", "강화능력치를 설정하였습니다.");
		}
		if(config.getString("공격력") == null) {
			config.set("공격력", "공격력 : <Value>");
		}
		if(config.getString("크리티컬확률") == null) {
			config.set("크리티컬확률", "크리티컬확률 : <Value>");
		}
		if(config.getString("방어력") == null) {
			config.set("방어력", "방어력 : <Value>");
		}
		if(config.getString("회피확률") == null) {
			config.set("회파확률", "회피확률 : <Value>");
		}
		if(config.getString("이동속도") == null) {
			config.set("이동속도", "이동속도 : <Value>");
		}
		if(config.getString("체력") == null) {
			config.set("체력", "체력 : <Value>");
		}
		if(config.getString("방어력") == null) {
			config.set("방어력", "방어력 : <Value>");
		}
		if(config.getString("크리티컬데미지") == null) {
			config.set("크리티컬데미지", "크리티컬데미지 : <Value>");
		}
		for(String key : config.getKeys(false)) {
			main.message.put(key, config.getString(key));
		}
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void equipmentconfig() {
		YamlConfiguration equipmentconfig = config.get("equipment");
		for(String key : equipmentconfig.getKeys(false)) {
			equipment equi = new equipment();
			for(Entry<String, intdistence> entry : equi.getdefaultAttributable().entrySet()) {
				equi.setdefaultAttributable(entry.getKey(), new intdistence(0, 0));
			}
			for(Entry<String, intdistence> entry : equi.gettightenAttributable().entrySet()) {
				equi.settightenAttributable(entry.getKey(), new intdistence(0, 0));
			}
			equi.setname(equipmentconfig.getString(key + ".name"));
			equi.setlore(equipmentconfig.getString(key + ".lore"));
			equi.setlevel(equipmentconfig.getInt(key + ".level"));
			equi.setmaxtighten(equipmentconfig.getInt(key + ".maxtighten"));
			equi.setitemmaterial(Material.getMaterial(equipmentconfig.getString(key + ".material")));
			equi.setequipmentcategorie(equipmentconfig.getString(key + ".categorie"));
			for(String string : equipmentconfig.getConfigurationSection(key + ".defaultAttributable").getKeys(false)) {
				equi.setdefaultAttributable(string, stringtodisint(equipmentconfig.getString(key + ".defaultAttributable." + string)));
			}
			for(String string : equipmentconfig.getConfigurationSection(key + ".tightenAttributable").getKeys(false)) {
				equi.setdefaultAttributable(string, stringtodisint(equipmentconfig.getString(key + ".tightenAtributable." + string)));
			}
			equipmentlist.put(key, equi);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void playerequipmentconfig() {
		YamlConfiguration config = this.config.get("playerequipment");
		for(String key : config.getKeys(false)) {
			playerequipment peq = new playerequipment();
			for(String value : config.getConfigurationSection(key).getKeys(false)) {
				if(value.equalsIgnoreCase("head")) {
					peq.sethead(config.getItemStack(key + ".head"));
				}else if(value.equalsIgnoreCase("body")) {
					peq.sethead(config.getItemStack(key + ".body"));
				}else if(value.equalsIgnoreCase("leg")) {
					peq.sethead(config.getItemStack(key + ".leg"));
				}else if(value.equalsIgnoreCase("foot")) {
					peq.sethead(config.getItemStack(key + ".foot"));
				}else if(value.equalsIgnoreCase("weapon")) {
					peq.sethead(config.getItemStack(key + ".weapon"));
				}else if(value.equalsIgnoreCase("acc1")) {
					peq.sethead(config.getItemStack(key + ".acc1"));
				}else if(value.equalsIgnoreCase("acc2")) {
					peq.sethead(config.getItemStack(key + ".acc2"));
				}else if(value.equalsIgnoreCase("acc3")) {
					peq.sethead(config.getItemStack(key + ".acc3"));
				}
			}
			playerequi.put(Bukkit.getOfflinePlayer(key), peq);
		}
	}
	
	@SuppressWarnings("unused")
	public void save() {
		File equipmentfile = file.get("equipment");
		YamlConfiguration equipmentconfig = config.get("equipment");
		File playerequipmentfile = file.get("playerequipment");
		YamlConfiguration playerequipmentconfig = config.get("playerequipment");
		for(String key : equipmentconfig.getKeys(true)) {
			equipmentconfig.set(key, null);
		}
		for(Entry<String, equipment> entry : equipmentlist.entrySet()) {
			equipmentconfig.set(entry.getKey() + ".name", entry.getValue().getname());
			equipmentconfig.set(entry.getKey() + ".lore", entry.getValue().getlore());
			equipmentconfig.set(entry.getKey() + ".level", entry.getValue().getlevel());
			equipmentconfig.set(entry.getKey() + ".maxtighten", entry.getValue().getmaxtighten());
			equipmentconfig.set(entry.getKey() + ".material", entry.getValue().getmaterial().toString());
			equipmentconfig.set(entry.getKey() + ".categorie", entry.getValue().getcategorie());
			for(Entry<String, intdistence> entry1 : entry.getValue().getdefaultAttributable().entrySet()) {
				equipmentconfig.set(entry.getKey() + ".defaultAttributable." + entry1.getKey(), entry1.getValue().tostring());
			}
			for(Entry<String, intdistence> entry1 : entry.getValue().gettightenAttributable().entrySet()) {
				equipmentconfig.set(entry.getKey() + ".gettightenAttributable." + entry1.getKey(), entry1.getValue().tostring());
			}
		}
		for(Entry<OfflinePlayer, playerequipment> entry : playerequi.entrySet()) {
			if(entry.getValue().hashead()) {
				playerequipmentconfig.set(entry.getKey() + ".head", entry.getValue().gethead());
			}
			if(entry.getValue().hasbody()) {
				playerequipmentconfig.set(entry.getKey() + ".body", entry.getValue().getbody());
			}
			if(entry.getValue().hasleg()) {
				playerequipmentconfig.set(entry.getKey() + ".leg", entry.getValue().getleg());
			}
			if(entry.getValue().hasfoot()) {
				playerequipmentconfig.set(entry.getKey() + ".foot", entry.getValue().getfoot());
			}
			if(entry.getValue().hasweapon()) {
				playerequipmentconfig.set(entry.getKey() + ".weapon", entry.getValue().getweapon());
			}
			if(entry.getValue().hasaccessory1()) {
				playerequipmentconfig.set(entry.getKey() + ".acc1", entry.getValue().getaccessory1());
			}
			if(entry.getValue().hasaccessory1()) {
				playerequipmentconfig.set(entry.getKey() + ".acc2", entry.getValue().getaccessory2());
			}
			if(entry.getValue().hasaccessory1()) {
				playerequipmentconfig.set(entry.getKey() + ".acc3", entry.getValue().getaccessory3());
			}
		}
		try {
			equipmentconfig.save(equipmentfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		File messagefile = new File(getDataFolder() + "/message.yml");
		YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messagefile);
		File equipmentfile = new File(getDataFolder() + "/equipment.yml");
		YamlConfiguration equipmentconfig = YamlConfiguration.loadConfiguration(equipmentfile);
		File playerequipmentfile = new File(getDataFolder() + "/playerequipment.yml");
		YamlConfiguration playerequipmentconfig = YamlConfiguration.loadConfiguration(playerequipmentfile);
		file.put("message", messagefile);
		config.put("message", messageconfig);
		file.put("equipment", equipmentfile);
		config.put("equipment", equipmentconfig);
		file.put("playerequipment", playerequipmentfile);
		config.put("playerequipment", playerequipmentconfig);
		messageconfig();
		equipmentconfig();
		save();
	}
	
	public static String getString(String string) {
		return main.message.get(string).replace("&", "§");
	}
	
	public void onDisable() {
		save();
	}
	
	public boolean isequipment(String string) {
		for(Entry<String, equipment> entry : equipmentlist.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(string)) {
				return true;
			}
		}
		return false;
	}
	
	public equipment getequipment(String string) {
		for(Entry<String, equipment> entry : equipmentlist.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(string)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public boolean isint(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public intdistence stringtodisint(String string) {
		String[] s = string.split("~");
		if(isint(s[0]) && isint(s[s.length])) {
			return new intdistence(Integer.parseInt(s[0]), Integer.parseInt(s[s.length]));
		}
		return null;
	}
	
	public Inventory equipmentGUI() {
		Inventory inv = Bukkit.createInventory(null, 0);
		return inv;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
		    if(command.getName().equalsIgnoreCase("장비")) {
		    	p.sendMessage(getString("접두어") + getString("개발중"));
		    }else if(command.getName().equalsIgnoreCase("장비강화")) {
		    	p.sendMessage(getString("접두어") + getString("개발중"));
		    }else if(command.getName().equalsIgnoreCase("장비설정")) {
		    	if(args.length == 0) {
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름>  --  장비를 확인합니다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 생성  --  장비를 생성합니다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 삭제  --  장비를 삭제합니다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 이름 <display>  --  장비의 이름을 설정합니다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 설명 <설명>  --  장비에 설명을 추가한다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 아이템 <코드>  --  장비의 아이템을 설정한다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 등급 <등급>  --  장비의 등급을 설정합니다");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 기본능력치 <능력치> <값>  --  장비의 기본능력치를 설정한다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 강화최대횟수 <값>  --  장비를 강화할 수 있는 최대 횟수를 설정한다.");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 강화설정 <능력치> <값>  --  장비를 강화할때마다 해당 능력치가 얼마씩 증가할지 설정한다");
		    		p.sendMessage(getString("접두어") + "/장비설정 <이름> 받기 <장비상태>  --  장비을 받는다");
		    	}else if(args.length == 1) {
		    		if(isequipment(args[0])) {
		    			ItemStack i = getequipment(args[0]).getitemsystem();
		    			ItemMeta m = i.getItemMeta();
		    			p.sendMessage(m.getDisplayName());
		    			for(String string : m.getLore()) {
		    				p.sendMessage(string);
		    			}
		    		}else {
		    			p.sendMessage(getString("접두어") + getString("없는장비"));
		    		}
		    	}else if(args.length == 2) {
		    		if(isequipment(args[0])) {
                        if(args[1].toString().equalsIgnoreCase("생성")) {
		    				p.sendMessage(getString("접두어") + getString("있는장비"));
		    			}else if(args[1].toString().equalsIgnoreCase("삭제")) {
		    				equipmentlist.put(args[1], null);
		    				p.sendMessage(getString("접두어") + getString("삭제완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("이름")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 이름 <display>  --  장비의 이름을 설정합니다.");
		    			}else if(args[1].toString().equalsIgnoreCase("설명")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 설명 <설명>  --  장비에 설명을 추가한다.");
		    			}else if(args[1].toString().equalsIgnoreCase("아이템")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 아이템 <코드>  --  장비의 아이템을 설정한다.");
		    			}else if(args[1].toString().equalsIgnoreCase("등급")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 등급 <등급>  --  장비의 등급을 설정합니다");
		    			}else if(args[1].toString().equalsIgnoreCase("기본능력치")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 기본능력치 <능력치> <값>  --  장비의 기본능력치를 설정한다.");
		    			}else if(args[1].toString().equalsIgnoreCase("강화최대횟수")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 강화최대횟수 <값>  --  장비를 강화할 수 있는 최대 횟수를 설정한다.");
		    			}else if(args[1].toString().equalsIgnoreCase("강화설정")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 강화설정 <능력치> <값>  --  장비를 강화할때마다 해당 능력치가 얼마씩 증가할지 설정한다");
		    			}else if(args[1].toString().equalsIgnoreCase("받기")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 받기 <장비상태>  --  장비을 받는다");
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("생성")) {
		    				equipment equi = new equipment();
		    				equipmentlist.put(args[1].toString(), equi);
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("없는장비"));
		    			}
		    		}
		    	}else if(args.length == 3) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("이름")) {
		    				equipmentlist.get(args[1].toString()).setname(args[2].toString());
		    				p.sendMessage(getString("접두어") + getString("이름설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("설명")) {
		    				equipmentlist.get(args[1]).setlore(args[2].toString());
		    				p.sendMessage(getString("접두어") + getString("설명설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("아이템")) {
		    				if(isint(args[2])) {
		    					equipmentlist.get(args[1]).setitemmaterial(Material.getMaterial(Integer.parseInt(args[2])));
		    					p.sendMessage(getString("접두어") + getString("아이템설정완료"));
		    				}else {
		    					p.sendMessage(getString("접두어") + getString("정수입력"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("등급")) {
		    				if(isint(args[2])) {
		    					if(Integer.parseInt(args[2]) >= 0 && Integer.parseInt(args[2]) <= 4) {
		    						p.sendMessage(getString("접두어") + getString("등급설정완료"));
		    					}else {
		    						p.sendMessage(getString("접두어") + getString("0~4"));
		    					}
		    				}else {
		    					p.sendMessage(getString("접두어") + getString("정수입력"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("기본능력치")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 기본능력치 <능력치> <값>  --  장비의 기본능력치를 설정한다.");
		    			}else if(args[1].toString().equalsIgnoreCase("강화최대횟수")) {
		    				if(isint(args[2])) {
		    					if(Integer.parseInt(args[2]) >= 0) {
		    						equipmentlist.get(args[1]).setmaxtighten(Integer.parseInt(args[2]));
		    						p.sendMessage(getString("접두어") + getString("강화최대횟수설정완료"));
		    					}else {
		    						p.sendMessage(getString("접두어") + getString("0이상"));
		    					}
		    				}else {
		    					p.sendMessage(getString("접두어") + getString("정수입력"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("강화설정")) {
		    				p.sendMessage(getString("접두어") + "/장비설정 <이름> 강화설정 <능력치> <값>  --  장비를 강화할때마다 해당 능력치가 얼마씩 증가할지 설정한다");
		    			}else if(args[1].toString().equalsIgnoreCase("받기")) {
		    				if(args[2].equalsIgnoreCase("일반")) {
		    					p.getInventory().addItem(equipmentlist.get(args[1]).getitem());
		    					p.sendMessage(getString("접두어") + getString("템지급"));
		    				}else if(args[2].equalsIgnoreCase("풀일반")) {
		    					p.getInventory().addItem(equipmentlist.get(args[1]).getitemfull());
		    					p.sendMessage(getString("접두어") + getString("템지급"));
		    				}else {
		    					p.sendMessage(getString("접두어") + "장비상태 = {일반, 풀일반}");
		    				}
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("생성")) {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("없는장비"));
		    			}
		    		}
		    	}else if(args.length == 4) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("이름")) {
		    				equipmentlist.get(args[1].toString()).setname(args[2].toString() + " " + args[3].toString());
		    				p.sendMessage(getString("접두어") + getString("이름설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("설명")) {
		    				equipmentlist.get(args[1]).setlore(args[2].toString() + " " + args[3].toString());
		    				p.sendMessage(getString("접두어") + getString("설명설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("기본능력치")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).setdefaultAttributable(args[2], stringtodisint(args[3]));
		    				}else {
		    					p.sendMessage(getString("접두어") + getString("명령어값오류"));
		    				}
		    				p.sendMessage(getString("접두어") + getString("기본능력치설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("강화설정")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).settightenAttributable(args[2], stringtodisint(args[3]));
		    				}else {
		    					p.sendMessage(getString("접두어") + getString("명령어값오류"));
		    				}
		    				p.sendMessage(getString("접두어") + getString("강화설정완료"));
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("생성")) {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("없는장비"));
		    			}
		    		}
		    	}else if(args.length >= 5) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("이름")) {
		    				String string = "";
		    				for (int i = 2; i < args.length; i++) {
								string = string + args[i] + " ";
							}
		    				equipmentlist.get(args[1].toString()).setname(string);
		    				p.sendMessage(getString("접두어") + getString("이름설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("설명")) {
		    				String string = "";
		    				for (int i = 2; i < args.length; i++) {
								string = string + args[i] + " ";
							}
		    				equipmentlist.get(args[1]).setlore(string);
		    				p.sendMessage(getString("접두어") + getString("설명설정완료"));
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("생성")) {
		    				p.sendMessage(getString("접두어") + getString("명령어오류"));
		    			}else {
		    				p.sendMessage(getString("접두어") + getString("없는장비"));
		    			}
		    		}
		    	}
		    }else {
		    	p.sendMessage(getString("접두어") + getString("명령어오류"));
		    }
		}else {
			System.out.println("플레이어만 입력할 수 있는 명령어입니다.");
		}
		return super.onCommand(sender, command, label, args);
	}
	
	@EventHandler
	public void autosave(WorldSaveEvent e) {
		save();
	}

}
