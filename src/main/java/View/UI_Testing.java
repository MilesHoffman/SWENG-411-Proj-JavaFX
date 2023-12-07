package View;

import NewView.NewHomescreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI_Testing extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        NewHomescreenView view = new NewHomescreenView();

        stage = new Stage();
        setStageScene( view.getScene() );
        stage.setTitle("SWENG 411 Proj");
        stage.show();
    }

    public void setStageScene( Scene scene ){
        stage.setScene(scene);
    }

    public static void main( String[] args){
        Application.launch(args);
    }
}