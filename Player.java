import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int playerNum;
	private String orientation;
	private int score;
	private int[][] lastMove;
	private int[][] playerPosition;
	private static ArrayList<Tile> playerHand = new ArrayList<Tile>();
	
	public Player(int playerNum, String orientation, int score, int[][] lastMove, int[][] playerPosition, ArrayList<Tile> playerHand) {
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
	
	public int[][] getPlayerPosition() {
		return playerPosition;
	}
	
	public void setPlayerPosition(int[][] playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	public ArrayList<Tile> getPlayerHand() {
		//Tile fireTile = new Tile("Fire",false,false,false,"North"); FOR TESTING PURPOSES
		//playerHand.add(fireTile);
		//for (Tile tile2 : playerHand) {
		//	System.out.println(tile2.getType());
		return playerHand;
	}
	
	public void setPlayerHand(ArrayList<Tile> playerHand) {
		this.playerHand = playerHand;
	}
	
	public void drawTile() {
		Tile tile = Board.getTile();
		
		// if tile is floor than play tile
		if (tile.getType().equals("Straight") || tile.getType().equals("Corner") || tile.getType().equals("T-Shaped")) {
			Board.insertTile(tile);
		}
		// else if tile is action then add to hand
		if (tile.getType().equals("Ice") || tile.getType().equals("Fire") || tile.getType().equals("Double")  || tile.getType().equals("Backtrack")) {
			playerHand.add(tile); //Add tile to players hand
		}
	}
	
	public static void playTile(Tile tile) {
		//Play action tile
		//Allow player to choose tile from arraylist
		for (Tile tiles : playerHand) {
			System.out.println(tiles.getType());
		}
		
		Scanner input = new Scanner(System.in);
		String tileType = input.next();
		System.out.println("Choose action tile to play: ");
		
		for (Tile tiles : playerHand) {
			if (tiles.getType().equals(tileType)) {
				playerHand.remove(tiles); //Need to set tile to played?
				Board.playActionTile(tileType);
			} else {
				System.out.println("Cant play that action tile"); //Make into error checking (do while loop?)
			}
		}
		
		input.close();
	}
	
	
	public void makeMove() {
		//player chooses direction to move in - needs to return which key pressed?
		//player position change 
		//check if surrounding tiles are frozen
	}
}
