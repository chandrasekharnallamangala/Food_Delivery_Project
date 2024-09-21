package com.project.DAO;

import java.util.List;

//import com.project.*;
import com.project.Model.Menu;

public interface MenuDAO
{
	int insert(Menu menu);
	List<Menu> get_All_Menus(int rest_id);
	List<Menu> get_Menu_By_Id(int id);
	int delete_By_Id(int id);
	int update_By_Id(int id);

}
