/**
 * 
 */
package actions;


/**
 * @author Will
 * Action factory responsible for constructing a single instance of each of the actions in this game.
 * The actions are then passed to the action cards.
 */
public class ActionFactory {
	
	Action discardCardsAction;

	/**
	 * Empty constructor
	 */
	public ActionFactory() {
	}
	
	public Action getDiscardCardsAction(){
		if(discardCardsAction == null){
			discardCardsAction = createAction(ActionType.DISCARDCARDSACTION);
		}
		
		return discardCardsAction;
	}

	private Action createAction(ActionType actionType) {
		switch (actionType) {
		case DISCARDCARDSACTION:
			discardCardsAction = new DiscardCardsAction();
			break;
		default:
			break;
		}
		return discardCardsAction;
	}
	
	/*public List<Action> createActions(){
		
		Action discardCardAction = new DiscardCardsAction();
		List<Action> actionsList = new ArrayList<>();
		actionsList.add(discardCardAction);
		
		return actionsList;
	}*/

}
