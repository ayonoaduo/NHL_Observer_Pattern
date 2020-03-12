package lab4;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author trevordouglas
 * Modified by Onisokien Ayonoadu
 */

public class GameCenter implements GameSubject 
{
	/**
	 * Initializing Variable needed 
	 */
	private int homeGameID;
	private int visitorGameID;
	private int homeScore;
	private int visitorScore;
	private int currentPeriod;
	private Hashtable<String, Integer> teams;
	Set <GameObserver> gameObservers;
	
	
	/**
	 * Constructor - Used to initialize variables 
	 * @param homeGameID - Home Team ID
	 * @param visitorGameID - Visitor Team ID
	 * @param homeScore	- Home Team Score
	 * @param visitorScore - Visitor Team Score 
	 * @param currentPeriod - Current Period of game
	 */
	public GameCenter(int homeGameID, int visitorGameID) 
	{
		this.homeGameID = homeGameID;
		this.visitorGameID = visitorGameID;
		this.homeScore = 0;
		this.visitorScore = 0;
		this.currentPeriod = 0;
		
		teams  = new Hashtable<String, Integer>();
		teams.put("Toronto Maple Leafs", 1);
		teams.put("Montreal Canadiens", 2);
		teams.put("Edmonton Oilers", 3);	
		teams.put("Vancouver Canucks", 4);
		teams.put("Calgary Flames",  5);
		teams.put("Ottawa Senators", 6);
		
		gameObservers = new HashSet<GameObserver>();
	}
	
	
	/**
	 * Add new observer to set
	 * @param gameObserver - Observer to be added to HashSet
	 */
	@Override
	public void addObserver(GameObserver gameObserver) 
	{
		gameObservers.add(gameObserver);
	}
	
	/**
	 * Remove observer from set
	 * @param gameObserver - Observer to be removed from HashSet
	 */
	@Override
	public void removeObserver(GameObserver gameObserver) 
	{
		gameObservers.remove(gameObserver);
	}

	
	/**
	 * Displays game info to observer
	 */
	@Override
	public void doNotify() 
	{
		Iterator<GameObserver> it = gameObservers.iterator();
		
		while (it.hasNext()) 
		{
			GameObserver gameObserver = it.next();
			gameObserver.doUpdate(homeScore, visitorScore, currentPeriod);
		}
	}

	/**
	 * This method will use homeID gotten from the user and assign the corresponding team name to that observer 
	 * @param newHomeID - Integer gotten from the user
	 */
	public void getTeamName(int newHomeID)
	{
		switch(newHomeID)
		{
			case 1: System.out.println("Subscribed to '" + newHomeID + "' - Toronto Maple Leafs");
					break;
			
			case 2: System.out.println("Subscribed to '" + newHomeID + "' - Montreal Canadiens");
					break;
			
			case 3: System.out.println("Subscribed to '" + newHomeID + "' - Edmonton Oilers");
					break;
					
			case 4: System.out.println("Subscribed to '" + newHomeID + "' - Vancouver Canucks");
					break;
					
			case 5: System.out.println("Subscribed to '" + newHomeID + "' - Calgary Flames");
					break;
					
			case 6: System.out.println("Subscribed to '" + newHomeID + "' - Ottawa Senators ");
					break;
		}
	}
	
	public void setHomeID(int newHomeID) 
	{
		getTeamName(newHomeID);
		homeGameID = newHomeID;
	}
	
	public void setVisitorID(int newVisitorID) 
	{
		System.out.println("\nThe opposing team is The Calgary Flames '" + newVisitorID + "'");
		visitorGameID = newVisitorID;
	}
	
	public void setGameScore(int newHomeScore, int newVisitorScore)
	{
		homeScore = newHomeScore;
		visitorScore = newVisitorScore;
		doNotify();
	}

	public void setCurrentPeriod(int newCurrentPeriod) 
	{
		//System.out.println("\nCurrent Period is " + newCurrentPeriod);
		currentPeriod = newCurrentPeriod;
	}
}

