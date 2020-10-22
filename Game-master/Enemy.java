import java.util.Random;

public class Enemy extends Entity
{
	private Item item;

	//Constructor
	public Enemy(String n, int mHp, Item i)
	{
		super(n, new Random().nextInt(4) + mHp);
		String itemName = i.getName();
	    item = new Item(itemName);
	}

	public Item getItem()
	{
		return item;
	}

	public String attack(Entity e)
	{
		Random rand = new Random();
		String str = "";
		int maxDamage = 10;
		int randomDamage = rand.nextInt(maxDamage);
		randomDamage++;
		e.takeDamage(randomDamage);
		str += name + " attacks " + e.getName() + " for " + randomDamage + " damage.";
		return str;
	}
}