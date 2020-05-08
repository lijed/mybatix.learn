package ariix.mybatix.learn.db.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

//Besides implement a self-defined Type handler,
//you need to enable it in Mybatis Configuration File

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(value= {List.class})
public class ListBusinessTypeHandler extends BaseTypeHandler<List<Integer>> {
	public static List<Integer> EMPTY_LIST = new ArrayList<Integer>();

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			List<Integer> parameter, JdbcType jdbcType) throws SQLException {
		String paraStr = Arrays.toString(parameter.toArray()).replace("[", "")
				.replace("]", "");
		ps.setString(i, paraStr);
	}

	@Override
	public List<Integer> getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		String strVals = rs.getString(columnName);
		return parseDbValueToIntList(strVals);
	}

	private List<Integer> parseDbValueToIntList(String strVals) {
		if (StringUtils.isNotBlank(strVals)) {
			String[] vals = strVals.split(",");
			List<Integer> intList = new ArrayList<Integer>(vals.length);
			for (String val : vals) {
				intList.add(Integer.valueOf(val.trim()));
			}
			return intList;
		} else {
			return EMPTY_LIST;
		}
	}

	@Override
	public List<Integer> getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String strVals = rs.getString(columnIndex);
		return parseDbValueToIntList(strVals);
	}

	@Override
	public List<Integer> getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String strVals = cs.getString(columnIndex);
		return parseDbValueToIntList(strVals);
	}

}
