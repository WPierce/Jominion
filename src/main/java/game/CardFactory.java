package game;
import java.util.ArrayList;
import java.util.List;

import actions.ActionFactory;
import cards.Cellar;
import cards.Duchy;
import cards.Estate;
import cards.Gold;
import cards.Province;
import cards.Silver;
import cards.Copper;
import cards.Smithy;
import cards.cardInterfaces.Card;

/**
 * This class instantiates new Card objects
 */

/**
 * @author piercew6
 *
 */
public class CardFactory {
	
	private ActionFactory actionFactory;

	/**
	 * @param actionsList 
	 * 
	 */
	public CardFactory(ActionFactory actionFactory) {
		this.actionFactory = actionFactory;
	}//Constructor
	
	/**
	 * Creates a new card of the type given by cardType (enum). Returns null
	 * if card type does not exist.
	 * @param cardType
	 * @return
	 */
	public Card createCard(CardType cardType){
		Card returnCard = null;
		
		switch (cardType) {
		case COPPER:
			returnCard = new Copper();
			break;
		case SILVER:
			returnCard = new Silver();
			break;
		case GOLD:
			returnCard = new Gold();
			break;
		case ESTATE:
			returnCard = new Estate();
			break;
		case DUCHY:
			returnCard = new Duchy();
			break;
		case PROVINCE:
			returnCard = new Province();
			break;
		case SMITHY:
			returnCard = new Smithy();
			break;
		case CELLAR:
			returnCard = new Cellar(actionFactory.getDiscardCardsAction());
			break;
		default:
			System.out.println("Unknown cardtype " + cardType);
			break;
		}//switch
		return returnCard;
	}//CreateCard
	
	/**
	 * Creates a number of cards of a single type and returns them as a list.
	 * @param type The type of card.
	 * @param number The number of this type of card to create.
	 * @return
	 */
	public List<Card> createCards(CardType type, int number){
		ArrayList<Card> returnCards = new ArrayList<Card>();
		for (int i = 0; i < number; i++) {
			returnCards.add(createCard(type));
		}
		
		return returnCards;
	}//CreateCards

}//CardFactory
