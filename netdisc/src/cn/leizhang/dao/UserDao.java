package cn.leizhang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.leizhang.domain.User;
import cn.leizhang.utils.DataRourceUtils;

public class UserDao {

	public static User userLogin(String username,String password) throws Exception {
		//连接数据库查表
		String sql = "SELECT * FROM user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataRourceUtils.getDatasource());

		User user=runner.query(sql, new BeanListHandler(User.class),username,password);
		return user;
	}

	public static void userSave(User user) {
		//System.out.println(user.getSex());
		String sql = "insert into user values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataRourceUtils.getDatasource());
		try {
			runner.update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getPreference());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static boolean isExist(String username) throws Exception {
		String sql = "SELECT * FROM user";
		QueryRunner runner = new QueryRunner(DataRourceUtils.getDatasource());
		//System.out.println(username);
		List<User> list=runner.query(sql, new BeanListHandler(User.class));
		for(User list1: list)
		{
			if(list1.getUsername().equals(username))
			{
			return true;
			}
		}
		return false;
	}

}
