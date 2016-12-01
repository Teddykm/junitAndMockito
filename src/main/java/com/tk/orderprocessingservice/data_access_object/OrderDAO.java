package com.tk.orderprocessingservice.data_access_object;

import com.tk.orderprocessingservice.data_transfer_object.Order;

import java.sql.SQLException;

public interface OrderDAO {

    int create(Order order) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;
}

