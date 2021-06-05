package sample;

public class UniversityFootballClub extends FootballClub{
    private  String universityName;

    public UniversityFootballClub(String clubName, String location, String teamManagerName, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, double score, double currentlyPoints, int numberOfMatchesPlayed, String universityName) {
        super(clubName, location, teamManagerName, numberOfWins, numberOfDraws, numberOfDefeats, numberOfGoalsReceived, score, currentlyPoints, numberOfMatchesPlayed);
        this.universityName = universityName;
    }

    public UniversityFootballClub(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    @Override
    public String toString() {
        return "universityName :"+universityName;
    }

}
