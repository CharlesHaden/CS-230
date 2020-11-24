/**
 *
 *
 * @author Hyder Al-Hashimi
 */

public abstract class FloorTile {

    private boolean fixed;
    private int orientation = 0;
    private boolean openPath[];

    public FloorTile(int orientation) {
        this.orientation = orientation;
    }

    public boolean[] getOpenPath() {
        return openPath;
    }

    private void setOpenPath(boolean openPath[]) {

    }

}
