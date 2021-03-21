package collector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CollectorProductsController {
    public TextArea collectorproducts;

    public void done(ActionEvent actionEvent) throws IOException {
        File delete = new File("collector.txt");
        delete.delete();
        Parent Parent = FXMLLoader.load(getClass().getResource("collector.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void back2main(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("collector.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
