/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

//class Constant is used to store the information about the constants in the XTrex
public class Constant
{
	private String whereTo = "Where To";
	private String alphabeticBackground = "img/backgroundAlphabetic.png";
	private String numericBackground = "img/backgroundNumeric.png";
	private String icon = "img/icon";
	private String rolloverIcon = "img/rollovericon";
	private String iconExtenction = ".png";
	private int whereToWidth = 240;
	private int whereToHeight = 375;
	private int whereToColumn0 = 14;
	private int whereToRow0 = 12;
	private int whereToWidth0 = 208;
	private int whereToHeight0 = 25;
	private int alphabeticColumn1 = 11;
	private int alphabeticColumn2 = 65;
	private int alphabeticColumn3 = 121;
	private int alphabeticColumn4 = 177;
	private int alphabeticRow1 = 52;
	private int alphabeticRow2 = 94;
	private int alphabeticRow3 = 136;
	private int alphabeticRow4 = 177;
	private int alphabeticRow5 = 219;
	private int alphabeticRow6 = 262;
	private int alphabeticRow7 = 303;
	private int alphabeticWidth1 = 52;
	private int alphabeticWidth2 = 54;
	private int alphabeticHeight1 = 40;
	private int alphabeticHeight2 = 41;
	private int alphabeticHeight3 = 39;
	private int alphabeticHeight4 = 38;
	private int numericColumn1 = 9;
	private int numericColumn2 = 82;
	private int numericColumn3 = 157;
	
	//sets up the class so the information about the constants in the XTrex can be stored
	public Constant ()
	{		
	}
	
	//returns the name of the where to mode
	public String getWhereTo ()
	{			
		return whereTo;
	}
	
	//returns the name of the alphabetic keyboard background file path
	public String getAlphabeticBackground ()
	{			
		return alphabeticBackground;
	}
	
	//returns the name of the numeric keyboard background file path
	public String getNumericBackground ()
	{			
		return numericBackground;
	}
	
	//returns the name of the icon file path
	public String getIcon ()
	{			
		return icon;
	}
	
	//returns the name of the rollover icon file path
	public String getRolloverIcon ()
	{			
		return rolloverIcon;
	}
	
	//returns the name of the icon file extension
	public String getIconExtenction ()
	{			
		return iconExtenction;
	}
	
	//returns the width of the screen in where to mode
	public int getWhereToWidth ()
	{			
		return whereToWidth;
	}
	
	//returns the height of the screen in where to mode
	public int getWhereToHeight ()
	{			
		return whereToHeight;
	}
	
	//returns the x coordinate of the field in where to mode
	public int getWhereToColumn0 ()
	{			
		return whereToColumn0;
	}
	
	//returns the y coordinate of the field in where to mode
	public int getWhereToRow0 ()
	{			
		return whereToRow0;
	}
	
	//returns the width of the field in where to mode
	public int getWhereToWidth0 ()
	{			
		return whereToWidth0;
	}
	
	//returns the height of the field in where to mode
	public int getWhereToHeight0 ()
	{			
		return whereToHeight0;
	}
	
	//returns the y coordinate of the icons in row 1 of the alphabetic keyboard
	public int getAlphabeticRow1 ()
	{			
		return alphabeticRow1;
	}
	
	//returns the y coordinate of the icons in row 2 of the alphabetic keyboard
	public int getAlphabeticRow2 ()
	{			
		return alphabeticRow2;
	}
	
	//returns the y coordinate of the icons in row 3 of the alphabetic keyboard
	public int getAlphabeticRow3 ()
	{			
		return alphabeticRow3;
	}
	
	//returns the y coordinate of the icons in row 4 of the alphabetic keyboard
	public int getAlphabeticRow4 ()
	{			
		return alphabeticRow4;
	}
	
	//returns the y coordinate of the icons in row 5 of the alphabetic keyboard
	public int getAlphabeticRow5 ()
	{			
		return alphabeticRow5;
	}
	
	//returns the y coordinate of the icons in row 6 of the alphabetic keyboard
	public int getAlphabeticRow6 ()
	{			
		return alphabeticRow6;
	}
	
	//returns the y coordinate of the icons in row 7 of the alphabetic keyboard
	public int getAlphabeticRow7 ()
	{			
		return alphabeticRow7;
	}
	
	//returns the x coordinate of the icons in column 1 of the alphabetic keyboard
	public int getAlphabeticColumn1 ()
	{			
		return alphabeticColumn1;
	}
	
	//returns the x coordinate of the icons in column 2 of the alphabetic keyboard
	public int getAlphabeticColumn2 ()
	{			
		return alphabeticColumn2;
	}
	
	//returns the x coordinate of the icons in column 3 of the alphabetic keyboard
	public int getAlphabeticColumn3 ()
	{			
		return alphabeticColumn3;
	}
	
	//returns the x coordinate of the icons in column 4 of the alphabetic keyboard
	public int getAlphabeticColumn4 ()
	{			
		return alphabeticColumn4;
	}
	
	//returns the width of the icons in columns 1 and 4 of the alphabetic keyboard
	public int getAlphabeticWidth1 ()
	{			
		return alphabeticWidth1;
	}
	
	//returns the width of the icons in columns 2 and 3 of the alphabetic keyboard
	public int getAlphabeticWidth2 ()
	{			
		return alphabeticWidth2;
	}
	
	//returns the height of the icons in rows 1, 2 and 3 of the alphabetic keyboard
	public int getAlphabeticHeight1 ()
	{			
		return alphabeticHeight1;
	}
	
	//returns the height of the icons in rows 4 and 5 of the alphabetic keyboard
	public int getAlphabeticHeight2 ()
	{			
		return alphabeticHeight2;
	}
	
	//returns the height of the icons in rows 6 of the alphabetic keyboard
	public int getAlphabeticHeight3 ()
	{			
		return alphabeticHeight3;
	}
	
	//returns the height of the icons in rows 7 of the alphabetic keyboard
	public int getAlphabeticHeight4 ()
	{			
		return alphabeticHeight4;
	}
	
	//returns the x coordinate of the icons in column 1 of the numeric keyboard
	public int getNumericColumn1 ()
	{			
		return numericColumn1;
	}
	
	//returns the x coordinate of the icons in column 2 of the numeric keyboard
	public int getNumericColumn2 ()
	{			
		return numericColumn2;
	}
	
	//returns the x coordinate of the icons in column 3 of the numeric keyboard
	public int getNumericColumn3 ()
	{			
		return numericColumn3;
	}
}