package collector;

import buyer.order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AcceptOrderController extends CollectorController{
    @FXML public TableView<order> customerorder;
    public ObservableList<order> receipt = FXCollections.observableArrayList();
    public String name;
    public Label customername;
    public Label contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @FXML public TableColumn<order, String> productcol;
    @FXML public TableColumn<order, String> quantitycol;
    @FXML public TableColumn<order, Integer> pricecol;
    @FXML public TableColumn<order, String> stallcol;
    public Label total;
    public void getReceipt(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+receiptname+"_receipt";
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
        customerorder.setItems(receipt);

    }

    public void back2main(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("collector.fxml"));
        Parent first = firstLoader.load();
        CollectorController collectorController = firstLoader.getController();
        collectorController.greeting.setText("Good Day "+fname+"!");
        collectorController.setName(name);
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void acceptorder(ActionEvent actionEvent) throws IOException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public.collectoravailable";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                if(order.getString("currentlyserving").equals(receiptname)){
                    Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
                    String sql2 = "UPDATE collectoravailable set status = ? where currentlyserving = ?";
                    PreparedStatement preparedStatement2 = conn2.prepareStatement(sql2);
                    preparedStatement2.setString(1, "order received");
                    preparedStatement2.setString(2, receiptname);
                    preparedStatement2.executeUpdate();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        gettotal();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("updateorderstatus.fxml"));
        Parent first = firstLoader.load();
        UpdateOrderStatusController updateOrderStatusController = firstLoader.getController();
        updateOrderStatusController.contact.setText(contactno);
        updateOrderStatusController.customer.setText(receiptname);
        updateOrderStatusController.delivdetails.setText(details);
        updateOrderStatusController.orderstatus.setText("Order Received");
        updateOrderStatusController.setName(getName());
        updateOrderStatusController.setFname(getFname());
        updateOrderStatusController.topay.setText("P " + rtotal + ".00");
        Scene Scene = new Scene(first);
        Stage Stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();

    }
}
