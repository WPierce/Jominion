package cards.cardInterfaces;
import game.CardType;

import java.awt.Image;

/**
 * 
 */

/**
 * @author piercew6
 *
 */
public abstract class Card {
	
	private int cost;
	private String name;
	private Image cardImage;
	private CardType type;

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the cardImage
	 */
	public Image getCardImage() {
		return cardImage;
	}

	/**
	 * @param cardImage the cardImage to set
	 */
	public void setCardImage(Image cardImage) {
		this.cardImage = cardImage;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return the type
	 */
	public CardType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(CardType type) {
		this.type = type;
	}

}
