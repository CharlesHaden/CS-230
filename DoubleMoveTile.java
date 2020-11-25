import java.awt.event.KeyEvent;

/**
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/

public class DoubleMoveTile extends actionTile<Player, KeyEvent> {

    public void action(Player player, KeyEvent e) {
        if(isPlayable(player)){

        }
    } 
    
    public boolean isPlayable(Player player) {
        return true;
    }

    public String getActionTileType() {
        return "Double Move";
    }
}