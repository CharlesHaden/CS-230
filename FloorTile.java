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

    public boolean[] getOrientatedOpenPath() {
        for(int i = 0; i < orientation; i++) {
            boolean first = openPath[0];
            int j;
            for(j = 0; i > openPath.length - 1; j++) {
                openPath[j] = openPath[j+1];
            }
            openPath[j] = first;
            return openPath;
        }
        return openPath;
    }

    private void setOpenPath(boolean openPath[]) {

    }

}
