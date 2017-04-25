package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SavePreferencePortlet
 */
public class SavePreferencePortlet extends MVCPortlet {
 
	public void actionMethod1(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		System.out.println("in action");
		 	PortletPreferences portletPreferences = actionRequest.getPreferences();
		 	if(portletPreferences!=null)
		 	{
		 	String stockSymbol = portletPreferences.getValue("StockSymbol", "");
	        System.out.println("old value:"+stockSymbol);
		 	}
	       String stockValue =actionRequest.getParameter("prefval");
	        System.out.println("stockvalue " +stockValue);
	        portletPreferences.setValue("StockSymbol", stockValue);
	        portletPreferences.store();
	        System.out.println("New Value :" +portletPreferences.getValue("StockSymbol", "")); 
	        
	

	//	super.processAction(actionRequest, actionResponse);
		
	}
 
}
