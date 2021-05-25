package buyer;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseController extends stallprices {

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

    public String productselected;
    public String measurement;
    public int buyingprice;
    public int totalprice;
    public static String receipt_name = "";
    public static String usercontact = "";

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        PurchaseController.usercontact = usercontact;
    }

    public String getReceipt_name() {
        return receipt_name;
    }

    public void setReceipt_name(String receipt_name) {
        PurchaseController.receipt_name = receipt_name;
    }

    // PURCHASE PRODUCTS
    public void vegetables() {
        vegetablesscreen.setVisible(true);
        fruitscreen.setVisible(false);
        meatscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }

    public void carrots() {
        productselected = "Carrots";
        product.setText("Carrots");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("78.00");
        stall2.setText(carrotstall);
        product2price.setText(carrotprice);
        stall3.setText(carrot2);
        product3price.setText(carrot2price);
        buyproductscreen.setVisible(true);
    }

    public void celery() {
        productselected = "Celery";
        product.setText("Celery");
        measurement = "kg";
        specification.setText("1/2 "+measurement);
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("180.00");
        stall2.setText(celerystall);
        product2price.setText(celeryprice);
        stall3.setText(celery2);
        product3price.setText(celery2price);
        buyproductscreen.setVisible(true);
    }

    public void eggplant() {
        productselected = "Eggplant";
        product.setText("Eggplant");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("75.00");
        stall2.setText(eggplantstall);
        product2price.setText(eggplantprice);
        stall3.setText(eggplant2);
        product3price.setText(eggplant2price);
        buyproductscreen.setVisible(true);
    }
    public void sili() {
        productselected = "Sili";
        product.setText("Sili");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("426.00");
        stall2.setText(silistall);
        product2price.setText(siliprice);
        stall3.setText(sili2);
        product3price.setText(sili2price);
        buyproductscreen.setVisible(true);
    }

    public void lettuce() {
        productselected = "Lettuce";
        product.setText("Lettuce");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Irene's Vegetable Stand");
        product1price.setText("64.00");
        stall2.setText(lettucestall);
        product2price.setText(lettuceprice);
        stall3.setText(lettuce2);
        product3price.setText(lettuce2price);
        buyproductscreen.setVisible(true);
    }

    public void fruits() {
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(true);
        meatscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }
    public void tomato() {
        productselected = "Tomato";
        product.setText("Tomato");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("62.00");
        stall2.setText(tomatostall);
        product2price.setText(tomatoprice);
        stall3.setText(tomato2);
        product3price.setText(tomato2price);
        buyproductscreen.setVisible(true);
    }

    public void pineapple() {
        productselected = "Pineapple";
        product.setText("Pineapple");
        measurement = "pc";
        specification.setText("1 "+measurement);
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("120.00");
        stall2.setText(pineapplestall);
        product2price.setText(pineappleprice);
        stall3.setText(pineapple2);
        product3price.setText(pineapple2price);
        buyproductscreen.setVisible(true);
    }

    public void apple() {
        productselected = "Apple";
        product.setText("Apple");
        specification.setText("1 pc");
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("35.00");
        stall2.setText(applestall);
        product2price.setText(appleprice);
        stall3.setText(apple2);
        product3price.setText(apple2price);
        buyproductscreen.setVisible(true);
    }

    public void banana() {
        productselected = "Banana";
        product.setText("Banana");
        measurement = "hand";
        specification.setText("1 "+measurement);
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("64.00");
        stall2.setText(bananastall);
        product2price.setText(bananaprice);
        stall3.setText(banana2);
        product3price.setText(banana2price);
        buyproductscreen.setVisible(true);
    }

    public void orange() {
        productselected = "Orange";
        product.setText("Orange");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Wendy's Fruit Stand");
        product1price.setText("35.00");
        stall2.setText(orangestall);
        product2price.setText(orangeprice);
        stall3.setText(orange2);
        product3price.setText(orange2price);
        buyproductscreen.setVisible(true);
    }

    public void meat() {
        meatscreen.setVisible(true);
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(false);
        seafoodscreen.setVisible(false);
    }
    public void porkginiling() {
        productselected = "Pork Giniling";
        product.setText("Pork Giniling");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("402.00");
        stall2.setText(porkginilingstall);
        product2price.setText(porkginilingprice);
        stall3.setText(porkginiling2);
        product3price.setText(porkginiling2price);
        buyproductscreen.setVisible(true);
    }

    public void porkchop() {
        productselected = "Pork Chop";
        product.setText("Pork Chop");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("402.00");
        stall2.setText(porkchopstall);
        product2price.setText(porkchopprice);
        stall3.setText(porkchop2);
        product3price.setText(porkchop2price);
        buyproductscreen.setVisible(true);
    }

    public void beefshortribs() {
        productselected = "Beef Short Ribs";
        product.setText("Beef Short Ribs");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("365.00");
        stall2.setText(beefshortribsstall);
        product2price.setText(beefshortribsprice);
        stall3.setText(beefshortribs2);
        product3price.setText(beefshortribs2price);
        buyproductscreen.setVisible(true);
    }

    public void chickendrumstick() {
        productselected = "Chicken Drumstick";
        product.setText("Chicken Drumstick");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("210.00");
        stall2.setText(chickendrumstickstall);
        product2price.setText(chickendrumstickprice);
        stall3.setText(chickendrumstick2);
        product3price.setText(chickendrumstick2price);
        buyproductscreen.setVisible(true);
    }

    public void chickenwings() {
        productselected = "Chicken Wings";
        product.setText("Chicken Wings");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("230.00");
        stall2.setText(chickenwingsstall);
        product2price.setText(chickenwingsprice);
        stall3.setText(chickenwings2);
        product3price.setText(chickenwings2price);
        buyproductscreen.setVisible(true);
    }

    public void seafood() {
        seafoodscreen.setVisible(true);
        meatscreen.setVisible(false);
        vegetablesscreen.setVisible(false);
        fruitscreen.setVisible(false);
    }
    public void bangus() {
        productselected = "Bangus";
        product.setText("Bangus");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("250.00");
        stall2.setText(bangusstall);
        product2price.setText(bangusprice);
        stall3.setText(bangus2);
        product3price.setText(bangus2price);
        buyproductscreen.setVisible(true);
    }

    public void tilapia() {
        productselected = "Tilapia";
        product.setText("Tilapia");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("180.00");
        stall2.setText(tilapiastall);
        product2price.setText(tilapiaprice);
        stall3.setText(tilapia2);
        product3price.setText(tilapia2price);
        buyproductscreen.setVisible(true);
    }

    public void shrimp() {
        productselected ="Shrimp";
        product.setText("Shrimp");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("725.00");
        stall2.setText(shrimpstall);
        product2price.setText(shrimpprice);
        stall3.setText(shrimp2);
        product3price.setText(shrimp2price);
        buyproductscreen.setVisible(true);
    }

    public void crab() {
        productselected = "Crab";
        product.setText("Crab");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("720.00");
        stall2.setText(crabstall);
        product2price.setText(crabprice);
        stall3.setText(crab2);
        product3price.setText(crab2price);
        buyproductscreen.setVisible(true);
    }

    public void galunggong() {
        productselected = "Galunggong";
        product.setText("Galunggong");
        measurement = "kg";
        specification.setText("1 "+measurement);
        stall1.setText("Brad's Meat and Seafood");
        product1price.setText("300.00");
        stall2.setText(galunggongstall);
        product2price.setText(galunggongprice);
        stall3.setText(galunggong2);
        product3price.setText(galunggong2price);
        buyproductscreen.setVisible(true);
    }

    public void product1() {
        selectedstall.setText(stall1.getText());
        selectedprice.setText(product1price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void product2() {
        selectedstall.setText(stall2.getText());
        selectedprice.setText(product2price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void product3() {
        selectedstall.setText(stall3.getText());
        selectedprice.setText(product3price.getText());
        selectedstall.setVisible(true);
        selectedprice.setVisible(true);
    }

    public void confirmbuy() {
        buyingprice = (int) (Float.parseFloat(productquantity.getText())*Float.parseFloat(selectedprice.getText()));
        totalprice += buyingprice;
        total.setText("P "+totalprice+".00");
        buyproductscreen.setVisible(false);
        addtoreceipt(selectedstall.getText(),productselected,Float.parseFloat(productquantity.getText()));
        productquantity.clear();
        selectedprice.setText("");
        selectedstall.setText("");
    }

    public void addtoreceipt(String stall, String productselected, float quantity){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String sql = "INSERT INTO public."+getReceipt_name()+"_receipt (stall,product,quantity,totalprice) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, stall);
            preparedStatement.setString(2, productselected);
            preparedStatement.setString(3, quantity +" "+measurement);
            preparedStatement.setInt(4, buyingprice);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void back2main(MouseEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("buyer.fxml"));
        Parent first = firstLoader.load();
        BuyerController buyerController = firstLoader.getController();
        buyerController.greeting.setText("Good Day "+getReceipt_name()+"!");
        buyerController.setReceiptname(getReceipt_name());
        buyerController.setUsercontact(getUsercontact());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void complete(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("receipt.fxml"));
        Parent first = firstLoader.load();
        ReceiptController receiptController = firstLoader.getController();
        receiptController.setName(getReceipt_name());
        receiptController.getReceipt();
        receiptController.total.setText(total.getText());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();

    }


    public void cancel() {buyproductscreen.setVisible(false);selectedstall.setVisible(false);
        selectedprice.setVisible(false); }

}
