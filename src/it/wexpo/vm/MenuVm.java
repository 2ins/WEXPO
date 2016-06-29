package it.wexpo.vm;



import it.wexpo.beans.ActiveBean;
import it.wexpo.beans.LanguageBean;
import it.wexpo.utils.ApplicationUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;

public class MenuVm extends GeneralVm{
 
		LanguageBean languageToSelect;
		ArrayList<LanguageBean> languages = new ArrayList<LanguageBean>();
		
	
		@Init
		@NotifyChange("languageToSelect")
		public void init(){
			
			popolaLingue();
			
			
			if (Sessions.getCurrent().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE)==null){
				Locale locale = new Locale("it");
				Sessions.getCurrent().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
				
			}
			Locale loc = (Locale)Sessions.getCurrent().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE);
			String locLang = loc.getLanguage();
			for(LanguageBean lingua:languages){
				if (lingua.getId().equalsIgnoreCase(locLang)){
					languageToSelect=lingua;
				}
			}
			
			
		}

		private void popolaLingue() {
			LanguageBean eng = new LanguageBean();
			LanguageBean ita = new LanguageBean();
			
			eng.setId("en");
			eng.setPath("/img/engicon.png");
			eng.setDesc("English");
			
			ita.setId("it");
			ita.setPath("/img/italiicon.png");
			ita.setDesc("Italian");
			
			languages.add(eng);
			languages.add(ita);
			
			
			
			
		}
		
		@Command("cambiaLingua")
		@NotifyChange("languageToSelect")
		public void cambiaLingua(@BindingParam("par") Combobox box)  throws IOException {
			try {
				box.setVisible(false);
				Locale locale = new Locale(languageToSelect.getId());
				Sessions.getCurrent().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
				Executions.getCurrent().sendRedirect("");
			} catch (Exception e) {
				Messagebox.show("errore");
			}
		}
		
	
	
		@Command("cercaUtenti")
		public void cercaUtenti()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("ricerca_utenti.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("mainpage")
		public void mainpage()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("index.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
	

		@Command("cercaOpere")
		public void cercaOpere()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("ricerca_opere.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("registrati")
		public void registrati()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("register.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("accedi")
		public void accedi()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("login.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("apriClassifica")
		public void apriClassifica()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("classifica.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("esci")
		@NotifyChange("*")
		public void esci()  throws IOException {
			try {
				ApplicationUtils.clean();
				Executions.getCurrent().sendRedirect("index.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("apriUserPage")
		@NotifyChange("*")
		public void apriUserPage()  throws IOException {
			try {
				ApplicationUtils.setSelectedUser(ApplicationUtils.getLoggedUser());
				Executions.getCurrent().sendRedirect("/user_dettaglio.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("nuovaOpera")
		@NotifyChange("*")
		public void nuovaOpera()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("/nuova_opera.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		
		@Command("updateAnagrafica")
		@NotifyChange("*")
		public void updateAnagrafica()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("/register.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}

		public LanguageBean getLanguageToSelect() {
			return languageToSelect;
		}

		public void setLanguageToSelect(LanguageBean languageToSelect) {
			this.languageToSelect = languageToSelect;
		}

		public ArrayList<LanguageBean> getLanguages() {
			return languages;
		}

		public void setLanguages(ArrayList<LanguageBean> languages) {
			this.languages = languages;
		}


	


}
