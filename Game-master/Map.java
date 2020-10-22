import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map
{
	private char[][] map;
	private boolean[][] revealed;

	public Map()
	{
		map = new char[5][5];
		revealed = new boolean[5][5];
	}

	public void loadMap(int mapNum)
	{
		mapNum++;
    	for (int i = 0; i < revealed.length; i++)
		{
			for (int j = 0; j < revealed[0].length; j++)
			{
				revealed[i][j] = false;
			}
		}

		try {
    	  	File myObj = new File("Map" + mapNum + ".txt");
    	  	Scanner myReader = new Scanner(myObj);
    	  	int row = 0;
    	  	while (myReader.hasNextLine()) {
    	  	  	String data = myReader.nextLine();
    	  	  	String[] tokens = data.split(" ");
 
 				char ch;
				for (int i = 0; i < tokens.length; i++)
				{
					ch = tokens[i].charAt(0);
					map[row][i] = ch;
				}
    	  	  	row++;
    	  	}
    	  	myReader.close();
    		} catch (FileNotFoundException e) {
    		  	e.printStackTrace();
    	}
	}

	public char getCharAtLoc(Point p)
	{
		return map[p.getX()][p.getY()];
	}

	public void displayMap(Point p)
	{
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[0].length; j++)
			{
				if (revealed[i][j])
				{
          			if (i == p.getX() && j == p.getY())
          			{
          			  System.out.print("* ");
          			}
          			else
          			{
          			  System.out.print(map[i][j] + " ");
          			}
				}
        		else
        		{
        		  System.out.print("x ");
        		}
			}
			System.out.println();
		}
	}

	public Point findStart()
	{
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[0].length; j++)
			{
				if (map[i][j] == 's')
				{
					return new Point(i, j); 
				}
			}
		}
		return new Point();
	}

	public void reveal(Point p)
	{
		revealed[p.getX()][p.getY()] = true;
	}

	public void removeCharAtLoc(Point p)
	{
		map[p.getX()][p.getY()] = 'n';
	}
}