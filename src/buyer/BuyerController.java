package buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class BuyerController extends stallprices{

    public Pane mainmenu;
    public TextArea receivedetails;
    public Label checkavailable;
    public Pane buyerinfo;
    public Label greeting;
    public static String receiptname = "";
    public String usercontact;
    public static int total = 0;
    public Label warning1;
    public static String status = "";
    public String collectorpn;
    public String collector;


    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact;
    }

    public static boolean alreadyset = false;
    public static boolean alreadyconfirmed = false;

    public String getReceiptname() {
        return receiptname;
    }

    public void setReceiptname(String receiptname) {
        BuyerController.receiptname = receiptname;
    }

    public void tobuyerinfo(MouseEvent actionEvent) throws IOException {
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.confirmeorder";
            ResultSet check = sta.executeQuery(sql);
            while(check.next()){
                if(receiptname.equals(check.getString("receipt_name"))){
                    alreadyset = true;
                    if(check.getString("confirmed").equals("yes")){
                        alreadyconfirmed = true;
                        alreadyset = false;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (alreadyconfirmed){
            warning1.setVisible(true);
        }
        if (alreadyset){
            productcheck();
            gettotal();
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("purchase.fxml"));
            Parent first = firstLoader.load();
            PurchaseController purchaseController = firstLoader.getController();
            purchaseController.setReceipt_name(getReceiptname());
            purchaseController.setUsercontact(getUsercontact());
            purchaseController.total.setText("P "+total+".00");
            purchaseController.totalprice = total;
            Scene Scene = new Scene(first);
            Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        if(!alreadyset&&!alreadyconfirmed) {
            buyerinfo.setVisible(true);
        }
    }

    public void buy(ActionEvent actionEvent) throws IOException {
        productcheck();
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            String sql = "INSERT INTO public.confirmeorder"+"(receipt_name,deliverydetails,confirmed,buyer_contact)"+"VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, getReceiptname());
            preparedStatement.setString(2, receivedetails.getText());
            preparedStatement.setString(3, "no");
            preparedStatement.setString(4, getUsercontact());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("purchase.fxml"));
        Parent first = firstLoader.load();
        PurchaseController purchaseController = firstLoader.getController();
        purchaseController.setReceipt_name(getReceiptname());
        purchaseController.setUsercontact(getUsercontact());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
    public void gettotal(){
        total = 0;
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public."+getReceiptname()+"_receipt";
            ResultSet check = sta.executeQuery(sql);
            while(check.next()){
                total+=check.getInt("totalprice");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../mainscreen.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void complete(MouseEvent actionEvent) throws IOException {
        gettotal();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("receipt.fxml"));
        Parent first = firstLoader.load();
        ReceiptController receiptController = firstLoader.getController();
        receiptController.setName(getReceiptname());
        receiptController.getReceipt();
        receiptController.total.setText("P "+total+".00");
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void back(MouseEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("purchase.fxml")));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void cancel() {
        buyerinfo.setVisible(false);
    }

    public void vieworderstatus(MouseEvent mouseEvent) throws IOException {
        getorderstatus();
        gettotal();
        if(status.equals("order received")||status.equals("order collected")||status.equals("delivering order")||status.equals("order secured")) {
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("orderstatus.fxml"));
            Parent first = firstLoader.load();
            OrderStatusController orderStatusController = firstLoader.getController();
            orderStatusController.collectorname.setText(collector);
            orderStatusController.contact.setText(collectorpn);
            if (status.equals("order received")) {
                orderStatusController.orderreceivedcomplete.setVisible(true);
            }
            if (status.equals("order collected")) {
                orderStatusController.ordercollectedcomplete.setVisible(true);
                orderStatusController.orderreceivedcomplete.setVisible(true);
            }
            if (status.equals("delivering order")) {
                orderStatusController.deliveringordercompleted.setVisible(true);
                orderStatusController.ordercollectedcomplete.setVisible(true);
                orderStatusController.orderreceivedcomplete.setVisible(true);
            }
            if (status.equals("order secured")) {
                orderStatusController.deliveringordercompleted.setVisible(true);
                orderStatusController.ordercollectedcomplete.setVisible(true);
                orderStatusController.orderreceivedcomplete.setVisible(true);
                orderStatusController.ordersecuredcompleted.setVisible(true);
                orderStatusController.confirmorderbtn.setVisible(true);
                orderStatusController.setName(getReceiptname());

            }
            orderStatusController.setName(getReceiptname());
            orderStatusController.setUsercontact(getUsercontact());
            orderStatusController.topay.setText("P " + total + ".00");
            Scene Scene = new Scene(first);
            Stage Stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        else{
            warning1.setText("No Confirmed Order Yet");
            warning1.setVisible(true);
        }

    }
    public void getorderstatus(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public.collectoravailable";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                if(order.getString("currentlyserving").equals(getReceiptname())){
                    collector = order.getString("collector");
                    collectorpn = order.getString("collector_contact");
                    status = order.getString("status");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
