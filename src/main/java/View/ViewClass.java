package View;

import Controller.Functions;
import Controller.ViewController;
import Model.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;

public class ViewClass {

    protected Scene scene;
    protected Pane root;
    protected final double sceneWidth = 800;
    protected final double sceneHeight = 600;
    protected final double sceneMidWi = sceneWidth / 2.0;
    protected final double sceneMidHi = sceneHeight / 2.0;
    protected final double headerHeight = 50.0;
    private boolean header = true;


    public ViewClass(){
        root = new Pane();
        setHeader();
    }

    public Scene getScene() {
        return scene;
    }
    public Pane getRoot(){ return root; }

    // Sets the scene with the root and size. Adds css file to scene. -MH
    protected void setScene( String styleSheet ){

        scene = new Scene(root, sceneWidth, sceneHeight);

        // Adds a css file to the scene.
        URL css = getClass().getResource("/StyleSheets/" + styleSheet );
        scene.getStylesheets().add( css.toExternalForm() );

        root.getStyleClass().addAll("root", "var");
    }

    protected void setHeader(){

        /*
        Sets the header with MyEvents, AllEvents, Home, Announcements.
         */

        Button myEventButton = new Button("MY EVENTS");
        Button searchEventButton = new Button("SEARCH EVENTS");
        Button homeButton = new Button("ALL EVENTS");
        Button mapButton = new Button("EVENT MAP");
        Button createEventButton = new Button("CREATE EVENT");

        //----------------------------------------------------------------------------
        myEventButton.setOnAction( actionEvent -> {
            new ViewController( new HomescreenView("myEvents") ).showView();
        });
        searchEventButton.setOnAction( actionEvent -> {
            //test case for now
            System.out.println("Search button clicked");
        });
        homeButton.setOnAction( actionEvent -> {
            new ViewController( new HomescreenView("allEvents") ).showView();
        });
        mapButton.setOnAction( actionEvent -> {
            new ViewController( new MapView() ).showView();
        });
        createEventButton.setOnAction( actionEvent -> {
            new ViewController( new CreateEventView() ).showView();
        });
        //---------------------------------------------------------------------------

        HBox hbox = new HBox(homeButton, myEventButton, searchEventButton, mapButton);
        //add create event to hbox only if the user is an admin
        if (User.getInstance().isAdmin()) {
            hbox.getChildren().add(createEventButton);
        }
        hbox.setPrefWidth(sceneWidth);
        hbox.setPrefHeight(headerHeight);
        hbox.getStyleClass().add("headerBackground");
        hbox.setAlignment(Pos.TOP_CENTER);

        Functions function = new Functions();
        function.setCollectionInputStyle(hbox, new Button(), new String[]{"buttonLightStandard"});

        VBox vbox = new VBox(hbox);

        root.getChildren().add(vbox);
    }

    protected void removeHeader(){
        if( header ) {
            root.getChildren().remove(0);
            header = !header;
        }
    }
}
