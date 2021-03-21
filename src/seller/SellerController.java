package seller;

import collector.CollectorProductsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SellerController {
    public static String newpricecar = "";
    public static String newpricecel = "";
    public static String newpriceegg = "";
    public static boolean uncar = false;
    public static boolean uncel = false;
    public static boolean unegg = false;

    public void setproducts(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("setproducts.fxml"));
        Parent first = firstLoader.load();
        SetProductsController setProductsController = firstLoader.getController();
        setProductsController.setproducts();
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void back2main(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("../mainscreen.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
