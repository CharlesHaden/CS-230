/**
 *
 *
 * @author Hyder Al-Hashimi
 */

public abstract class FloorTile extends Tile {

    private boolean fixed;
    private int orientation = 0;
    protected boolean openPath[];

    public FloorTile(int orientation) {
        this.orientation = orientation;
        this.fixed = false;
    }

    public FloorTile(int orientation, boolean fixed) {
        this.orientation = orientation;
        this.fixed = fixed;
    }

    public boolean[] getOrientatedOpenPath() {
        for(int i = 0; i < orientation; i++) {
            boolean first = openPath[0];
            int j;
            for(j = 0; j < openPath.length-1; j++) {
                openPath[j] = openPath[j+1];
            }
            openPath[j] = first;
            return openPath;
        }
        return openPath;
    }

    public String getTileType(){
        return "Floor";
    }

    public abstract String getFloorTileType();

}
