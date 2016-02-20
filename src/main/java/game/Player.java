package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import actions.Action;
import cards.Cellar;
import cards.cardInterfaces.ActionCard;
import cards.cardInterfaces.Card;
import cards.cardInterfaces.VictoryCard;

public abstract class Player {

	protected Hand hand;
	protected List<Card> deck;
	private int buys;
	private int actions;
	private String name;
	protected List<Card> discardPile;
	protected GameDeck gamedeck;

	public Player() {
		super();
	}

	/**
	 * Buys the specified card
	 * @param cardType
	 * @return success Returns true if card was bought, false if not.
	 */
	public boolean buy(CardType cardType) {
			System.out.println("Buying card " + cardType);
			boolean success = false;
			int treasureValue = hand.treasureValue();
			
			//First get the card so we can get its value
			Card cardToBuy = gamedeck.getCard(cardType);
			if (cardToBuy == null) { //could be null from getCard
				System.out.println("Card was null you idiot!");
			} else {
				if (cardToBuy.getCost() <= treasureValue){
					//discardPile.add(card);
	//				System.out.println(gamedeck);
					discardPile.add(gamedeck.takeCard(cardType));
					//this.setBuys(this.getBuys() - 1);
					this.buys = 0;
					success = true;
					
					//TODO: Game could end at this point, so test for it?
					//TODO: Actually, I have a feeling that the game shouldn't end
					//here & only ends at the end of a turn
					if(gamedeck.gameShouldEnd()){
						//Now we need to set the game so it can end,
						//i.e set actions, buys etc to zero
						this.buys = 0;
						this.actions = 0;
					}
				}
			}
	
			return success;
		}//buy

	/**
	 * 
	 * @return The total number of victory points the player has.
	 */
	public int getVictoryValue() {
		int victoryValue = 0;
		//check hand
		List<Card> cards = hand.getCards();
		if (cards != null) {
			for (Card card : cards) {
				if(card instanceof VictoryCard){
					victoryValue += ((VictoryCard) card).getVictoryValue();
				}
			}
		}
		//check discard
		if (discardPile != null) {
			for (Card card : discardPile) {
				if(card instanceof VictoryCard){
					victoryValue += ((VictoryCard) card).getVictoryValue();
				}
			}
		}
		//check deck
		if (deck != null) {
			for (Card card : deck) {
				if(card instanceof VictoryCard){
					victoryValue += ((VictoryCard) card).getVictoryValue();
				}
			}
		}
		return victoryValue;
	}

	/**
	 * 
	 * @return newHand
	 */
	public void drawHand() {
			List<Card> newHand = new ArrayList<Card>();
	//		System.out.println("Deck: " + deck);
	//		System.out.println("Discard: " + discardPile);
	//		System.out.println("Is empty? " + deck.isEmpty());
			
			while(newHand.size() < 5){
				//draw cards
				if(deck.size() > 0){
					newHand.add(deck.remove(0));
				} else {
					discardToDeck();
				}
			}
			hand.setHand(newHand);
		}//drawHand

	/**
	 * Draws a card from player's deck and puts it in their hand
	 */
	public void drawCard() {
		Card cardToAdd = null;
		if(deck.size() > 0){
			cardToAdd = deck.remove(0);
			hand.addCard(cardToAdd);
		} else {
			discardToDeck();
			cardToAdd = deck.remove(0);
			hand.addCard(cardToAdd);
		}
	}

	/**
	 * Performs the action of a given card
	 * TODO: Should move this code to somewhere else.
	 */
	public void doAction(Card card) {
		switch (card.getType()) {
		case SMITHY:
			System.out.println("Playing smithy card!");
			for (int i = 0; i < 3; i++) {
				drawCard();
			}
			//decrease actions by 1
			actions = actions - 1;
			discardCard(card);
			System.out.println(hand);
			break;
		case VILLAGE:
			//Village gives +2 actions +1 card
			System.out.println("Playing village card!");
			drawCard();
			this.actions = this.actions + 1; //only increment by 1 as we use 1 up this turn
			discardCard(card);
		case CELLAR:
			//cellar gives +1 action and allows us to discard any # of cards and pick up that # more
			
		default:
			break;
		}
	}//doAction
	
	public void playCard(Card card){
		//first make sure that the card is an action card
		if(!(card instanceof ActionCard)){
			System.out.println("This is not an action card and so cannot be played.");
		} else {
			//we're okay to play the card, so lets do it
			//first get the actions of the card
			List<Action> actions = ((ActionCard) card).getActions();
			
			//now perform the actions
			for (Action action : actions) {
				//TODO: How the fuck do I do this?
			}
		}
	}

	/**
	 * Moves the discard pile to be the new deck and empties discard pile.
	 * Also shuffles the deck.
	 */
	private void discardToDeck() {
			//set discard pile as new deck
	//		System.out.println("Discard to deck");
	//		System.out.println("Deck before shuffle: " +) deck);
			this.deck = new ArrayList<Card>(discardPile);
	//		System.out.println("Deck after copy: " + deck);
			//empty discard pile
			discardPile.clear();
			//finally shuffle the deck
			shuffleDeck();
	//		System.out.println("Deck after shuffle: " + deck);
		}

	public void shuffleDeck() {
		//shuffle discard pile
		Collections.shuffle(deck);
	}//shuffleDiscardPile

	public abstract void takeTurn();

	/**
	 * 
	 */
	public void discardHand() {
		discardPile.addAll(hand.getCards());
		hand.empty();
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the deck
	 */
	public List<Card> getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	/**
	 * @return the buys
	 */
	public int getBuys() {
		return buys;
	}

	/**
	 * @param buys the buys to set
	 */
	public void setBuys(int buys) {
		this.buys = buys;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the discardPile
	 */
	public List<Card> getDiscardPile() {
		return discardPile;
	}

	/**
	 * @param discardPile the discardPile to set
	 */
	public void setDiscardPile(List<Card> discardPile) {
		this.discardPile = discardPile;
	}

	/**
	 * @return the actions
	 */
	public int getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		String returnString = "Name:" + name + "\n";
	    returnString += "Buys: " + buys + " Actions: " + actions + "\n";
	    returnString += hand.toString();
	    return returnString;
	}
	
	/**
	 * Returns the number of that type of card in a player's hand, deck and
	 * discard pile.
	 * @param cardType The type of card to find
	 * @return The number of the given card type in the hand, deck and discard.
	 */
	public int NumberOfCard(CardType cardType){
		int numCards = 0;
		//check hand
		List<Card> cards = hand.getCards();
		if (cards != null) {
			for (Card card : cards) {
				if(card.getType() == cardType){
					numCards++;
				}
			}
		}
		//check discard
		if (discardPile != null) {
			for (Card card : discardPile) {
				if(card.getType() == cardType){
					numCards++;
				}
			}
		}
		//check deck
		if (deck != null) {
			for (Card card : deck) {
				if(card.getType() == cardType){
					numCards++;
				}
			}
		}
		return numCards++;
	}//NumberOfCard
	
	/**
	 * Puts the given card on the discard pile and removes from hand
	 * @param card
	 */
	public void discardCard(Card card){
		discardPile.add(card);
		hand.remove(card);
	}

}