package buyer;

public class order {
    String product, stall, quantity;
    int price;

    public order(String product, String stall, String quantity, int price){
        this.product = product;
        this.stall = stall;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public String getStall() {
        return stall;
    }

    public String getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setStall(String stall) {
        this.stall = stall;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
