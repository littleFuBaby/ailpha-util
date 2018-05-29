package org.fuys.own.dao;

import java.util.List;

import org.fuys.own.common.datasource.DataSource;
import org.fuys.own.common.datasource.DataSourceType;
import org.fuys.own.vo.User;

public interface UserDao {
	
	@DataSource(DataSourceType.Slave)
	List<User> selectUser(String name);
	
	@DataSource
	int updateUserById(User user);

}
