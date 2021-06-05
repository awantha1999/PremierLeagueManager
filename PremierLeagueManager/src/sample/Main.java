package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        //creating a object in PremierLeagueManager class and call the console method.
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.console();



    }




    public static void main(String[] args) {
        launch(args);
    }
}
