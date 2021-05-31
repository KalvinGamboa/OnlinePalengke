package seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SellerLoginController {
    public Label warning;

    public TextField loginphonenumber;

    public PasswordField password;
    public PasswordField loginpassword;

    public static boolean isuser = false;

    public Label loginwarning;

    public String name;
    public String fname;

    public String loginph;
    public String loginpass;

    public void logincheck(String phone, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.selleraccountdetails";
            ResultSet login = sta.executeQuery(sql);
            while(login.next()){
                if(password.equals(login.getString("password"))&&phone.equals(login.getString("phone_number"))){
                    isuser = true;
                    name = login.getString("seller");
                    fname = login.getString("stallname");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void login(ActionEvent actionEvent) throws IOException {
        loginpass = loginpassword.getText();
        loginph = loginphonenumber.getText();
        logincheck(loginph,loginpass);
        if(isuser){
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
            Parent first = firstLoader.load();
            SellerController sellerController = firstLoader.getController();
            sellerController.greeting.setText("Good Day "+fname+"!");
            sellerController.setSellerstall(name);
            Scene Scene = new Scene(first);
            Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        else{
            loginwarning.setText("Incorrect Phone Number/Password");
            loginwarning.setVisible(true);
        }
    }
}
