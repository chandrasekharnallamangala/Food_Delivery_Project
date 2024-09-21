package com.project.DAO;


import com.project.Model.Order1;


public interface Order1DAO 
{
  int insertOrders(Order1 order);
  Order1 fetchOrderId(int orderId);
  int updateOrder(int orderId);
}
