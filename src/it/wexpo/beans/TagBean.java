package it.wexpo.beans;

import java.lang.Integer;
import java.lang.String;
import automation.bean.AutomationBean;

public class TagBean extends AutomationBean{
	private Long tagId;
	private String tagDesc;
	private Long tagOperaId;

	public Long getTagId()  {
		return this.tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public String getTagDesc()  {
		return this.tagDesc;
	}
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}
	public Long getTagOperaId()  {
		return this.tagOperaId;
	}
	public void setTagOperaId(Long tagOperaId) {
		this.tagOperaId = tagOperaId;
	}

	@Override
	public AutomationBean getNewInstance() {
		return new TagBean();
	}

}