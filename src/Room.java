

public class Room {
	
	/*
	 * initialize variables
	 */
	private Boss boss;
	private Item item;
	
	/*
	 * constructor
	 * the type could be:
	 * 		empty = nothing in the room
	 * 		boss = the room has the final boss which drops the key
	 * 		minion = the room has a minion you can fight for potential loot
	 */
	public Room(Boss boss, Item item) {
		
		this.setBoss(boss);
		this.setItem(item);
		
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
