/**
 * This works as the leader board for viewing the wins and losses of players with assigned profiles in the game.
 *
 * @author Charles Haden
 * @author Mathew Clarke
 */
public class LeaderBoard {
	
	//Used to store which order to display the profiles. 
	private Profile[] profileList;
	//Used to store which order to display the profiles.  
	private boolean ascending = true;
	//Used in the bubble sort
	private boolean sorted;
	private Profile temp;
	
	/**
	 * Constructs a LeaderBoard object and does't take any parameters.
	 */
	public LeaderBoard(Profile[] profileList) {
		this.profileList = profileList;
	}
	
	/**
	 * Used as a getter for list of profiles.
	 * 
	 * @return Return type is an array of strings and is the profileList.
	 */
    public Profile[] getProfileList() {
        return profileList;
    }
    
	/**
	 * Used as a setter for list of profiles.
	 * 
	 * @param profileList Stores the array of strings used to store the profile classes
	 */
    public void setProfileList(Profile[] profileList) {
        this.profileList = profileList;
    }
    
	/**
	 * Returns all profiles in the current array/list with their associated wins and losses.
	 * 
	 * Side effects: changes stored profileList in LeaderBoard as opposed to just returning it
	 * @return Returns the sorted profile list in either ascending or descending order.
	 */
	public Profile[] sortBy() {
		// Bubble sort as array is likely to be small
		sorted = false;
		while(!sorted) {
			sorted = true;
			for (int i = 0; i < profileList.length - 1; i++) {
				if ((profileList[i].getWins() > profileList[i+1].getWins()) ^ !ascending) {
					temp = profileList[i];
					profileList[i] = profileList[i+1];
					profileList[i+1] = temp;
					sorted = false;
				}
			}
		}
		return profileList;
	}

}
