package game;
import java.util.ArrayList;
import java.util.List;

import cards.cardInterfaces.Card;
import cards.cardInterfaces.TreasureCard;

/**
 * The hand class is used to represent a player's hand, i.e. the cards in it
 * and their value + other attributes.
 */

/**
 * @author piercew6
 *
 */
public class Hand {
	
	private List<Card> cards;

	/**
	 * 
	 */
	public Hand() {
		cards = new ArrayList<Card>();
	}//constructor
	
	/**
	 * 
	 * @param hand
	 */
	public void setHand(List<Card> hand){
		this.cards = hand;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Card> getCards(){
		return this.cards;
	}
	
	/**
	 * Empties the current hand
	 */
	public void empty(){
		cards.clear();
	}
	
	/**
	 * 
	 * @return value the treasure value of the cards in the hand
	 */
	public int treasureValue(){
		int treasureValue = 0;
		if (cards == null){
			System.out.println("What is going on????");
			return 0;
		}
		for (Card card : cards) {
			if(card == null){
				System.out.println("Card is null???");
				return 0;
			}
			if(card != null && card instanceof TreasureCard){
				treasureValue += ((TreasureCard) card).getTreasureValue();
			}
		}
		return treasureValue;
	}//treasureValue
	
	/**
	 * 
	 * @return card Returns zero if the hand does not contain the specified card
	 * else returns the number of the specified card in this hand.
	 */
	public int contains(CardType specifiedCard){
		//TODO: This method is not implemented
		int numCards = 0;
		for (Card card : cards) {
			if(card.getType() == specifiedCard){
				numCards += 1;
			}
		}
		return numCards;
	}//contains
	
	@Override
	public String toString() {
		String returnString = "Hand value: " + this.treasureValue() + "\n";
		for (Card card : cards) {
			returnString += card.toString();
		}
		return returnString;
	}//toString

	public void addCard(Card cardToAdd) {
		cards.add(cardToAdd);
	}

	/**
	 * Removes the given card from a hand.
	 * @param card
	 */
	public void remove(Card card) {
		cards.remove(card);
	}

	/**
	 * Returns the first instance of the given card from a hand. Does not
	 * remove it from the hand. Returns null if card not in hand.
	 * @param card
	 * @return
	 */
	public Card getCard(CardType requiredCardType) {
		//TODO: This might return the LAST instance of a card in hand.
		Card returnCard = null;
		for (Card card : cards) {
			if (card.getType() == requiredCardType) {
				returnCard = card;
				break;
			}
		}//for
		return returnCard;
	}//getCard

}
