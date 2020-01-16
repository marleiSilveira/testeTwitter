<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@page import="br.com.prjtwitter.entidade.Tweet"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tweets</title>
	<script type="text/javascript">
	  function confirmarExclusao(id){
		  if(window.confirm("Confirma exclusao?")){
			  location.href="TweetsController?operacao=exc&id=" + id;
		  }
	  }
	  
	  function ecluirTudo(id){
		  if(window.confirm("Confirma a exclusão de todos os Tweets?")){
			  location.href="TweetsController?operacao=ext";
		  }
	  }	  
	</script>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
		List<Tweet> listaTweet = (List<Tweet>)request.getAttribute("lisTweets"); 
	%>	

	<table border=1>
	<tr> <th>Id</th>  <th>Id_hashtag</th> <th>Msn_id</th>  <th>Msn</th> <th>Autor</th> <th>Data_post</th> <th>Retweet_Count</th>  <th>Favorite_Count</th> <th>Data_pesquisa</th>  <th>Operação</th></tr>
	
	<%for (Tweet tweet:listaTweet){ %>
		<tr>
		  <td><%out.print(tweet.getId());%></td> 
          <td><%out.print(tweet.getId_hashtag());%></td>
          <td><%out.print(tweet.getMsn_id());%></td>
          <td><%out.print(tweet.getMsn());%></td>
          <td><%out.print(tweet.getAutor());%></td>
          <td><%out.print(tweet.getData_post());%></td>
          <td><%out.print(tweet.getRetweet_count());%></td>
          <td><%out.print(tweet.getFavorite_count());%></td>
          <td><%out.print(tweet.getData_pesquisa());%></td>
		  <td> <a href="javascript:confirmarExclusao(<%=tweet.getId()%>)">excluir </a></td>
		</tr>
	<%}%>
	</table>
	<br>
	<input type="button" value="Excluir Tudo" onclick="javascript:ecluirTudo()">
</body>
</html>