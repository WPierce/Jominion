package cards;

import cards.cardInterfaces.Card;
import cards.cardInterfaces.VictoryCard;
import game.CardType;
/**
 * 
 */

/**
 * @author piercew6
 *
 */
public class Province extends Card implements VictoryCard {

	private int victoryValue;
	
	/**
	 * 
	 */
	public Province() {
		this.setCost(8);
		this.setVictoryValue(6);
		this.setName("Province");
		this.setType(CardType.PROVINCE);
	}

	@Override
	public int getVictoryValue() {
		return victoryValue;
	}

	@Override
	public void setVictoryValue(int victoryValue) {
		this.victoryValue = victoryValue;
	}

}
