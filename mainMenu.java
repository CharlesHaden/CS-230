/**
 * This works as the main menu for starting and saving games as well as creating and deleting profiles.
 *
 * @author Charlie Haden
 * @author Mathew Clarke
 */
public class mainMenu {
    private String[] currentGame;
    private String[] presetBoards;

    public mainMenu() {

    }

    public String[] getCurrentGame() {
        return currentGame;
    }

    public String[] getPresetBoards() {
        return presetBoards;
    }

    public void setCurrentGame(String[] currentGame) {
        this.currentGame = currentGame;
    }

    public void setPresetBoards(String[] presetBoards) {
        this.presetBoards = presetBoards;
    }

    /**
     * Saves the current game state to txt file
     */
    public void saveBoard() {

    }

    /**
     * Opens a game state from a save file.
     *
     * @return the game state from the save file
     */
    public String[] loadBoard() {

    }

    /**
     * Starts the game
     */
    public void startGame() {

    }

    /**
     * returns an array for the leaderboard
     *
     * @return leaderboard array
     */
    public String[] displayLeaderBoard() {

    }

    /**
     * Creates a new profile
     */
    public void newProfile() {

    }

    /**
     * deletes a profile
     */
    public void deleteProfile() {

    }

}