<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>


 <script type="text/javascript">
 $(document).ready(function() {

	 $("#savediv").hide();
	 
	 $("#editid").click(function() {	
		 $("#savediv").show();
         $("#editdiv").hide();
	  });
	 
	  
	 $("#saveid").click( function() {

		 $form = $(this).closest("form"); //wrap this in jQuery
		 
		    $.ajax( {
		      type: "POST",
		      url: $form.attr( 'action' ),
		      data: $form.serialize(),
		      dataType: "json",
		      success: function( response ) {
		        //Code to process the response
		        $("#savediv").hide();
		        $("#editdiv").show();
		     
		   //     alert(response["stockval"]);
		        $("#preflabel").text(response["stockval"]);

			      }
		    });
		 
		    return false;
		  } );
	  
	  
	});
</script>

<portlet:defineObjects />
 
 <%
    String stock = portletPreferences.getValue("StockSymbol", ""); 
%>
 
<portlet:actionURL name="actionMethod1" var="editPrefActionMethodURL">
</portlet:actionURL>
<form id="saveform" action="${editPrefActionMethodURL}" method="post"  name="<portlet:namespace />fm">
   <div id="editdiv">
  		<label  id="preflabel"><%= stock%></label>  <!--Default preference value configured in portlet.xml for "Edit" Portlet -->  		
    	<input type="button" id="editid" value="Edit" />
  </div>
 
  <div id="savediv">
    <input type="text" id="prefval" name="<portlet:namespace />prefval" value="<%= stock%>"/>
    <input type="button" id="saveid" value="Save" />
  </div>

</form>


