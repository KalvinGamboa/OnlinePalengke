package seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SetProductsController extends SellerController{
    public CheckBox unavailablecarrots;
    public CheckBox unavailablecelery;
    public CheckBox unavailableeggplant;
    public TextField newpricecarrots;
    public TextField newpricecelery;
    public TextField newpriceeggplant;
    public Pane confirmedscreen;
    public Pane setproductscreen;
    public Label currentpricecarrots;
    public Label currentpricecelery;
    public Label currentpriceeggplant;

    public void setproducts(){
        if(!uncar){
            currentpricecarrots.setText("Current Price: P"+newpricecar);
        }
        if(!uncel){
            currentpricecelery.setText("Current Price: P"+newpricecel);
        }
        if(!unegg){
            currentpriceeggplant.setText("Current Price: P"+newpriceegg);
        }
        if(uncar){
            currentpricecarrots.setText("UNAVAILABLE");
        }
        if(uncel){
            currentpricecelery.setText("UNAVAILABLE");
        }
        if(unegg){
            currentpriceeggplant.setText("UNAVAILABLE");
        }


    }

    public void confirm(MouseEvent mouseEvent) {
        if(unavailablecarrots.isSelected()){
            uncar = true;
        }
        if(unavailablecelery.isSelected()){
            uncel = true;
        }
        if(unavailableeggplant.isSelected()){
            unegg = true;
        }
        if(!unavailablecarrots.isSelected()){
            uncar = false;
            newpricecar = newpricecarrots.getText();
        }
        if(!unavailablecelery.isSelected()){
            uncel = false;
            newpricecel = newpricecelery.getText();
        }
        if(!unavailableeggplant.isSelected()){
            unegg = false;
            newpriceegg = newpriceeggplant.getText();
        }
        setproductscreen.setVisible(false);
        confirmedscreen.setVisible(true);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("seller.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
