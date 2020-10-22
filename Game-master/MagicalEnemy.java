import java.util.Random;

public class MagicalEnemy extends Enemy implements Magical
{
	public MagicalEnemy(String n, int mHp, Item i)
	{
		super(n, mHp, i);
	}

	public String attack(Entity e)
	{
		Random rand = new Random();
		int numChoices = 3;
		numChoices++;
		int attackChoice = rand.nextInt(numChoices);
		String str = "";
		switch(attackChoice)
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
		return str;
	}

	public String magicMissile(Entity e)
	{
		String str = "";
		Random rand = new Random();
		int damageToTake = rand.nextInt(25);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " hits " + e.getName() + " with a Magic Missile for " + damageToTake + " damage.";
		return str;
	}

  	public String fireball(Entity e)
  	{
  		String str = "";
		Random rand = new Random();
		int damageToTake = rand.nextInt(25);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " hits " + e.getName() + " with a Fireball for " + damageToTake + " damage.";
		return str;
  	}

  	public String thunderclap(Entity e)
  	{
  		String str = "";
		Random rand = new Random();
		int damageToTake = rand.nextInt(25);
		damageToTake++;
		e.takeDamage(damageToTake);
		str += name + " zaps " + e.getName() + " with a Thunderclap for " + damageToTake + " damage.";
		return str;
  	}
}