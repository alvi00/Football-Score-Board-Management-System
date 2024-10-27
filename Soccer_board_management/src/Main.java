import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        League league = new League();

       
        try {
            league.loadTeamsFromFile("teams.txt");
        } catch (IOException e) {
            System.out.println("Could not load teams: " + e.getMessage());
        }

       
        if (league.getStandings().size() >= 2) {
            Team teamA = league.getStandings().get(0); 
            Team teamB = league.getStandings().get(1); 
            league.scheduleMatch(teamA, teamB, 2, 1); 
        } else {
            System.out.println("Not enough teams to schedule a match.");
        }

        
        league.printStandings();

       
        try {
            league.saveStandingsToFile("standings.txt");
            System.out.println("Standings saved to file.");
        } catch (IOException e) {
            System.out.println("Could not save standings: " + e.getMessage());
        }

        
        league.resetStandings();
        System.out.println("Standings have been reset.");
        
       
        league.printStandings();
    }
}
