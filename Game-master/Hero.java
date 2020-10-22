import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Hero extends Entity implements Magical
{
	private ArrayList<Item> items;
	private Map map;
	private Point location;

	public Hero(String n, Map m)
	{
		super(n, 25);
		map = m;
		items = new ArrayList<Item>();
		location = new Point(map.findStart().getX(), map.findStart().getY());
	}

	public String itemsToString()
	{
		String itemString = "";
		Item item;
		itemString += "Inventory:";
		for(int i = 0; i < getNumItems(); i++)
		{
			item = items.get(i);
			itemString += "\n";
			itemString += (i+1) + ". " + item.getName();
		}
		return itemString;
	}

	public int getNumItems()
	{
		return items.size();
	}

	public boolean pickUpItem(Item i)
	{
		if (getNumItems() < 5)
		{
			items.add(i);
			return true;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Your inventory is too full for a " + i.getName() + ".");
		System.out.println("1. Leave " + i.getName());
		System.out.println("2. Replace an item in your inventory with " + i.getName());
		int inventoryChoice;
		do{
			inventoryChoice = scanner.nextInt();
		}
		while(inventoryChoice < 1 || inventoryChoice > 2);
		if (inventoryChoice == 2)
		{
			System.out.println("Choose the item to replace");
			for (int index = 1; index <= 5; index++)
			{
				System.out.println(index + ". " + items.get(index-1).getName());
			}
			int itemToReplace = scanner.nextInt();
			System.out.println(items.get(itemToReplace-1).getName() + "replaced with " + i.getName());
			items.set(itemToReplace-1, i);
			return true;
		}
		return false;
	}

	public void drinkPotion()
	{
		if (hasPotion())
		{
			//Increase 25 HP
			heal(25);
			/*
			if (hp + 25 > maxHp)
			{
				hp = maxHp;
			}
			else
			{
				hp += 25;
			}
			*/
		}
		//Take Health Potion out of inventory
		boolean dropped = false;
		for (int i = 0; i < getNumItems(); i++)
		{
			if (items.get(i).getName().equals("Health Potion") && !dropped)
			{
				dropItem(i);
				dropped = true;
			}
		}
	}

	public void dropItem(int index)
	{
		items.remove(index);
	}

	public boolean hasPotion()
	{
		for (Item item: items)
		{
			if (item.getName().equals("Health Potion"))
			{
				return true;
			}
		}
		return false;
	}

	public Point getLocation()
	{
		return location;
	}

	public char goEast()
	{
		location.translate(0, 1);
		return map.getCharAtLoc(location);
	}

	public char goWest()
	{
		location.translate(0, -1);
		return map.getCharAtLoc(location);
	}

	public char goSouth()
	{
		location.translate(1, 0);
		return map.getCharAtLoc(location);
	}

	public char goNorth()
	{
		location.translate(-1, 0);
		return map.getCharAtLoc(location);
	}

	public String toString()
	{
		String str = super.toString() + "\n";
		str += itemsToString();
		return str;
	}

	public String attack(Entity e)
	{
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Physical Attack");
		System.out.println("2. Magic Attack");
		int attackChoice;
		do{
			attackChoice = scanner.nextInt();
		}while(attackChoice < 1 || attackChoice > 2);
		String str = "";
		switch(attackChoice)
		{
			case 1:
				int maxDamage = e.getMaxHP() * 2;
				int randomDamage = rand.nextInt(maxDamage);
				randomDamage++;
				e.takeDamage(randomDamage);
				str += name + " attacks " + e.getName() + " for " + randomDamage + " damage.";
				break;
			case 2:
				System.out.println(Magical.MAGIC_MENU);
				int magicAttackChoice;//Needs Validation
				do{
					magicAttackChoice = scanner.nextInt();
				}while(magicAttackChoice < 1 || magicAttackChoice > 3);
				switch(magicAttackChoice)
				{
					case 1:
						str += magicMissile(e);
						break;
					case 2:
						str += fireball(e);
						break;
					case 3:
						str += thunderclap(e);
						break;
				}
				break;
		}
		//scanner.close();
		return str;
	}

	public String magicMissile(Entity e)
	{
		String str = "";
		int maxDamage = e.getMaxHP() * 2;
		Random rand = new Random();
		int damageToTake = rand.nextInt(maxDamage);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " hits " + e.getName() + " with a Magic Missile for " + damageToTake + " damage.";
		return str;
	}

  	public String fireball(Entity e)
  	{
  		String str = "";
		int maxDamage = e.getMaxHP() * 2;
		Random rand = new Random();
		int damageToTake = rand.nextInt(maxDamage);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " hits " + e.getName() + " with a Fireball for " + damageToTake + " damage.";
		return str;
  	}

  	public String thunderclap(Entity e)
  	{
  		String str = "";
		int maxDamage = e.getMaxHP() * 2;
		Random rand = new Random();
		int damageToTake = rand.nextInt(maxDamage);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " zaps " + e.getName() + " with a Thunderclap for " + damageToTake + " damage.";
		return str;
  	}
}