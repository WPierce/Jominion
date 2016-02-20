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
public class Estate extends Card implements VictoryCard {

	private int victoryValue;
	
	/**
	 * 
	 */
	public Estate() {
		this.setCost(2);
		this.setVictoryValue(1);
		this.setName("Estate");
		this.setType(CardType.ESTATE);
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
