/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import zain.shopping.OrderDetail;
import zain.shopping.Orders;
import zain.utils.DBUtil;

/**
 *
 * @author quan2
 */
public class ProductDao {

    public List<ProductDTO> getProductbyName(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select productID, productName, description, categoryID, marketPrice, quantity, createDate, image from tblProducts where productName like ? and quantity > 0";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search.trim() + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    String categoryID = rs.getString("categoryID");
                    double marketPrice = Double.parseDouble(rs.getString("marketPrice"));
                    int quantity = rs.getInt("quantity");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, productName, description, categoryID, marketPrice, quantity, "", image));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getProductbyType(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select productID, productName, description, categoryID, marketPrice, quantity, statusID, createDate, image from tblProducts where categoryID=? and statusID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setString(2, "S1");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    String categoryID = rs.getString("categoryID");
                    double marketPrice = Double.parseDouble(rs.getString("marketPrice"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String statusID = rs.getString("statusID");
                    String createDate = rs.getString("createDate");
                    String image = rs.getString("image");
                    list.add(new ProductDTO(productID, productName, description, categoryID, marketPrice, quantity, createDate, image));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ProductDTO getProductbyID(String search) throws SQLException {
        ProductDTO pro = new ProductDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select productID, productName, description, categoryID, marketPrice, quantity, createDate, image from tblProducts where productID=? and quantity>0";
                stm = conn.prepareStatement(sql);
                stm.setString(1, search.trim());
                rs = stm.executeQuery();
                if (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    String categoryID = rs.getString("categoryID");
                    double marketPrice = Double.parseDouble(rs.getString("marketPrice"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String createDate = rs.getString("createDate");
                    String image = rs.getString("image");
                    pro = new ProductDTO(productID, productName, description, categoryID, marketPrice, quantity, createDate, image);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pro;
    }

    public String getCategoryNamebyID(String categoryID) throws SQLException {
        String CategoryName = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Select categoryName from tblCategory where categoryID=?";
                stm = conn.prepareCall(sql);
                stm.setString(1, categoryID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    CategoryName = rs.getString("categoryName");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return CategoryName;
    }

    public boolean updateQuantity(int quantity, String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tblProducts set quantity=? where productID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productID);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean writeOrder(Orders order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders ( email, userID, address, phone, totalMoney, orderDate, statusID, paymentStatus)"
                        + " VALUES(?,?,?,?,?,GETDATE(),?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getEmail());
                stm.setString(2, order.getUserID());
                stm.setString(3, order.getAddress());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getTotalMoney());
                stm.setString(6, order.getStatusID());
                stm.setString(7, order.getPaymentStatus());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean writeOrderDetail(OrderDetail detail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tblOrderDetail ( orderdetailID, orderID, productID, quantity, price, statusID) values(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, detail.getOrderdetailID());
                stm.setInt(2, detail.getOrderID());
                stm.setString(3, detail.getProductID());
                stm.setInt(4, detail.getQuantity());
                stm.setDouble(5, detail.getPrice());
                stm.setString(6, detail.getStatusID());
                check=stm.executeUpdate()>0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getLastOrderID() throws SQLException {
        int orderID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT IDENT_CURRENT('tblOrders') as LastID";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("LastID");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orderID;
    }
}
