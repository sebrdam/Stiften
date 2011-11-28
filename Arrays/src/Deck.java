import java.util.Arrays;

/**
 * Een deck met Cards
 * 
 * @author Youri Tjang
 *
 */
public class Deck {
	Card[] cardArray;
	public boolean debug = false;
	
	
	/**
	 * Constructor
	 */
	Deck(){
		cardArray = new Card[0];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fillDeck() {
		int amountOfSuits = Suit.values().length;
		int amountOfNumbers = Number.values().length;  
		
		cardArray = new Card[amountOfNumbers * amountOfSuits];
		int cardNumber = 0;
		for (int i = 0; i < amountOfSuits; i++) {
			for (int j = 0; j < amountOfNumbers; j++) {
				cardArray[cardNumber] = new Card(Number.values()[j], Suit.values()[i]);
				cardNumber++;
			}
		}
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
		Card[] cardArrayTemp = new Card[cardArray.length];
		for (int i = 0; i < index; i++) {
			
			cardArrayTemp[i] = cardArray[i];
		}
		cardArrayTemp[index] = card;
				
		for (int i = index+1; i < cardArrayTemp.length; i++) {
			
			cardArrayTemp[i] = cardArray[i];
		}		
		
		cardArray = cardArrayTemp;
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
		if(index < cardArray.length && index > 0){
			Card[] cardArrayTemp = new Card[cardArray.length-1];

			for (int i = 0; i < index; i++) {
				
				cardArrayTemp[i] = cardArray[i];
			}
					
			for (int i = index+1; i < cardArrayTemp.length; i++) {
				
				cardArrayTemp[i] = cardArray[i-1];
			}		
			
			cardArray = cardArrayTemp;		
		}else{
			
			
		}
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
		for (int i = 0; i < cardArray.length; i++) {
			cardSwap(i, (int) (Math.random()*(float)cardArray.length));
		}
	}

	/**
	 * Utillity method for swapping cards in given indices
	 * 
	 * @param indexA
	 * @param indexB
	 */
	private void cardSwap(int indexA, int indexB){
		//TODO error check for arrayoutofbounds
		Card temp = cardArray[indexA];
		cardArray[indexA] = cardArray[indexB];
		cardArray[indexB] = temp; 
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
		int result = -1;
		
		for (int i = 0; i < cardArray.length; i++) {
			if(cardArray[i].equals(card)){
				result = i;
			}
		}
		
		return result;
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
		//TODO implement sort 
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbart p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		int result = -1;
		
		binarySearch(card, 0, cardArray.length);
		
		return result;
	}
	
	
	/**
	 * TODO DEBUG THIS
	 * @param card
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public int binarySearch(Card card, int startIndex, int endIndex) {
		
		int mid =  startIndex + ((endIndex - startIndex) / 2);
	
		if(endIndex < startIndex){
			return -1;
		}
		
		int compare = card.compareTo(cardArray[mid]);
		

		if(debug){
			System.out.println("Comparing " + card +" to "+ cardArray[mid] + " --> " + compare + " @ " + mid);
		}
		
		if(compare < 0){
			return binarySearch(card, startIndex, mid-1);
		}else if(compare > 0){
			return binarySearch(card, mid+1, endIndex);
		}else{
			return mid;
		}
	}
	
	
	/**
	 *  Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0; i<cardArray.length;i++){
			str += cardArray[i] + " ";
		}
		return str + "\n";	
	}
	
	public void debug(){
		if(debug){
			this.toString();
		}
	}
}
