package cards;

import cards.cardInterfaces.Card;
import cards.cardInterfaces.TreasureCard;
import game.CardType;

/**
 * 
 */

/**
 * @author piercew6
 *
 */
public class Copper extends Card implements TreasureCard {
	
	private int treasureValue;

	/**
	 * 
	 */
	public Copper() {
		this.setCost(0);
		this.setName("Copper");
		
		this.setTreasureValue(1);
		this.setType(CardType.COPPER);
	}//Constructor

	@Override
	public int getTreasureValue() {
		// TODO Auto-generated method stub
		return this.treasureValue;
	}

	@Override
	public void setTreasureValue(int treasureValue) {
		this.treasureValue = 1;
	}

}//Copper
