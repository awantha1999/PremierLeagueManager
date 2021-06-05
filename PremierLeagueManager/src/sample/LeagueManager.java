package sample;

public interface LeagueManager {
    public void createSportClub(SportsClub sportsClub);
    public void deleteClub(String clubname);
    public void addPlayedMatch(String team1, int goals, double score, String team2, Date date);
    public void displayPremierLeagueTable();
    public void displayStatisticsSelectedClub(String displayClub);
    public void console();
    public void loadarray();


}
