/** 
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/
public class Fire extends actionTile {
    public void action() {
        int tileNum; //get tile position - 1D array
        int col = getTileColumn(tileNum);
        int row = getTileRow(tileNum);
        for (int x = col-1; x < col+2; x++) {
            for (int y = row - 1; y < row + 2; y++) {
                Board.getTile((Board.getWidth()*y) + x).setState(1);
            }
        }
         

    }  

    public Boolean isPlayable() {
        //check for any tile on the edge
        int tileNum; 
        int col = getTileColumn(tileNum);
        int row = getTileRow(tileNum);
        if (col == 0 || col == Board.getWidth()-1 ||
        row == 0 || row == Board.getHeight()-1) {
            System.out.println("This action cannot be made here.");
            return false;
        }
        // if player is on one of the selected tiles

    }
    
    public String getActionTileType() {
        return "Fire";

}