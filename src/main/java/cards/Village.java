/**
 * 
 */
package cards;

import actions.Action;
import cards.cardInterfaces.ActionCard;
import cards.cardInterfaces.Card;
import game.CardType;

import java.util.List;

/**
 * @author Will
 *
 */
public class Village extends Card implements ActionCard {

	/**
	 * 
	 */
	public Village() {
		this.setCost(3);
		this.setName("Village");
		this.setType(CardType.VILLAGE);
	}

	public List<Action> getActions() {
		return null;
	}
}
