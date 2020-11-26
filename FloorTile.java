/**
 *
 *
 * @author Nim Man
 * @author Hyder Al-Hashimi
 */

public abstract class FloorTile extends Tile {

    private int state; // 0 for normal, 1 on fire, 2 frozen 
    private boolean fixed;
    private int orientation;
    protected boolean openPath[];

    public FloorTile(int orientation) {
        this.orientation = orientation;
        this.fixed = false;
        setOpenPath();
    }

    public FloorTile(int orientation, boolean fixed) {
        this.orientation = orientation;
        this.fixed = fixed;
        setOpenPath();
    }

    public void setOpenPath() {
        for(int i = 0; i < orientation; i++) {
            boolean first = openPath[0];
            int j;
            for(j = 0; j < openPath.length-1; j++) {
                openPath[j] = openPath[j+1];
            }
            openPath[j] = first;
        }
    }

    public boolean[] getOpenPath(){
        return openPath;
    }

    public String getTileType(){
        return "Floor";
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public abstract String getFloorTileType();

}
