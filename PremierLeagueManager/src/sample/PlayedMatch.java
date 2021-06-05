package sample;

import java.io.Serializable;

public class PlayedMatch implements Serializable {
    String winningTeamName;
    String defeatTeamName;
    int goals;
    int score;
    Date date;




    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public PlayedMatch(String winningTeamName, String defeatTeamName, int goals , int score, Date date) {
        this.winningTeamName = winningTeamName;
        this.defeatTeamName = defeatTeamName;
        this.goals=goals;
        this.score=score;
        this.date = date;
    }


    public  PlayedMatch (){

    }

    public String getWinningTeamName() {
        return winningTeamName;
    }

    public void setWinningTeamName(String winningTeamName) {
        this.winningTeamName = winningTeamName;
    }

    public String getDefeatTeamName() {
        return defeatTeamName;
    }

    public void setDefeatTeamName(String defeatTeamName) {
        this.defeatTeamName = defeatTeamName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "winningTeamName='" + winningTeamName +
                ", defeatTeamName='" + defeatTeamName +
                ", date=" + date ;
    }

}
