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

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

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

    public Label loginwarning;

    public String loginph;
    public String loginpass;

    public void logincheck(String phone, String password){
        boolean stop = false;
        List<String> lines = Collections.emptyList();
        List lines2 = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("password.txt"), StandardCharsets.UTF_8);
            lines2 = Files.readAllLines(Paths.get("phone.txt"), StandardCharsets.UTF_8);
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        do {
            for(int i = 0; i < lines.size(); ++i) {
                if (password.equals(lines.get(i))&&phone.equals(lines2.get(i))) {
                    i = lines.size();
                    isuser = true;
                    stop = true;
                }
                if (i == lines.size() - 1) {
                    stop = false;
                    isuser = false;
                    i++;
                }
            }
            if(!isuser){
                stop = true;
            }
        } while(!stop);
    }
    public void login(ActionEvent actionEvent) throws IOException {
        loginpass = loginpassword.getText();
        loginph = loginphonenumber.getText();
        logincheck(loginph,loginpass);
        if(isuser){
            Parent mainmenuParent = FXMLLoader.load(getClass().getResource("buyer/buyer.fxml"));
            Scene mainmenuScene = new Scene(mainmenuParent);
            Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            mainmenu.setScene(mainmenuScene);
            mainmenu.show();
        }
        else{
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
                try {
                    FileWriter myWriterUser = new FileWriter("name.txt", true);
                    FileWriter myWriterPass = new FileWriter("password.txt", true);
                    FileWriter myWriterPhone = new FileWriter("phone.txt", true);
                    myWriterUser.write(firstname.getText() + "\r\n");
                    myWriterPass.write(password.getText() + "\r\n");
                    myWriterPhone.write(phonenumber.getText() + "\r\n");
                    myWriterUser.close();
                    myWriterPass.close();
                    myWriterPhone.close();
                } catch (IOException var5) {
                    System.out.println("An error occurred.");
                    var5.printStackTrace();
                }
                Parent mainmenuParent = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
                Scene mainmenuScene = new Scene(mainmenuParent);
                Stage mainmenu = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                mainmenu.setScene(mainmenuScene);
                mainmenu.show();
            }
        }
    }

    public void gotoregister(MouseEvent mouseEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void gotologin(MouseEvent mouseEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }
}
