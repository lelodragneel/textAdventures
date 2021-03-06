package Areas;

import java.util.Scanner;

import General.Core;
import General.Room;

//Area class acts as a template for Cave and City areas
public abstract class Area {

	/*
	 * initialize variables
	 */
	protected String areaName;
	protected Room[][] rooms;
	protected Scanner keyboard;
	protected Core core;

	public Area() {

	}

	//There are 9 rooms in the areas
	public abstract void room1();
	public abstract void room2();
	public abstract void room3();
	public abstract void room4();
	public abstract void room5();
	public abstract void room6();
	public abstract void room7();
	public abstract void room8();
	public abstract void room9();

	//Areas must have getRoom(int, int) method so Core can access Rooms
	public abstract Room getRoom(int r, int c);
	
	public abstract String getMinionKills();
}