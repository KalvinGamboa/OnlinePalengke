package buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class ProductController extends BuyerController{
    public Label price;
    public TextField Quantity;
    public Label label;
    public static String stall = "";
    public static float totalprice = 0;
    public static float buying = 0;

    public void roberto(MouseEvent mouseEvent) {
        if(carrot) {
            label.setText("Roberto's - P45.00");
            buying = 45;
        }
        if(celery){
            label.setText("Roberto's - P26.00");
            buying = 26;
        }
        if(eggplant){
            label.setText("Roberto's - P32.00");
            buying = 32;
        }
        stall = "Roberto's";
    }

    public void alberto(MouseEvent mouseEvent) {
        if(carrot) {
            label.setText("Alberto's - P42.00");
            buying = 42;
        }
        if(celery){
            label.setText("UNAVAILABLE");
            buying = 0;
        }
        if(eggplant){
            label.setText("Alberto's - P37.00");
            buying = 37;
        }
        stall = "Alberto's";
    }

    public void norberto(MouseEvent mouseEvent) {
        if(carrot) {
            label.setText("Norberto's - P44.00");
            buying = 44;
        }
        if(celery){
            label.setText("Norberto's - P21.00");
            buying = 21;
        }
        if(eggplant){
            label.setText("Norberto's - P30.00");
            buying = 30;
        }
        stall = "Norberto's";
    }

    public void confirm(ActionEvent actionEvent) throws IOException {
        if(carrot) {
            int quantity = Integer.parseInt(Quantity.getText());
            float price = buying*quantity;
            totalprice+=price;
            System.out.println(totalprice);
            try {
                FileWriter myWriterReceipt = new FileWriter("receipt.txt", true);
                FileWriter myWriterCollector = new FileWriter("collector.txt", true);
                myWriterReceipt.write(stall+" carrots "+quantity+" kg - " + price + "\r\n");
                myWriterCollector.write(stall+" carrots "+quantity+" kg - " + price + "\r\n");
                myWriterReceipt.close();
                myWriterCollector.close();
            } catch (IOException var5) {
                System.out.println("An error occurred.");
                var5.printStackTrace();
            }
        }
        else if(celery) {
            int quantity = Integer.parseInt(Quantity.getText());
            float price = buying*quantity;
            totalprice+=price;
            try {
                FileWriter myWriterReceipt = new FileWriter("receipt.txt", true);
                FileWriter myWriterCollector = new FileWriter("collector.txt", true);
                myWriterReceipt.write(stall +" celery "+ quantity+ " kg - " + price + "\r\n");
                myWriterCollector.write(stall +" celery "+ quantity+ " kg - " + price + "\r\n");
                myWriterReceipt.close();
                myWriterCollector.close();
            } catch (IOException var5) {
                System.out.println("An error occurred.");
                var5.printStackTrace();
            }
        }
        else if(eggplant) {
            int quantity = Integer.parseInt(Quantity.getText());
            float price = buying*quantity;
            totalprice+=price;
            try {
                FileWriter myWriterReceipt = new FileWriter("receipt.txt", true);
                FileWriter myWriterCollector = new FileWriter("collector.txt", true);
                myWriterReceipt.write(stall+" eggplant "+quantity+" kg - " + price + "\r\n");
                myWriterCollector.write(stall+" eggplant "+quantity+" kg - " + price + "\r\n");
                myWriterReceipt.close();
                myWriterCollector.close();
            } catch (IOException var5) {
                System.out.println("An error occurred.");
                var5.printStackTrace();
            }
        }
        totallabel = "P"+totalprice+"0";
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("purchase.fxml"));
        Parent first = firstLoader.load();
        BuyerController buyerController = firstLoader.getController();
        buyerController.total.setText(totallabel);
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();

    }

    public void back(MouseEvent actionEvent) throws IOException {
        Parent Parent = FXMLLoader.load(getClass().getResource("purchase.fxml"));
        Scene Scene = new Scene(Parent);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
