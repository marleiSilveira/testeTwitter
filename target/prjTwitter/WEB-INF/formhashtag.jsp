<!DOCTYPE html>
<%@page import="br.com.prjtwitter.entidade.Hashtag"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Hashtag</title>
</head>
<body>
 	<%@include file="menu.jsp" %>
	<%
	Hashtag hashtag = (Hashtag)request.getAttribute("has");
	%>
	<form action="HashtagController" method="post">
	    ID:       <input type="text" name="id"  value="<%=hashtag.getId()%>"/>
	   	Hashtag:  <input type="text" name="hashtag"  value="<%=hashtag.getHashtag()%>"/>
		Status:   <input type="text" name="status"  value="<%=hashtag.isStatus()%>"/>
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>