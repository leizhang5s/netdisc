package cn.leizhang.service;

import cn.leizhang.dao.UserDao;
import cn.leizhang.domain.User;

public class UserService {
	
	public static boolean find_User(User user) throws Exception
	{
		return UserDao.userLogin(user);
		
	
	}

	public void save_User(User user) {
		
		UserDao.userSave(user);
	}

	public boolean ifExist(String username) throws Exception {
		
		return UserDao.isExist(username);
	}

}
