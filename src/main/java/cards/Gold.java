/**
 * 
 */
package cards;

import cards.cardInterfaces.Card;
import cards.cardInterfaces.TreasureCard;
import game.CardType;

/**
 * @author piercew6
 *
 */
public class Gold extends Card implements TreasureCard {

	private int treasureValue;
	
	/**
	 * 
	 */
	public Gold() {
		this.setCost(6);
		this.setTreasureValue(3);
		this.setName("Gold");
		this.setType(CardType.GOLD);
	}

	@Override
	public int getTreasureValue() {
		return this.treasureValue;
	}

	@Override
	public void setTreasureValue(int treasureValue) {
		this.treasureValue = treasureValue;
	}

}//Gold
