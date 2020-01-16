<!DOCTYPE html>
<%@page import="br.com.prjtwitter.entidade.Config"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Configuracoes da Busca</title>
</head>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
	Config conf = (Config)request.getAttribute("con");
	%>
	<form action="ConfigController" method="post">
	    ID:       <input type="text" name="id"  value="<%=conf.getId()%>"/><br><br>
	   	Frequencia:  <input type="text" name="frequencia"  value="<%=conf.getFrequencia()%>"/><br><br>
	   	ConsumerKey:  <input type="text" name="consumerKey"  value="<%=conf.getConsumerKey()%>"/><br><br>
	   	ConsumerSecret:  <input type="text" name="consumerSecret"  value="<%=conf.getConsumerSecret()%>"/><br><br>
	   	AccessToken:  <input type="text" name="accessToken"  value="<%=conf.getAccessToken()%>"/><br><br>
	   	AccessTokenSecret: <input type="text" name="accessTokenSecret"  value="<%=conf.getAccessTokenSecret()%>"/><br><br>
	   	Count: <input type="text" name="count"  value="<%=conf.getCount()%>"/><br><br>
	   	Language: <input type="text" name="language"  value="<%=conf.getLanguage()%>"/><br><br>
	   	GeoCodeLatitude: <input type="text" name="geoCodeLatitude"  value="<%=conf.getGeoCodeLatitude()%>"/><br><br>
	   	GeoCodeLogitude: <input type="text" name="geoCodeLogitude"  value="<%=conf.getGeoCodeLogitude()%>"/><br><br>
	   	GeoCodeRadius: <input type="text" name="geoCodeRadius"  value="<%=conf.getGeoCodeRadius()%>"/><br><br>
	   	GeoCodeUnit: <input type="text" name="geoCodeUnit"  value="<%=conf.getGeoCodeUnit()%>"/><br><br>
	   	Since: <input type="text" name="since"  value="<%=conf.getSince()%>"/><br><br>
	   	Until: <input type="text" name="until"  value="<%=conf.getUntil()%>"/><br><br>
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>