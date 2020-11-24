/**
 *
 *
 * @author Hyder Al-Hashimi
 */


public class CornerTile extends FloorTile {

    boolean openPath[] = new boolean[] {false, true, true, false};

    public CornerTile(int orientation) {
        super(orientation);
    }
}
