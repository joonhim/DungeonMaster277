public abstract class Entity
{
	protected String name;//Protected?
	protected int maxHp;
	protected int hp;

	public Entity(String n, int mHp)
	{
		name = n;
		maxHp = mHp;
		hp = mHp;
	}

	public abstract String attack(Entity e);

	public String getName()
	{
		return name;
	}

	public int getHP()
	{
		return hp;
	}

	public int getMaxHP()
	{
		return maxHp;
	}

	public void heal(int h)
	{
		//Adds hp up to maximum of the max hp
		int newHp = hp + h;
		if (newHp < maxHp)
		{
			hp = newHp;
		}
		else
		{
			hp = maxHp;
		}
	}

	public void takeDamage(int h)
	{
		//Removes hp down to a minimum of 0
		int newHp = hp - h;
		if (newHp < 0)
		{
			hp = 0;
		}
		else
		{
			hp = newHp;
		}
	}

	public String toString()
	{
		return name + "\nHP: " + hp + "/" + maxHp;
	}
}