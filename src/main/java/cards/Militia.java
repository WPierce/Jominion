/**
 * 
 */
package cards;

import actions.Action;
import cards.cardInterfaces.ActionCard;
import cards.cardInterfaces.Card;
import cards.cardInterfaces.TreasureCard;
import game.CardType;

import java.util.List;

/**
 * @author piercew6
 *
 */
public class Militia extends Card implements ActionCard, TreasureCard {

	private int treasureValue;
	/**
	 * 
	 */
	public Militia() {
		this.setCost(4);
		this.setName("Militia");
		this.setType(CardType.MILITIA);
		this.treasureValue = 0;
	}
	
	/**
	 * Changes the treasure value of this card to 2. Only valid once
	 * the card is played.
	 */
	public void playMilitiaCard(){
		this.setTreasureValue(2);
	}
	
	/**
	 * Sets the treasure value of this card to the given value.
	 * Should only be used to reset the value of the card after it
	 * is put on the discard pile
	 * @param value
	 */
	public void setTreasureValue(int value){
		this.treasureValue = value;
	}
	
	/**
	 * Will return 0 if card hasn't been played and 2 if it has.
	 * @return
	 */
	public int getTreasureValue(){
		return treasureValue;
	}

	public List<Action> getActions() {
		return null;
	}
}//class
