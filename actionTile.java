/** 
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/

abstract class actionTile<T, R> extends Tile {

    public abstract void action(T t, R r);

    public abstract boolean isPlayable(T t);

    public abstract String getActionTileType();

    public String getTileType() {
        return "Action Tile";
    }

}


 


    

    
        
