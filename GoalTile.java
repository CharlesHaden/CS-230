/**
 *
 *
 * @author Hyder Al-Hashimi
 */

public class GoalTile extends FloorTile {

    public GoalTile(int orientation) {
        super(orientation);
        openPath =  new boolean[] {true, true, true, true};
    }
}
