import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class AdminController {
    public TextField sellerid;
    public TextField sellerstallname;
    public TextField sellermobilenumber;
    public TextField sellerpassword;
    public Label warning;
    public TextField collectorfname;
    public TextField collectorlname;
    public TextField collectormobilenumber;
    public TextField collectorpassword;

    public void addseller(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addseller.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void signout(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainscreen.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void addcollector(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addcollector.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();

    }

    public void confirmaddseller(ActionEvent actionEvent) throws IOException {
        if (sellerid.getText().isEmpty()||sellerstallname.getText().isEmpty()||sellerpassword.getText().isEmpty()||sellermobilenumber.getText().isEmpty()){
            warning.setText("Details Incomplete");
            warning.setVisible(true);
        }
        else {
            warning.setVisible(false);
            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
                String sql = "INSERT INTO public.selleraccountdetails"+"(seller, phone_number, password, stallname)"+"VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, sellerid.getText());
                preparedStatement.setString(2, sellermobilenumber.getText());
                preparedStatement.setString(3, sellerpassword.getText());
                preparedStatement.setString(4, sellerstallname.getText());
                preparedStatement.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","OnlinePalengke123");
                String sql = "INSERT INTO public.stalls"+"(stall, stall_name)"+"VALUES(?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, sellerid.getText());
                preparedStatement.setString(2, sellerstallname.getText());
                preparedStatement.executeUpdate();
                Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","OnlinePalengke123");
                Statement sta = conn2.createStatement();
                String sql2 = "CREATE TABLE "+ sellerid.getText()+" (product varchar(99), price varchar(99), available varchar(99))";
                sta.executeQuery(sql2);
                ResultSet resultSet2 = sta.executeQuery(sql2);
                resultSet2.next();
            } catch (SQLException e){
                e.printStackTrace();
            }
            try {
                Connection conn4 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
                Statement sta4 = conn4.createStatement();
                String sql4 = "CREATE TABLE IF NOT EXISTS " + sellerid.getText() + "_orderhistory(buyer varchar(255), product varchar(255),quantity varchar(50), totalprice int)";
                ResultSet resultSet = sta4.executeQuery(sql4);
                resultSet.next();
            }catch (SQLException e){
                e.printStackTrace();
            }
            Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminmain.fxml")));
            Scene mainmenuScene = new Scene(mainmenuParent);
            Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            mainmenu.setScene(mainmenuScene);
            mainmenu.show();
        }
    }

    public void confirmaddcollector(ActionEvent actionEvent) throws IOException {
        if (collectorfname.getText().isEmpty()||collectorlname.getText().isEmpty()||collectorpassword.getText().isEmpty()||collectormobilenumber.getText().isEmpty()){
            warning.setText("Details Incomplete");
            warning.setVisible(true);
        }
        else {
            warning.setVisible(false);
            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
                String sql = "INSERT INTO public.collectoraccoundetails"+"(first_name, last_name, password, mobile_number)"+"VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, collectorfname.getText());
                preparedStatement.setString(2, collectorlname.getText());
                preparedStatement.setString(3, collectorpassword.getText());
                preparedStatement.setString(4, collectormobilenumber.getText());
                preparedStatement.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts","postgres","OnlinePalengke123");
                String sql = "INSERT INTO public.collectoravailable"+"(collector, currentlyserving, status ,collector_contact)"+"VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, collectorfname.getText()+" "+collectorlname.getText());
                preparedStatement.setString(2, "none");
                preparedStatement.setString(3, "none");
                preparedStatement.setString(4, collectormobilenumber.getText());
                preparedStatement.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
            Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminmain.fxml")));
            Scene mainmenuScene = new Scene(mainmenuParent);
            Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            mainmenu.setScene(mainmenuScene);
            mainmenu.show();
        }
    }

    public void cancel(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminmain.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

}
