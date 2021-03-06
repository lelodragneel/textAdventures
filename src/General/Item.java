package General;


public class Item {
	
	/*
	 * initialize variables
	 */
	private int damageIncrease;
	private int healthIncrease;
	private String itemName;
	
	public Item(int damageIncrease, int healthIncrease, String itemName) {
		
		this.damageIncrease = damageIncrease;
		this.healthIncrease = healthIncrease;
		this.itemName = itemName;
		
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getDamageIncrease() {
		return damageIncrease;
	}

	public void setDamageIncrease(int damageIncrease) {
		this.damageIncrease = damageIncrease;
	}

	public int getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
	
}
