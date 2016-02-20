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
public class Duchy extends Card implements VictoryCard {

	private int victoryValue;
	
	/**
	 * 
	 */
	public Duchy() {
		this.setCost(5);
		this.setVictoryValue(3);
		this.setName("Duchy");
		this.setType(CardType.DUCHY);
	}

	@Override
	public int getVictoryValue() {
		// TODO Auto-generated method stub
		return this.victoryValue;
	}

	@Override
	public void setVictoryValue(int victoryValue) {
		this.victoryValue = victoryValue;
	}

}
