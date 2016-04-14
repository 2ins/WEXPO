package it.wexpo.dao;

import it.wexpo.autodao.ImmaginiAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.UsersBean;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
	public static Long salvaUtenteImmagineAuth(UsersBean user,
			ImmaginiBean imgBean, Connection conn) throws SQLException {
		Long x;
		
		UsersAutoDao dao = new UsersAutoDao();
		ImmaginiAutoDao imgDao = new ImmaginiAutoDao();
		
		if(user.getUserId()==null){
			
			Long idImg = imgDao.insertGenKey(imgBean, conn);
			user.setUserFoto(idImg);
			x = dao.insertGenKey(user, conn);
			user.setUserId(x);
		}else{
			
			
			if(imgBean.getImmagineHash()!=null){
				Long idImg = imgDao.insertGenKey(imgBean, conn);
				user.setUserFoto(idImg);
			}
			UsersBean dataSelect = new UsersBean();
			dataSelect.setUserId(user.getUserId());
			dao.update(user, dataSelect, conn);
			x = user.getUserId();
		}
		return x;
	}
}
