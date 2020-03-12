package lab4;

public class ObserverMain 
{
	public static void main(String[] args) 
	{
		GameCenter gameCenter = new GameCenter(4, 5);
		
		NHLFan fan = new NHLFan("Peter");
		/**
		 * @param homeID - will hold the user's team selection
		 */
		int homeID = fan.subscribe();
				
		gameCenter.addObserver(fan);
		
		gameCenter.setHomeID(homeID);
		gameCenter.setVisitorID(5);
		
		gameCenter.setCurrentPeriod(1);
		gameCenter.setGameScore(10, 15);
		
		gameCenter.setCurrentPeriod(4);	
		gameCenter.setGameScore(14, 18);
	}
}
