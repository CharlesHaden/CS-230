/** 
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/

public class IceTile extends ActionTile<int[]> {

    public void action(int[] chosenTile) {

    }

    public boolean isPlayable(int[] chosenTile) {
        return true;
    }

    public String getActionTileType(){
        return "Ice";
    }
}