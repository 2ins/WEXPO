package it.wexpo.vm;

import it.wexpo.beans.FeedbackBean;
import it.wexpo.beans.FeedbackOperaViewBean;
import it.wexpo.beans.FeedbackViewBean;
import it.wexpo.beans.ImmaginiBean;
import it.wexpo.beans.OperaViewBean;
import it.wexpo.beans.OpereBean;
import it.wexpo.beans.RuoliBean;
import it.wexpo.beans.UsersBean;
import it.wexpo.business.Business;
import it.wexpo.business.BusinessDao;
import it.wexpo.business.BusinessUtente;
import it.wexpo.business.FeedbackBusiness;
import it.wexpo.dao.UsersDao;
import it.wexpo.utils.ApplicationUtils;
import it.wexpo.utils.WexpoMediaUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class FeedbackEmessiUserVm extends GeneralVm{
	

	private UsersBean utenteSelected ;
	private ArrayList<FeedbackOperaViewBean> feedbacks;
	private Integer totFeedbackEmessi = 0;
	private Integer totFeedbackRate = 0;

	
	@Init
	@NotifyChange("*")
	public void init(){
		try {
			utenteSelected = ApplicationUtils.getSelectedUser();
			
			if(utenteSelected==null){
				Messagebox.show("nessun utente selezionato");
				Executions.getCurrent().sendRedirect("index.zul");
			}else{
				feedbacks = BusinessUtente.selectAllFeeds(utenteSelected);
				totFeedbackEmessi = feedbacks.size();
				for (FeedbackOperaViewBean f:feedbacks){
					totFeedbackRate+=f.getFeedbackVoto();
				}
			}
		} catch (SQLException e) {
			Messagebox.show("errore db");
		}
	}
	
	@Command("apriProfiloUtente")
	public void apriProfiloUtente(@BindingParam("par") FeedbackOperaViewBean f)  throws IOException {
		UsersBean b = new UsersBean();
		b.setUserId(f.getUserId());
		ApplicationUtils.setSelectedUser(b);
		Executions.sendRedirect("/user_dettaglio.zul");
	}
	
	@Command("apriOpera")
	public void apriOpera(@BindingParam("par") FeedbackOperaViewBean f)  throws IOException {
		OperaViewBean op = new OperaViewBean();
		op.setOperaId(f.getOperaId());
		ApplicationUtils.setOperaSelected(op);
		Executions.sendRedirect("/feedback.zul");
	}

	
	public String getImageUser(FeedbackOperaViewBean bean){
		return WexpoMediaUtils.getImage(bean.getUserHashFoto());
	}
	
	public String getImageOpera(FeedbackOperaViewBean bean){
		return WexpoMediaUtils.getImage(bean.getOperaHashFoto());
	}
	
	public String getImageRate(FeedbackViewBean bean){
		return null;
	}
	
	public String getImageRateGlobale(){
		return null;
	}
	
	

	public ArrayList<FeedbackOperaViewBean> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(ArrayList<FeedbackOperaViewBean> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Integer getTotFeedbackEmessi() {
		return totFeedbackEmessi;
	}

	public void setTotFeedbackEmessi(Integer totFeedbackEmessi) {
		this.totFeedbackEmessi = totFeedbackEmessi;
	}

	public Integer getTotFeedbackRate() {
		return totFeedbackRate;
	}

	public void setTotFeedbackRate(Integer totFeedbackRate) {
		this.totFeedbackRate = totFeedbackRate;
	}
	
	
	
	
}
