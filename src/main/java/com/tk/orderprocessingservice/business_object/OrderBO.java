package com.tk.orderprocessingservice.business_object;

import com.tk.orderprocessingservice.business_object.exception.BOexception;
import com.tk.orderprocessingservice.data_transfer_object.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOexception;

    boolean updateOrder(Order order) throws BOexception;

    boolean deleteOrder(int id) throws BOexception;

    boolean cancelOrder(int id) throws BOexception;
}
