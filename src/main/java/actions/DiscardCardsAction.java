/**
 * 
 */
package actions;

import java.util.List;

import cards.cardInterfaces.Card;

/**
 * @author Will
 * This is the action for discarding cards from the players own hand.
 */
public class DiscardCardsAction extends Action {

	/**
	 *  Empty constructor.
	 */
	public DiscardCardsAction() {
	}
	
	public List<Card> DiscardCards(List<Card> discardPile, List<Card> cardsToDiscard){
		//go through each card to discard and put it in the discard pile
		for (Card card : cardsToDiscard) {
			discardPile.add(card);
		}
		cardsToDiscard.clear();
		
		//return the discard pile
		return discardPile;
	}

}
