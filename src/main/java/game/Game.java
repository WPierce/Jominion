package game;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author piercew6
 *
 */
public class Game implements Runnable{
	
	//Stores the players in the game
	private List<Player> players;
	
	private GameDeck gamedeck;
	
	//Stores whether game is over
	private boolean gameFinished;
	
	//Temporary variable until I work out how to end things gracefully
	private boolean hasPrintedOutput = false;
	
	/**
	 * Constructor
	 */
	public Game() {
		players = new ArrayList<Player>();
		this.gameFinished = false;
		this.setGamedeck(new GameDeck());
	}//Constructor

	/**
	 *
	 * @param player the player to add
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * @return the gameFinished
	 */
	public boolean isGameFinished() {
		return gameFinished;
	}

	/**
	 * @param gameFinished the gameFinished to set
	 */
	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}
	
	public void run() {
		for (Player player : players) {
			player.shuffleDeck();
		}
		
		while (!gameFinished) {
			System.out.println("Game is running!");
			
			//Take each players turn
			for (Player player : players) {
				System.out.println(player.getName());
				player.takeTurn();
				System.out.println();
				
				if (gamedeck.numberOfCard(CardType.PROVINCE) == 0) {
					gameFinished = true;
				}
				
				if(gameFinished && hasPrintedOutput == false){
					System.out.println("Game is finished, we're exiting!");
					Player winner = null;
					int winningPoints = 0;
					boolean draw = false;
					for (Player p: players) {
						int playerVictoryPoints = p.getVictoryValue();
						System.out.println(p.getName() + " " + playerVictoryPoints);
						//TODO: If players have equal points p1 always wins
						if(playerVictoryPoints > winningPoints){
							winner = p;
							winningPoints = playerVictoryPoints;
						} else if (playerVictoryPoints == winningPoints) {
							draw = true;
						}
					}
					
					if (draw) {
						System.out.println("Game was a draw! Both players had " + winningPoints + " points");
					} else {
						System.out.println("Winner was " + winner.getName() + " with " + winningPoints + " points!");
					}
					
					hasPrintedOutput = true;
					//System.exit(0);
				}
			}
			
			//sleep the thread
			/*try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}//while
	}//run

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedList<Game> games = new LinkedList<Game>();
		
		for (int i = 0; i < 1000; i++) {
			Game game = new Game();
			
			game.getGamedeck().addCardType(CardType.COPPER, 60);
			game.getGamedeck().addCardType(CardType.SILVER, 40);
			game.getGamedeck().addCardType(CardType.GOLD, 30);
			game.getGamedeck().addCardType(CardType.PROVINCE, 8);
			//game.getGamedeck().addCardType(CardType.SMITHY, 10);
			game.getGamedeck().addCardType(CardType.CELLAR, 10);
			
			Player willyp = new BigSmithyPlayer("WillyP", game.getGamedeck());
			Player mort = new BigMoneyPlayer("Mort", game.getGamedeck());
			
			
			game.addPlayer(willyp);
			game.addPlayer(mort);
			
			games.add(game);
		}
		
		int i = 0;
		for (Game game : games) {
			System.out.println("Starting game " + i);
			new Thread(game). start ( );
			i++;
		}
	}

	/**
	 * @return the gamedeck
	 */
	public GameDeck getGamedeck() {
		return gamedeck;
	}

	/**
	 * @param gamedeck the gamedeck to set
	 */
	public void setGamedeck(GameDeck gamedeck) {
		this.gamedeck = gamedeck;
	}


}
