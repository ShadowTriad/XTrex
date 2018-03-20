/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

//class Keycap is used to store the information about the buttons on a keyboard
public class Keycap
{	
	private String name;
	private int x;
	private int y;
	
	//sets up the class so the information about the buttons on a keyboard can be stored
	public Keycap (String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//returns the name of the button on a keyboard
	public String getName ()
	{			
		return name;
	}
	
	//returns the x coordinate of the button on a keyboard
	public int getX ()
	{			
		return x;
	}
	
	//returns the y coordinate of the button on a keyboard
	public int getY ()
	{			
		return y;
	}
}