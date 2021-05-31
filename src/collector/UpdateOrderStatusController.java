package collector;

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
import java.sql.*;

public class UpdateOrderStatusController {
    public Pane orderstatusscreen;
    public Label topay;
    public Label warning;
    public Label contact;
    public Label customer;
    public Label delivdetails;
    public String name;
    public Label orderstatus;
    public static String status = "";
    public String newstatus;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String fname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(ActionEvent actionEvent) {
        getorderstatus();
        if(!status.equals("order secured")) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
                String sql = "UPDATE collectoravailable set status = ? where collector = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                if (status.equals("order received")) {
                    preparedStatement.setString(1, "order collected");
                    newstatus = "Order Collected";
                }
                if (status.equals("order collected")) {
                    preparedStatement.setString(1, "delivering order");
                    newstatus = "Delivering Order";
                }
                if (status.equals("delivering order")) {
                    preparedStatement.setString(1, "order secured");
                    newstatus = "Order Secured";
                }
                preparedStatement.setString(2, getName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            orderstatus.setText(newstatus);
        }
    }


    public void getorderstatus(){
        System.out.println(getName());
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public.collectoravailable";
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                if(order.getString("collector").equals(getName())){
                    status = order.getString("status");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void back2main(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("collector.fxml"));
        Parent first = firstLoader.load();
        CollectorController collectorController = firstLoader.getController();
        collectorController.greeting.setText("Good Day "+getName()+"!");
        collectorController.setName(name);
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
