package it.wexpo.business;

import it.wexpo.autodao.FeedbackAutoDao;
import it.wexpo.autodao.OpereAutoDao;
import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.FeedbackViewBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.dao.FeedBackDao;
import it.wexpo.dao.OpereDao;
import it.wexpo.dao.SqlQuery;
import it.wexpo.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackBusiness {
	
	public static OpereBean caricaOpera(Long idOpera) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			OpereAutoDao dao = new OpereAutoDao();
			OpereBean cerca = new OpereBean();
			cerca.setOperaId(idOpera);
			return dao.select(cerca, conn).get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
	}
	
	
	public static int emettiFeedback(FeedbackBean feed, OpereBean opera, UsersBean giudice) throws SQLException{
		Connection conn = DbUtils.getMySqlConn();
		try {
			
			FeedbackAutoDao feedDao = new FeedbackAutoDao();
			feed.setFeedbackIdUser(giudice.getUserId());
			feed.setFeedbackIdOpera(opera.getOperaId());
			Integer tipo = Integer.parseInt(giudice.getUserIdRuolo().toString());
			feed.setFeedbackTipo(tipo);
			feedDao.insert(feed, conn);
			
			ArrayList<FeedbackBean> listF = caricaFeedbackList(opera.getOperaId());
			int tot = 0;
			for (FeedbackBean fb:listF){
				if(fb.getFeedbackTipo().equals(tipo)){
					tot += fb.getFeedbackVoto();
				}
			}
			
			
			int feeds = listF.size();
			//aggiorna anche valore medio
			OpereAutoDao dao = new OpereAutoDao();
			OpereBean operaSelect = new OpereBean();
			operaSelect.setOperaId(opera.getOperaId());
			if(tipo==1){
				opera.setOperaRatePop(tot);
				opera.setOperaRatePopFeeds(feeds);
			}if(tipo==2){
				opera.setOperaRateCrit(tot);
				opera.setOperaRateCritFeeds(feeds);
			}
			
			conn.commit();
			dao.update(opera, operaSelect, conn);
			
			
			return 2;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
	}


	public static FeedbackBean caricaFeedback(Long userId, Long operaId) throws SQLException {
		Connection conn = DbUtils.getMySqlConn();
		try {
			FeedbackBean feed = new FeedbackBean();
			FeedbackAutoDao feedDao = new FeedbackAutoDao();
			
			feed.setFeedbackIdUser(userId);
			feed.setFeedbackIdOpera(operaId);
			
			ArrayList<FeedbackBean> list = feedDao.select(feed, conn);
			if (list.size()>0) {
				return list.get(0);
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ArrayList<FeedbackBean> caricaFeedbackList(Long operaId) throws SQLException {
		Connection conn = DbUtils.getMySqlConn();
		try {
			FeedbackBean feed = new FeedbackBean();
			FeedbackAutoDao feedDao = new FeedbackAutoDao();
			
			
			feed.setFeedbackIdOpera(operaId);
			
			ArrayList<FeedbackBean> list = feedDao.select(feed, conn);
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	}
	
	public static ArrayList<FeedbackViewBean> caricaFeedbackViewList(Long operaId) throws SQLException {
		Connection conn = DbUtils.getMySqlConn();
		try {
			String sql = SqlQuery.FEED_USER_BY_OPERA.replaceAll("\\?", operaId.toString());
			ArrayList<FeedbackViewBean> list = FeedBackDao.executeQweryMany(sql, conn);
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		
	
	}
	
	
}
