package buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class OrderStatusController {
    public Pane orderstatusscreen;
    public Label collectorname;
    public Label orderrecieved;
    public Label ordercollected;
    public Label deliveringorder;
    public Label ordersecured;
    public Label orderreceivedcomplete;
    public Label ordercollectedcomplete;
    public Label deliveringordercompleted;
    public Label ordersecuredcompleted;
    public Label topay;
    public Label warning;
    public Label contact;
    public Button confirmorderbtn;
    public String name;
    public String usercontact;

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void returntobuyer(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("buyer.fxml"));
        Parent first = firstLoader.load();
        BuyerController buyerController = firstLoader.getController();
        buyerController.greeting.setText("Good Day "+getName()+"!");
        buyerController.setReceiptname(getName());
        buyerController.setUsercontact(getUsercontact());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void confirmorder(ActionEvent actionEvent) throws IOException {
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "DELETE FROM "+getName()+"_receipt";
            ResultSet resultSet = sta.executeQuery(sql);
            resultSet.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String sql = "DELETE FROM confirmeorder WHERE receipt_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
            String sql = "UPDATE collectoravailable set currentlyserving = ?,status = ? where currentlyserving = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "none");
            preparedStatement.setString(2, "none");
            preparedStatement.setString(3, getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("buyer.fxml"));
        Parent first = firstLoader.load();
        BuyerController buyerController = firstLoader.getController();
        buyerController.greeting.setText("Good Day "+getName()+"!");
        buyerController.setReceiptname(getName());
        buyerController.setUsercontact(getUsercontact());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
