package com.project.DAO;

import java.util.ArrayList;
import java.util.List;


import com.project.Model.OrderItems;

public interface OrderItemsDAO
{
	int insertOrderItems(OrderItems orderItems);
	OrderItems fetchOrderItems(int order_id);
}
