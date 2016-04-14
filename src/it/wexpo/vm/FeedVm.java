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
import it.wexpo.business.FeedbackBusiness;
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

public class FeedVm extends GeneralVm{
	
	private UsersBean user;
	private ImmaginiBean immagine;	
	private OpereBean opera;
	private OperaViewBean operaView;
	private FeedbackBean feed;
	private ArrayList<FeedbackViewBean> feedbacks;
	private boolean feedbackEnabled = false;
	
	
	@Init
	@NotifyChange("*")
	public void init(){
		immagine = new ImmaginiBean();
		
		user = ApplicationUtils.getLoggedUser();
		operaView = ApplicationUtils.getOperaSelected();
		immagine.setImmagineHash(operaView.getImmagineHash());
		try {
			opera = FeedbackBusiness.caricaOpera(operaView.getOperaId());
			if(user!=null){
				feed = FeedbackBusiness.caricaFeedback(user.getUserId(),operaView.getOperaId());
			}
			if (feed==null){
				feed=new FeedbackBean();
			}
			feedbacks = FeedbackBusiness.caricaFeedbackViewList(operaView.getOperaId());
			feedbackEnabled = evaluateFeedbackEnabled();
		} catch (SQLException e) {
			e.printStackTrace();
			Messagebox.show("errore in apertura opera");
		}
	}
	
	public boolean evaluateFeedbackEnabled(){
		if (super.isUserLogged()){
			if (!opera.getOperaIdUser().equals(user.getUserId())){
				return true;
			}
		} 
		return false;
	}
	
	public String getImage(){
		if(immagine.getImmagineHash()!=null){
			String hash = immagine.getImmagineHash();
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	
	public String getImageUser(FeedbackViewBean bean){
		if(bean.getUserHashFoto() !=null){
			String hash = bean.getUserHashFoto();
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	
	public String getImageUser(){
		String hash = operaView.getUserImmagineHash();
		if(hash !=null){
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	
	public String getImageRate(FeedbackViewBean bean){
		return null;
	}

	@Command("emettiFeed")
	@NotifyChange("*")
	public void emettiFeed()  throws IOException {
		try {
			
			int x = FeedbackBusiness.emettiFeedback(feed, opera, user);
			System.out.println(x);
			Messagebox.show("inserimento avvenuto con successo.");
			Executions.getCurrent().sendRedirect("/feedback.zul");
		} catch (SQLException e) {
			Messagebox.show("errore durante inserimento");
		}
	}
	
	
	@Command("valorizzaFeed")
	public void valorizzaFeed(@BindingParam("param") String value)  throws IOException {
		Integer val = Integer.parseInt(value);
		feed.setFeedbackVoto(val);
	}
	
	@Command("apriProfiloUtenteOpera")
	public void apriProfiloUtenteOpera()  throws IOException {
		UsersBean b = new UsersBean();
		b.setUserId(opera.getOperaIdUser());
		ApplicationUtils.setSelectedUser(b);
		Executions.sendRedirect("/user_dettaglio.zul");
	}
	
	@Command("apriProfiloUtente")
	public void apriProfiloUtente(@BindingParam("param") FeedbackViewBean f)  throws IOException {
		UsersBean b = new UsersBean();
		b.setUserId(f.getUserId());
		ApplicationUtils.setSelectedUser(b);
		Executions.sendRedirect("/user_dettaglio.zul");
	}
	

	public UsersBean getUser() {
		return user;
	}

	public void setUser(UsersBean user) {
		this.user = user;
	}

	public ImmaginiBean getImmagine() {
		return immagine;
	}

	public void setImmagine(ImmaginiBean immagine) {
		this.immagine = immagine;
	}

	public OpereBean getOpera() {
		return opera;
	}

	public void setOpera(OpereBean opera) {
		this.opera = opera;
	}

	public FeedbackBean getFeed() {
		return feed;
	}

	public void setFeed(FeedbackBean feed) {
		this.feed = feed;
	}

	public ArrayList<FeedbackViewBean> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(ArrayList<FeedbackViewBean> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public OperaViewBean getOperaView() {
		return operaView;
	}

	public void setOperaView(OperaViewBean operaView) {
		this.operaView = operaView;
	}

	public boolean isFeedbackEnabled() {
		return feedbackEnabled;
	}

	public void setFeedbackEnabled(boolean feedbackEnabled) {
		this.feedbackEnabled = feedbackEnabled;
	}
	  
	
	
}
