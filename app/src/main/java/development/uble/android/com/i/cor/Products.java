package development.uble.android.com.i.cor;

import java.io.Serializable;

/**
 * Created by ederpadilla on 09/01/17.
 */

public class Products implements Serializable{
    private String name;

    private String price;

    private String id;

    private String url;

    private boolean discount;

    private boolean moreSell;

    private String desctription;

    private String quantity;

    private boolean lowPrice;

    public Products(String name, String price, String id, String url, boolean discount, boolean moreSell, String desctription, String quantity, boolean lowPrice) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.url = url;
        this.discount = discount;
        this.moreSell = moreSell;
        this.desctription = desctription;
        this.quantity = quantity;
        this.lowPrice = lowPrice;
    }


    public boolean isLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(boolean lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Products() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isMoreSell() {
        return moreSell;
    }

    public void setMoreSell(boolean moreSell) {
        this.moreSell = moreSell;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctription) {
        this.desctription = desctription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", discount=" + discount +
                ", moreSell=" + moreSell +
                ", desctription='" + desctription + '\'' +
                ", quantity='" + quantity + '\'' +
                ", lowPrice=" + lowPrice +
                '}';
    }
}
