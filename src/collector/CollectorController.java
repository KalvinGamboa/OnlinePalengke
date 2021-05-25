package collector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class CollectorController {
    public Pane mainmenu;
    public Label greeting;
    public Label checkavailable;
    public String name;
    public String fname;
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Label warning;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public static String receiptname = "";
    public static String contactno = "";
    public static String details = "";
    public static int rtotal = 0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void signout(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../mainscreen.fxml")));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
    public void getorderstatus() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public.collectoravailable";
            ResultSet order = sta.executeQuery(sql);
            while (order.next()) {
                if (order.getString("collector").equals(getName())) {
                    receiptname = order.getString("currentlyserving");
                    status = order.getString("status");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            }
    }
    public void getcontact(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public.confirmeorder";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                if(order.getString("receipt_name").equals(receiptname)){
                    contactno = order.getString("buyer_contact");
                    details = order.getString("deliverydetails");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void acceptupdateorder(ActionEvent mouseEvent) throws IOException {
        getorderstatus();
        getcontact();
        System.out.println(status);
        if(status.equals("pending collector")) {
            gettotal();
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("acceptorder.fxml"));
            Parent first = firstLoader.load();
            AcceptOrderController acceptOrderController = firstLoader.getController();
            acceptOrderController.contact.setText(contactno);
            acceptOrderController.customername.setText(receiptname);
            acceptOrderController.setName(getName());
            acceptOrderController.setFname(getFname());
            acceptOrderController.total.setText("P "+rtotal+".00");
            acceptOrderController.getReceipt();
            Scene Scene = new Scene(first);
            Stage Stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        if(receiptname.equals("none")){
            warning.setVisible(true);
        }
        else {
            gettotal();
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("updateorderstatus.fxml"));
            Parent first = firstLoader.load();
            UpdateOrderStatusController updateOrderStatusController = firstLoader.getController();
            updateOrderStatusController.contact.setText(contactno);
            updateOrderStatusController.customer.setText(receiptname);
            updateOrderStatusController.delivdetails.setText(details);
            updateOrderStatusController.setName(getName());
            updateOrderStatusController.setFname(getFname());
            updateOrderStatusController.orderstatus.setText(status);
            updateOrderStatusController.topay.setText("P " + rtotal + ".00");
            Scene Scene = new Scene(first);
            Stage Stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }


    }
    public void gettotal(){
        rtotal = 0;
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public."+receiptname+"_receipt";
            ResultSet check = sta.executeQuery(sql);
            while(check.next()){
                rtotal+=check.getInt("totalprice");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    public void viewcurrentorder(ActionEvent actionEvent) throws IOException {
        getorderstatus();
        getcontact();
        gettotal();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("viewcurrentorder.fxml"));
        Parent first = firstLoader.load();
        ViewCurrentOrderController viewCurrentOrderController = firstLoader.getController();
        viewCurrentOrderController.contact.setText(contactno);
        viewCurrentOrderController.customername.setText(receiptname);
        viewCurrentOrderController.setName(getName());
        viewCurrentOrderController.setFname(getFname());
        viewCurrentOrderController.total.setText("P "+rtotal+".00");
        viewCurrentOrderController.getReceipt();
        Scene Scene = new Scene(first);
        Stage Stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
