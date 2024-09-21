package com.project.DAO;

import java.util.List;


import com.project.Model.OrderHistory;

public interface OrderHistoryDAO
{
	int insertOrderHistory(OrderHistory oh);
	OrderHistory fetchOrderOnUserId(int user_id);
	int updateHistory(int orderHistoryId);
}
