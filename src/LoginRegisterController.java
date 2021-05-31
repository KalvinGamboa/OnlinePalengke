import buyer.BuyerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class LoginRegisterController {
    public Label warning;

    public TextField firstname;
    public TextField lastname;
    public TextField phonenumber;
    public TextField loginphonenumber;

    public PasswordField password;
    public PasswordField confirmpassword;
    public PasswordField loginpassword;

    public static boolean isuser = false;
    public static boolean isadmin = false;

    public Label loginwarning;

    public String name;
    public String fname;

    public String loginph;
    public String loginpass;

    public void logincheck(String phone, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.useraccountdetails";
            ResultSet login = sta.executeQuery(sql);
            while(login.next()){
                if(password.equals(login.getString("password"))&&phone.equals(login.getString("phone_number"))){
                    isuser = true;
                    name = login.getString("first_name")+"_"+login.getString("last_name");
                    fname = login.getString("first_name");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        isadmin = phone.equals("Admin01")&&password.equals("AdminControl");
    }

    public String getName() {
        return name;
    }

    public void login(ActionEvent actionEvent) throws IOException {
        loginpass = loginpassword.getText();
        loginph = loginphonenumber.getText();
        logincheck(loginph,loginpass);
        if(isuser){
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/receipts", "postgres", "OnlinePalengke123");
                Statement sta = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS " +getName()+"_receipt(stall varchar(255), product varchar(255),quantity varchar(50), totalprice int)";
                sta.execute(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }
            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("buyer/buyer.fxml"));
            Parent first = firstLoader.load();
            BuyerController buyerController = firstLoader.getController();
            buyerController.greeting.setText("Good Day "+fname+"!");
            buyerController.setReceiptname(name);
            buyerController.setUsercontact(loginph);
            Scene Scene = new Scene(first);
            Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Stage.setScene(Scene);
            Stage.show();
        }
        if (isadmin) {
            Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminmain.fxml")));
            Scene mainmenuScene = new Scene(mainmenuParent);
            Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            mainmenu.setScene(mainmenuScene);
            mainmenu.show();
        } else {
            loginwarning.setText("Incorrect Phone Number/Password");
            loginwarning.setVisible(true);
        }
    }

    public void register(ActionEvent actionEvent) throws IOException {
        if (firstname.getText().isEmpty()||lastname.getText().isEmpty()||phonenumber.getText().isEmpty()||password.getText().isEmpty()||confirmpassword.getText().isEmpty()){
            warning.setText("Details Incomplete");
            warning.setVisible(true);
        }
        else {
            if (!password.getText().equals(confirmpassword.getText())) {
                warning.setText("Password Does Not Match");
                warning.setVisible(true);
            } else {
                warning.setVisible(false);
                try{
                    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounts","postgres","OnlinePalengke123");
                    String sql = "INSERT INTO public.useraccountdetails"+"(first_name,last_name,password,phone_number)"+"VALUES(?,?,?,?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, firstname.getText());
                    preparedStatement.setString(2, lastname.getText());
                    preparedStatement.setString(3, password.getText());
                    preparedStatement.setString(4, phonenumber.getText());
                    preparedStatement.executeUpdate();

                } catch (SQLException e){
                    e.printStackTrace();
                }
                Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainscreen.fxml")));
                Scene mainmenuScene = new Scene(mainmenuParent);
                Stage mainmenu = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                mainmenu.setScene(mainmenuScene);
                mainmenu.show();
            }
        }
    }

    public void gotoregister(MouseEvent mouseEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void gotologin(MouseEvent mouseEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }
}
