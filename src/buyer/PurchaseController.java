package buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PurchaseController {

    public Pane purchase;

    @FXML
    public Label total;

    public Label product;
    public Pane buyproductscreen;
    public Label specification;
    public TextField productquantity;
    public Label selectedstall;
    public Label selectedprice;

    public Pane product1;
    public Label stall1;
    public Label product1price;

    public Pane product2;
    public Label stall2;
    public Label product2price;

    public Pane product3;
    public Label stall3;
    public Label product3price;

    public Pane vegetablesscreen;
    public Pane fruitscreen;
    public Pane meatscreen;
    public Pane seafoodscreen;

    // PURCHASE PRODUCTS
    public void vegetables(MouseEvent mouseEvent) {
        vegetablesscreen.setVisible(true);
        fruitscreen.setVisible(false);
        meatscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }

    public void carrots(MouseEvent mouseEvent) {
        product.setText("Carrots");
        specification.setText("1 kg");
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("78.00");
        buyproductscreen.setVisible(true);
    }

    public void celery(MouseEvent mouseEvent) {
        product.setText("Celery");
        specification.setText("1/2 kg");
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("180.00");
        buyproductscreen.setVisible(true);
    }

    public void eggplant(MouseEvent mouseEvent) throws IOException {
        product.setText("Eggplant");
        specification.setText("1 kg");
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("75.00");
        buyproductscreen.setVisible(true);
    }
    public void sili(MouseEvent mouseEvent) {
        product.setText("Sili");
        specification.setText("1 kg");
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("426.00");
        buyproductscreen.setVisible(true);
    }

    public void lettuce(MouseEvent mouseEvent) {
        product.setText("Lettuce");
        specification.setText("1 kg");
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("64.00");
        buyproductscreen.setVisible(true);
    }

    public void fruits(MouseEvent mouseEvent) {
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(true);
        meatscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }
    public void tomato(MouseEvent mouseEvent) {
        product.setText("Tomato");
        specification.setText("1 kg");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("62.00");
        buyproductscreen.setVisible(true);
    }

    public void pineapple(MouseEvent mouseEvent) {
        product.setText("Pineapple");
        specification.setText("1 pc");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("120.00");
        buyproductscreen.setVisible(true);
    }

    public void apple(MouseEvent mouseEvent) {
        product.setText("Apple");
        specification.setText("1 pc");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("35.00");
        buyproductscreen.setVisible(true);
    }

    public void banana(MouseEvent mouseEvent) {
        product.setText("Banana");
        specification.setText("1 kg");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("64.00");
        buyproductscreen.setVisible(true);
    }

    public void orange(MouseEvent mouseEvent) {
        product.setText("Orange");
        specification.setText("1 pc");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("60.00");
        buyproductscreen.setVisible(true);
    }

    public void meat(MouseEvent mouseEvent) {
        meatscreen.setVisible(true);
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }
    public void porkginiling(MouseEvent mouseEvent) {
        product.setText("Pork Giniling");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("402.00");
        buyproductscreen.setVisible(true);
    }

    public void porkchop(MouseEvent mouseEvent) {
        product.setText("Pork Chop");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("402.00");
        buyproductscreen.setVisible(true);
    }

    public void beefshortribs(MouseEvent mouseEvent) {
        product.setText("Beef Short Ribs");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("365.00");
        buyproductscreen.setVisible(true);
    }

    public void chickendrumstick(MouseEvent mouseEvent) {
        product.setText("Chicken Drumstick");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("210.00");
        buyproductscreen.setVisible(true);
    }

    public void chickenwings(MouseEvent mouseEvent) {
        product.setText("Chicken Wings");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("230.00");
        buyproductscreen.setVisible(true);
    }

    public void seafood(MouseEvent mouseEvent) {
        seafoodscreen.setVisible(true);
        meatscreen.setVisible(false);
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(false);
    }
    public void bangus(MouseEvent mouseEvent) {
        product.setText("Bangus");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("250.00");
        buyproductscreen.setVisible(true);
    }

    public void tilapia(MouseEvent mouseEvent) {
        product.setText("Tilapia");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("180.00");
        buyproductscreen.setVisible(true);
    }

    public void shrimp(MouseEvent mouseEvent) {
        product.setText("Shrimp");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("725.00");
        buyproductscreen.setVisible(true);
    }

    public void crab(MouseEvent mouseEvent) {
        product.setText("Crab");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("720.00");
        buyproductscreen.setVisible(true);
    }

    public void galunggong(MouseEvent mouseEvent) {
        product.setText("Galunggong");
        specification.setText("1 kg");
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("300.00");
        buyproductscreen.setVisible(true);
    }

    public void product1(MouseEvent mouseEvent) {
        selectedstall.setText(stall1.getText());
        selectedprice.setText(product1price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void product2(MouseEvent mouseEvent) {
        selectedstall.setText(stall2.getText());
        selectedprice.setText(product2price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void product3(MouseEvent mouseEvent) {
        selectedstall.setText(stall3.getText());
        selectedprice.setText(product3price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void confirmbuy(ActionEvent actionEvent) {
    }

    public void back2main(MouseEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("buyer.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void complete(MouseEvent mouseEvent) {
    }

    public void cancel(MouseEvent mouseEvent) {buyproductscreen.setVisible(false); }

}
