import java.util.Arrays;

/**
 * 
 * @author Youri Tjang
 *
 */
public class App {

	/**
	 * App die onze datastructuur test.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.debug = true;
		
		deck.fillDeck();
		//deck.shuffle();
		
		Card card = new Card(Number.ACE, Suit.RUITEN);
		
		int testIndex = 30;
		deck.insertAt(card, testIndex);
		System.out.print("Sequential search ...");
		int foundIndex = deck.sequentialSearch(card);
		System.out.println((foundIndex == testIndex)?"Win":"Fail");
		
		System.out.print("Binary search...");
		deck.sort();
deck.debug();

System.out.println(Arrays.asList(Suit.values()));

		foundIndex = deck.binarySearch(card);
		System.out.println(foundIndex);

		
	}
}
