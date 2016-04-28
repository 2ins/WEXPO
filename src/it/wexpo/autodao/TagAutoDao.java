package it.wexpo.autodao;


import it.wexpo.beanparsers.TagParser;
import it.wexpo.beans.TagBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import automation.constans.OperatorConstants;
import automation.dao.GenericDao;

public class TagAutoDao extends GenericDao<TagBean>{

	TagParser parser = new TagParser();

	
	public  ArrayList<TagBean> selectByDesc(TagBean bean, Connection conn) throws SQLException{
		setCondition(bean,OperatorConstants.WHERE_CONDITION);
		ArrayList<TagBean> list = new ArrayList<TagBean>();
		String sql = "select * from TAG where tag_desc like '"+bean.getTagDesc()+"%'";
		printStatement(sql);
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		
		while (rset.next()){
			list.add(parseBean(rset));
	    }
	    
	    rset.close();
	    stmt.close();

	    
	    return list;
		
	}
	
	@Override
	public void setMap(TagBean bean){
		DBmap.put( "tag_id",bean.getTagId());
		DBmap.put( "tag_desc",bean.getTagDesc());
		DBmap.put( "tag_opera_id",bean.getTagOperaId());
	
	}

	@Override
	public TagBean parseBean(ResultSet resultSet) throws SQLException {
		return parser.parseBean(resultSet);
	}

	@Override
	protected void defineTable() {
		this.TABLE = "TAG";
	}
	
}