package collector;

import buyer.BuyerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CollectorController {
    public static String products="";

    public void setproducts(){
        products="";
        try (BufferedReader br = new BufferedReader(new FileReader("collector.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                products+=line+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void collect(ActionEvent actionEvent) throws IOException {
        setproducts();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("productsqueue.fxml"));
        Parent first = firstLoader.load();
        CollectorProductsController collectorProductsController = firstLoader.getController();
        collectorProductsController.collectorproducts.setText(products);
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();

    }

    public void signout(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("../mainscreen.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

}
