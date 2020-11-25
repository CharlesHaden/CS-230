/**
 * Player Class
 * @author Lewis Hotchkiss
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int playerNum;
	private String orientation;
	private int score;
	private int[][] lastMove;
	private int[] playerPosition;
	private static ArrayList<Tile> playerHand = new ArrayList<Tile>();
	
	public Player(int playerNum, String orientation, int score, int[][] lastMove, int[] playerPosition, ArrayList<Tile> playerHand) {
		this.playerNum = playerNum;
		this.orientation = orientation;
		this.score = score;
		this.lastMove = lastMove;
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
	
	public int[][] getLastMove() {
		return lastMove;
	}
	
	public void setLastMove(int[][] lastMove) {
		this.lastMove = lastMove;
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
	
	
	public void makeMove() {
		//player chooses direction to move in - needs to return which key pressed?
		//player position change 
		//check if surrounding tiles are frozen
		
	}
	
}
