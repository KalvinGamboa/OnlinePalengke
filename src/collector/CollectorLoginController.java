package collector;

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

public class CollectorLoginController {
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
    public String contact;

    public void logincheck(String phone, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.collectoraccoundetails";
            ResultSet login = sta.executeQuery(sql);
            while(login.next()){
                if(password.equals(login.getString("password"))&&phone.equals(login.getString("mobile_number"))){
                    isuser = true;
                    name = login.getString("first_name")+" "+login.getString("last_name");
                    fname = login.getString("first_name");
                    contact = login.getString("mobile_number");
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
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("collector.fxml"));
            Parent first = firstLoader.load();
            CollectorController collectorController = firstLoader.getController();
            collectorController.greeting.setText("Good Day "+fname+"!");
            collectorController.setName(name);
            collectorController.setFname(fname);
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
