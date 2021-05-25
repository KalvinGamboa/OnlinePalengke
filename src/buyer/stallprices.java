package buyer;

import java.sql.*;

public class stallprices {
    public static String carrotstall="",celerystall="",eggplantstall="",lettucestall="",silistall="",bananastall="",applestall="",orangestall="",pineapplestall="", tomatostall="", chickendrumstickstall="",
            chickenwingsstall="", beefshortribsstall="", porkchopstall="", porkginilingstall="", bangusstall="", tilapiastall="", galunggongstall="" ,shrimpstall="", crabstall="";
    public static String carrotprice,celeryprice,eggplantprice,lettuceprice,siliprice,bananaprice,appleprice, orangeprice, pineappleprice, tomatoprice, chickendrumstickprice,
            chickenwingsprice, beefshortribsprice, porkchopprice, porkginilingprice, bangusprice,tilapiaprice,galunggongprice,shrimpprice,crabprice;

    public static String carrot2price,celery2price,eggplant2price,lettuce2price,sili2price,banana2price,apple2price, orange2price, pineapple2price, tomato2price, chickendrumstick2price,
            chickenwings2price, beefshortribs2price, porkchop2price, porkginiling2price, bangus2price,tilapia2price,galunggong2price,shrimp2price,crab2price;
    public static String carrot2,celery2,eggplant2,lettuce2,sili2,banana2,apple2,orange2,pineapple2, tomato2, chickendrumstick2,
            chickenwings2, beefshortribs2, porkchop2, porkginiling2, bangus2,tilapia2,galunggong2,shrimp2,crab2;
    public void productcheck(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","OnlinePalengke123");
            Statement sta = conn.createStatement();
            String sql = "select * from public.stalls";
            ResultSet searchstalls = sta.executeQuery(sql);
            while (searchstalls.next()) {
                Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "OnlinePalengke123");
                Statement sta2 = conn2.createStatement();
                String sql2 = "select * from public."+searchstalls.getString("stall");
                ResultSet search = sta2.executeQuery(sql2);
                while (search.next()) {
                    if (search.getString("product").equals("bangus") && search.getString("available").equals("yes") && bangusstall.isEmpty()){
                        bangusstall = searchstalls.getString("stall_name");
                        bangusprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("tilapia") && search.getString("available").equals("yes")&&tilapiastall.isEmpty()) {
                        tilapiastall = searchstalls.getString("stall_name");
                        tilapiaprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("galunggong") && search.getString("available").equals("yes")&&galunggongstall.isEmpty()) {
                        galunggongstall = searchstalls.getString("stall_name");
                        galunggongprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("shrimp") && search.getString("available").equals("yes")&&shrimpstall.isEmpty()) {
                        shrimpstall = searchstalls.getString("stall_name");
                        shrimpprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("crab") && search.getString("available").equals("yes")&&crabstall.isEmpty()) {
                        crabstall = searchstalls.getString("stall_name");
                        crabprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("pork chop") && search.getString("available").equals("yes")&&porkchopstall.isEmpty()) {
                        porkchopstall = searchstalls.getString("stall_name");
                        porkchopprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("pork giniling") && search.getString("available").equals("yes")&&porkginilingstall.isEmpty()) {
                        porkginilingstall = searchstalls.getString("stall_name");
                        porkginilingprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("beef short ribs") && search.getString("available").equals("yes")&&beefshortribsstall.isEmpty()) {
                        beefshortribsstall = searchstalls.getString("stall_name");
                        beefshortribsprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("chicken drumstick") && search.getString("available").equals("yes")&&chickendrumstickstall.isEmpty()) {
                        chickendrumstickstall = searchstalls.getString("stall_name");
                        chickendrumstickprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("chicken wings") && search.getString("available").equals("yes")&&chickenwingsstall.isEmpty()) {
                        chickenwingsstall = searchstalls.getString("stall_name");
                        chickenwingsprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("carrots") && search.getString("available").equals("yes")&&carrotstall.isEmpty()) {
                        carrotstall = searchstalls.getString("stall_name");
                        carrotprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("celery") && search.getString("available").equals("yes")&&celerystall.isEmpty()) {
                        celerystall = searchstalls.getString("stall_name");
                        celeryprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("eggplant") && search.getString("available").equals("yes")&&eggplantstall.isEmpty()) {
                        eggplantstall = searchstalls.getString("stall_name");
                        eggplantprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("lettuce") && search.getString("available").equals("yes")&&lettucestall.isEmpty()) {
                        lettucestall = searchstalls.getString("stall_name");
                        lettuceprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("sili") && search.getString("available").equals("yes")&&silistall.isEmpty()) {
                        silistall = searchstalls.getString("stall_name");
                        siliprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("banana") && search.getString("available").equals("yes")&&bananastall.isEmpty()) {
                        bananastall = searchstalls.getString("stall_name");
                        bananaprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("apple") && search.getString("available").equals("yes")&&applestall.isEmpty()) {
                        applestall = searchstalls.getString("stall_name");
                        appleprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("orange") && search.getString("available").equals("yes")&&orangestall.isEmpty()) {
                        orangestall = searchstalls.getString("stall_name");
                        orangeprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("pineapple") && search.getString("available").equals("yes")&&pineapplestall.isEmpty()) {
                        pineapplestall = searchstalls.getString("stall_name");
                        pineappleprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("tomato") && search.getString("available").equals("yes")&&tomatostall.isEmpty()) {
                        tomatostall = searchstalls.getString("stall_name");
                        tomatoprice = search.getString("price")+".00";
                    }
                    if (search.getString("product").equals("bangus") && search.getString("available").equals("yes") && !bangusstall.isEmpty()){
                        if(!searchstalls.getString("stall_name").equals(bangusstall)) {
                            bangus2 = searchstalls.getString("stall_name");
                            bangus2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("tilapia") && search.getString("available").equals("yes")&&!tilapiastall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(tilapiastall)) {
                            tilapia2 = searchstalls.getString("stall_name");
                            tilapia2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("galunggong") && search.getString("available").equals("yes")&&!galunggongstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(galunggongstall)) {
                            galunggong2 = searchstalls.getString("stall_name");
                            galunggong2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("shrimp") && search.getString("available").equals("yes")&&!shrimpstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(shrimpstall)) {
                            shrimp2 = searchstalls.getString("stall_name");
                            shrimp2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("crab") && search.getString("available").equals("yes")&&!crabstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(crabstall)) {
                            crab2 = searchstalls.getString("stall_name");
                            crab2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("pork chop") && search.getString("available").equals("yes")&&!porkchopstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(porkchopstall)) {
                            porkchop2 = searchstalls.getString("stall_name");
                            porkchop2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("pork giniling") && search.getString("available").equals("yes")&&!porkginilingstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(porkginilingstall)) {
                            porkginiling2 = searchstalls.getString("stall_name");
                            porkginiling2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("beef short ribs") && search.getString("available").equals("yes")&&!beefshortribsstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(beefshortribsstall)) {
                            beefshortribs2 = searchstalls.getString("stall_name");
                            beefshortribs2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("chicken drumstick") && search.getString("available").equals("yes")&&!chickendrumstickstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(chickendrumstickstall)) {
                            chickendrumstick2 = searchstalls.getString("stall_name");
                            chickendrumstick2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("chicken wings") && search.getString("available").equals("yes")&&!chickenwingsstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(chickenwingsstall)) {
                            chickenwings2 = searchstalls.getString("stall_name");
                            chickenwings2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("carrots") && search.getString("available").equals("yes")&&!carrotstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(carrotstall)) {
                            carrot2 = searchstalls.getString("stall_name");
                            carrot2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("celery") && search.getString("available").equals("yes")&&!celerystall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(celerystall)) {
                            celery2 = searchstalls.getString("stall_name");
                            celery2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("eggplant") && search.getString("available").equals("yes")&&!eggplantstall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(eggplantstall)) {
                            eggplant2 = searchstalls.getString("stall_name");
                            eggplant2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("lettuce") && search.getString("available").equals("yes")&&!lettucestall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(lettucestall)) {
                            lettuce2 = searchstalls.getString("stall_name");
                            lettuce2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("sili") && search.getString("available").equals("yes")&&!silistall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(silistall)) {
                            sili2 = searchstalls.getString("stall_name");
                            sili2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("banana") && search.getString("available").equals("yes")&&!bananaprice.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(bananastall)) {
                            banana2 = searchstalls.getString("stall_name");
                            banana2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("apple") && search.getString("available").equals("yes")&&!applestall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(applestall)) {
                            apple2 = searchstalls.getString("stall_name");
                            apple2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("orange") && search.getString("available").equals("yes")&&!orangestall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(orangestall)) {
                            orange2 = searchstalls.getString("stall_name");
                            orange2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("pineapple") && search.getString("available").equals("yes")&&!pineapplestall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(pineapplestall)) {
                            pineapple2 = searchstalls.getString("stall_name");
                            pineapple2price = search.getString("price")+".00";
                        }
                    }
                    if (search.getString("product").equals("tomato") && search.getString("available").equals("yes")&&!tomatostall.isEmpty()) {
                        if(!searchstalls.getString("stall_name").equals(tomatostall)) {
                            tomato2 = searchstalls.getString("stall_name");
                            tomato2price = search.getString("price")+".00";
                        }
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
