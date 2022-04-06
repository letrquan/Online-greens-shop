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
public class Orders {
    private String orderID;
    private String email;
    private String userID;
    private String address;
    private String phone;
    private String totalMoney;
    private String orderDate;
    private String statusID;
    private String paymentStatus;

    public Orders(String orderID, String email, String userID, String address, String phone, String totalMoney, String orderDate, String statusID, String paymentStatus) {
        this.orderID = orderID;
        this.email = email;
        this.userID = userID;
        this.address = address;
        this.phone = phone;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.statusID = statusID;
        this.paymentStatus = paymentStatus;
    }

    public Orders() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
}
