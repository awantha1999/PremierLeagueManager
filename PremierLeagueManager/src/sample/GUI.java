package sample;



import java.awt.*;

import java.io.IOException;

import java.net.*;
import java.util.ArrayList;



public class GUI {


    public static void guiTable(ArrayList<SportsClub> allClubs1, ArrayList<PlayedMatch> played_matches1) {

        Desktop desktopBrows = Desktop.getDesktop();
        try {
            desktopBrows.browse(new URI("http://localhost:4200/play"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }




    }

}
