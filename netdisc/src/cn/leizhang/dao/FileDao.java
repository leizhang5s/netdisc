package cn.leizhang.dao;



import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.leizhang.domain.FileInfo;
import cn.leizhang.utils.DataRourceUtils;

public class FileDao {

	public void save(FileInfo fi) throws SQLException {
		String sql = "insert into fileinfo values(?,?,?)";
		QueryRunner runner = new QueryRunner(DataRourceUtils.getDatasource());

		runner.update(sql, fi.getFilename(),fi.getRealpath(),fi.getDescription());
		
	}

}
