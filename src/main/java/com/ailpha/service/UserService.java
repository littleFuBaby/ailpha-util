package com.ailpha.service;

import java.util.List;

import com.ailpha.vo.User;

public interface UserService {
	
	List<User> selectUser(String name);
	
	int updateUser(String name);

}
