package buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class BuyerController{

    public Pane mainmenu;

    public TextArea receivedetails;
    public Label checkavailable;
    public Pane buyerinfo;


    public void tobuyerinfo(MouseEvent actionEvent) throws IOException {
        buyerinfo.setVisible(true);
    }

    public void buy(ActionEvent actionEvent) throws IOException {
        FileWriter myWriterCollector = new FileWriter("collector.txt", true);
        myWriterCollector.write("FROM: Buyer"+"\r\n");
        myWriterCollector.write("DELIVERY DETAILS: "+receivedetails.getText()+"\r\n");
        myWriterCollector.write("PRODUCTS\r\n");
        myWriterCollector.close();
        Parent Parent = FXMLLoader.load(getClass().getResource("purchase.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Parent mainmenuParent = FXMLLoader.load(getClass().getResource("../mainscreen.fxml"));
        Scene mainmenuScene = new Scene(mainmenuParent);
        Stage mainmenu =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainmenu.setScene(mainmenuScene);
        mainmenu.show();
    }

    public void complete(MouseEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("complete.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();;
    }

    public void back(MouseEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("purchase.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void cancel(MouseEvent mouseEvent) {
        buyerinfo.setVisible(false);
    }
}
