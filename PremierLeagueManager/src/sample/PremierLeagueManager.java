package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PremierLeagueManager implements  LeagueManager{

    //Sports clubs details are store in this array as objects.
    private ArrayList<SportsClub> allClubs=new ArrayList();

    //played matches details store in this array as objects.
    private ArrayList<PlayedMatch> played_matches=new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    @Override
    public void console() {

        //read the text file and load the data into the arrays.
        loadarray();

        while (true){

            try{

                System.out.println("***** Sport Club *****");
                System.out.println("1) Create a new football club");
                System.out.println("2) Delete an existing club");
                System.out.println("3) Display various statistics selected club");
                System.out.println("4) Display premier league table");
                System.out.println("5) Add a played match");
                System.out.println("6) Saving data into a text file");
                System.out.println("7) GUI");
                System.out.println("8) Quit");

                System.out.println(" ");




                System.out.print("Enter the input :");
                int input_1 = sc.nextInt();

                //creating a new football club by user.
                if (input_1 == 1) {


                    System.out.print("Enter club name :");
                    String club_name = sc.next();                   //the club name given by the user is saved to the 'club_name' variable.

                    System.out.print("Enter location :");
                    String location = sc.next();                    //the club location given by the user is saved to the 'location' variable.

                    System.out.print("Enter team manager name :");
                    String team_manager_name = sc.next();           //the club team manager name given by the user is saved to the 'location' variable.



                    while (true) {
                        try {
                            System.out.print("Enter number of wins matches :");
                            int no_wins_matches = sc.nextInt();                   //the number of win matches of the club  given by the user is saved to the 'no_wins_matches' variable.

                            System.out.print("Enter number of draw matches :");
                            int no_draw_matches = sc.nextInt();                   //the number of draw matches of the club  given by the user is saved to the 'no_draw_matches' variable.

                            System.out.print("Enter number of defeat matches :");
                            int no_defeat_matches = sc.nextInt();                 //the number of defeat matches of the club  given by the user is saved to the 'no_defeat_matches' variable.

                            System.out.print("Enter number of goals received :");
                            int no_received_goals = sc.nextInt();                 //the number of received goal  of the club  given by the user is saved to the 'no_received_goals' variable.

                            System.out.print("Enter score :");
                            double score = sc.nextDouble();                       //the number of score  of the club  given by the user is saved to the 'score' variable.

                            System.out.print("Enter current points :");
                            double points = sc.nextDouble();                      //the number of points  of the club  given by the user is saved to the 'points' variable.

                            System.out.print("Enter number of matches played :");
                            int played_matches = sc.nextInt();                    //the number of played_matches of the club  given by the user is saved to the 'played_matches' variable.

                            FootballClub sportsClub=new FootballClub(club_name,location,team_manager_name,no_wins_matches,no_draw_matches,no_defeat_matches,no_received_goals,score,points,played_matches);  //creating a object of FootballClub
                            createSportClub(sportsClub);
                            break;

                        } catch (Exception e) {
                            System.out.println("Invalid input!Try again");    //if user enter wrong input, then this massage will be prompt.
                            sc.next();

                        }
                    }
                }
                if(input_1==2) {
                    System.out.print("Enter name of the  club :");
                    String delete_club_name = sc.next();                //the  name of the delete club given by user is saved to the  'delete_club_name' variable.
                    deleteClub(delete_club_name);                       //call the deleteClub() method with parameter.
                }

                if(input_1==3){
                    System.out.print("Enter the club name :");
                    String dis_static=sc.next();                        //the  name of the club given by user is saved to the  'dis_static' variable.
                    displayStatisticsSelectedClub(dis_static);          //call the displayStatisticsSelectedClub() method with parameter.
                }

                if(input_1==4){
                    displayPremierLeagueTable();                        //call the   displayPremierLeagueTable() method with no parameter.
                }

                if(input_1==5){

                    //Adding a played match

                    System.out.print("Enter  winning team  name :");
                    String team1=sc.next();                                                  //add the winning team name of played match to 'team1' variable.

                    System.out.print("Enter number of goals received (winning team) :");
                    int team1_goals =sc.nextInt();                                           //add the winning team goals  of played match to 'team1_goals' variable.

                    System.out.print("Enter the score (winning team) :");
                    double team1_score=sc.nextDouble();                                      //add  the winning team score of played match to 'team1_score' variable.

                    System.out.print("Enter defeat team  name :");
                    String team2=sc.next();                                                  //add the name of the defeat team name to 'team2' variable.

                    Date date_1=new Date();                                                  //create the object from Date class

                    while (true) {
                        try {
                            System.out.print("Enter date(DD-MM-YYYY) :");
                            String day = sc.next();                                   //get the date from user

                            String[] dateArraySplit = day.split("-", 3);
                            int date = Integer.parseInt(dateArraySplit[0]);
                            int month = Integer.parseInt(dateArraySplit[1]);
                            int year = Integer.parseInt(dateArraySplit[2]);

                            if (date > 0 && date < 32 && month > 0 && month < 13 && year > 2019 && year < 10000) {
                                date_1.setDay(date);
                                date_1.setMonth(month);
                                date_1.setYear(year);
                                break;
                            }
                            else {
                                System.out.println("Invalid Date Inserted!");     //if user entered the wrong date ,this massage will  be prompt.
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Invalid Date Inserted");          //if user entered the wrong date ,this massage will  be prompt.
                        }
                    }
                    addPlayedMatch(team1,team1_goals,team1_score,team2,date_1);

                }

                if(input_1==6){
                    saveFile();       //call the  saveFile() method with no parameters.
                }

                if(input_1==7){
                    GUI.guiTable(allClubs,played_matches);

                }
                if(input_1==8){
                    break;
                }

            }catch(Exception e){
                System.out.println("Invalid input!Try again");
                sc.next();
            }
        }
    }

    @Override
    public void loadarray() {

        //loading the all club details into 'all_clubs' array.

        String loadClubDetails="E:\\New folder (5)\\PlayFramework\\console and ui\\java-play-angular\\Data.txt";     //file path
        File filePathOfClubDetailsFile=new File(loadClubDetails);

        FileInputStream fisOfClubDetails= null;

        try {
            fisOfClubDetails = new FileInputStream(filePathOfClubDetailsFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisOfClubDetails= null;
        try {
            oisOfClubDetails = new ObjectInputStream(fisOfClubDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true){
            try{
                SportsClub sportObj=(SportsClub)oisOfClubDetails.readObject();
                allClubs.add(sportObj);


            }catch (EOFException e){
                break;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //loading played match details to the array


        /*String loadPlayedMatchDetails="E:\\New folder (5)\\PlayFramework\\console and ui\\java-play-angular\\playedMatches.txt";
        File fileMatch=new File(loadPlayedMatchDetails);

        FileInputStream fisMatch= null;

        try {
            fisMatch = new FileInputStream(fileMatch);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisMatch= null;
        try {
            oisMatch = new ObjectInputStream(fisMatch);
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true){
            try{
                PlayedMatch plyObj=(PlayedMatch) oisMatch.readObject();
                played_matches.add(plyObj);


            }catch (EOFException e){
                break;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }*/

    }

    @Override
    public void createSportClub(SportsClub sportsClub) {
        allClubs.add(sportsClub);                         //add the sportsClub object into the 'allClubs' array.
        System.out.println("successfully added!");        //prompt this massage to user
        System.out.println(" ");
    }

    @Override
    public void deleteClub(String clubname) {
        boolean del_club = false;                                   //create a boolean variable
        for (SportsClub sportsClub : allClubs) {                      //check the club, one by one using  for loop
            if (clubname.equals(sportsClub.getClubName())) {
                allClubs.remove(sportsClub);                      //if found the club, then remove that relevant whole object from the array
                del_club = true;
                System.out.println("successfully deleted!");      //after deleting the club then, prompt this massage to the user
                break;                                            //then stop the  loop
            }
        }
        if (!del_club) {
            System.out.println("Club name unavailable!");         //when the club is not found this massage will be prompt
            System.out.println(" ");
        }
    }
        @Override
        public void addPlayedMatch(String team1,int goals,double score,String team2,Date date) {
            boolean team1_check=false;
            boolean team2_check=false;
            boolean team11_check=false;
            boolean team22_check=false;



            if(goals==(int)score){                                                             //checking that relevant match draw or not
                for(SportsClub drawMatchSportsClubSearch:allClubs){
                    if (team1.equals(drawMatchSportsClubSearch.getClubName())) {
                        int draw=((FootballClub)drawMatchSportsClubSearch).getNumberOfDraws();
                        draw=draw+1;
                        ((FootballClub)drawMatchSportsClubSearch).setNumberOfDraws(draw);      //update the draw match attribute of relevant object


                        double update_points=((FootballClub)drawMatchSportsClubSearch).getCurrentlyPoints()+1.0;
                        ((FootballClub)drawMatchSportsClubSearch).setCurrentlyPoints(update_points);   //update the points of club attribute of relevant object

                        int drawGoalsTeam1=((FootballClub)drawMatchSportsClubSearch).getNumberOfGoalsReceived();
                        drawGoalsTeam1=drawGoalsTeam1+goals;
                        ((FootballClub)drawMatchSportsClubSearch).setNumberOfGoalsReceived(drawGoalsTeam1);  //update the goals of club attribute of relevant object

                        double drawScoreTeam1=((FootballClub)drawMatchSportsClubSearch).getScore();
                        ((FootballClub)drawMatchSportsClubSearch).setScore(drawScoreTeam1+goals);       //update the score of club attribute of relevant object

                        ((FootballClub)drawMatchSportsClubSearch).setNumberOfMatchesPlayed(((FootballClub)drawMatchSportsClubSearch).getNumberOfMatchesPlayed()+1);

                        team1_check=true;


                    }
                }

                for(SportsClub sportsClub:allClubs){
                    if (team2.equals(sportsClub.getClubName())) {
                        int draw=((FootballClub)sportsClub).getNumberOfDraws();
                        draw=draw+1;
                        ((FootballClub)sportsClub).setNumberOfDraws(draw);

                        double update_points=((FootballClub)sportsClub).getCurrentlyPoints()+1.0;
                        ((FootballClub)sportsClub).setCurrentlyPoints(update_points);

                        int drawGoalsTeam2=((FootballClub)sportsClub).getNumberOfGoalsReceived();
                        drawGoalsTeam2=drawGoalsTeam2+goals;
                        ((FootballClub)sportsClub).setNumberOfDraws(drawGoalsTeam2);

                        double drawScoreTeam2=((FootballClub)sportsClub).getScore();
                        ((FootballClub)sportsClub).setScore(drawScoreTeam2+goals);

                        ((FootballClub)sportsClub).setNumberOfMatchesPlayed(((FootballClub)sportsClub).getNumberOfMatchesPlayed()+1);

                        team2_check=true;
                    }
                }

                //import details to the array

                if(team1_check==true && team2_check==true ){

                    PlayedMatch playedMatch=new PlayedMatch(team1,team2,goals, (int) score,date);
                    played_matches.add(playedMatch);
                }


            }

            else{
                for(SportsClub sportsClub:allClubs){
                    if(team1.equals(sportsClub.getClubName())){
                        int goals_1=((FootballClub)sportsClub).getNumberOfGoalsReceived();
                        goals_1=goals_1+goals;
                        ((FootballClub)sportsClub).setNumberOfGoalsReceived(goals_1);

                        double score_1=((FootballClub)sportsClub).getScore();
                        score_1=score_1+score;
                        ((FootballClub)sportsClub).setScore(score_1);

                        double update_points=((FootballClub)sportsClub).getCurrentlyPoints()+3.0;
                        ((FootballClub)sportsClub).setCurrentlyPoints(update_points);

                        int update_played_match=((FootballClub)sportsClub).getNumberOfMatchesPlayed();
                        update_played_match=update_played_match+1;
                        ((FootballClub)sportsClub).setNumberOfMatchesPlayed(update_played_match);

                        int update_wins=((FootballClub)sportsClub).getNumberOfWins();
                        update_wins=update_wins+1;
                        ((FootballClub)sportsClub).setNumberOfWins(update_wins);

                        team11_check=true;

                    }


                }
                for(SportsClub sportsClub:allClubs){
                    if(team2.equals(sportsClub.getClubName())){

                        int goals_2=((FootballClub)sportsClub).getNumberOfGoalsReceived();
                        goals_2=goals_2+(int)score;
                        ((FootballClub)sportsClub).setNumberOfGoalsReceived(goals_2);

                        double score_2=((FootballClub)sportsClub).getScore();
                        score_2=score_2+goals;
                        ((FootballClub)sportsClub).setScore(score_2);

                        int update_played_match=((FootballClub)sportsClub).getNumberOfMatchesPlayed();
                        update_played_match=update_played_match+1;
                        ((FootballClub)sportsClub).setNumberOfMatchesPlayed(update_played_match);

                        int update_defeat=((FootballClub)sportsClub).getNumberOfDefeats();
                        update_defeat=update_defeat+1;
                        ((FootballClub)sportsClub).setNumberOfDefeats(update_defeat);

                        team22_check=true;

                    }

                }

                if(team11_check==true && team22_check==true ){

                    PlayedMatch playedMatch=new PlayedMatch(team1,team2,goals, (int) score,date);
                    played_matches.add(playedMatch);
                }

            }
            if(team11_check == false){
                System.out.println("winning Team not available!");     //if winning team is not available this massage will be prompt
            }
            if (team22_check == false){
                System.out.println("defeat Team not available!");      //if defeat team is not available this massage will be prompt
            }
            if(team1_check ==false){
                System.out.println("Team not available !");
            }
            if(team2_check ==false){
                System.out.println("Team not available !");
            }

        }





    public void saveFile()   {

        //saving objects
        String filePath="E:\\New folder (5)\\PlayFramework\\console and ui\\java-play-angular\\Data.txt";
        File fClubDetails=new File(filePath);
        try{
            FileOutputStream fosClub=new FileOutputStream(fClubDetails);
            ObjectOutputStream oosClub=new ObjectOutputStream(fosClub);

            for (SportsClub sportsClub:allClubs){
                oosClub.writeObject(sportsClub);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        //saving played matches details

        String loadPlayedMatchDetails="E:\\New folder (5)\\PlayFramework\\console and ui\\java-play-angular\\playedMatches.txt";
        File fPlayedMatch =new File(loadPlayedMatchDetails);
        try{
            FileOutputStream fosPlayedMatch=new FileOutputStream(fPlayedMatch);
            ObjectOutputStream oosPlayedMatch=new ObjectOutputStream(fosPlayedMatch);

            for (PlayedMatch playedMatchesSaving:played_matches){
                oosPlayedMatch.writeObject(playedMatchesSaving);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void displayPremierLeagueTable() {

        //comparing clubs according clubs points.if both points of clubs are same,then comparing goals
        Comparator comparator_1=  Comparator.comparing(FootballClub::getCurrentlyPoints).thenComparing(FootballClub::getNumberOfGoalsReceived);
        Collections.sort(allClubs,comparator_1);
        Collections.reverse(allClubs);

        System.out.println(" ");
        System.out.format("%-25s%-12s%12s%12s%12s%12s%20s%20s%20s%n","Club_name","Location","  Manager_name","Wins","Draws","  Defeats",
                "Goals","Score","Points","played matches");
        System.out.println(" ");

        for(SportsClub sportsClub:allClubs){

            if(sportsClub instanceof FootballClub){

                System.out.format("%-25s%-12s%12s%12s%12s%12s%20s%20s%20s%n",sportsClub.getClubName(),sportsClub.getLocation(),sportsClub.getTeamManagerName(),
                        ((FootballClub)sportsClub).getNumberOfWins(),((FootballClub)sportsClub).getNumberOfDraws(),((FootballClub)sportsClub).getNumberOfDefeats(),
                        ((FootballClub)sportsClub).getNumberOfGoalsReceived(),((FootballClub)sportsClub).getScore(),((FootballClub)sportsClub).getCurrentlyPoints());


            }
        }
        System.out.println(" ");

    }



    @Override
    public void displayStatisticsSelectedClub(String clubname) {
        boolean check_stst=false;
        for(SportsClub sportsClub:allClubs){                               //Check the clubs one by one
            if(clubname.equals(sportsClub.getClubName())){                 //check the club name using if condition
                System.out.println(" ");
                System.out.println("* * * * * * * * * * *");
                System.out.println("Club name :"+sportsClub.getClubName());
                System.out.println("Location :"+sportsClub.getLocation());
                System.out.println("Manager name :"+sportsClub.getTeamManagerName());

                check_stst=true;
                if (sportsClub instanceof FootballClub){                   //checking the object, instance of this class

                    System.out.println("Number of wins :"+((FootballClub)sportsClub).getNumberOfWins());
                    System.out.println("Number of draw :"+((FootballClub)sportsClub).getNumberOfDraws());
                    System.out.println("Number of defeat :"+((FootballClub)sportsClub).getNumberOfDefeats());
                    System.out.println("Number of goals received :"+((FootballClub)sportsClub).getNumberOfGoalsReceived());
                    System.out.println("Current score :"+((FootballClub)sportsClub).getScore());
                    System.out.println("Current points :"+((FootballClub)sportsClub).getCurrentlyPoints());
                    System.out.println("Number of matches played :"+((FootballClub)sportsClub).getNumberOfMatchesPlayed());
                    System.out.println("* * * * * * * * * * *");
                    System.out.println(" ");
                }
            }
        }
        if(!check_stst){
            System.out.println("This club name is not available!");
        }

    }
}
