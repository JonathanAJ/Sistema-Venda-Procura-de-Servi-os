<%		
	if(session.getAttribute("Usuario")==null){
		response.sendRedirect("index.jsp");
	}else{
%>
<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>
	<%
		}
	%>