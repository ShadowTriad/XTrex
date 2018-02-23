/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

//class Keycap is used to store the information about a button on a keypad

public class Keycap
{
	//stores the name of a button on a keypad
	
	private String name;
	
	//stores the x coordinate of a button on a keypad
	
	private int x;
	
	//stores the y coordinate of a button on a keypad
	
	private int y;
	
	//constructor stores the name, x coordinate and x coordinate of a button on a keypad
	
	public Keycap (String name, int x, int y)
	{
		this.name = name;
		
		this.x = x;
		
		this.y = y;
	}
	
	//returns the name of a button on a keypad
	
	public String getName ()
	{			
		return name;
	}
	
	//returns the x coordinate of a button on a keypad
	
	public int getX ()
	{			
		return x;
	}
	
	//returns the y coordinate of a button on a keypad
	
	public int getY ()
	{			
		return y;
	}
}