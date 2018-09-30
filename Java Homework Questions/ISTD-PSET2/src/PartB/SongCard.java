package PartB;



// Homework Question 3
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.*;
public class SongCard {

    private int songs;
    private boolean activated;
    public SongCard(int n) {      
    	songs = n;
    }
    public void activate(){
       activated = true;

}
    public void buyASong()
        throws CardNotActivatedException, CardEmptyException {
       
        if ( ! activated ) 
        	throw new CardNotActivatedException();
        if ( songs == 0 ) 
        	throw new CardEmptyException();
        
        songs -= 1;

    }

    public int songsRemaining(){
        return songs;
         
    }
    public String toString() {
    	if ( this.activated )
    		return String.format("Card has %d songs and is activated", songs);
    	else
    		return String.format("Card has %d songs and is not activated", songs);
    }

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		SongCard sc = new SongCard(10);
		System.out.println(sc);
		System.out.println("Trying to buy a song");
		try {
			sc.buyASong();
		} catch (CardEmptyException e1) {
			System.out.println("Caught error: " + e1.getMessage());
		} catch (CardNotActivatedException e2) {
			System.out.println("Caught error: " + e2.getMessage());
		}
		System.out.println(sc);
		System.out.println("Activating the card");
		sc.activate();
		System.out.println(sc);
		System.out.println("Buying songs");

		for (int n = 0; n < 11; n++) {
			try {
				sc.buyASong();

			} catch (CardNotActivatedException e3) {
				System.out.println("Caught error: " + e3.getMessage());
			} catch (CardEmptyException e4) {
				System.out.println("Caught error: " + e4.getMessage());
			} finally {
				System.out.println(sc);
			}
		}
	}

    public class CardNotActivatedException extends Exception{
       public CardNotActivatedException() {
    	   super("Card not activated");
       }

    }

    public class CardEmptyException extends Exception{
       public CardEmptyException() {
    	   super("No more songs on the card");
       }
    }
}