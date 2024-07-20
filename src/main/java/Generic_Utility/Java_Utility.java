package Generic_Utility;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author Sanju
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	
	/**
	 * This method is used to get system date and time in IST format
	 * @return
	 * @author Sanju
	 */
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
	System.out.println(dateAndTime);
		return dateAndTime;
		}
	
	/**
	 * This method is used to get Date In YYYY-MM-DD Format
	 * @return
	 * @author Sanju
	 */
	public String getSystemDateWithFormat()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
	System.out.println(dateAndTime);
	
	String YYYY = dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
	
	int MM = date.getMonth()+1;
	
	String FinalFormat = YYYY+"-"+MM+"-"+DD;
	System.out.println(FinalFormat);
		return FinalFormat;
		
	}
//1st pull
	
	//hello
}




