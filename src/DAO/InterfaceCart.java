package DAO;

import com.test.Beans.Cart;

public interface InterfaceCart {
	    void saveCart(Cart cart);
	    void updateCart(Cart cart);
	    Cart getCart(int userId);
	    void deleteCart(int userId);
	}

