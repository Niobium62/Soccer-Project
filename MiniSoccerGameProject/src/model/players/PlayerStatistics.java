package model.players;

/**
 * PlayerStatistics is the object which stores the important statistic of a player in our Mini-Soccer Game.
 * 
 * @author Roberto Shino
 * @author Arian Mohamad Hosaini
 * @author Wenjing Qu
 */
public class PlayerStatistics {

    private int statistics;

    /**
     * Gets the current value of the player's statistic.
     * 
     * @return	<code>Integer</code>	the integer representing the player's statistic
     */
    public Integer getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the player's statistic to the given value.
     * 
     * @param statistics	the new desired statistic value
     */
    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    /**
     * Returns the value of the player's statistic as a string.
     * 
     * @return	</code>String</code>	value of statistic as a string
     */
    @Override
    public String toString() {
        return String.valueOf(statistics);
    }
}
