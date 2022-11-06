package org.fuys.own.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.fuys.own.dao.UserDao;
import org.fuys.own.service.UserService;
import org.fuys.own.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public List<User> selectUser(String name) {
		List<User> users = userDao.selectUser(name);
		System.out.println("++++++++++++++++++++++"+users);
		return users;
	}

	@Override
	public int updateUser(String name) {
		
		int res = 0;
		
		List<User> users = userDao.selectUser(name);
		if(users!=null) {
			System.out.println("------------------------"+users);
			users.get(0).setAge(5);
			try {
				res = userDao.updateUserById(users.get(0));
			} catch (Exception e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				res = 0;
				e.printStackTrace();
			}
		}
		
//		users = userDao.selectUser(name);
//		System.out.println("+++++++++++++++++++++++="+users);
//		try {
//			int a,b;
//			a = 1;
//			b = 0;
//			System.out.println(a/b);
//		} catch (Exception e) {
//			res = 0;
//		}
		return res;
	}
	
}
