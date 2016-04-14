package test;

import java.sql.Connection;
import java.sql.SQLException;

import it.wexpo.bean.compo.UserImmagineBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.compo.UserImmagineDao;
import it.wexpo.utils.DbUtils;

public class TestCompo {

	public static void main(String[] args) throws SQLException {
		
		UserImmagineDao dao = new UserImmagineDao();
		
		Connection conn = DbUtils.getMySqlConn();
		try{
			
			UserImmagineBean cerca = new UserImmagineBean();
			UsersBean bean = new UsersBean();
			bean.setUserNome("asd");
			cerca.setUser(bean);
			
			dao.select(cerca, conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}

	}

}
