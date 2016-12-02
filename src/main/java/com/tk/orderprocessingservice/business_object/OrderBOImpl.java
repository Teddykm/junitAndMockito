package com.tk.orderprocessingservice.business_object;

import com.tk.orderprocessingservice.business_object.exception.BOexception;
import com.tk.orderprocessingservice.data_access_object.OrderDAO;
import com.tk.orderprocessingservice.data_transfer_object.Order;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;


    public boolean placeOrder(Order order) throws BOexception {

        try {
            int createdOrderId = orderDAO.create(order);
            if (createdOrderId == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new BOexception(e);
        }
        return true;
    }

    public boolean updateOrder(Order order) throws BOexception {

        try {
            int updatedOrderId = orderDAO.update(order);
            if (updatedOrderId == 0 ){
                return false;
            }
        } catch (SQLException e) {
            throw new BOexception(e);
        }
        return true;
    }

    public boolean deleteOrder(int orderId) throws BOexception {

        try {
            int deleteOrder = orderDAO.delete(orderId);
            if (deleteOrder == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new BOexception(e);
        }
        return true;
    }

    public boolean cancelOrder(int orderId) throws BOexception {
        try {
            Order cancelOrderId = orderDAO.read(orderId);
            cancelOrderId.setStatus("cancel");
            int cancelOrder = orderDAO.update(cancelOrderId);
            if (cancelOrder == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new BOexception(e);
        }
        return true;
    }


    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
