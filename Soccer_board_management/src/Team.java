public class Team {
    private String name;
    private int points;
    private int matchesPlayed;
    private int goalDifference; 

    public Team(String name) {
        this.name = name;
        this.points = 0;
        this.matchesPlayed = 0;
        this.goalDifference = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void incrementMatchesPlayed() {
        this.matchesPlayed++;
    }

    public void updateGoalDifference(int goalDifference) {
        this.goalDifference += goalDifference; 
    }

    public void reset() {
        this.points = 0;
        this.matchesPlayed = 0;
        this.goalDifference = 0; 
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getGoalDifference() {
        return goalDifference; 
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", matchesPlayed=" + matchesPlayed +
                ", goalDifference=" + goalDifference +
                '}';
    }
}
