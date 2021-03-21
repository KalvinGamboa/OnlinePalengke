package buyer;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class ReceiptController extends BuyerController implements Initializable {

    public Label rtotal;
    public Pane confirmedscreen;
    public Pane receiptscreen;

    private List<String> receiptList;
    private ObservableList<String> list = FXCollections.observableArrayList();

    public ListView<String> receipt;

    public void fillreceipt(){
        this.receiptList = Collections.emptyList();
        try {
            this.receiptList = Files.readAllLines(Paths.get("receipt.txt"), StandardCharsets.UTF_8);

        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public ObservableList<String> getReceipt(){
        fillreceipt();
        if(!receiptList.isEmpty()){
            for(int i = 0; i<receiptList.size();i++){
                list.add(receiptList.get(i));
            }

        }
        return list;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        receipt.setItems(getReceipt());

    }

    public void complete(MouseEvent mouseEvent) {
        receiptscreen.setVisible(false);
        confirmedscreen.setVisible(true);
        File delete = new File("receipt.txt");
        delete.delete();
    }
    public void back(ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("purchase.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void returntobuyerscreen(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("buyer.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
