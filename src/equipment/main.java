package equipment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	Map<String, File> file = new HashMap<String, File>();
	Map<String, YamlConfiguration> config = new HashMap<String, YamlConfiguration>();
    static Map<String, String> message = new HashMap<String, String>();
	
	public void messageconfig() {
		File file = this.file.get("message");
		YamlConfiguration config = this.config.get("message");
		if(config.getString("���ξ�") != null) {
			config.set("���ξ�", "&f[ &a��� &f] ");
		}
		if(config.getString("����з�") != null) {
			config.set("����з�", "&f----------����----------");
		}
		if(config.getString("���з�") != null) {
			config.set("���з�", "&f----------���----------");
		}
		if(config.getString("��ű��з�") != null) {
			config.set("��ű��з�", "&f---------��ű�---------");
		}
		if(config.getString("�з�") != null) {
			config.set("�з�", "&f----------------------");
		}
		if(config.getString("���ݷ�") != null) {
			config.set("���ݷ�", "&f���ݷ� : <value>");
		}
		if(config.getString("ü��") != null) {
			config.set("ü��", "&fü�� : <value>");
		}
		if(config.getString("ȸ��Ȯ��") != null) {
			config.set("ȸ��Ȯ��", "&fȸ��Ȯ�� : <value>");
		}
		if(config.getString("�̵��ӵ�") != null) {
			config.set("�̵��ӵ�", "&f�̵��ӵ� : <value>");
		}
		if(config.getString("����") != null) {
			config.set("����", "&f���� : <value>");
		}
		if(config.getString("���ݷ�") != null) {
			config.set("���ݷ�", "&f���ݷ� : <value>");
		}
		if(config.getString("�Ϲݵ��") != null) {
			config.set("�Ϲݵ��", "&f�Ϲ�");
		}
		if(config.getString("��͵��") != null) {
			config.set("��͵��", "&a���");
		}
		if(config.getString("������") != null) {
			config.set("������", "&9����");
		}
		if(config.getString("���ȵ��") != null) {
			config.set("���ȵ��", "&5����");
		}
		if(config.getString("��������") != null) {
			config.set("��������", "&6������");
		}
		if(config.getString("��ȭȽ��") != null) {
			config.set("��ȭȽ��", "&f��ȭȽ�� : <Value>/<MaxValue>");
		}
		if(config.getString("��ɾ����") != null) {
			config.set("��ɾ����", "������ɾ���? �߸𸣰ھ��!");
		}
		if(config.getString("������") != null) {
			config.set("������", "����... �������̿���!");
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
		return main.message.get(string).replace("&", "��");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
		    if(command.getName().equalsIgnoreCase("���")) {
		    	p.sendMessage(getString("���ξ�") + getString("������"));
		    }else if(command.getName().equalsIgnoreCase("���ȭ")) {
		    	p.sendMessage(getString("���ξ�") + getString("������"));
		    }else if(command.getName().equalsIgnoreCase("�����")) {
		    	if(args.length == 0) {
		    		
		    	}
		    }else {
		    	p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    }
		}else {
			System.out.println("�÷��̾ �Է��� �� �ִ� ��ɾ��Դϴ�.");
		}
		return super.onCommand(sender, command, label, args);
	}

}
