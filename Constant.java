/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

//class Constant is used to store the information about the constants in the XTrex
public class Constant
{
	private int xtrexWidth = 240;
	private int xtrexHeight = 353;
	private String whereTo = "Where To";
	private String tripComputer = "Trip Computer";
	private String alphabeticBackground = "img/backgroundalphabetic.png";
	private String numericBackground = "img/backgroundnumeric.png";
	private String meterBackground = "img/backgroundmeter.png";
	private String icon = "img/icon";
	private String rolloverIcon = "img/rollovericon";
	private String iconExtenction = ".png";
	private String tripOdometer = "trip odometer";
	private String speed = "speed";
	private String movingTime = "moving time";
	private String distanceUnits = " KM";
	private String speedUnits = " KM/H";
	private String timeUnits1 = " min ";
	private String timeUnits2 = " sec";
	private int alphabeticButtons = 28;
	private int numericButtons = 12;
	private int whereToWidth = 240;
	private int whereToHeight = 375;
	private int tripComputerWidth = 240;
	private int tripComputerHeight = 321;
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
	private int numericRow1 = 52;
	private int numericRow2 = 114;
	private int numericRow3 = 174;
	private int numericRow4 = 228;
	private int numericRow5 = 282;
	private int numericWidth1 = 72;
	private int numericWidth2 = 74;
	private int numericWidth3 = 149;
	private int numericHeight1 = 61;
	private int numericHeight2 = 59;
	private int numericHeight3 = 53;
	private int numericHeight4 = 116;
	private int numericHeight5 = 62;
	private int meterColumn1 = 16;
	private int meterRow1 = 17;
	private int meterRow2 = 64;
	private int meterRow3 = 115;
	private int meterRow4 = 162;
	private int meterRow5 = 213;
	private int meterRow6 = 257;
	private int meterWidth1 = 208;
	private int meterHeight1 = 25;
	private int daySeconds = 86400;
	private int hourSeconds = 3600;
	private int minuteSeconds = 60;
	private String textFont = "Arial";
	private int textSize = 27;
	private int whereToTextColumn = 16;
	private int whereToTextRow = 34;
	private int tripComputerBackgroundRow = 27;
	private int tripComputerTextColumn1 = 40;
	private int tripComputerTextRow1 = 75;
	private int tripComputerTextColumn2 = 65;
	private int tripComputerTextRow2 = 100;
	private int tripComputerTextColumn3 = 75;
	private int tripComputerTextRow3 = 175;
	private int tripComputerTextColumn4 = 50;
	private int tripComputerTextRow4 = 200;
	private int tripComputerTextColumn5 = 45;
	private int tripComputerTextRow5 = 270;
	private int tripComputerTextColumn6 = 30;
	private int tripComputerTextRow6 = 295;

	//sets up the class so the information about the constants in the XTrex can be stored
	public Constant ()
	{
	}

	//returns the width of the screen of the XTrex
	public int getXTrexWidth ()
	{
		return xtrexWidth;
	}

	//returns the height of the screen of the XTrex
	public int getXTrexHeight ()
	{
		return xtrexHeight;
	}

	//returns the name of the where to mode
	public String getWhereTo ()
	{
		return whereTo;
	}

	//returns the name of the trip computer mode
	public String getTripComputer ()
	{
		return tripComputer;
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

	//returns the name of the meter reader background file path
	public String getMeterBackground ()
	{
		return meterBackground;
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

	//returns the name of the trip odometer meter reader
	public String getTripOdometer ()
	{
		return tripOdometer;
	}

	//returns the name of the speed meter reader
	public String getSpeed ()
	{
		return speed;
	}

	//returns the name of the moving time meter reader
	public String getMovingTime ()
	{
		return movingTime;
	}

	//returns the name of the units of distance
	public String getDistanceUnits ()
	{
		return distanceUnits;
	}

	//returns the name of the units of speed
	public String getSpeedUnits ()
	{
		return speedUnits;
	}

	//returns the name of the first units of time
	public String getTimeUnits1 ()
	{
		return timeUnits1;
	}

	//returns the name of the second units of time
	public String getTimeUnits2 ()
	{
		return timeUnits2;
	}

	//returns the number of alphabetic buttons
	public int getAlphabeticButtons ()
	{
		return alphabeticButtons;
	}

	//returns the number of numeric buttons
	public int getNumericButtons ()
	{
		return numericButtons;
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

	//returns the width of the screen in trip computer mode
	public int getTripComputerWidth ()
	{
		return tripComputerWidth;
	}

	//returns the height of the screen in trip computer mode
	public int getTripComputerHeight ()
	{
		return tripComputerHeight;
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

	//returns the y coordinate of the icons in row 1 of the numeric keyboard
	public int getNumericRow1 ()
	{
		return numericRow1;
	}

	//returns the y coordinate of the icons in row 2 of the numeric keyboard
	public int getNumericRow2 ()
	{
		return numericRow2;
	}

	//returns the y coordinate of the icons in row 3 of the numeric keyboard
	public int getNumericRow3 ()
	{
		return numericRow3;
	}

	//returns the y coordinate of the icons in row 4 of the numeric keyboard
	public int getNumericRow4 ()
	{
		return numericRow4;
	}

	//returns the y coordinate of the icons in row 5 of the numeric keyboard
	public int getNumericRow5 ()
	{
		return numericRow5;
	}

	//returns the width of the icons in column 1 of the numeric keyboard
	public int getNumericWidth1 ()
	{
		return numericWidth1;
	}

	//returns the width of the icons in columns 2 and 3 of the numeric keyboard
	public int getNumericWidth2 ()
	{
		return numericWidth2;
	}

	//returns the width of the delete icon of the numeric keyboard
	public int getNumericWidth3 ()
	{
		return numericWidth3;
	}

	//returns the height of the icons in row 1 of the numeric keyboard
	public int getNumericHeight1 ()
	{
		return numericHeight1;
	}

	//returns the height of the icons in row 2 of the numeric keyboard
	public int getNumericHeight2 ()
	{
		return numericHeight2;
	}

	//returns the height of the icons in rows 3 and 4 of the numeric keyboard
	public int getNumericHeight3 ()
	{
		return numericHeight3;
	}

	//returns the height of the delete icon of the numeric keyboard
	public int getNumericHeight4 ()
	{
		return numericHeight4;
	}

	//returns the height of the icons in row 5 of the numeric keyboard
	public int getNumericHeight5 ()
	{
		return numericHeight5;
	}

	//returns the x coordinate of the fields in column 1 of the meter reader
	public int getMeterColumn1 ()
	{
		return meterColumn1;
	}

	//returns the y coordinate of the field in row 1 of the meter reader
	public int getMeterRow1 ()
	{
		return meterRow1;
	}

	//returns the y coordinate of the field in row 2 of the meter reader
	public int getMeterRow2 ()
	{
		return meterRow2;
	}

	//returns the y coordinate of the field in row 3 of the meter reader
	public int getMeterRow3 ()
	{
		return meterRow3;
	}

	//returns the y coordinate of the field in row 4 of the meter reader
	public int getMeterRow4 ()
	{
		return meterRow4;
	}

	//returns the y coordinate of the field in row 5 of the meter reader
	public int getMeterRow5 ()
	{
		return meterRow5;
	}

	//returns the y coordinate of the field in row 6 of the meter reader
	public int getMeterRow6 ()
	{
		return meterRow6;
	}

	//returns the width of the fields in columns 1 of the meter reader
	public int getMeterWidth1 ()
	{
		return meterWidth1;
	}

	//returns the height of the fields in columns 1 of the meter reader
	public int getMeterHeight1 ()
	{
		return meterHeight1;
	}

	//returns the number of seconds in a day
	public int getDaySeconds ()
	{
		return daySeconds;
	}

	//returns the number of seconds in a hour
	public int getHourSeconds ()
	{
		return hourSeconds;
	}

	//returns the number of seconds in a minute
	public int getMinuteSeconds ()
	{
		return minuteSeconds;
	}

	//returns the fornt of the text
	public String getTextFont ()
	{
		return textFont;
	}

	//returns the size of the text
	public int getTextSize ()
	{
		return textSize;
	}

	//returns the x coordinate of the text in Where To mode
	public int getWhereToTextColumn ()
	{
		return whereToTextColumn;
	}

	//returns the y coordinate of the text in Where To mode
	public int getWhereToTextRow ()
	{
		return whereToTextRow;
	}

	//returns the y coordinate of the background in Trip Computer mode
	public int getTripComputerBackgroundRow ()
	{
		return tripComputerBackgroundRow;
	}

	//returns the x coordinate of the text in row 1 in Trip Computer mode
	public int getTripComputerTextRow1 ()
	{
		return tripComputerTextRow1;
	}

	//returns the y coordinate of the text in column 1 in Trip Computer mode
	public int getTripComputerTextColumn1 ()
	{
		return tripComputerTextColumn1;
	}

	//returns the x coordinate of the text in row 2 in Trip Computer mode
	public int getTripComputerTextRow2 ()
	{
		return tripComputerTextRow2;
	}

	//returns the y coordinate of the text in column 2 in Trip Computer mode
	public int getTripComputerTextColumn2 ()
	{
		return tripComputerTextColumn2;
	}

	//returns the x coordinate of the text in row 3 in Trip Computer mode
	public int getTripComputerTextRow3 ()
	{
		return tripComputerTextRow3;
	}

	//returns the y coordinate of the text in column 3 in Trip Computer mode
	public int getTripComputerTextColumn3 ()
	{
		return tripComputerTextColumn3;
	}

	//returns the x coordinate of the text in row 4 in Trip Computer mode
	public int getTripComputerTextRow4 ()
	{
		return tripComputerTextRow4;
	}

	//returns the y coordinate of the text in column 4 in Trip Computer mode
	public int getTripComputerTextColumn4 ()
	{
		return tripComputerTextColumn4;
	}

	//returns the x coordinate of the text in row 5 in Trip Computer mode
	public int getTripComputerTextRow5 ()
	{
		return tripComputerTextRow5;
	}

	//returns the y coordinate of the text in column 5 in Trip Computer mode
	public int getTripComputerTextColumn5 ()
	{
		return tripComputerTextColumn5;
	}

	//returns the x coordinate of the text in row 6 in Trip Computer mode
	public int getTripComputerTextRow6 ()
	{
		return tripComputerTextRow6;
	}

	//returns the y coordinate of the text in column 6 in Trip Computer mode
	public int getTripComputerTextColumn6 ()
	{
		return tripComputerTextColumn6;
	}
}
