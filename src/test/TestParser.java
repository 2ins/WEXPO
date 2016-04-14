package test;
import java.sql.ResultSet;
import java.sql.SQLException;
import automation.parser.BeanParser;
import it.wexpo.beans.ConcorsiBean;

public class TestParser implements BeanParser<TestBean>{
	public TestBean parseBean(ResultSet res) throws SQLException{
		TestBean bean = new TestBean();
		bean.setX1(res.getString("a.user_nome"));
		bean.setX2(res.getString("opera_hash"));
		return bean;
	}
}