import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class League {
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public League() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void scheduleMatch(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        Match match = new Match(homeTeam, awayTeam, homeScore, awayScore);
        matches.add(match);
        match.playMatch();
    }

    public List<Team> getStandings() {
        teams.sort((team1, team2) -> {
            int pointComparison = Integer.compare(team2.getPoints(), team1.getPoints());
            return (pointComparison != 0) ? pointComparison : Integer.compare(team2.getGoalDifference(), team1.getGoalDifference());
        });
        return teams;
    }

    public void printStandings() {
        System.out.println("League Standings:");
        for (Team team : getStandings()) {
            System.out.println(team);
        }
    }

    public void resetStandings() {
        for (Team team : teams) {
            team.reset(); // Call reset method in Team class
        }
        matches.clear();
    }

    public void saveStandingsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Team team : getStandings()) {
                writer.write(team.toString());
                writer.newLine();
            }
        }
    }

    public void loadTeamsFromFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            // Create the file and add default teams
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Team A");
                writer.newLine();
                writer.write("Team B");
                writer.newLine();
                writer.write("Team C");
                writer.newLine();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addTeam(new Team(line.trim()));
            }
        }
    }
}
