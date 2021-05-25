package buyer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ReceiptController extends PurchaseController {


    public Pane paymentscreen;
    public Label total;
    public static String collector = "";
    public static String collectorpn = "";
    public Pane buyproductscreen;
    public Label product;
    public Label product1price;
    public Pane product1;
    public Label stall1;
    public Pane product2;
    public ObservableList<order> receipt = FXCollections.observableArrayList();
    public TextField newproductquantity;
    public Pane buyerinfo;
    public TextArea receivedetails;
    public static boolean stop = false;

    private order selectedorder;

    @FXML public TableView<order> ordertable;


    @FXML public TableColumn<order, String> productcol;
    @FXML public TableColumn<order, String> quantitycol;
    @FXML public TableColumn<order, Integer> pricecol;
    @FXML public TableColumn<order, String> stallcol;

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getReceipt(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getName()+"_receipt";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                receipt.add(new order(order.getString("product"),order.getString("stall"),order.getString("quantity"),order.getInt("totalprice")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        productcol.setCellValueFactory(new PropertyValueFactory<order, String>("Product"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<order, String>("Quantity"));
        stallcol.setCellValueFactory(new PropertyValueFactory<order, String>("Stall"));
        pricecol.setCellValueFactory(new PropertyValueFactory<order, Integer>("Price"));
        ordertable.setItems(receipt);

    }
    public void getcollector(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.collectoravailable";
            ResultSet check = sta.executeQuery(sql);
            while (check.next()){
                if (check.getString("currentlyserving").equals("none")) {
                    collector = check.getString("collector");
                    collectorpn = check.getString("collector_contact");
                    stop = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void complete(MouseEvent mouseEvent) throws IOException {
        getcollector();
        if(stop){
            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
                String sql = "UPDATE collectoravailable set currentlyserving = ?,status = ? where collector = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, getName());
                preparedStatement.setString(2, "pending collector");
                preparedStatement.setString(3, collector);
                preparedStatement.executeUpdate();
                Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
                String sql2 = "UPDATE confirmeorder set confirmed = ? where receipt_name = ?";
                PreparedStatement preparedStatement2 = conn2.prepareStatement(sql2);
                preparedStatement2.setString(1, "yes");
                preparedStatement2.setString(2,getName());
                preparedStatement2.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("orderstatus.fxml"));
            Parent first = firstLoader.load();
            OrderStatusController orderStatusController = firstLoader.getController();
            orderStatusController.collectorname.setText(collector);
            orderStatusController.contact.setText(collectorpn);
            orderStatusController.orderrecieved.setVisible(false);
            orderStatusController.orderreceivedcomplete.setVisible(true);
            orderStatusController.topay.setText(total.getText());
            orderStatusController.setName(getReceipt_name());
            Scene Scene = new Scene(first);
            Stage Stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        else{
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("orderstatus.fxml"));
            Parent first = firstLoader.load();
            OrderStatusController orderStatusController = firstLoader.getController();
            orderStatusController.warning.setText("Waiting for Available Collector.");
            orderStatusController.contact.setText("");
            orderStatusController.collectorname.setText("");
            orderStatusController.topay.setText(total.getText());
            Scene Scene = new Scene(first);
            Stage Stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }

    }
    public void back(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("purchase.fxml")));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }


    public void back2main(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("buyer.fxml"));
        Parent first = firstLoader.load();
        BuyerController buyerController = firstLoader.getController();
        buyerController.greeting.setText("Good Day "+getName()+"!");
        buyerController.setReceiptname(getName());
        buyerController.setUsercontact(getUsercontact());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
    public void getSelectedorder(){selectedorder = ordertable.getSelectionModel().getSelectedItem();}

    public void editorder() {
        getSelectedorder();
        if(selectedorder.getProduct().equals("Carrots")){ carrots();}
        if(selectedorder.getProduct().equals("Celery")){ celery();}
        if(selectedorder.getProduct().equals("Eggplant")){ eggplant();}
        if(selectedorder.getProduct().equals("Sili")){ sili();}
        if(selectedorder.getProduct().equals("Lettuce")){ lettuce();}
        if(selectedorder.getProduct().equals("Tomato")){ tomato();}
        if(selectedorder.getProduct().equals("Pineapple")){ pineapple();}
        if(selectedorder.getProduct().equals("Apple")){ apple();}
        if(selectedorder.getProduct().equals("Banana")){ banana();}
        if(selectedorder.getProduct().equals("Orange")){ orange();}
        if(selectedorder.getProduct().equals("Pork Giniling")){ porkginiling();}
        if(selectedorder.getProduct().equals("Pork Chop")){ porkchop();}
        if(selectedorder.getProduct().equals("Beef Short Ribs")){ beefshortribs();}
        if(selectedorder.getProduct().equals("Chicken Wings")){ chickenwings();}
        if(selectedorder.getProduct().equals("Chicken Drumstick")){ chickendrumstick();}
        if(selectedorder.getProduct().equals("Tilapia")){ tilapia();}
        if(selectedorder.getProduct().equals("Bangus")){ bangus();}
        if(selectedorder.getProduct().equals("Galunggong")){ galunggong();}
        if(selectedorder.getProduct().equals("Shrimp")){ shrimp();}
        if(selectedorder.getProduct().equals("Crab")){ crab();}


    }


    public void removeorder() {
        getSelectedorder();
        ordertable.getItems().removeAll(ordertable.getSelectionModel().getSelectedItem());
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String s1 = selectedorder.getProduct().substring(0, 1).toUpperCase();
            String capitalize = s1 + selectedorder.getProduct().substring(1);
            String sql = "DELETE from "+getName()+"_receipt WHERE product = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, capitalize);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        refreshorder();
    }

    public void editdeliverydetails() {
        buyerinfo.setVisible(true);

    }

    public void editbuy() {
        getSelectedorder();
        ordertable.getItems().removeAll(ordertable.getSelectionModel().getSelectedItem());
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String s1 = selectedorder.getProduct().substring(0, 1).toUpperCase();
            String capitalize = s1 + selectedorder.getProduct().substring(1);
            String sql = "DELETE from "+getName()+"_receipt WHERE product = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, capitalize);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        int buyingprice = (int) (Float.parseFloat(newproductquantity.getText())*Float.parseFloat(selectedprice.getText()));
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String sql = "INSERT INTO "+getName()+"_receipt (stall,product,quantity,totalprice) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, selectedstall.getText());
            preparedStatement.setString(2, selectedorder.getProduct());
            preparedStatement.setString(3, newproductquantity.getText() +" "+measurement);
            preparedStatement.setInt(4, buyingprice);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        refreshorder();
    }
    public void refreshorder(){
        receipt.clear();
        int newtotal = 0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getName()+"_receipt";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                receipt.add(new order(order.getString("product"),order.getString("stall"),order.getString("quantity"),order.getInt("totalprice")));
                newtotal += order.getInt("totalprice");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        total.setText("P "+newtotal+".00");
        ordertable.setItems(receipt);
    }

    public void detailsedited() {
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String sql = "UPDATE confirmeorder set deliverydetails = ? where receipt_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, receivedetails.getText());
            preparedStatement.setString(2, getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void canceleditdetails() {
        buyerinfo.setVisible(false);
    }
}
