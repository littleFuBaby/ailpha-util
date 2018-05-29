package org.fuys.own.service;

import java.util.List;

import org.fuys.own.vo.User;

public interface UserService {
	
	List<User> selectUser(String name);
	
	int updateUser(String name);

}
