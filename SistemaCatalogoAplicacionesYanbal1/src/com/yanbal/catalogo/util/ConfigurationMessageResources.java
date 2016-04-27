package com.yanbal.catalogo.util;

import java.util.Set;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import com.ibm.websphere.management.AdminService;
import com.ibm.websphere.management.AdminServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigurationMessageResources {
	final static Logger Log = LogManager.getLogger(ConfigurationMessageResources.class);
	
	public static String getRutaProperties ()
	{
		
		if(Constantes.PATH.equals(Constantes.STRING_VACIO) ||  Constantes.PATH == null)
		{
			try{
					AdminService adminService = AdminServiceFactory.getAdminService(); 
			        ObjectName queryName = new ObjectName( Constantes.STRING_WEBSPHERE ); 
			        Set objs = adminService.queryNames( queryName, null ); 
			        if ( !objs.isEmpty() ) { 
			            ObjectName thisObj = (ObjectName)objs.iterator().next(); 
			            String opName = "expandVariable";
			            String signature[] = { "java.lang.String" };
			            String params[] = { Constantes.STRING_NOMBREWEBSPHERE  } ; 
			            Object retVal = adminService.invoke( thisObj, opName, params, signature ); 
			            Constantes.PATH = (String)retVal+Constantes.CONFIG;
			            System.out.print("Variable"+Constantes.PATH);
			            
			        }
			        
			}
	        catch (MalformedObjectNameException e) {
				Log.error("Error en getConfiguration()="+e);
			} catch (NullPointerException e) {
				Log.error("Error en getConfiguration()="+e);
			} catch (InstanceNotFoundException e) {
				Log.error("Error en getConfiguration()="+e);
			} catch (MBeanException e) {
				Log.error("Error en getConfiguration()="+e);
			} catch (ReflectionException e) {
				Log.error("Error en getConfiguration()="+e);
			}
		}
				
		return Constantes.PATH;
	}
}
