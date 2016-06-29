package it.wexpo.dao;

import it.wexpo.autodao.ImmaginiAutoDao;
import it.wexpo.autodao.UsersAutoDao;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.UsersBean;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
	public static void salvaUtenteImmagineAuth(UsersBean user,
			ImmaginiBean imgBean, ImmaginiBean cvBean, Connection conn) throws SQLException {
		Long x;
		
		UsersAutoDao dao = new UsersAutoDao();
		ImmaginiAutoDao imgDao = new ImmaginiAutoDao();
		
		if(user.getUserId()==null){
			
			if (imgBean.getImmagineId()!=1){
				Long idImg = imgDao.insertGenKey(imgBean, conn);
				imgBean.setImmagineId(idImg);
			}
			user.setUserFoto(imgBean.getImmagineId());
			
			if (cvBean.getImmagineId()==null){
				Long idcv = imgDao.insertGenKey(cvBean, conn);
				user.setUserCv(idcv);
				
			}
			
			x = dao.insertGenKey(user, conn);
			user.setUserId(x);
			
			
		}else{
			
			
			if((imgBean.getImmagineId()==null||imgBean.getImmagineId()!=1)
					&&user.getUserFoto()!=imgBean.getImmagineId()){
				Long idImg = imgDao.insertGenKey(imgBean, conn);
				user.setUserFoto(idImg);
			}
			if (cvBean.getImmagineId()==null){
				Long idcv = imgDao.insertGenKey(cvBean, conn);
				user.setUserCv(idcv);
				
			}
			
			UsersBean dataSelect = new UsersBean();
			dataSelect.setUserId(user.getUserId());
			dao.update(user, dataSelect, conn);
			x = user.getUserId();
		}
		
	}
}
