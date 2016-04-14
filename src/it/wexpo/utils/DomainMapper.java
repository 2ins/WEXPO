package it.wexpo.utils;

import java.util.ArrayList;

import it.wexpo.beans.RuoliBean;

public class DomainMapper {

	public static RuoliBean getRuolo(Long idRuolo) throws Exception{
		
		ArrayList<RuoliBean> ruoli = RuoliSingleton.getInstance().getRuoli();
		
		for(RuoliBean b:ruoli){
			if (b.getRuoloId()==idRuolo){
				return b;
			}
		}
		
		return null; 
	}
}
