/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.shopping;

/**
 *
 * @author quan2
 */
public class OrderDetail {

    private String orderdetailID;
    private int orderID;
    private String productID;
    private int quantity;
    private double price;
    private String statusID;

    public OrderDetail() {
    }

    public OrderDetail(String orderdetailID, int orderID, String productID, int quantity, double price, String statusID) {
        this.orderdetailID = orderdetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.statusID = statusID;
    }

    public String getOrderdetailID() {
        return orderdetailID;
    }

    public void setOrderdetailID(String orderdetailID) {
        this.orderdetailID = orderdetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

}
