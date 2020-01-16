 <%@ page import="br.com.prjtwitter.entidade.Hashtag"%>
 <%@ page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hashtags</title>
	<script type="text/javascript">
	  function confirmarExclusao(id){
		  if(window.confirm("Confirma exclusao?")){
			  location.href="HashtagController?operacao=exc&id=" + id;
		  }
	  }
	  function novo(){
		  location.href="HashtagController?operacao=cad";
	  }
	</script>

</head>
<body>

	<%@include file="menu.jsp" %>
	<%
		List<Hashtag> listaHash = (List<Hashtag>)request.getAttribute("lisHashtags"); 
	%>	
	

	
	<table border=1>
	<tr> <th>Id</th>  <th>Hashtag</th> <th>Status</th> <th>Operação</th></tr>
	
	<%for (Hashtag hash:listaHash){ %>
		<tr>
		  <td><%out.print(hash.getId());%></td> 
		  <td><%out.print(hash.getHashtag());%></td> 
		  <td><%out.print(hash.isStatus());%></td>  
		  <td> <a href="javascript:confirmarExclusao(<%=hash.getId()%>)">excluir</a>  | <a href="HashtagController?operacao=alt&id=<%=hash.getId() %>"> alterar </a> | <a href="TweetsController?operacao=lih&id=<%=hash.getId() %>"> listar tweets </a></td>
		</tr>
	<%}%>
	</table>
	<br>
	<input type="button" value="Novo" onclick="javascript:novo()">
</body>
</html>