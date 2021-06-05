package sample;

public class SchoolFootballClubs extends FootballClub  {
    private String schoolName;

    public SchoolFootballClubs(String clubName, String location, String teamManagerName, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, double score, double currentlyPoints, int numberOfMatchesPlayed, String schoolName) {
        super(clubName, location, teamManagerName, numberOfWins, numberOfDraws, numberOfDefeats, numberOfGoalsReceived, score, currentlyPoints, numberOfMatchesPlayed);
        this.schoolName = schoolName;
    }

    public SchoolFootballClubs(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    @Override
    public String toString() {
        return "schoolName :"+schoolName;
    }
}
