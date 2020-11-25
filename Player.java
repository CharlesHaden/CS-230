/**
 * Player Class
 * @author Lewis Hotchkiss
 */

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int playerNum;
	private String orientation;
	private int score;
	private int[][] lastMoves;
	private int[] playerPosition;
	private static ArrayList<Tile> playerHand = new ArrayList<Tile>();
	
	public Player(int playerNum, String orientation, int score, int[][] lastMoves, int[] playerPosition, ArrayList<Tile> playerHand) {
		this.playerNum = playerNum;
		this.orientation = orientation;
		this.score = score;
		this.lastMoves = lastMoves;
		this.playerPosition = playerPosition;
		this.playerHand = playerHand;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	
	public String orientation() {
		return orientation;
	}
	
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int[][] getLastMoves() {
		return lastMoves;
	}
	
	public void setLastMoves(int[][] lastMoves) {
		this.lastMoves = lastMoves;
	}
	
	public int[] getPlayerPosition() {
		return playerPosition;
	}
	
	public void setPlayerPosition(int[] playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	public ArrayList<Tile> getPlayerHand() {
		return playerHand;
	}
	
	public void setPlayerHand(ArrayList<Tile> playerHand) {
		this.playerHand = playerHand;
	}
	
	public void drawTile() {
		Tile tile = Board.getTile();
		
		if (tile.getType().equals("Straight") || tile.getType().equals("Corner") || tile.getType().equals("T-Shaped")) {
			Board.insertTile(tile);
		} 
		else if (tile.getType().equals("Ice") || tile.getType().equals("Fire") || tile.getType().equals("Double")  || tile.getType().equals("Backtrack")) {
			playerHand.add(tile);
		}
	}
	
	public static void playTile(Tile tile) {
		Boolean played = false;
		
		//Displays the action tiles in the players hand
		for (Tile tiles : playerHand) {
			System.out.println(tiles.getType());
		}
		
		Scanner input = new Scanner(System.in);
		
		do {
			//Gets user to choose action tile
			String tileType = input.next();
			System.out.println("Choose action tile to play: ");
		
			//Goes through each tile in the players hand to see if they have that tile to play
			for (Tile tiles : playerHand) {
				//If they have the tile to play then it is removed from their hand and played
				if (tiles.getType().equals(tileType)) {
					playerHand.remove(tiles);
					Board.playActionTile(tileType);
					played = true;
				//If they haven't got that tile to play then they will have to choose again
				} else {
					System.out.println("Cant play that action tile");
					played = false;
				}
			}
		} while (played = false);
		
		input.close();
	}
	
	public void updateLastMoves(int x, int y) {
		//changes one position ago to two positions ago
		lastMoves[1][0] = lastMoves[0][0];
		lastMoves[1][1] = lastMoves[0][1];
		//sets x,y one position ago
		lastMoves[0][0] = x;
		lastMoves[0][1] = y;
	}
	
	public void makeMove(KeyEvent e) {
		/**
		 * if player chooses right
		 * 		check if there is a clear path    (if FloorTile.openPath?)
		 * 		x = x + 1   playerPosition[0] = playerPosition[0] + 1;
		 * 
		 * if player chooses left
		 * 		check if there is a clear path
		 * 		x = x - 1   playerPosition[0] = playerPosition[0] - 1;
		 * 
		 * if player chooses up
		 * 		check if there is a clear path
		 * 		y = y + 1   playerPosition[1] = playerPosition[1] + 1;
		 * 
		 * if player chooses down
		 * 		check if there is a clear path
		 * 		y = y - 1   playerPosition[1] = playerPosition[1] - 1;
		 */
		
		int keyCode = e.getKeyCode();
	    switch (keyCode) { 
	        case KeyEvent.VK_UP:
	        	playerPosition[1] = playerPosition[1] + 1;
	            break;
	        case KeyEvent.VK_DOWN:
	        	playerPosition[1] = playerPosition[1] - 1;
	            break;
	        case KeyEvent.VK_LEFT:
	        	playerPosition[0] = playerPosition[0] - 1;
	            break;
	        case KeyEvent.VK_RIGHT :
	        	playerPosition[0] = playerPosition[0] + 1;
	            break;
	     }

	}
	
}
