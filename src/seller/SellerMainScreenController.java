package seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SellerMainScreenController {
    public Button login;
    public Button collector;
    public Button seller;
    public Button buyer;


    public void login(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SellerLogin.fxml")));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }
}
