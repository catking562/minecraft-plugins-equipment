package equipment;

import org.bukkit.inventory.ItemStack;

public class playerequipment {
	
	private ItemStack weapon;
	private ItemStack head;
	private ItemStack body;
	private ItemStack leg;
	private ItemStack foot;
	private ItemStack accessory1;
	private ItemStack accessory2;
	private ItemStack accessory3;
	
	public playerequipment() {
		
	}
	
	public boolean hasweapon() {
		return weapon != null;
	}
	
	public boolean hashead() {
		return head != null;
	}
	
	public boolean hasbody() {
		return body != null;
	}
	
	public boolean hasleg() {
		return leg != null;
	}
	
	public boolean hasfoot() {
		return foot != null;
	}
	
	public boolean hasaccessory1() {
		return accessory1 != null;
	}
	
	public boolean hasaccessory2() {
		return accessory2 != null;
	}
	
	public boolean hasaccessory3() {
		return accessory3 != null;
	}
	
	public ItemStack getweapon() {
		return weapon;
	}
	
	public ItemStack gethead() {
		return head;
	}
	
	public ItemStack getbody() {
		return body;
	}
	
	public ItemStack getleg() {
		return leg;
	}
	
	public ItemStack getfoot() {
		return foot;
	}
	
	public ItemStack getaccessory1() {
		return accessory1;
	}
	
	public ItemStack getaccessory2() {
		return accessory2;
	}
	
	public ItemStack getaccessory3() {
		return accessory3;
	}
	
	public void setweapon(ItemStack i) {
		this.weapon = i;
	}
	
	public void sethead(ItemStack i) {
		this.head = i;
	}
	
	public void setbody(ItemStack i) {
		this.body = i;
	}
	
	public void setleg(ItemStack i) {
		this.leg = i;
	}
	
	public void setfoot(ItemStack i) {
		this.foot = i;
	}
	
	public void setaccessory1(ItemStack i) {
		this.accessory1 = i;
	}
	
	public void setaccessory2(ItemStack i) {
		this.accessory2 = i;
	}
	
	public void setaccessory3(ItemStack i) {
		this.accessory3 = i;
	}

}
