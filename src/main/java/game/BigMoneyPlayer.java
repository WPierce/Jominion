package game;
import java.util.ArrayList;

import cards.cardInterfaces.Card;

/**
 * 
 */

/**
 * @author piercew6
 *
 */
public class BigMoneyPlayer extends Player {
	
	public BigMoneyPlayer(String name, GameDeck gamedeck) {
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
		
	}

	@Override
	public void takeTurn() {
		//reset number of buy & action events
		this.setBuys(1);
		this.setActions(1);
		
		//Pick up hand
		this.drawHand();
		
		//System.out.println(discardPile);
//		System.out.println("Before turn:");
//		System.out.println("Hand: " + hand);
//		System.out.println("Discard: " + discardPile);
//		System.out.println("Deck: " + deck);
		
		//Get value of coins in hand
		int treasureValue = hand.treasureValue();
//		System.out.println("Hand is worth " + treasureValue);
		
		if (treasureValue >= 8){
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
//		System.out.println("After turn:");
//		System.out.println("Hand: " + hand);
//		System.out.println("Discard: " + discardPile);
//		System.out.println("Deck: " + deck);
	}//takeTurn
}
