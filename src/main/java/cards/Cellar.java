/**
 * 
 */
package cards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import actions.Action;
import cards.cardInterfaces.ActionCard;
import cards.cardInterfaces.Card;
import game.CardType;

/**
 * @author Will
 *
 */
public class Cellar extends Card implements ActionCard {

	Action cellarAction;
	
	/**
	 * 
	 */
	public Cellar(Action cellarAction) {
		this.setCost(2);
		this.setName("Cellar");
		this.setType(CardType.CELLAR);
		this.cellarAction = cellarAction;
	}

	@Override
	public List<Action> getActions() {
		List<Action> actionsList = new LinkedList<Action>();
		actionsList.add(cellarAction);
		return actionsList;
	}

}
