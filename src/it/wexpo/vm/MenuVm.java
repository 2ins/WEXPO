package it.wexpo.vm;



import it.wexpo.utils.ApplicationUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class MenuVm extends GeneralVm{
 
	
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
		
		


}
