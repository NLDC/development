package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.json.JSONFactoryUtil;

/**
 * Portlet implementation class EditPortlet
 */
public class EditPortlet extends MVCPortlet {

	
	public void actionMethod1(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		 	PortletPreferences portletPreferences = actionRequest.getPreferences();
		 	if(portletPreferences!=null)
		 	{
		 	String stockSymbol = portletPreferences.getValue("StockSymbol", "");
	        System.out.println("Existing pref value:"+stockSymbol);
		 	}
	       String stockValue =actionRequest.getParameter("prefval");
	        System.out.println("Edited to pref value " +stockValue);
	        portletPreferences.setValue("StockSymbol", stockValue);
	        portletPreferences.store();
	        System.out.println("Updated pref value :" +portletPreferences.getValue("StockSymbol", "")); 
	        
	        JSONObject json = JSONFactoryUtil.createJSONObject();
	        json.put("stockval", portletPreferences.getValue("StockSymbol", ""));

	        HttpServletResponse httpResp = PortalUtil.getHttpServletResponse(actionResponse);
	        httpResp.setContentType("application/json");
	        httpResp.getWriter().write(json.toString());
	        httpResp.flushBuffer();
	        return;


	//	super.processAction(actionRequest, actionResponse);
		
	}
 

}
