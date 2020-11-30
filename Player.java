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
		Tile tile = Board.drawTile();
		
		if (tile.getTileType().equals("Floor")) {
			Board.insertTile(tile);//might need to add where player wants to insert tile?
		} 
		else if (tile.getTileType().equals("Action")) {
			playerHand.add(tile);
		}
	}
	
	public static void playTile(Tile tile) {
		Boolean played = false;
		
		//Displays the action tiles in the players hand
		for (Tile tiles : playerHand) {
			System.out.println(tiles.getActionTileType());
		}
		
		Scanner input = new Scanner(System.in);
		
		do {
			//Gets user to choose action tile
			String tileType = input.next();
			System.out.println("Choose action tile to play: ");
		
			//Goes through each tile in the players hand to see if they have that tile to play
			for (Tile tiles : playerHand) { //WARNING: may loop through and remove several tiles of same type
				//If they have the tile to play then it is removed from their hand and played
				if (tiles.getActionTileType().equals(tileType)) {
					tiles.action();
					playerHand.remove(tiles);
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
		boolean moved = false;
		//Do while player not moved
		//Tile currentTile = currentTile.getTile(playerPosition[0], playerPosition[1]);
		Tile currentTile = Board.getTile(playerPosition[0], playerPosition[1]);
		Boolean[] currentTileOpenPath = currentTile.getOpenPath();
		
		do {
			int keyCode = e.getKeyCode();
		    switch (keyCode) { 
		        case KeyEvent.VK_UP:
		        	movePlayer(currentTileOpenPath, playerPosition[0], playerPosition[1] + 1, 0, 1);
		            break;
		        case KeyEvent.VK_DOWN:
		        	movePlayer(currentTileOpenPath, playerPosition[0], playerPosition[1] - 1, 1, 0);
		            break;
		        case KeyEvent.VK_LEFT:
		        	movePlayer(currentTileOpenPath, playerPosition[0] - 1, playerPosition[1], 2, 3);
		            break;
		        case KeyEvent.VK_RIGHT:
		        	movePlayer(currentTileOpenPath, playerPosition[0] + 1, playerPosition[1], 3, 2);
		            break;
		     }
		} while (moved == false);
		
	}
	
	public boolean movePlayer(Boolean[] currentTileOpenPath, int x, int y, int currentPath, int nextPath) {
		Boolean moved = false;
		Tile nextTile = Board.getTile(x, y);
    	Boolean[] nextTileOpenPath = nextTile.getOpenPath();

    	if ((currentTileOpenPath[currentPath] = true) && (nextTileOpenPath[nextPath] = true)) {
    		if ((nextTile.getOnFire().equals(true)) || (checkForPlayers(x, y) == true)) {
    			moved = false;
    		} else {
    			playerPosition[0] = x;
	        	playerPosition[1] = y;
	        	moved = true;
    		}
    	}
		return moved;
	}
	
	public boolean checkForPlayers(int x, int y) {
		boolean playerOnTile = false;
		Player players[] = Board.getPlayers(); 
		int i;
  
        for (i = 0; i < players.length; i++) { 
        	int otherPlayerPosition[] = players[i].getPlayerPosition();
        	if ((otherPlayerPosition[0] == x && otherPlayerPosition[1] == y + 1) ||
        			(otherPlayerPosition[0] == x && otherPlayerPosition[1] == y - 1) ||
        			(otherPlayerPosition[0] == x + 1 && otherPlayerPosition[1] == y) ||
        			(otherPlayerPosition[0] == x - 1 && otherPlayerPosition[1] == y)) {
        		
        		playerOnTile = true;
        	}
        	else {
        		playerOnTile = false;
        	}
        } 
		
		return playerOnTile;
	}
	
}
