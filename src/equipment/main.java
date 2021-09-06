package equipment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	Map<String, File> file = new HashMap<String, File>();
	Map<String, YamlConfiguration> config = new HashMap<String, YamlConfiguration>();
    static Map<String, String> message = new HashMap<String, String>();
	
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

}
