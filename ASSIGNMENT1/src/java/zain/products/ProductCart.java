/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.products;

/**
 *
 * @author quan2
 */
public class ProductCart {

    private String productID;
    private String productName;
    private String description;
    private String categoryName;
    private double marketPrice;
    private int quantityCart;
    private String image;

    public ProductCart(String productID, String productName, String description, String categoryName, double marketPrice, int quantityCart, String image) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.categoryName = categoryName;
        this.marketPrice = marketPrice;
        this.quantityCart = quantityCart;
        this.image = image;
    }

    public ProductCart() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
