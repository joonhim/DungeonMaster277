import java.util.ArrayList; 
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ItemGenerator
{
	private ArrayList<Item> itemList;

	//Constructor
	public ItemGenerator()
	{
		Scanner read = null;
		itemList = new ArrayList<Item>();
	   try {
			read = new Scanner(new File("itemList.txt"));
			while(read.hasNext()) {
				String line = read.nextLine();

				Item item = new Item(line);
				itemList.add(item);
			}
			read.close();
	   }catch(FileNotFoundException e){
	     System.out.println("File Not Found - place file in the project folder. ");
	   }
	}

	public Item generateItem()
	{
		//Return a random Item
		
		Random rand = new Random(); 
        return itemList.get(rand.nextInt(itemList.size())); 
	}
}