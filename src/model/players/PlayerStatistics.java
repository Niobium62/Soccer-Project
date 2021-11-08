package model.players;

public class PlayerStatistics {

    private int statistics;

    public Integer getStatistics() {
        return statistics;
    }

    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return String.valueOf(statistics);
    }
}
