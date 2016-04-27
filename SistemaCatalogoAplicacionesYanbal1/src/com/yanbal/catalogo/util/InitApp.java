package com.yanbal.catalogo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yanbal.catalogo.login.ControladorLogin;
import org.apache.logging.log4j.core.LoggerContext;



/**
 * Servlet implementation class for Servlet: Init
 *
 */
 public class InitApp extends HttpServlet{
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	 private static final long serialVersionUID = 1L;
	
	 final static Logger Log = LogManager.getLogger(InitApp.class);

		
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub

		}  	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}   	  	  

	
	 public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();	
		
	   
	    	LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	    	File file = new File(ConfigurationMessageResources.getRutaProperties()+"/"+Constantes.LOG4J_PROPERTIES);
	    	 
	    	// this will force a reconfiguration
	    	context.setConfigLocation(file.toURI());
	   		
	    
	}
	
}