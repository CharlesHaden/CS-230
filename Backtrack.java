/** 
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/
public class Backtrack extends actionTile {

    public void action(Player player) {
        if (Board.getTile(player.getLastMoves() == "Fire")){
            System.out.println("This action cannot be made");
        }
        else if (player.getLastMoves() == null){
            System.out.println("This action cannot be made");
        }
        else {
            player.setPlayerPosition(player.getLastMoves());
        }
    }  

    public void isPlayable() {
        return true;
    }
}
