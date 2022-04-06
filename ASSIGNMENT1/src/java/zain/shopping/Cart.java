/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.shopping;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import zain.products.ProductCart;
import zain.products.ProductDTO;
import zain.products.ProductDao;

/**
 *
 * @author quan2
 */
public class Cart {

    private Map<String, ProductCart> cart;

    public Cart() {
    }

    public Cart(Map<String, ProductCart> cart) {
        this.cart = cart;
    }

    public Map<String, ProductCart> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductCart> cart) {
        this.cart = cart;
    }

    public boolean add(ProductDTO pro, ProductCart proCart) throws SQLException {
        boolean check=false;
        int quantityCart=proCart.getQuantityCart();
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(pro.getProductID())) {
            int currentQuantity=this.cart.get(pro.getProductID()).getQuantityCart();
            if(currentQuantity<pro.getQuantity() && (currentQuantity+proCart.getQuantityCart())<=pro.getQuantity()){
                proCart.setQuantityCart(currentQuantity+proCart.getQuantityCart());
                check=true;
            }
        }else{
            check=true;
        }
        cart.put(pro.getProductID(), proCart);
        return check;
    }

    public boolean delete(String id) {
        boolean check=false;
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            check=true;
        }
        return check;
    }

    public boolean update(ProductCart newpro) {
        boolean check=false;
        if (this.cart.containsKey(newpro.getProductID())) {
            this.cart.replace(newpro.getProductID(), newpro);
            check=true;
        }
        return check;
    }
}
