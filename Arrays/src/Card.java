public class Card implements Comparable<Card> {


	/**
	 * Constructor
	 * 
	 * @param number
	 * @param suit
	 */
	Card() {
	}


	/**
	 * Pretty-print deze Card als string
	 */
	public String toString() {
		return "Aas" + " van " + "Ruiten";
	}

	/**
	 * Vergelijk twee kaarten.
	 */
	public int compareTo(Card card) {
		return 0;
	}

}
