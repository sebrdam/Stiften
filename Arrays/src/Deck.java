import java.util.Arrays;

/**
 * Een deck met Cards
 * 
 */
public class Deck {

	public static void main(String[] args) {

		Deck d = new Deck();

		d.fill();
		Card bas = new Card(Number.BOER, Suit.KLAVEREN);
	    d.insertAt(bas, 1);
		 //d.delete(5);
		// d.shuffle();
		// d.cardSwap(1, 0);
		// d.sequentialSearch(bas);
		// d.sort();
		int test = d.binarySearch(bas);
		System.out.println(test);
	}

	Card[] cardArray;

	int size = 52;
	int result;

	/**
	 * Constructor. Maakt een deck met lengte 0.
	 */
	Deck() {
		cardArray = new Card[size];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fill() {
		int i = 0;

		for (Suit suit : Suit.values()) {
			// System.out.println(suit);
			for (Number num : Number.values()) {
				Card c = new Card(num, suit);
				cardArray[i] = c;
				i++;
			}

		}
		// System.out.println(cardArray[25]);

	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {

		cardArray = Arrays.copyOf(cardArray, cardArray.length + 1);

		for (int i = cardArray.length - 1; i > index; i--) {
			cardArray[i] = cardArray[i - 1];
		}
		cardArray[index] = card;
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er
	 * in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {

		System.arraycopy(cardArray, index + 1, cardArray, index,
				cardArray.length - 1 - index);
		cardArray = Arrays.copyOf(cardArray, cardArray.length - 1);

	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {

		for (int i = cardArray.length - 1; i > -1; i--) {
			int j = (int) Math.floor(Math.random() * (i + 1));
			Card temp = cardArray[i];
			cardArray[i] = cardArray[j];
			cardArray[j] = temp;

			// System.out.println(cardArray[i] + "-" + i);
		}

	}

	/**
	 * Utillity method for swapping cards in given indices
	 * 
	 * @param indexA
	 * @param indexB
	 */
	public void cardSwap(int indexA, int indexB) {
		Card temp = cardArray[indexA];
		cardArray[indexA] = cardArray[indexB];
		cardArray[indexB] = temp;

		// System.out.println(cardArray[1]);
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {

		for (int i = cardArray.length - 1; i > -1; i--) {

			// System.out.println(cardArray[i] + "-" + i);

			Card temp = cardArray[i];

			if (temp.toString().contentEquals(card.toString())) {
				result = i;

			}
		}

		// System.out.println(result);

		return result;

	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {

		int nieuw = 0;

		Card[] cardArray1 = new Card[cardArray.length];

		for (Suit suit : Suit.values()) {

			for (Number num : Number.values()) {

				for (int i = 0; i < cardArray.length; i++) {

					String bas = cardArray[i].num1;
					String bas1 = cardArray[i].suit1;
					String bas2 = suit.toString();
					String bas3 = num.toString();

					if ((bas2.equals(bas1)) && (bas3.equals(bas))) {

						Card c = new Card(num, suit);
						cardArray1[nieuw] = c;
						System.out.println(cardArray1[nieuw]);
						nieuw++;

					}

				}
			}

		}

		cardArray = Arrays.copyOf(cardArray1, cardArray1.length);

		// System.out.println(cardArray1.length);
	}

	/**
	 * Vertelt of het deck gesorteerd is.
	 * 
	 * @return
	 */
	public boolean isSorted() {
		boolean sorted = true;
		// ...
		return sorted;
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbard p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {

		int testcard = sequentialSearch(card);

		int lo = 0;
		int hi = cardArray.length;
		while (lo < hi) {
			int i = (lo + hi) / 2;
			int testcard1 = sequentialSearch(cardArray[i]);
			if (testcard1 == testcard) {
				return i;
			} else if (testcard1 < testcard) {
				lo = i + 1;
			} else {
				hi = i;
			}
		}

		return -1;

	}

	/**
	 * Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";

		return str + "\n";
	}

	public int compareTo(Deck d) {
		return 0;
	}

}
