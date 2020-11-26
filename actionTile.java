/** 
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/

abstract class actionTile extends Tile {
    public abstract void action();
    public abstract Boolean isPlayable();
    public abstract String getActionTileType();


    public String getTileType() {
        return "Action Tile";

    }

    public int getTileRow(int tileNum) {
        int height = Board.getHeight();  
        return tileNum /  height;

    }

    public int getTileColumn(int tileNum) {
        int width = Board.getWidth();
        return tileNum % width;
    }
}


 


    

    
        
