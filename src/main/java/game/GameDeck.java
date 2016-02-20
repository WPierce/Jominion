package game;
import java.util.Hashtable;
import java.util.List;

import actions.ActionFactory;
import cards.cardInterfaces.Card;

/**
 * 
 */

/**
 * @author piercew6
 *
 */
public class GameDeck {

	//Stores the cards for the game
	private Hashtable<CardType, List<Card>> gamedeck;
	
	private CardFactory cardFactory;
	
	//For creating a list of actions
	private ActionFactory actionFactory = new ActionFactory();
	
	//game ends if numEmptyPiles == 3
	private int numEmptyPiles;
	
	private boolean gameShouldEnd;
	
	/**
	 * 
	 */
	public GameDeck() {
		gamedeck = new Hashtable<CardType, List<Card>>();
		numEmptyPiles = 0;
		gameShouldEnd = false;
		//actionsList = actionFactory.createActions();
		cardFactory = new CardFactory(actionFactory);
	}
	
	public boolean gameShouldEnd(){
		return gameShouldEnd;
	}
	
	/**
	 * Returns a card of the given type (without removing from game deck).
	 * Returns null if card type is not in deck or has run out.
	 * @param type
	 * @return
	 */
	public Card getCard(CardType type){
		Card returnCard = null;
		List<Card> cards = gamedeck.get(type);
		if(cards != null && cards.size() > 0){
			returnCard = cards.get(0);
		} else {
			System.out.println("Error getting card " + type);
		}
		return returnCard;
	}
	
	/**
	 * Returns card if purchasable or null if card type not in game or exhausted.
	 * If the taken card should end the game it is calculated now.
	 * @param cardType
	 * @return
	 */
	public Card takeCard(CardType cardType){
		
		Card returnCard = null;
		
		List<Card> wantedCards = gamedeck.get(cardType);
		//System.out.println("Card type:" + cardType);
		int numCardsInPile = -1;
		if (wantedCards == null){
			//card type does not exist or map to anything (could be empty)
			System.out.println("Major error! CardType not existing in deck or exhausted");
			return returnCard;
		} else {
			//remove first card on the pile
			numCardsInPile = wantedCards.size();
			returnCard = wantedCards.remove(0);
			numCardsInPile--;
			//success = true;
		}
		//System.out.println("There are " + (wantedCards.size()-1) + " " + cardType + "cards remaing in the deck");
		
		//if the pile of cards has been exhausted then we should check if victory
		//conditions are satisfied.
		if(numCardsInPile == 0){
			//card pile has been exhausted
			if(cardType == CardType.PROVINCE){
				//end game now as provinces are exhausted
				gameShouldEnd = true;
			} else {
				//See if three piles are empty
				numEmptyPiles++;
				if (numEmptyPiles >= 3) {
					//end game now as three piles are empty
					gameShouldEnd = true;
				}
			}
		}
		
		return returnCard;
	}//takeCard

	/**
	 * @return the gamedeck
	 */
	public Hashtable<CardType, List<Card>> getGamedeck() {
		return gamedeck;
	}

	/**
	 * @param gamedeck the gamedeck to set
	 */
	public void setGamedeck(Hashtable<CardType, List<Card>> gamedeck) {
		this.gamedeck = gamedeck;
	}
	
	@Override
	public String toString() {
		return gamedeck.toString();
	}

	/**
	 * Creates specified number of cards of the given card type and adds them
	 * to the game deck
	 * @param type
	 * @param number
	 */
	public void addCardType(CardType type, int number) {
		gamedeck.put(type, cardFactory.createCards(type, number));
	}//addCardType
	
	public int numberOfCard(CardType type){
		List<Card> cards = gamedeck.get(type);
		int numCards = 0;
		if (cards != null) {
			numCards = cards.size();
		}
		return numCards;
	}//numberOfCard

}
