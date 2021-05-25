package seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SetProductsController extends SellerLoginController{
    public CheckBox unavailablecarrots;
    public CheckBox unavailablecelery;
    public CheckBox unavailableeggplant;
    public TextField newpricecarrots;
    public TextField newpricecelery;
    public TextField newpriceeggplant;
    public Pane setproductscreen;
    public Pane fruits;
    public CheckBox unavailableapple;
    public TextField newpriceapple;
    public CheckBox unavailablebanana;
    public CheckBox unavailablepineapple;
    public TextField newpricebanana;
    public TextField newpricepineapple;
    public TextField newpriceorange;
    public CheckBox unavailableorange;
    public TextField newpricetomato;
    public CheckBox unavailabletomato;
    public Pane vegetables;
    public TextField newpricelettuce;
    public CheckBox unavailablelettuce;
    public TextField newpricesili;
    public CheckBox unavailablesili;
    public Pane meat;
    public CheckBox unavailablecd;
    public CheckBox unavailablebsr;
    public CheckBox unavailablecw;
    public TextField newpricecd;
    public TextField newpricecw;
    public TextField newpricebsr;
    public CheckBox unavailablepc;
    public TextField newpricepc;
    public CheckBox unavailablepg;
    public TextField newpricepg;
    public Pane seafood;
    public CheckBox unavailablebangus;
    public TextField newpricebangus;
    public CheckBox unavailablecrab;
    public CheckBox unavailablegalunggong;
    public TextField newpricecrab;
    public TextField newpricegalunggong;
    public CheckBox unavailableshrimp;
    public TextField newpriceshrimp;
    public CheckBox unavailabletilapia;
    public TextField newpricetilapia;
    public String sellerstall;
    public static String available = "";
    ArrayList<String> productsupdated = new ArrayList<String>();


    public ArrayList<products> products = new ArrayList<products>();
    public void setProducts(){
        if(unavailablecarrots.isSelected()){
            products.add(new products("carrots",true,newpricecarrots.getText()));
        }
        if(unavailablecelery.isSelected()){
            products.add(new products("celery",true,newpricecelery.getText()));
        }
        if(unavailableeggplant.isSelected()){
            products.add(new products("eggplant",true,newpriceeggplant.getText()));
        }
        if(unavailableapple.isSelected()){
            products.add(new products("apple",true,newpriceapple.getText()));
        }
        if(unavailablebanana.isSelected()){
            products.add(new products("banana",true,newpricebanana.getText()));
        }
        if(unavailablebangus.isSelected()){
            products.add(new products("bangus",true,newpricebangus.getText()));
        }
        if(unavailablebsr.isSelected()){
            products.add(new products("beef short ribs",true,newpricebsr.getText()));
        }
        if(unavailablecd.isSelected()){
            products.add(new products("chicken drumstick",true,newpricecd.getText()));
        }
        if(unavailablecrab.isSelected()){
            products.add(new products("crab",true,newpricecd.getText()));
        }
        if(unavailablecw.isSelected()){
            products.add(new products("chicken wings",true,newpricecw.getText()));
        }
        if(unavailablegalunggong.isSelected()){
            products.add(new products("galunggong",true,newpricegalunggong.getText()));
        }
        if(unavailablelettuce.isSelected()){
            products.add(new products("lettuce",true,newpricelettuce.getText()));
        }
        if(unavailableorange.isSelected()){
            products.add(new products("orange",true,newpriceorange.getText()));
        }
        if(unavailablepc.isSelected()){
            products.add(new products("pork chop",true,newpricepc.getText()));
        }
        if(unavailablepg.isSelected()){
            products.add(new products("pork giniling",true,newpricepg.getText()));
        }
        if(unavailablepineapple.isSelected()){
            products.add(new products("pineapple",true,newpricepineapple.getText()));
        }
        if(unavailableshrimp.isSelected()){
            products.add(new products("shrimp",true,newpriceshrimp.getText()));
        }
        if(unavailablesili.isSelected()){
            products.add(new products("sili",true,newpricesili.getText()));
        }
        if(unavailabletilapia.isSelected()){
            products.add(new products("tilapia",true,newpricetilapia.getText()));
        }
        if(unavailabletomato.isSelected()){
            products.add(new products("tomato",true,newpricetomato.getText()));
        }
        if(!unavailablecarrots.isSelected()){
            products.add(new products("carrots",false,"00.00"));
        }
        if(!unavailablecelery.isSelected()){
            products.add(new products("celery",false,"00.00"));
        }
        if(!unavailableeggplant.isSelected()){
            products.add(new products("eggplant",false,"00.00"));
        }
        if(!unavailableapple.isSelected()){
            products.add(new products("apple",false,"00.00"));
        }
        if(!unavailablebanana.isSelected()){
            products.add(new products("banana",false,"00.00"));
        }
        if(!unavailablebangus.isSelected()){
            products.add(new products("bangus",false,"00.00"));
        }
        if(!unavailablebsr.isSelected()){
            products.add(new products("beef short ribs",false,"00.00"));
        }
        if(!unavailablecd.isSelected()){
            products.add(new products("chicken drumstick",false,"00.00"));
        }
        if(!unavailablecrab.isSelected()){
            products.add(new products("crab",false,"00.00"));
        }
        if(!unavailablecw.isSelected()){
            products.add(new products("chicken wings",false,"00.00"));
        }
        if(!unavailablegalunggong.isSelected()){
            products.add(new products("galunggong",false,"00.00"));
        }
        if(!unavailablelettuce.isSelected()){
            products.add(new products("lettuce",false,"00.00"));
        }
        if(!unavailableorange.isSelected()){
            products.add(new products("orange", false, "00.00"));
        }
        if(!unavailablepc.isSelected()){
            products.add(new products("pork chop",false,"00.00"));
        }
        if(!unavailablepg.isSelected()){
            products.add(new products("pork giniling",false,"00.00"));
        }
        if(!unavailablepineapple.isSelected()){
            products.add(new products("pineapple",false,"00.00"));
        }
        if(!unavailableshrimp.isSelected()){
            products.add(new products("shrimp",false,"00.00"));
        }
        if(!unavailablesili.isSelected()){
            products.add(new products("sili",false,"00.00"));
        }
        if(!unavailabletilapia.isSelected()){
            products.add(new products("tilapia",false,"00.00"));
        }
        if(!unavailabletomato.isSelected()){
            products.add(new products("tomato",false,"00.00"));
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public." + sellerstall;
            ResultSet search = sta.executeQuery(sql);
            while(search.next()) {
                int i = 0;
                int productsize = products.size();
                while (i < productsize) {
                    if (search.getString("product").equals(products.get(i).getProduct())){
                        if(products.get(i).isAvailable()){
                            available = "yes";
                        }
                        else{
                            available = "no";
                        }
                        productsupdated.add(products.get(i).getProduct());
                        String update = "UPDATE "+sellerstall+" set price = ?,available = ? where product = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(update);
                        preparedStatement.setString(1, products.get(i).getPrice());
                        preparedStatement.setString(2, available);
                        preparedStatement.setString(3, products.get(i).getProduct());
                        preparedStatement.executeUpdate();
                    }
                    i++;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        int i = 0;
        while(i < productsupdated.size()){
            int j = 0;
            while(j < products.size()){
                if(productsupdated.get(i).equals(products.get(j).getProduct())){
                    products.remove(j);
                }
                j++;
            }
            i++;
        }
        i = 0;
        while(i < products.size()) {
            if(products.get(i).isAvailable()){
                available = "yes";
            }
            else{
                available = "no";
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
                String sql = "INSERT INTO public." + sellerstall + " (product,price,available)" + "VALUES(?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, products.get(i).getProduct());
                preparedStatement.setString(2, products.get(i).getPrice());
                preparedStatement.setString(3, available);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.greeting.setText("Good Day "+fname+"!");
        sellerController.setSellerstall(getSellerstall());
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void vegetables() {
        vegetables.setVisible(true);
        fruits.setVisible(false);
        meat.setVisible(false);
        seafood.setVisible(false);
    }

    public void fruits() {
        vegetables.setVisible(false);
        fruits.setVisible(true);
        meat.setVisible(false);
        seafood.setVisible(false);
    }

    public void meat() {
        vegetables.setVisible(false);
        fruits.setVisible(false);
        meat.setVisible(true);
        seafood.setVisible(false);
    }

    public void seafood() {
        vegetables.setVisible(false);
        fruits.setVisible(false);
        meat.setVisible(false);
        seafood.setVisible(true);
    }

    public String getSellerstall() {
        return sellerstall;
    }

    public void setSellerstall(String sellerstall) {
        this.sellerstall = sellerstall;
    }

    public void confirm(ActionEvent actionEvent) throws IOException {
        setProducts();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSellerstall());
        sellerController.greeting.setText("Good Day "+getSellerstall()+"!");
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }

    public void back2main(MouseEvent mouseEvent) throws IOException {
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("seller.fxml"));
        Parent first = firstLoader.load();
        SellerController sellerController = firstLoader.getController();
        sellerController.setSellerstall(getSellerstall());
        sellerController.greeting.setText("Good Day "+getSellerstall()+"!");
        Scene Scene = new Scene(first);
        Stage Stage =(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Stage.setScene(Scene);
        Stage.show();
    }
}
