package seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SellerController {
    public String sellerstall;
    public Pane mainmenu;
    public Label greeting;

    public String getSellerstall() {
        return sellerstall;
    }

    public void setSellerstall(String sellerstall) {
        this.sellerstall = sellerstall;
    }

    public void signout(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("../mainscreen.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void setproducts(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("setproducts.fxml"));
        Parent first = firstLoader.load();
        SetProductsController setProductsController = firstLoader.getController();
        setProductsController.setSeller(getSellerstall());
        setProductsController.getProducts();
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void home(MouseEvent mouseEvent) throws IOException {
        Parent Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("seller.fxml")));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void orderhistory(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("orderhistory.fxml"));
        Parent first = firstLoader.load();
        OrderHistoryController orderHistoryController = firstLoader.getController();
        orderHistoryController.setSeller(getSellerstall());
        orderHistoryController.getOrderHistory();
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
