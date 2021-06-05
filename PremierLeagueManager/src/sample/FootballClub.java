package sample;

public class FootballClub extends SportsClub {
    private int numberOfWins;
    private  int numberOfDraws;
    private int numberOfDefeats;
    private int numberOfGoalsReceived;
    private double score;
    private double currentlyPoints;
    private int numberOfMatchesPlayed;


    public FootballClub(String clubName, String location, String teamManagerName, int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, double score, double currentlyPoints, int numberOfMatchesPlayed) {
        super(clubName, location, teamManagerName);
        this.numberOfWins = numberOfWins;
        this.numberOfDraws = numberOfDraws;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.score = score;
        this.currentlyPoints = currentlyPoints;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public FootballClub(){
        super();
    }


    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getCurrentlyPoints() {
        return currentlyPoints;
    }

    public void setCurrentlyPoints(double currentlyPoints) {
        this.currentlyPoints = currentlyPoints;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }


    @Override
    public String toString() {
        return  ", Club name :"+getClubName()+
                ", Location :"+getLocation()+
                ", team manager name :"+getTeamManagerName()+
                ", numberOfWins : "+numberOfWins+
                ", numberOfDraws : "+numberOfDraws+
                ", numberOfDefeats :"+numberOfDefeats+
                ", numberOfGoalsReceived :"+numberOfGoalsReceived+
                ", score :"+score+
                ", currentlyPoints :"+currentlyPoints+
                ", numberOfMatchesPlayed :"+numberOfMatchesPlayed;

    }
}
