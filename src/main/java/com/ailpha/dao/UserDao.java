package com.ailpha.dao;

import java.util.List;

import com.ailpha.vo.User;
import com.ailpha.common.datasource.DataSource;
import com.ailpha.common.datasource.DataSourceType;

public interface UserDao {
	
	@DataSource(DataSourceType.Slave)
	List<User> selectUser(String name);
	
	@DataSource
	int updateUserById(User user);

}
