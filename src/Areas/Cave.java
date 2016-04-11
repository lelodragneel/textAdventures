package Areas;

import java.util.Scanner;
import java.util.ArrayList;

import General.Room;
import Enemies.Boss;
import Enemies.Minion;
import General.Item;
import General.Core;
import General.Character;

public class Cave extends Area {
	
	//instance variables
   /*
	private String areaName = "Cave";
	private Room[][] rooms;
	private Core core;
	private Scanner keyboard;
   private General.Character player;
   */
   private Core core;

	public Cave(Core core) {
      this.core = core;
		rooms[0][0] = new Room(null, null, null, false);
		rooms[0][1] = new Room(null, null, null, false);
		rooms[0][2] = new Room(null, null, null, true);
		rooms[1][0] = new Room(null, null, null, false);
		rooms[1][1] = new Room(new Boss(1, 1, "Bossy guy"), null, null, false);
		rooms[1][2] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Wizard] Robe"), false);
		rooms[2][0] = new Room(null, null, null, true);
		rooms[2][1] = new Room(null, new Minion(1, 1, "Troll"), new Item(1, 1, "[Thief] Cape"), false);
		rooms[2][2] = new Room(null, null, null, true);
		keyboard = new Scanner(System.in);
	}
	
	//The rooms ******************************************************
   //room1 to begin, its an empty room
	public void room1()
	{
		System.out.println("You enter the Cave and find an empty room. The room has two doorways, one " +
		"directly across from where you entered and one off to the right. Somehwere further into the cave " +
		"you hear a menacing voice \"YOU DARE ENTER MY LAIR? TURN BACK NOW OR FACE CERTAIN DEATH!\"");
      //Loop to wait for correct decision to be made by user
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Forward = \"f\", Right = \"r\"");
		   String move = keyboard.next();
		   if(move.equals("r"))
		   	room5();
	   	else if(move.equals("f"))
   			room2();
         else
            System.out.println("Incorrect input, try again");
      }
	}
   //room2 is empty
	public void room2()
	{
		System.out.println("You run into another empty room. There are another 2 doorways to choose from. There is a doorway straight ahead " +
		" and another off to the right. A loud voice comes from the doorway on the right, \"Come this way traveller. FACE ME IF YOUR DARE!\"");
		
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Forward = \"f\", Right = \"r\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("r"))
			room9();
		else if(move.equals("f"))
			room3();
		else if(move.equals("b"))
			room1();
      else
         System.out.println("Incorrect input, try again");
      }
	}
   //room 3 with potion
	public void room3()
	{
		//potion
      if(rooms[0][2].getPotion())
      {
         System.out.println("You spot a potion in the corner and pick it up.");
		   core.getPlayer().findPotion();
         rooms[0][2].setPotion(false);
      }
      
		System.out.println("There is a doorway on the right giving off a foul stench.");
		
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Right = \"r\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("r"))
			room4();
		else if(move.equals("b"))
			room2();
      else
         System.out.println("Incorrect input, try again");
      }
	}
   //room4 with minion fight and item drop
	public void room4()
	{
		//fight
      if(rooms[1][2].getMinion().isAlive())
		{
			System.out.println("You walk into the room and a troll appears out of the darkness. He challenges you and carnage ensues!");
			core.fightEnemy(rooms[1][2].getMinion());
         core.getPlayer().getInventory().add(rooms[1][2].getItem());
		}
		
      System.out.println("There is a doorway on the right from which you hear a voice \"Come adventurer, don't be scared.\"");
		
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Right = \"r\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("r"))
			room9();
		else if(move.equals("b"))
			room3();
      else
         System.out.println("Incorrect input, try again");
      }
	}
   //room5 is empty
	public void room5()
	{
		System.out.println("The doorway leads to another empty room with a doorway to the left and straight ahead. From the left a voice taunts " +
		"\"Don't be rude, AHAHA! Come, allow me to introduce myself!\"");
      
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Forward = \"f\", Left = \"l\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("l"))
			room9();
      else if(move.equals("f"))
         room6();
		else if(move.equals("b"))
			room1();
      else
         System.out.println("Incorrect input, try again");
      }
	}
   //room6 has potion, otherwise empty
	public void room6()
	{
		//potion
      if(rooms[2][0].getPotion())
      {
         System.out.println("You find a potion wedged into a crack in the wall.");
		   core.getPlayer().findPotion();
         rooms[2][0].setPotion(false);
      }
       
		System.out.println("There is a doorway to the left. Other than left, back is the only option.");
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Left = \"l\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("l"))
			room7();
		else if(move.equals("b"))
			room5();
      else
         System.out.println("Incorrect input, try again");
      }
	}
   //A minion is here holding an item
	public void room7()
	{
		//fight
      if(rooms[2][1].getMinion().isAlive())
		{
		   System.out.println("A troll wakes up from its slumber as you walk through the doorway. It prepares itself to charge!");
		   core.fightEnemy(rooms[1][2].getMinion());
         core.getPlayer().getInventory().add(rooms[2][1].getItem());
		}
		
      System.out.println("From the left you hear a voice scream as you defeat the troll \"HOW DARE YOU KILL MY BRETHEREN. COME HERE SO I MAY TAKE REVENGE!\"" +
		"There is also a hole straight ahead that appears to lead to another open area.");
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Forward = \"f\", Left = \"l\", Back = \"b\"");
		   String move = keyboard.next();
		if(move.equals("l"))
			room9();
      else if(move.equals("f"))
         room8();
		else if(move.equals("b"))
			room6();
      else
         System.out.println("Incorrect input, try again");
      }
	}
	public void room8()
	{
		//potion
      if(rooms[2][2].getPotion())
      {
         System.out.println("You see a skeleton of a body sitting in the far corner. It holds a note and beside it lays a potion." +
		   " The note reads \"There is no way out. Here is where I stay for fear that the troll kill will eat me alive...\"");
		   core.getPlayer().findPotion();
         rooms[2][2].setPotion(false);
      }
      
		System.out.println("The only way to go is back.");
      boolean awaitingDecision = true;
      while(awaitingDecision)
      {
         System.out.println("Which doorway will you choose? Back = \"b\"");
		   String move = keyboard.next();
		   if(move.equals("b"))
			   room7();
         else
            System.out.println("Incorrect input, try again");
      }
	}
	public void room9()
	{
		System.out.println("As you enter the room a massive troll appears waiting for you to arrive.");
		System.out.println("\"At last you have come! Now come here so I can make soup out of you! Just as I did with that weak little village!\"");
		core.fightEnemy(rooms[1][1].getBoss());
		rooms[1][1].getBoss().setAlive(false);
		System.out.println("After killing the troll you feel somehow stronger. You leave the cave in search of the other horrible monsters.");
	}
	
	//Get room to allow game engine to access minions and potions
	public Room getRoom(int r, int c)
	{
		return rooms[r][c];
	}
}
