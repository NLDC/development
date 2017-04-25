<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

 
 <portlet:defineObjects />
 
 <%
    String stock = portletPreferences.getValue("StockSymbol", ""); 
%>

<portlet:actionURL name="actionMethod1" var="editPrefActionMethodURL">
</portlet:actionURL>
 <form action="${editPrefActionMethodURL}" method="post"  name="<portlet:namespace />fm">
   Stock symbol:   <input type="text" name="<portlet:namespace />prefval" value=" <%=stock%>"/>
   </br>
 	<input type="submit" name="Save"  />

</form>


