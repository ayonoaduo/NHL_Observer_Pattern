package lab4;

/**
 * 
 * @author okienayonoadu
 *
 */
public interface GameSubject 
{
	public void addObserver(GameObserver gameObserver);
	public void removeObserver(GameObserver gameObserver);
	public void doNotify();
}
