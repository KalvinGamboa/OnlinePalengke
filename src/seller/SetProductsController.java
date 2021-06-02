package seller;

import buyer.order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SetProductsController extends SellerLoginController{
    public static String available = "";


    public ArrayList<products> products = new ArrayList<products>();
    @FXML public TableView<products> yourproducts;
    @FXML public TableColumn<products, String> productcol;
    @FXML public TableColumn<products, Integer> pricecol;
    @FXML public TableColumn<products, Integer> stockscol;
    public String measurement;
    public String seller;
    public String productselected;
    public Pane editproductscreen;
    public Label product;
    public TextField priceinput;
    public Label specification;
    public TextField stocksinput;

    public String getSeller() {
        return seller;
    }
    public products selectedproduct;
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public ObservableList<products> rproducts = FXCollections.observableArrayList();

    public void getProducts(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getSeller();
            ResultSet aproducts = sta.executeQuery(sql);
            while(aproducts.next()){
                rproducts.add(new products(aproducts.getString("product"),aproducts.getString("price"),aproducts.getInt("stock")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        productcol.setCellValueFactory(new PropertyValueFactory<products, String>("Product"));
        pricecol.setCellValueFactory(new PropertyValueFactory<products, Integer>("Price"));
        stockscol.setCellValueFactory(new PropertyValueFactory<products, Integer>("Stocks"));
        yourproducts.setItems(rproducts);
        yourproducts.getSortOrder().add(stockscol);

    }

    public void back2main(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSeller());
        sellerController.greeting.setText("Good Day "+getSeller()+"!");
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
    public void getSelectedproduct(){selectedproduct = yourproducts.getSelectionModel().getSelectedItem();}


    public void edit(ActionEvent actionEvent) {
        getSelectedproduct();
        if(selectedproduct.getProduct().equals("carrots")){ carrots();}
        if(selectedproduct.getProduct().equals("celery")){ celery();}
        if(selectedproduct.getProduct().equals("eggplant")){ eggplant();}
        if(selectedproduct.getProduct().equals("sili")){ sili();}
        if(selectedproduct.getProduct().equals("lettuce")){ lettuce();}
        if(selectedproduct.getProduct().equals("tomato")){ tomato();}
        if(selectedproduct.getProduct().equals("pineapple")){ pineapple();}
        if(selectedproduct.getProduct().equals("apple")){ apple();}
        if(selectedproduct.getProduct().equals("banana")){ banana();}
        if(selectedproduct.getProduct().equals("orange")){ orange();}
        if(selectedproduct.getProduct().equals("pork giniling")){ porkginiling();}
        if(selectedproduct.getProduct().equals("pork chop")){ porkchop();}
        if(selectedproduct.getProduct().equals("beef short ribs")){ beefshortribs();}
        if(selectedproduct.getProduct().equals("chicken wings")){ chickenwings();}
        if(selectedproduct.getProduct().equals("chicken drumstick")){ chickendrumstick();}
        if(selectedproduct.getProduct().equals("tilapia")){ tilapia();}
        if(selectedproduct.getProduct().equals("bangus")){ bangus();}
        if(selectedproduct.getProduct().equals("galunggong")){ galunggong();}
        if(selectedproduct.getProduct().equals("shrimp")){ shrimp();}
        if(selectedproduct.getProduct().equals("crab")){ crab();}

    }

    public void remove(ActionEvent actionEvent) {
    }

    public void carrots() {
        productselected = "carrots";
        product.setText("Carrots");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);
    }

    public void celery() {
        productselected = "celery";
        product.setText("Celery");
        measurement = "kg";
        specification.setText("1/2 "+measurement);
        editproductscreen.setVisible(true);


    }

    public void eggplant() {
        productselected = "eggplant";
        product.setText("Eggplant");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }
    public void sili() {
        productselected = "sili";
        product.setText("Sili");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void lettuce() {
        productselected = "lettuce";
        product.setText("Lettuce");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void tomato() {
        productselected = "tomato";
        product.setText("Tomato");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }

    public void pineapple() {
        productselected = "pineapple";
        product.setText("Pineapple");
        measurement = "pc";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void apple() {
        productselected = "apple";
        product.setText("Apple");
        specification.setText("1 pc");
        editproductscreen.setVisible(true);


    }

    public void banana() {
        productselected = "banana";
        product.setText("Banana");
        measurement = "hand";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void orange() {
        productselected = "orange";
        product.setText("Orange");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }


    public void porkginiling() {
        productselected = "pork giniling";
        product.setText("Pork Giniling");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void porkchop() {
        productselected = "pork chop";
        product.setText("Pork Chop");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void beefshortribs() {
        productselected = "beef short ribs";
        product.setText("Beef Short Ribs");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void chickendrumstick() {
        productselected = "chicken drumstick";
        product.setText("Chicken Drumstick");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }

    public void chickenwings() {
        productselected = "Chicken Wings";
        product.setText("Chicken Wings");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }
    public void bangus() {
        productselected = "bangus";
        product.setText("Bangus");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void tilapia() {
        productselected = "tilapia";
        product.setText("Tilapia");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void shrimp() {
        productselected ="shrimp";
        product.setText("Shrimp");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);


    }

    public void crab() {
        productselected = "crab";
        product.setText("Crab");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void galunggong() {
        productselected = "galunggong";
        product.setText("Galunggong");
        measurement = "kg";
        specification.setText("1 "+measurement);
        editproductscreen.setVisible(true);

    }

    public void confirmproduct(ActionEvent actionEvent) {
        getSelectedproduct();
        yourproducts.getItems().removeAll(yourproducts.getSelectionModel().getSelectedItem());
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","OnlinePalengke123");
            String sql = "DELETE from "+getSeller()+" WHERE product = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, productselected);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","OnlinePalengke123");
            String sql = "INSERT INTO "+getSeller()+" (product,price,stock) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, productselected);
            preparedStatement.setString(2, priceinput.getText());
            preparedStatement.setInt(3, Integer.parseInt(stocksinput.getText()));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        refreshorder();
        editproductscreen.setVisible(true);
    }
    public void refreshorder(){
        rproducts.clear();
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "SELECT * from public."+getSeller();
            ResultSet order = sta.executeQuery(sql);
            while(order.next()){
                rproducts.add(new products(order.getString("product"),order.getString("price"),order.getInt("stock")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        yourproducts.setItems(rproducts);
    }

    public void cancel() {
        editproductscreen.setVisible(false);
    }
}
