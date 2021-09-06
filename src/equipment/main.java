package equipment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	Map<String, File> file = new HashMap<String, File>();
	Map<String, YamlConfiguration> config = new HashMap<String, YamlConfiguration>();
    static Map<String, String> message = new HashMap<String, String>();
    Map<String, equipment> equipmentlist = new HashMap<String, equipment>();
	
	public void messageconfig() {
		File file = this.file.get("message");
		YamlConfiguration config = this.config.get("message");
		if(config.getString("접두어") != null) {
			config.set("접두어", "&f[ &a장비 &f] ");
		}
		if(config.getString("무기분류") != null) {
			config.set("무기분류", "&f----------무기----------");
		}
		if(config.getString("장비분류") != null) {
			config.set("장비분류", "&f----------장비----------");
		}
		if(config.getString("장신구분류") != null) {
			config.set("장신구분류", "&f---------장신구---------");
		}
		if(config.getString("분류") != null) {
			config.set("분류", "&f----------------------");
		}
		if(config.getString("공격력") != null) {
			config.set("공격력", "&f공격력 : <value>");
		}
		if(config.getString("체력") != null) {
			config.set("체력", "&f체력 : <value>");
		}
		if(config.getString("회피확률") != null) {
			config.set("회피확률", "&f회피확률 : <value>");
		}
		if(config.getString("이동속도") != null) {
			config.set("이동속도", "&f이동속도 : <value>");
		}
		if(config.getString("방어력") != null) {
			config.set("방어력", "&f방어력 : <value>");
		}
		if(config.getString("공격력") != null) {
			config.set("공격력", "&f공격력 : <value>");
		}
		if(config.getString("일반등급") != null) {
			config.set("일반등급", "&f일반");
		}
		if(config.getString("희귀등급") != null) {
			config.set("희귀등급", "&a희귀");
		}
		if(config.getString("레어등급") != null) {
			config.set("레어등급", "&9레어");
		}
		if(config.getString("에픽등급") != null) {
			config.set("에픽등급", "&5에픽");
		}
		if(config.getString("레전드등급") != null) {
			config.set("레전드등급", "&6레전드");
		}
		if(config.getString("강화횟수") != null) {
			config.set("강화횟수", "&f강화횟수 : <Value>/<MaxValue>");
		}
		if(config.getString("명령어오류") != null) {
			config.set("명령어오류", "무슨명령어죠? 잘모르겠어요!");
		}
		if(config.getString("개발중") != null) {
			config.set("개발중", "아직... 개발중이에요!");
		}
		if(config.getString("없는장비") != null) {
			config.set("없는장비", "존재하지 않는 장비입니다.");
		}
		if(config.getString("있는장비") != null) {
			config.set("있는장비", "이미 존재하는 장비입니다.");
		}
		if(config.getString("생성완료") != null) {
			config.set("생성완료", "장비를 생성하였습니다.");
		}
		if(config.getString("삭제완료") != null) {
			config.set("삭제완료", "장비를 삭제하였습니다.");
		}
		if(config.getString("이름설정완료") != null) {
			config.set("이름설정완료", "장비의 이름을 설정하였습니다.");
		}
		if(config.getString("설명설정완료") != null) {
			config.set("설명설정완료", "장비의 설명을 설정하였습니다.");
		}
		if(config.getString("정수입력") != null) {
			config.set("정수입력", "정수를 입력해주세요.");
		}
		if(config.getString("아이템설정완료") != null) {
			config.set("아이템설정완료", "장비의 아이템을 설정하였습니다.");
		}
		if(config.getString("등급설정완료") != null) {
			config.set("등급설정완료", "장비의 등급을 설정하였습니다.");
		}
		if(config.getString("0~4") != null) {
			config.set("0~4", "0 ~ 4의 정수만 입력하세요.");
		}
		if(config.getString("최대강화횟수설정완료") != null) {
			config.set("최대강화횟수설정완료", "장비의 최대강화횟수를 설정하였습니다.");
		}
		if(config.getString("0이상") != null) {
			config.set("0이상", "0이상의 정수만 입력해주세요");
		}
		if(config.getString("템지급") != null) {
			config.set("템지급", "장비를 지급하였습니다.");
		}
		for(String key : config.getKeys(false)) {
			this.message.put(key, config.getString(key));
		}
	}
	
	public void save() {
		
	}
	
	public void savefirst() {
		File messagefile = this.file.get("message");
		YamlConfiguration messageconfig = this.config.get("message");
		try {
			messageconfig.save(messagefile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onEnable() {
		File messagefile = new File(getDataFolder() + "/message.yml");
		YamlConfiguration messageconfig = YamlConfiguration.loadConfiguration(messagefile);
		file.put("message", messagefile);
		config.put("message", messageconfig);
		messageconfig();
		savefirst();
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
		    				equipmentlist.get(args[1].toString()).setname(args[2].toString() + args[3].toString());
		    				p.sendMessage(getString("접두어") + getString("이름설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("설명")) {
		    				equipmentlist.get(args[1]).setlore(args[2].toString() + args[3].toString());
		    				p.sendMessage(getString("접두어") + getString("설명설정완료"));
		    			}else if(args[1].toString().equalsIgnoreCase("기본능력치")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).setdefaultAttributable(args[2], stringtodisint(args[3]));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("강화설정")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).settightenAttributable(args[2], stringtodisint(args[3]));
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
