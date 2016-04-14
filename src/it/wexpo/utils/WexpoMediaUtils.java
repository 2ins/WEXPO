package it.wexpo.utils;

import it.media.cloud.WexpoCloudinaryBridge;
import it.wexpo.beans.ImgCloudBean;
import it.wexpo.beans.OperaViewBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.zkoss.bind.BindContext;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.UploadEvent;

public class WexpoMediaUtils {
	public static String salvaMedia(BindContext ctx,  String mainFolder ) throws IOException {
		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
	   
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
		}
	   
		if (upEvent != null) {
			Media media = upEvent.getMedia();
			Calendar now = Calendar.getInstance();
		  
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH) +1; // Note: zero based!
			int day = now.get(Calendar.DAY_OF_MONTH);
		  
		   //filePath = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
			
			
			String filePath = getPathFolder(mainFolder);
		
			File baseDir = new File(filePath);
		   
			if (!baseDir.exists()) {
			  baseDir.mkdirs();
			}
			
			
 
			Files.copy(new File(filePath + media.getName()), media.getStreamData());
         
            
			String fileId=media.getName();
			filePath = filePath + fileId;
			
			return fileId;
       }
		
		return null;
	}
	
	public static ImgCloudBean salvaMediaCloud(BindContext ctx,  String mainFolder ) throws Exception {
		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
		
		ImgCloudBean cloudBean  = new ImgCloudBean();
		
	   
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
		}
	   
		if (upEvent != null) {
			Media media = upEvent.getMedia();
			String format = media.getFormat();
			
			String filePath = getPathFolder(mainFolder);
		
			File baseDir = new File(filePath);
		   
			if (!baseDir.exists()) {
			  baseDir.mkdirs();
			}
			
			byte[] bytes = media.getByteData();
			String fileId=null;
					
			try {
				fileId = WexpoCloudinaryBridge.upload(bytes);
				cloudBean.setId(fileId);
				cloudBean.setFormat(format);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
			
			
			
			return cloudBean;
       }
		
		return null;
	}

	public static String getImage(String hash){
		if(hash!=null){
			return WexpoMediaUtils.getPathWebFolder(hash);
		}
		return null;
	}
	
	public static String getTrunk(String str){
		if(str!=null)
			if (str.length()>50){
				return str.substring(0,50);
			}
		return str;
	}

	public static ArrayList<Integer> getRateAsIntegerArray(Float x) {
		int count = x.intValue();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<count;i++){
			list.add(new Integer(i+1));
		}
		return list;
	}
	
	public static String getPathFolder(String mainFolder) {
		String filePath = Costanti.FILEPATH + mainFolder+ "/" ;
		return filePath;
	}
	
	public static String getPathWebFolder(String hash) {
		
		String fileWebPath = Costanti.FILEPATH_WEB + hash;
		return fileWebPath;
	}

	public static String getTimeUpdate(Date dt1) {
		
		
	
		
		if (dt1==null){
			return null;
		}
		
		Date dt2 = new Date();
		
        long diff = dt2.getTime() - dt1.getTime();
        
        
        
    	long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diff);
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		long diffInHours = TimeUnit.MILLISECONDS.toHours(diff);
        
        
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        int diffInDays = (int) ((dt2.getTime() - dt1.getTime()) / (1000 * 60 * 60 * 24));

        String suf = "Pubblicato ";
        String pos = " fa";
        if (diffInDays >= 1) {
           return ( suf+diffInDays+" giorni"+pos);
            
        } else if (diffHours > 0) {
        	return ( suf+diffHours+" ore"+pos);
        } else if ((diffHours == 24 || diffHours == 0) && (diffMinutes >= 1)) {
        	return ( suf+diffMinutes+" minuti"+pos);
        }else {
        	return ( suf+diffSeconds+" secondi"+pos);
        }
		
	}
}
