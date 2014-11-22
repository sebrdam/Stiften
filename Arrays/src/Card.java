public class Card implements Comparable<Card> {


	String num1;
	String suit1;
	/**
	 * Constructor
	 * 
	 * @param number
	 * @param suit
	 */
	Card(Number num, Suit suit) {
		
		this.num1 = num.toString();
		this.suit1 = suit.toString();
		
	}


	/**
	 * Pretty-print deze Card als string
	 */
	public String toString() {
		//return "Aas" + " van " + "Ruiten";
		return num1 + " van " + suit1;
	}

	/**
	 * Vergelijk twee kaarten.
	 */
	public int compareTo(Card card) {
		return 0;
	}

}
