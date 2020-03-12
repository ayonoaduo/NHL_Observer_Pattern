package lab4;

/**
 * @author okienayonoadu
 */
import java.util.Scanner;

public class NHLFan implements GameObserver
{
	/**
	 * @param fanName - Name of observer
	 */
	private String fanName;
	
	
	/**
	 * Constructor to assign name of observer
	 * @param name - Name of Observer
	 */
	public NHLFan(String name)
	{
		this.fanName = name;
	}
	
	/**
	 * @return name of Observer
	 */
	public String getFanName()
	{
		return this.fanName;
	}
	
	/**
	 * @return number corresponding to team Name
	 */
	public int subscribe()
	{
		System.out.println("Welcome " + getFanName() + "!");
		System.out.println("\nChoose a team to subscribe to by inputting corresponding number: \nToronto Maple Leafs, 1" + 
						"\nMontreal Canadiens, 2" + 
						"\nEdmonton Oilers, 3" + 
						"\nVancouver Canucks, 4" + 
						"\nOttawa Senators, 6");
		
		Scanner input= new Scanner(System.in);
		int in = input.nextInt();
		
		input.close();
		return in;	
	}
	
	
	/**
	 * @param period - period in integer
	 * @return the right string format for the period
	 */
	public String periodToString(int period)
	{
		String per= "";
		if(period == 1)
			per = "1st";
		else if(period == 2)
			per = "2nd";
		else if(period == 3)
			per = "3rd";
		else if(period == 4)
			per = "4th";
		else if(period == 5)
			per = "5th";
		else if(period == 6)
			per = "6th";
		 
		return per;
	}
	
	/**
	 * Method will display game info to Observer
	 */
	@Override
	public void doUpdate(int homeScore, int visitorScore, int currentPeriod) 
	{
		String per = periodToString(currentPeriod);
		System.out.println("The Game Score for " + getFanName() + " : Your Team - " + homeScore + " Opposing Team - " + visitorScore + " in " + per +" period.");
	}
}
