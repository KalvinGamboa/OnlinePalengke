package seller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class OrderHistoryController {
    public String seller;
    @FXML public TableView<orderhistory> yourorderhistory;
    @FXML public TableColumn<orderhistory, String> productcol;
    @FXML public TableColumn<orderhistory, Integer> pricecol;
    @FXML public TableColumn<orderhistory, String> quantitycol;
    @FXML public TableColumn<orderhistory, String> buyercol;
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public ObservableList<orderhistory> orderhistories = FXCollections.observableArrayList();


    public void home(ActionEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSeller());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void getOrderHistory(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getSeller()+"_orderhistory";
            ResultSet aorderhistory = sta.executeQuery(sql);
            while(aorderhistory.next()){
                orderhistories.add(new orderhistory(aorderhistory.getString("product"),aorderhistory.getInt("totalprice"),aorderhistory.getString("quantity"),aorderhistory.getString("buyer")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        productcol.setCellValueFactory(new PropertyValueFactory<orderhistory, String>("Product"));
        pricecol.setCellValueFactory(new PropertyValueFactory<orderhistory, Integer>("Price"));
        buyercol.setCellValueFactory(new PropertyValueFactory<orderhistory, String>("Buyer"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<orderhistory, String>("Quantity"));
        yourorderhistory.setItems(orderhistories);

    }
}
