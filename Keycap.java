/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

//class Keycap is used to store information about buttons

public class Keycap
{
	//stores the name of the button
	
	private String name;
	
	//stores the x coordinate of the button
	
	private int x;
	
	//stores the y coordinate of the button
	
	private int y;
	
	//constructor stores the name, x coordinate and x coordinate of a button
	
	public Keycap (String name, int x, int y)
	{
		this.name = name;
		
		this.x = x;
		
		this.y = y;
	}
	
	//returns the name of the button
	
	public String getName ()
	{			
		return name;
	}
	
	//returns the x coordinate of the button
	
	public int getX ()
	{			
		return x;
	}
	
	//returns the y coordinate of the button
	
	public int getY ()
	{			
		return y;
	}
}