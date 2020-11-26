/**
 * This works as the main menu for starting and saving games as well as creating and deleting profiles.
 *
 * @author Charles Haden
 * @author Mathew Clarke
 */

import java.util.ArrayList;

public class MainMenu {
    private String[] currentGame;
    private String[] presetBoards;
    ArrayList<Profile> profileList = new ArrayList<Profile>();

    public MainMenu() {

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
     * Saves the current game state 22222222222222222to txt file
     */
    public void saveBoard() {

    }

    /**
     * Opens a game state from a save file.
     *
     * @return the game state from the save file
     */
    public String[] loadBoard() {
        return(null);

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
        return(null);
    }

    /**
     * Creates a new profile
     *
     */
    public void createProfile(String name){
        Profile profile1 = new Profile(name);
        profileList.add(profile1);
    }


    /**
     * deletes a profile
     */
    public void deleteProfile() {

    }

}
