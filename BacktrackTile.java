/**
 * 
 * 
 * @author Nim Man
 * @author Hyder Al-Hashimi
*/

public class BacktrackTile extends actionTile<Player, int[]>  {

    public void action(Player player, int[] twoMovesAgo) {
        if(isPlayable(player)){
            player.setPlayerPosition(twoMovesAgo);
        }
    }

    public boolean isPlayable(Player player) {
        int[][] lastMoves = player.getLastMoves();
        int[] twoMovesAgo = {lastMoves[1][0], lastMoves[1][1]};
        //need a way to find out which tiles have fire or ice on them
        if (Board.getTile(twoMovesAgo) == "Fire"){
            return false;
        }
        else if (player.getLastMoves() == null){
            return false;
        }
        else {
            return true;
        }
    }

    public String getActionTileType() {
        return "Backtrack";
    }
}
