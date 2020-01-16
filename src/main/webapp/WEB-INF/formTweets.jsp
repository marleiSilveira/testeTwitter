<!DOCTYPE html>
<%@page import="br.com.prjtwitter.entidade.Tweet"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tweets</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
	Tweet tweet = (Tweet)request.getAttribute("twe");
	%>
	<form action="TweetsController" method="post">
	    ID:         <input type="text" name="id"  value="<%=tweet.getId()%>"/><br><br>
        Id_hashtag: <input type="text" name="id_hashtag"  value="<%=tweet.getId_hashtag()%>"/><br><br>
        Msn: <input type="text" name="msn"  value="<%=tweet.getMsn()%>"/><br><br>
        Autor: <input type="text" name="autor"  value="<%=tweet.getAutor()%>"/><br><br>
        Data_post: <input type="text" name="data_post"  value="<%=tweet.getData_post()%>"/><br><br>
        Data_pesquisa: <input type="text" name="data_pesquisa"  value="<%=tweet.getData_pesquisa()%>"/><br><br>
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>