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
public class Silver extends Card implements TreasureCard {

	private int treasureValue;
	
	/**
	 * 
	 */
	public Silver() {
		this.setCost(0);
		this.setTreasureValue(2);
		this.setName("Silver");
		this.setType(CardType.SILVER);
	}

	@Override
	public int getTreasureValue() {
		return this.treasureValue;
	}

	@Override
	public void setTreasureValue(int treasureValue) {
		this.treasureValue = treasureValue;
	}

}
