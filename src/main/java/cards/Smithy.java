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
 * @author piercew6
 *
 */
public class Smithy extends Card implements ActionCard {

	/**
	 * 
	 */
	public Smithy() {
		this.setCost(4);
		this.setName("Smithy");
		this.setType(CardType.SMITHY);
	}

	public List<Action> getActions() {
		return null;
	}
}
