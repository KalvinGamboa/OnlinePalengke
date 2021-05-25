import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainScreenController {
    public Button login;
    public Button register;
    public Button collector;
    public Button seller;
    public Button buyer;

    public void register(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void seller(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("seller/SellerMainScreen.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void collector(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("collector/CollectorMainScreen.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void buyer(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buyer/buyer.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }
}
