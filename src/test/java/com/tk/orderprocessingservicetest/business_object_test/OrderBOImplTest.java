package com.tk.orderprocessingservicetest.business_object_test;

import com.tk.orderprocessingservice.business_object.OrderBOImpl;
import com.tk.orderprocessingservice.business_object.exception.BOexception;
import com.tk.orderprocessingservice.data_access_object.OrderDAO;
import com.tk.orderprocessingservice.data_transfer_object.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OrderBOImplTest {

    private OrderBOImpl orderBOImpl;
    private Order order;

    @Mock
    OrderDAO orderDAO;
    public static final int ORDER_ID = new Random().nextInt();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        orderBOImpl = new OrderBOImpl();
        orderBOImpl.setOrderDAO(orderDAO);
        order = new Order();
    }

    @Test
    public void shouldReturnOnTrueSuccessfulPlaceOrder() throws Exception {
        when(orderDAO.create(order)).thenReturn(new Integer(1));
        boolean result = orderBOImpl.placeOrder(order);

        assertTrue(result);
        verify(orderDAO).create(order);
    }

    @Test
    public void shouldReturnFalseOnUnsuccessfulPlaceOrder() throws Exception {
        when(orderDAO.create(order)).thenReturn(new Integer(0));
        boolean result = orderBOImpl.placeOrder(order);

        assertFalse(result);
        verify(orderDAO).create(order);

    }

    @Test(expected = BOexception.class)
    public void placeOrdershouldThrowWrappedBOException() throws Exception {
        when(orderDAO.create(order)).thenThrow(SQLException.class);
        orderBOImpl.placeOrder(order);

        verify(orderDAO, times(1)).create(order);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulUpdateOrder() throws Exception {

        when(orderDAO.update(order)).thenReturn(new Integer(1));
        boolean result = orderBOImpl.updateOrder(order);

        assertTrue(result);
        verify(orderDAO).update(order);
    }

    @Test
    public void shouldReturnFalseOnUnsuccessfulUpdateOrder() throws Exception {
        when(orderDAO.update(order)).thenReturn(new Integer(0));
        boolean result = orderBOImpl.updateOrder(order);

        assertFalse(result);
        verify(orderDAO).update(order);

    }

    @Test(expected = BOexception.class)
    public void updateOrderShouldThrowWrapSQLExceptionToBOException() throws Exception {
        when(orderDAO.update(order)).thenThrow(SQLException.class);
        orderBOImpl.updateOrder(order);

        verify(orderDAO, times(1)).update(order);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulDeletionOfOrderId() throws Exception {
        when(orderDAO.delete(ORDER_ID)).thenReturn(new Integer(1));
        boolean result = orderBOImpl.deleteOrder(ORDER_ID);

        assertTrue(result);
        verify(orderDAO).delete(ORDER_ID);

    }

    @Test
    public void shouldReturnFalseOnUnsuccessfulDeletionOfOrderId() throws Exception {
        when(orderDAO.delete(ORDER_ID)).thenReturn(new Integer(0));
        boolean result = orderBOImpl.deleteOrder(ORDER_ID);

        assertFalse(result);
        verify(orderDAO).delete(ORDER_ID);

    }

    @Test(expected = BOexception.class)
    public void deleteOrderShouldThrowWrapSQLExceptionToBOException() throws Exception {
        when(orderDAO.delete(ORDER_ID)).thenThrow(SQLException.class);
        orderBOImpl.deleteOrder(ORDER_ID);

        verify(orderDAO, times(1)).delete(ORDER_ID);
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCancellationOfOrder() throws Exception {
        int cancelOrderId = new Random().nextInt();

        when(orderDAO.read(cancelOrderId)).thenReturn(order);
        when(orderDAO.update(order)).thenReturn(new Integer(1));

        boolean result = orderBOImpl.cancelOrder(cancelOrderId);

        assertTrue(result);
        verify(orderDAO).read(cancelOrderId);
        verify(orderDAO).update(order);

    }

    @Test(expected = BOexception.class)
    public void cancleOrderShouldThrowWrapSQLExceptionToBOException() throws Exception {
        when(orderDAO.update(order)).thenThrow(SQLException.class);
        orderBOImpl.updateOrder(order);

        verify(orderDAO, times(1)).update(order);
    }
}