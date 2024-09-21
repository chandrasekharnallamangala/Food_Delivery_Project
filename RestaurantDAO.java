package com.project.DAO;

import java.util.List;

import com.project.Model.Restaurant;

public interface RestaurantDAO
{
	int insert_Data(Restaurant rest);
	List selectAll();
	Restaurant fetch_By_Id(int id);
	int update_By_Id(int id);
	int delete_BY_Id(int id);
}
