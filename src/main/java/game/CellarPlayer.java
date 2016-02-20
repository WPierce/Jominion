/**
 * 
 */
package game;

import java.util.ArrayList;

import cards.cardInterfaces.Card;

/**
 * @author piercew6
 *
 */
public class CellarPlayer extends Player {

	/**
	 * 
	 */
	public CellarPlayer(String name, GameDeck gamedeck) {
		this.setName(name);
		this.deck = new ArrayList<Card>();
		this.hand = new Hand();
		this.discardPile = new ArrayList<Card>();
		this.gamedeck = gamedeck;
		
		//add coppers
		for (int i = 0; i < 7; i++) {
			deck.add(gamedeck.takeCard(CardType.COPPER));
		}
		
		//add estates
		for (int i = 0; i < 3; i++) {
			deck.add(gamedeck.takeCard(CardType.ESTATE));
		}
	}//constructor

	/* (non-Javadoc)
	 * @see game.Player#takeTurn()
	 */
	@Override
	public void takeTurn() {
		//reset number of buy & action events
		this.setBuys(1);
		this.setActions(1);
		
		//Pick up hand
		this.drawHand();

		int numSmithy = NumberOfCard(CardType.SMITHY);
		
		//Action card phase
		if (hand.contains(CardType.CELLAR) > 0 ) {
			System.out.println("I have a Cellar in my hand!");
			this.doAction(hand.getCard(CardType.SMITHY)); //TODO:Bad method call
		}
		
		//Get value of coins in hand
		int treasureValue = hand.treasureValue();
		System.out.println("Hand value: " + treasureValue);
		
		//TODO: Should not be using absolute values, should have some kind
		//of smithy.cost etc
		if (numSmithy < 1 && treasureValue >= 4) {
			this.buy(CardType.SMITHY);
		} else if (treasureValue >= 8){
			//buy province
			this.buy(CardType.PROVINCE);
		} else if (treasureValue >= 6){
			//buy gold
			this.buy(CardType.GOLD);
		} else if (treasureValue >= 3){
			//buy silver
			this.buy(CardType.SILVER);
		} else {
			//buy copper
			//Do nothing
			//this.buy(CardType.COPPER);
		}//if
		
		//Turn is over, so add all cards to discard pile
		discardHand();
	}

}//BigSmithyPlayer
