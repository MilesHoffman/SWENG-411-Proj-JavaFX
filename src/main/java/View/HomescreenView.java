package View;

import Controller.Functions;
import Controller.HomescreenLogic;
import Controller.ViewController;
import View.Components.EventCard;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.time.LocalDateTime;

public class HomescreenView extends ViewClass {

     /* Here are the parent variables/methods:

    protected Scene scene;
    protected Group root;

    public Scene getScene();
    public Group getRoot();
    protected setScene( String );

     */

    private HomescreenLogic logic = new HomescreenLogic( this ); // Connects to the logic -MH
    public HomescreenView() {

        super();

        setVars();
        setScene("HomeStyle.css");
    }

    private void setVars(){

        Functions function = new Functions();

        Label upcomingLabel = new Label("UPCOMING EVENTS");
        TilePane upcomingTilesP = new TilePane();
        for( int i = 0; i < 50; i++ ){

            EventCard card = new EventCard( "Name" + i, "Desc", "Franklin",
                    "Rando Club", false, LocalDateTime.now() );

            logic.addCardEvent(card);
            upcomingTilesP.getChildren().add(card);
        }
        function.setCollectionInputStyle(upcomingTilesP, new Button(), new String[]{"center"});
        ScrollPane upcomingScroll = new ScrollPane( upcomingTilesP );

        VBox upcomingVbox = new VBox( upcomingLabel, upcomingScroll);
        upcomingVbox.setPrefWidth(400);
        upcomingVbox.getStyleClass().add("splitVBox");

        Label myEventsLabel = new Label("MY EVENTS");

        TilePane myEventsTileP = new TilePane();
        for( int i : new int[50]){

            EventCard card =  new EventCard("TestName", "This is a description",
                    "Erie", "Club lang", true, LocalDateTime.now());

            logic.addCardEvent(card);
            myEventsTileP.getChildren().add(card);
        }
        ScrollPane myEventScroll = new ScrollPane( myEventsTileP );


        VBox myEventsVbox = new VBox(myEventsLabel, myEventScroll);
        myEventsVbox.setPrefWidth(400);
        myEventsVbox.getStyleClass().add("splitVBox");

        HBox split = new HBox(upcomingVbox, myEventsVbox);
        split.getStyleClass().add("container");
        split.setMaxWidth(sceneWidth);
        split.setMaxHeight(sceneHeight - headerHeight);
        split.setLayoutY(headerHeight);
        function.setObjectCenterX(sceneMidWi, split);

        function.setCollectionInputStyle(split, new Label(), new String[]{"fontHeader1"});

        root.getChildren().add(split);
    }
}
