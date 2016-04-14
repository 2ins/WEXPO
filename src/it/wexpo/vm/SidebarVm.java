package it.wexpo.vm;



import java.io.IOException;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class SidebarVm extends GeneralVm{
 
		
		
		
		@Command("esponi")
		@NotifyChange("*")
		public void esponi()  throws IOException {
			try {
				Executions.getCurrent().sendRedirect("nuova_opera.zul");
			} catch (Exception e) {
				Messagebox.show("");
			}
		}
		


}
