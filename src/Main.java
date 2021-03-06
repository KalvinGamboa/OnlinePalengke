import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainscreen.fxml")));
        primaryStage.setTitle("Online Palengke");
        primaryStage.setScene(new Scene(root, 250, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
