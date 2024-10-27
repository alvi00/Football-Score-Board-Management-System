public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public void playMatch() {
        homeTeam.incrementMatchesPlayed();
        awayTeam.incrementMatchesPlayed();
    
        // Update goal difference
        homeTeam.updateGoalDifference(homeScore - awayScore);
        awayTeam.updateGoalDifference(awayScore - homeScore);
    
        if (homeScore > awayScore) {
            homeTeam.addPoints(3);
        } else if (homeScore < awayScore) {
            awayTeam.addPoints(3);
        } else {
            homeTeam.addPoints(1);
            awayTeam.addPoints(1);
        }
    }
    
}
