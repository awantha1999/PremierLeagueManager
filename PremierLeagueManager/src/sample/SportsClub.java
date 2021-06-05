package sample;



import java.io.Serializable;


public class SportsClub implements Serializable {
    private String clubName;
    private String location;
    private String teamManagerName;


    public SportsClub(String clubName, String location, String teamManagerName) {
        this.clubName = clubName;
        this.location = location;
        this.teamManagerName = teamManagerName;
    }

    public SportsClub() {


    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamManagerName() {
        return teamManagerName;
    }

    public void setTeamManagerName(String teamManagerName) {
        this.teamManagerName = teamManagerName;
    }


    @Override
    public String toString() {
        return "club Name : " + clubName +", location : " + location +", teamManagerName : " + teamManagerName ;
    }

}

