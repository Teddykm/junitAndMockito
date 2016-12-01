package com.tk.orderprocessingservicetest.business_object_test;

import com.tk.orderprocessingservice.business_object.OrderBOImpl;
import com.tk.orderprocessingservice.data_access_object.OrderDAO;
import com.tk.orderprocessingservice.data_transfer_object.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class OrderBOImplTest {

    @Mock
    OrderDAO orderDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnOnSuccessfulPlaceOrder() throws Exception {

        OrderBOImpl orderImpl = new OrderBOImpl();
        orderImpl.setOrderDAO(orderDAO);

        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(new Integer(1));
    }

    @Test
    public void testUpdateOrder() throws Exception {

    }

    @Test
    public void testDeleteOrder() throws Exception {

    }

    @Test
    public void testCancelOrder() throws Exception {

    }

    @Test
    public void testGetOrderDAO() throws Exception {

    }

    @Test
    public void testSetOrderDAO() throws Exception {

    }
}