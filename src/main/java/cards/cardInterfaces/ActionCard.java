package cards.cardInterfaces;

import java.util.List;

import actions.Action;


/**
 * 
 */

/**
 * @author piercew6
 *
 */
public interface ActionCard {

	//TODO: put in an abstract method here which allows the card to be played
	public List<Action> getActions();
}
