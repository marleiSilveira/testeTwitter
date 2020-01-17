<%@ page import="br.com.prjtwitter.entidade.Config"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuracoes do Sistema</title>
	<script type="text/javascript">
	  function confirmarExclusao(id){
		  if(window.confirm("Confirma exclusao?")){
			  location.href="ConfigController?operacao=exc&id=" + id;
		  }
	  }
	  
	  function start(){
		  location.href="SystemController?operacao=run";
	  }	 
	  
	  function stop(){
		  location.href="SystemController?operacao=stop";
	  }	 	

	  function test(){
		  location.href="SystemController?operacao=test";
	  }	 
	  
	</script>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
		List<Config> listaConfig = (List<Config>)request.getAttribute("lisConfig"); 
		String status = String.valueOf(request.getAttribute("status")); 
	%>	

	<table border=1>
	<tr> <th>Id</th>  <th>Frequência</th>  <th>ConsumerKey</th> <th>ConsumerSecret</th> <th>AccessToken</th> <th>AccessTokenSecret</th> <th>Count</th> <th>Language</th> <th>GeoCodeLatitude</th> <th>GeoCodeLogitude</th> <th>GeoCodeRadius</th> <th>GeoCodeUnit</th> <th>Since</th> <th>Until</th> <th>Operação</th></tr>
	
	<%for (Config conf:listaConfig){ %>
		<tr>
		  <td><%out.print(conf.getId());%></td> 
		  <td><%out.print(conf.getFrequencia());%></td>
		  <td><%out.print(conf.getConsumerKey());%></td> 
		  <td><%out.print(conf.getConsumerSecret());%></td>   
		  <td><%out.print(conf.getAccessToken());%></td> 
		  <td><%out.print(conf.getAccessTokenSecret());%></td> 
		  <td><%out.print(conf.getCount());%></td>
		  <td><%out.print(conf.getLanguage());%></td>   
		  <td><%out.print(conf.getGeoCodeLatitude());%></td>    
		  <td><%out.print(conf.getGeoCodeLogitude());%></td>  
		  <td><%out.print(conf.getGeoCodeRadius());%></td>
		  <td><%out.print(conf.getGeoCodeUnit());%></td>
		  <td><%out.print(conf.getSince());%></td>
		  <td><%out.print(conf.getUntil());%></td>
		  <td> <a href="javascript:confirmarExclusao(<%=conf.getId()%>)">excluir</a>  | <a href="ConfigController?operacao=alt&id=<%=conf.getId() %>"> alterar </a></td>
		</tr>
	<%}%>
	</table>
	<br>
	<input type="button" value="Start" onclick="javascript:start()">
	<input type="button" value="Stop" onclick="javascript:stop()">	
	<input type="button" value="Teste" onclick="javascript:test()">	
    Status: <%out.print(status);%> 
</body>
</html>