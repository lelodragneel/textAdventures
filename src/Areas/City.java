package Areas;

import General.Room;

import java.util.Scanner;

import Enemies.Boss;
import Enemies.Minion;
import General.Item;
import General.Core;

//The city-themed level of our text-based adventure.
public class City extends Area {
	
	/*
	 * constructor
	 */
	public City(Core core) {
		
		//use getPlayer method to get the player
		keyboard = new Scanner(System.in);
		this.core = core;
		rooms = new Room[3][3];
		//rooms and their contents are outlined
		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, new Minion(100, 2, "Trash Creature"), null, false);
		rooms[0][2] = new Room(null, new Minion(135, 2, "Sneaky Trash Creature"), new Item(0, 30, "[Shield] +30 Health"), false);
		rooms[1][0] = new Room(null, new Minion(90, 5, "Trash Creature"), new Item(10, 0, "[Ring] +10 Attack"), false);
		rooms[1][1] = new Room(new Boss(300, 2, "Sewage Beast"), null, null, false);
		rooms[1][2] = new Room(null, null, null, false);
		rooms[2][0] = new Room(null, null, null, false);
		rooms[2][1] = new Room(null, null, null, true);
		rooms[2][2] = new Room(null, null, null, true);
		
	}
	/*
	 * Room #1
	 * Empty
	 */
	public void room1()
	{

		String direction;
		//boolean keeps direction choosing loop going as long as incorrect inputs are entered
		boolean directionFound=false;
		System.out.println("\nLooking FORWARD, the city's wide main street stretches out before you, bathed in shadow from the looming buildings on either side."
				+ "\nTo your RIGHT, a narrower street winds off through a collection of smaller buildings. Lights can be seen in the distance."
				+ "\nChoose your path, or type \"info\" to display game information. "
				+ "\n    (r) right"
				+ "\n    (f) forward");
		//User enters their choice of direction
		direction = keyboard.next();
		while(!directionFound){
			if(direction.equals("f")){
				//to shield path
				room2();
			}
			else if(direction.equals("r")){
				//to old woman path
				room5();
			}
			//If requested, game information is displayed
			else if(direction.equals("info")){
				core.displayInfo();
				//User must input a new choice
				direction=keyboard.next();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, or r for right.");
				direction=keyboard.next();
			}
		}
		
	}

	/*
	 * Room #2
	 * Contains minion
	 */
	public void room2()
	{
		
		String direction;
		boolean directionFound = false;
		System.out.println("You proceed straight ahead. The buildings seem taller from this angle, but also a lot more... run down?");
		System.out.println("Something seems to have driven the city's inhabitants away.");
		
		//Determine whether the user needs to face a minion
		if(rooms[0][1].getMinion().isAlive()) {
			System.out.println("As you stare thoughtfully upward, something grabs you from behind!");
			core.fightEnemy(rooms[0][1].getMinion());
		}
		System.out.println("Wait... what's that straight ahead?"
				+ "\nTo your right, a loud voice rings out: \"HOW DARE YOU ENTER MY CITY? FACE ME, SO THAT I MAY DEFEAT YOU ONCE AND FOR ALL.\""
				+ "\n\nWill you investigate what lies ahead, or accept the challenge?\nType \"info\" to display game information."
				+ "\n    (f) forward "
				+ "\n    (r) right"
				+ "\n    (b) crossroads");
		
		direction = keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				//to shield 
				room3();
			}
			else if(direction.equals("r")){
				//to boss
				room9();
			}
			else if(direction.equals("b")){
				directionFound=true;
				room1();
			}
			else if(direction.equals("info")){
				core.displayInfo();
				direction=keyboard.next();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, r for right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #3
	 * Contains minion
	 * Drops [Shield] +30 Health
	 */
	public void room3()
	{
		
		String direction;
		boolean directionFound=false;
		System.out.println("The street ahead of you is littered with debris. ");

		if (rooms[0][2].getMinion().isAlive()) {
			System.out.println("Before you can even investigate what you've found, another creature leaps out from the shadows.");
			// true if you kill enemy, false if you flee
			if (core.fightEnemy(rooms[0][2].getMinion())) {
				System.out.println("The shiny thing that caught your eye seems to be buried in the mess. Gingerly, you reach into one of the piles.");
				core.getPlayer().addToInventory(rooms[0][2].getItem());
			}
		}
		
		System.out.println("\nThe path veers off to the right. The only other way to go is backward. "
				+ "\nWhat will you do? \nType \"info\" to display game information."
				+ "\n    (r) right "
				+ "\n    (b) back.");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("r")){
				//Empty room
				room4();
			}
			else if(direction.equals("b")){
				room2();
			}
			else if(direction.equals("info")){
				core.displayInfo();
				direction=keyboard.next();
			}
			else {
				System.out.println("Command not recognized. Type r to go right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #4
	 * Empty
	 */
	public void room4()
	{
		
		String direction;
		boolean directionFound=false;
		System.out.println("Concrete buildings block your path in every direction but one."
				+ "The voice speaks again. \"Come adventurer, don't be scared.\""
				+ "\nSteeling yourself, you make a decision. Will you move to the right and face the boss? Or will you go backward?"
				+ "\nMake a choice. \nType \"info\" to display game information."
				+ "\n    (r) right"
				+ "\n    (b) back");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("r")){
				//to boss
				room9();
			}
			else if(direction.equals("b")){
				room3();
			}
			else if(direction.equals("info")){
				core.displayInfo();
				direction=keyboard.next();
			}
			else{
				System.out.println("Command not recognized. Type r to go right, or b to turn back.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #5
	 * Contains minion
	 * Drops [Ring] +10 Attack
	 */
	public void room5()
	{
		
		String direction;
		boolean directionFound=false;
		System.out.println("This path is darker and narrower!\nAs you approach the cluster of ramshackle houses, the smell of woodsmoke and something cooking grows stronger. ");
		System.out.println("A few of the houses' windows are lit, and you feel many eyes upon you."); 
		System.out.println("You back into the shadows to assess your situation.");
		//Check to see whether the user will have to face a minion
		if(rooms[1][0].getMinion().isAlive())
		{
			System.out.println("Unfortunately, you are not alone.\n");		
			// true if you kill enemy, false if you flee
			if(core.fightEnemy(rooms[1][0].getMinion()))
				core.getPlayer().addToInventory(rooms[1][0].getItem());
		}

		System.out.println("\nThe road extends in two directions. From the left, a voice taunts: \"Come here! Allow me to introduce myself!\""
				+ "\nYou may also go forward or turn back to the crossroads, if you choose."
				+ "\nMake your choice. \nType \"info\" to display game information."
				+ "\n    (l) left"
				+ "\n    (f) forward"
				+ "\n    (b) back");
		direction=keyboard.next();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				//to room with opening door
				room6();
			}
			else if(direction.equals("l")){
				directionFound=true;
				//to boss room
				room9();
			}
			else if(direction.equals("b")){
				directionFound=true;
				//to crossroads
				room1();
			}
			else if(direction.equals("info")){
				core.displayInfo();
				direction=keyboard.next();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, l for left, or b to go back.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #6
	 * Empty
	 */
	public void room6()
	{
		String direction;
		boolean directionFound=false;
		System.out.println("You hear a creak, and see a door to the left starting to open.");
		System.out.println("An elderly-looking woman calls out to you. \"You look tired dear, come in for a moment and rest.\""
				+ "\nWill you trust her?"
				+ "\n    (y) yes "
				+ "\n    (n) no");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("y")){
				System.out.println("Despite what your mother told you about stranger danger, you accept.");
				//to old woman's house
				room7();
			}
			else if(direction.equals("n")){
				//back
				room5();
			}
			else{
				System.out.println("Command not recognized. Type y for yes or n for no.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #7
	 * Contains health potion
	 */
	public void room7()
	{
		String direction;
		
		boolean directionFound=false;
		//If it is the user's first time in the room, a potion is given
		if(rooms[2][1].getPotion()){
			System.out.println("Her house is small, but comfortable. \nOnce you are settled with a bowl of stew and a blanket, she tells you about the \"Creature\" that has been terrorizing the city's citizens."
					+ "\nShe also hands you a homemade POTION. How thoughtful.");
			core.getPlayer().findPotion();
			rooms[2][1].setPotion(false);
			System.out.println("Sounds like the monster you've been looking for. You thank the woman and walk back out into the night.");
		}
		//User is directed to the boss regardless of whether a potion is given
		System.out.println("The old woman has directed you to the path on the left." +
		"There is, however, also a fence straight ahead that you could probably jump over, if you wanted to."
		+ "\nWhat will you do? \nType \"info\" to display game information."
		+ "\n    (l) left "
		+ "\n    (f) forward");
		direction=keyboard.nextLine();
		while(!directionFound){
			if(direction.equals("f")){
				directionFound=true;
				//To dead end puzzle room
				room8();
			}
			else if(direction.equals("l")){
				directionFound=true;
				//to boss
				room9();
			}
			else if(direction.equals("info")){
				core.displayInfo();
				direction=keyboard.next();
			}
			else{
				System.out.println("Command not recognized. Type f for forward, or l for left.");
				direction=keyboard.nextLine();
			}
		}
	}
	
	/*
	 * Room #8
	 * Contains health potion
	 */
	public void room8()
	{
		//boolean indicates whether or not the user has solved the escape puzzle
		boolean solved = false;
		System.out.println("In one mighty and very heroic leap, you hop the fence and land majestically in the sad-looking field. ");
		System.out.println("You keep walking forward, and... oh. It's a cliff. There's nothing here.");
		System.out.println("You turn to go back and notice that the fence seems a lot higher somehow. Jumping doesn't look like it will do the trick!\n");
		System.out.println("You look around for something that might help you escape.");
		//Potion given
		if(rooms[2][2].getPotion()){
			System.out.println("You find a POTION in the grass, but admittedly, there isn't much else.");
			core.getPlayer().findPotion();
			rooms[2][2].setPotion(false);
		}
		while(!solved){
			solved=fencePuzzle();
		}
		System.out.println("The only way to go is back.");
		room7();
	}
	
	/*
	 * Room #9
	 * Contains boss
	 */
	public void room9()
	{
		if(rooms[1][1].getBoss().isAlive()){
			System.out.println("\nAs you enter the plaza, what initially appeared to be a huge pile of debris starts to quake.");
			System.out.println("It's a giant Sewage Beast. \"AH, WELCOME PESKY TRAVELLER!\" it roars."
					+ "\n\"You have proven yourself to be most irksome in coming here. Once I defeat you, I will truly make this city great again!\""
					+ "\n\nYou prepare yourself for battle.");
			// true if you kill enemy, false if you flee
			if(core.fightEnemy(rooms[1][1].getBoss())){
				System.out.println("After killing the Sewage Beast you feel somehow stronger. You leave the city in search of the other horrible monsters.\n");
				core.chooseArea();			
			}
		} else {
			System.out.println("You enter the plaza to find the creature already dead. Nice.");
			core.chooseArea();
		}
	}
	
	/*
	 * puzzle for room 8
	 */
	public boolean fencePuzzle(){
		
		String direction,choice="*";
		boolean solved=false;
		System.out.println("Your search yields three items: a worn leather SATCHEL, a cracked wooden BUCKET, and a dashing feathered HAT.");
		System.out.println("You decide to try one. "
				+ "\n    (s) satchel"
				+ "\n    (b) bucket"
				+ "\n    (h) hat");
		direction=keyboard.nextLine();
		while(!direction.equals("s")&&!direction.equals("b")&&!direction.equals("h")){
			System.out.println("Command not recognized. Type s, b, or h.");
			direction=keyboard.nextLine();
		}
		//Satchel
		if(direction.equals("s")){
			System.out.println("You open the satchel and look inside. It contains three small potions and a note.");
			System.out.println("You read the note:\n");
			System.out.println("I see that you have crossed my fence.\nI tell you now without pretense;\nThe potions you have chanced to find\nWill let you leave this field behind.");
			System.out.println("One will let you pass right through;\nOne is useless (harmless too);\nand one's a simple sleeping brew.\n");
			System.out.println("One of three will do the trick,\nAll you have to do is pick,\nIf you are wrong, then try anew.\nSo take a chance- it's up to you.");
			System.out.println("\nYou choose a potion. "
					+ "\n    (r) red potion"
					+ "\n    (g) green potion"
					+ "\n    (p) purple potion");
			choice=keyboard.nextLine();
			while(!choice.equals("r")&&!choice.equals("g")&&!choice.equals("p")){
				System.out.println("Command not recognized. Type r, g, or p.");
				direction=keyboard.nextLine();
			}
			if(choice.equals("r")){
				System.out.println("You drink the RED potion and feel okay... maybe this is the right one.");
				System.out.println("You run at the fence, hoping for the best, and crash right into it. It's as solid as ever. Whoops.\n");
			}
			if(choice.equals("g")){
				System.out.println("You drink the GREEN potion...and fall asleep immediately.\nYou wake up four hours later, a little disoriented and still just as trapped.\n");
			}
			if(choice.equals("p")){
				System.out.println("You drink the PURPLE potion and feel a little dizzy. Gingerly, you step forward and pass through the fence.\n");
				solved=true;
			}
			
		}
		//Bucket
		if(direction.equals("b"))
			System.out.println("You drag the BUCKET over to the fence and try to stand on it. The fence is still too tall to jump over.\n");
		//Hat
		if(direction.equals("h"))
			System.out.println("You put the HAT on your head. Nothing happens.\nYou do look awfully nice though.\n");
		return solved;
	}
	
	//Get room to allow game engine to access minions and potions
	public Room getRoom(int r, int c)
	{
		return rooms[r][c];
	}
	
	// return the (number of minion kills / total minions)
	public String getMinionKills() {
		int kills = 0;
		if (!rooms[0][1].getMinion().isAlive())
			kills++;
		if (!rooms[0][2].getMinion().isAlive())
			kills++;
		if (!rooms[1][0].getMinion().isAlive())
			kills++;
		return kills + "/3";
	}
	
}
