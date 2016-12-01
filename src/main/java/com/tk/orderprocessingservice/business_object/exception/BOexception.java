package com.tk.orderprocessingservice.business_object.exception;

import java.sql.SQLException;

public class BOexception extends Exception {

    public BOexception(SQLException e) {
        super(e);
    }
}
