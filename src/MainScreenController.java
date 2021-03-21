import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    public Button login;
    public Button register;
    public Button collector;
    public Button seller;
    public Button buyer;

    public void register(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void seller(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("seller/seller.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void collector(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("collector/collector.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void buyer(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("buyer/buyer.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }
}
