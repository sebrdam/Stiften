/**
 * 
 * @author Youri Tjang
 *
 */
public class Card {	
	/**
	 * 2,3,4,5,6,7,8,9,10,b,v,k,a
	 * Hoeft niet persé van type Object te zijn,
	 * vul zelf in
	 */
	private final Number number;
	
	/**
	 * Klaver, Schoppen, Harten of Ruiten 
	 * Hoeft niet persé van type Object te zijn,
	 * vul zelf in
	 */	
    private final Suit suit;
    
    /**
     * Constructor
     * 
     * @param number
     * @param suit
     */
    Card(Number number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    /**
     * Getters
     * @return
     */
    public Number number() { return number; }
    public Suit suit() { return suit; }
	
	
	/**
	 * Pretty-print deze Card als string
	 */
	public String toString(){
		return number + " of " + suit; 
	}
	
	
	public int compareTo(Card card){
		int suitComp = this.suit().compareTo(card.suit()) ;
		
		if(suitComp == 0){
			int numberComp = this.number().compareTo(card.number()) ;
			return numberComp;
		}else{
			return suitComp;
		}		
	}
}
