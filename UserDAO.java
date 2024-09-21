package com.project.DAO;

import java.util.List;

import com.project.Model.User;

public interface UserDAO
{
	int insert_User(User user);
	List selectAll(); 
	User selectSpecific(String id);
	int  DeleteUser(int id);
	int updateUser(String email,String password);
	
}
