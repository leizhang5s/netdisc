package cn.leizhang.service;

import cn.leizhang.dao.UserDao;
import cn.leizhang.domain.User;

public class UserService {
	
	public static User find_User(String username,String password) throws Exception
	{
		return UserDao.userLogin(username,password);
		
	
	}

	public void save_User(User user) {
		
		UserDao.userSave(user);
	}

	public boolean ifExist(String username) throws Exception {
		
		return UserDao.isExist(username);
	}

}
