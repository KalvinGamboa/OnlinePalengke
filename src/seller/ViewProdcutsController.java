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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ViewProdcutsController {
    public String seller;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @FXML public TableView<products> yourproducts;

    public ObservableList<products> rproducts = FXCollections.observableArrayList();

    @FXML public TableColumn<products, String> productcol;
    @FXML public TableColumn<products, Integer> pricecol;

    public void getProducts(){
        try {
            boolean ava;
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getSeller();
            ResultSet aproducts = sta.executeQuery(sql);
            while(aproducts.next()){
                ava = aproducts.getString("available").equals("yes");
                rproducts.add(new products(aproducts.getString("product"),ava,aproducts.getString("price")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        productcol.setCellValueFactory(new PropertyValueFactory<products, String>("Product"));
        pricecol.setCellValueFactory(new PropertyValueFactory<products, Integer>("Price"));
        yourproducts.setItems(rproducts);

    }
    public void back2main(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSeller());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }


    public void home(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSeller());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
