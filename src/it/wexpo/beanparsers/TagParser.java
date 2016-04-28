package it.wexpo.beanparsers;
import it.wexpo.beans.TagBean;

import java.sql.ResultSet;
import java.sql.SQLException;

import automation.parser.BeanParser;

public class TagParser implements BeanParser<TagBean>{
	public TagBean parseBean (ResultSet res) throws SQLException{
		TagBean bean = new TagBean();
		bean.setTagId(res.getLong("tag_id"));
		bean.setTagDesc(res.getString("tag_desc"));
		bean.setTagOperaId(res.getLong("tag_opera_id"));
		return bean;
	}
}