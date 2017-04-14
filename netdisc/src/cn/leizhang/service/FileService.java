package cn.leizhang.service;

import java.sql.SQLException;

import cn.leizhang.dao.FileDao;
import cn.leizhang.domain.FileInfo;

public class FileService {
	public static void Save(FileInfo fi) throws SQLException
	{
		new FileDao().save(fi);	
	}

}
