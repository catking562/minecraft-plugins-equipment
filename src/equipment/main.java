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
		if(config.getString("���ξ�") == null) {
			config.set("���ξ�", "&f[ &a��� &f] ");
		}
		if(config.getString("����з�") == null) {
			config.set("����з�", "&f----------����----------");
		}
		if(config.getString("���з�") == null) {
			config.set("���з�", "&f----------���----------");
		}
		if(config.getString("��ű��з�") == null) {
			config.set("��ű��з�", "&f---------��ű�---------");
		}
		if(config.getString("�з�") == null) {
			config.set("�з�", "&f----------------------");
		}
		if(config.getString("�Ϲݵ��") == null) {
			config.set("�Ϲݵ��", "&f�Ϲ�");
		}
		if(config.getString("��͵��") == null) {
			config.set("��͵��", "&a���");
		}
		if(config.getString("������") == null) {
			config.set("������", "&9����");
		}
		if(config.getString("���ȵ��") == null) {
			config.set("���ȵ��", "&5����");
		}
		if(config.getString("��������") == null) {
			config.set("��������", "&6������");
		}
		if(config.getString("��ȭȽ��") == null) {
			config.set("��ȭȽ��", "&f��ȭȽ�� : <Value>/<MaxValue>");
		}
		if(config.getString("��ɾ����") == null) {
			config.set("��ɾ����", "������ɾ���? �߸𸣰ھ��!");
		}
		if(config.getString("������") == null) {
			config.set("������", "����... �������̿���!");
		}
		if(config.getString("�������") == null) {
			config.set("�������", "�������� �ʴ� ����Դϴ�.");
		}
		if(config.getString("�ִ����") == null) {
			config.set("�ִ����", "�̹� �����ϴ� ����Դϴ�.");
		}
		if(config.getString("�����Ϸ�") == null) {
			config.set("�����Ϸ�", "��� �����Ͽ����ϴ�.");
		}
		if(config.getString("�����Ϸ�") == null) {
			config.set("�����Ϸ�", "��� �����Ͽ����ϴ�.");
		}
		if(config.getString("�̸������Ϸ�") == null) {
			config.set("�̸������Ϸ�", "����� �̸��� �����Ͽ����ϴ�.");
		}
		if(config.getString("�������Ϸ�") == null) {
			config.set("�������Ϸ�", "����� ������ �����Ͽ����ϴ�.");
		}
		if(config.getString("�����Է�") == null) {
			config.set("�����Է�", "������ �Է����ּ���.");
		}
		if(config.getString("�����ۼ����Ϸ�") == null) {
			config.set("�����ۼ����Ϸ�", "����� �������� �����Ͽ����ϴ�.");
		}
		if(config.getString("��޼����Ϸ�") == null) {
			config.set("��޼����Ϸ�", "����� ����� �����Ͽ����ϴ�.");
		}
		if(config.getString("0~4") == null) {
			config.set("0~4", "0 ~ 4�� ������ �Է��ϼ���.");
		}
		if(config.getString("�ִ밭ȭȽ�������Ϸ�") == null) {
			config.set("�ִ밭ȭȽ�������Ϸ�", "����� �ִ밭ȭȽ���� �����Ͽ����ϴ�.");
		}
		if(config.getString("0�̻�") == null) {
			config.set("0�̻�", "0�̻��� ������ �Է����ּ���");
		}
		if(config.getString("������") == null) {
			config.set("������", "��� �����Ͽ����ϴ�.");
		}
		if(config.getString("��ɾ����") == null) {
			config.set("��ɾ����", "���� ����� �Է����ּ���.");
		}
		if(config.getString("�⺻�ɷ�ġ�����Ϸ�") == null) {
			config.set("�⺻�ɷ�ġ�����Ϸ�", "�⺻�ɷ�ġ�� �����Ͽ����ϴ�.");
		}
		if(config.getString("��ȭ�����Ϸ�") == null) {
			config.set("��ȭ�����Ϸ�", "��ȭ�ɷ�ġ�� �����Ͽ����ϴ�.");
		}
		if(config.getString("���ݷ�") == null) {
			config.set("���ݷ�", "���ݷ� : <Value>");
		}
		if(config.getString("ũ��Ƽ��Ȯ��") == null) {
			config.set("ũ��Ƽ��Ȯ��", "ũ��Ƽ��Ȯ�� : <Value>");
		}
		if(config.getString("����") == null) {
			config.set("����", "���� : <Value>");
		}
		if(config.getString("ȸ��Ȯ��") == null) {
			config.set("ȸ��Ȯ��", "ȸ��Ȯ�� : <Value>");
		}
		if(config.getString("�̵��ӵ�") == null) {
			config.set("�̵��ӵ�", "�̵��ӵ� : <Value>");
		}
		if(config.getString("ü��") == null) {
			config.set("ü��", "ü�� : <Value>");
		}
		if(config.getString("����") == null) {
			config.set("����", "���� : <Value>");
		}
		if(config.getString("ũ��Ƽ�õ�����") == null) {
			config.set("ũ��Ƽ�õ�����", "ũ��Ƽ�õ����� : <Value>");
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
		return main.message.get(string).replace("&", "��");
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
		    if(command.getName().equalsIgnoreCase("���")) {
		    	p.sendMessage(getString("���ξ�") + getString("������"));
		    }else if(command.getName().equalsIgnoreCase("���ȭ")) {
		    	p.sendMessage(getString("���ξ�") + getString("������"));
		    }else if(command.getName().equalsIgnoreCase("�����")) {
		    	if(args.length == 0) {
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�>  --  ��� Ȯ���մϴ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ����  --  ��� �����մϴ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ����  --  ��� �����մϴ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> �̸� <display>  --  ����� �̸��� �����մϴ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ���� <����>  --  ��� ������ �߰��Ѵ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ������ <�ڵ�>  --  ����� �������� �����Ѵ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��� <���>  --  ����� ����� �����մϴ�");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> �⺻�ɷ�ġ <�ɷ�ġ> <��>  --  ����� �⺻�ɷ�ġ�� �����Ѵ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��ȭ�ִ�Ƚ�� <��>  --  ��� ��ȭ�� �� �ִ� �ִ� Ƚ���� �����Ѵ�.");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��ȭ���� <�ɷ�ġ> <��>  --  ��� ��ȭ�Ҷ����� �ش� �ɷ�ġ�� �󸶾� �������� �����Ѵ�");
		    		p.sendMessage(getString("���ξ�") + "/����� <�̸�> �ޱ� <������>  --  ����� �޴´�");
		    	}else if(args.length == 1) {
		    		if(isequipment(args[0])) {
		    			ItemStack i = getequipment(args[0]).getitemsystem();
		    			ItemMeta m = i.getItemMeta();
		    			p.sendMessage(m.getDisplayName());
		    			for(String string : m.getLore()) {
		    				p.sendMessage(string);
		    			}
		    		}else {
		    			p.sendMessage(getString("���ξ�") + getString("�������"));
		    		}
		    	}else if(args.length == 2) {
		    		if(isequipment(args[0])) {
                        if(args[1].toString().equalsIgnoreCase("����")) {
		    				p.sendMessage(getString("���ξ�") + getString("�ִ����"));
		    			}else if(args[1].toString().equalsIgnoreCase("����")) {
		    				equipmentlist.put(args[1], null);
		    				p.sendMessage(getString("���ξ�") + getString("�����Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("�̸�")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> �̸� <display>  --  ����� �̸��� �����մϴ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("����")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ���� <����>  --  ��� ������ �߰��Ѵ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("������")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ������ <�ڵ�>  --  ����� �������� �����Ѵ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("���")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��� <���>  --  ����� ����� �����մϴ�");
		    			}else if(args[1].toString().equalsIgnoreCase("�⺻�ɷ�ġ")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> �⺻�ɷ�ġ <�ɷ�ġ> <��>  --  ����� �⺻�ɷ�ġ�� �����Ѵ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("��ȭ�ִ�Ƚ��")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��ȭ�ִ�Ƚ�� <��>  --  ��� ��ȭ�� �� �ִ� �ִ� Ƚ���� �����Ѵ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("��ȭ����")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��ȭ���� <�ɷ�ġ> <��>  --  ��� ��ȭ�Ҷ����� �ش� �ɷ�ġ�� �󸶾� �������� �����Ѵ�");
		    			}else if(args[1].toString().equalsIgnoreCase("�ޱ�")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> �ޱ� <������>  --  ����� �޴´�");
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("����")) {
		    				equipment equi = new equipment();
		    				equipmentlist.put(args[1].toString(), equi);
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("�������"));
		    			}
		    		}
		    	}else if(args.length == 3) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("�̸�")) {
		    				equipmentlist.get(args[1].toString()).setname(args[2].toString());
		    				p.sendMessage(getString("���ξ�") + getString("�̸������Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("����")) {
		    				equipmentlist.get(args[1]).setlore(args[2].toString());
		    				p.sendMessage(getString("���ξ�") + getString("�������Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("������")) {
		    				if(isint(args[2])) {
		    					equipmentlist.get(args[1]).setitemmaterial(Material.getMaterial(Integer.parseInt(args[2])));
		    					p.sendMessage(getString("���ξ�") + getString("�����ۼ����Ϸ�"));
		    				}else {
		    					p.sendMessage(getString("���ξ�") + getString("�����Է�"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("���")) {
		    				if(isint(args[2])) {
		    					if(Integer.parseInt(args[2]) >= 0 && Integer.parseInt(args[2]) <= 4) {
		    						p.sendMessage(getString("���ξ�") + getString("��޼����Ϸ�"));
		    					}else {
		    						p.sendMessage(getString("���ξ�") + getString("0~4"));
		    					}
		    				}else {
		    					p.sendMessage(getString("���ξ�") + getString("�����Է�"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("�⺻�ɷ�ġ")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> �⺻�ɷ�ġ <�ɷ�ġ> <��>  --  ����� �⺻�ɷ�ġ�� �����Ѵ�.");
		    			}else if(args[1].toString().equalsIgnoreCase("��ȭ�ִ�Ƚ��")) {
		    				if(isint(args[2])) {
		    					if(Integer.parseInt(args[2]) >= 0) {
		    						equipmentlist.get(args[1]).setmaxtighten(Integer.parseInt(args[2]));
		    						p.sendMessage(getString("���ξ�") + getString("��ȭ�ִ�Ƚ�������Ϸ�"));
		    					}else {
		    						p.sendMessage(getString("���ξ�") + getString("0�̻�"));
		    					}
		    				}else {
		    					p.sendMessage(getString("���ξ�") + getString("�����Է�"));
		    				}
		    			}else if(args[1].toString().equalsIgnoreCase("��ȭ����")) {
		    				p.sendMessage(getString("���ξ�") + "/����� <�̸�> ��ȭ���� <�ɷ�ġ> <��>  --  ��� ��ȭ�Ҷ����� �ش� �ɷ�ġ�� �󸶾� �������� �����Ѵ�");
		    			}else if(args[1].toString().equalsIgnoreCase("�ޱ�")) {
		    				if(args[2].equalsIgnoreCase("�Ϲ�")) {
		    					p.getInventory().addItem(equipmentlist.get(args[1]).getitem());
		    					p.sendMessage(getString("���ξ�") + getString("������"));
		    				}else if(args[2].equalsIgnoreCase("Ǯ�Ϲ�")) {
		    					p.getInventory().addItem(equipmentlist.get(args[1]).getitemfull());
		    					p.sendMessage(getString("���ξ�") + getString("������"));
		    				}else {
		    					p.sendMessage(getString("���ξ�") + "������ = {�Ϲ�, Ǯ�Ϲ�}");
		    				}
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("����")) {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("�������"));
		    			}
		    		}
		    	}else if(args.length == 4) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("�̸�")) {
		    				equipmentlist.get(args[1].toString()).setname(args[2].toString() + " " + args[3].toString());
		    				p.sendMessage(getString("���ξ�") + getString("�̸������Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("����")) {
		    				equipmentlist.get(args[1]).setlore(args[2].toString() + " " + args[3].toString());
		    				p.sendMessage(getString("���ξ�") + getString("�������Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("�⺻�ɷ�ġ")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).setdefaultAttributable(args[2], stringtodisint(args[3]));
		    				}else {
		    					p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    				}
		    				p.sendMessage(getString("���ξ�") + getString("�⺻�ɷ�ġ�����Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("��ȭ����")) {
		    				if(stringtodisint(args[3]) != null) {
		    					equipmentlist.get(args[1]).settightenAttributable(args[2], stringtodisint(args[3]));
		    				}else {
		    					p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    				}
		    				p.sendMessage(getString("���ξ�") + getString("��ȭ�����Ϸ�"));
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("����")) {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("�������"));
		    			}
		    		}
		    	}else if(args.length >= 5) {
		    		if(isequipment(args[0])) {
		    			if(args[1].toString().equalsIgnoreCase("�̸�")) {
		    				String string = "";
		    				for (int i = 2; i < args.length; i++) {
								string = string + args[i] + " ";
							}
		    				equipmentlist.get(args[1].toString()).setname(string);
		    				p.sendMessage(getString("���ξ�") + getString("�̸������Ϸ�"));
		    			}else if(args[1].toString().equalsIgnoreCase("����")) {
		    				String string = "";
		    				for (int i = 2; i < args.length; i++) {
								string = string + args[i] + " ";
							}
		    				equipmentlist.get(args[1]).setlore(string);
		    				p.sendMessage(getString("���ξ�") + getString("�������Ϸ�"));
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}
		    		}else {
                        if(args[1].toString().equalsIgnoreCase("����")) {
		    				p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    			}else {
		    				p.sendMessage(getString("���ξ�") + getString("�������"));
		    			}
		    		}
		    	}
		    }else {
		    	p.sendMessage(getString("���ξ�") + getString("��ɾ����"));
		    }
		}else {
			System.out.println("�÷��̾ �Է��� �� �ִ� ��ɾ��Դϴ�.");
		}
		return super.onCommand(sender, command, label, args);
	}
	
	@EventHandler
	public void autosave(WorldSaveEvent e) {
		save();
	}

}
