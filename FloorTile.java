/**
 *
 *
 * @author Hyder Al-Hashimi
 */


abstract class FloorTile {

    private Boolean fixed;
    private Integer orientation = 0;
    private Boolean[] openPath;

    public Boolean[] getOpenPath() {
        return openPath;
    }

}
