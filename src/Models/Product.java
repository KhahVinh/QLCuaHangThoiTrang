package Models;

import java.io.Serializable;

public class Product implements Serializable{
    private String productID;
    private String productName;
    private int productSold;
    private String productCategory;
    private String productStock;
    private float productPrice;

    public Product() {
    }

    public Product(String productID, String productName, int productSold, String productCategory, String productStock, float productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productSold = productSold;
        this.productCategory = productCategory;
        this.productStock = productStock;
        this.productPrice = productPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductSold() {
        return productSold;
    }

    public void setProductSold(int productSold) {
        this.productSold = productSold;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return productID + productName +  productSold + productCategory + productStock +productPrice ;
    }

    
}
