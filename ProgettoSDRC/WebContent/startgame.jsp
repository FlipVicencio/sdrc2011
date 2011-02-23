<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="html-style/Style.css" rel="stylesheet" />
<title>Tic-Tac-Toe</title>
</head>

<body background="html-img/quadretti.gif" alink="#1f75cc"
	vlink="#1f75cc" link="#1f75cc">
<%
Boolean status = (Boolean)session.getAttribute("StatusLogin");
if (status != null){
	if (status == false){
		int val = 1;
		session.setAttribute("startgame",val);
		response.sendRedirect("index.jsp");
	}else{
		session.removeAttribute("startgame");	
%>
<jsp:useBean id="user" type="tictactoe.beans.Person" scope="session" />

<!-- Livello del menu utente altro a destra -->
<div class="infoTab" style="position: absolute; top: 0px; right: 0px;">
<table>
	<tr>
		<td>Benvenuto</td>
		<td><span style="color: blue; font-weight:bold"><jsp:getProperty name="user" property="nome" /> <jsp:getProperty
			name="user" property="cognome" /></span></td>
		<td><b>|</b></td>
		<td><a href="startgame.jsp">Gioca</a>
		<td><b>|</b></td>
		<td><a href="Account">Gestione Account</a></td>
		<td><b>|</b></td>
		<td><a href="Statistics">Rank e Statistiche</a></td>
		<td><b>|</b></td>
		<td>
		<a href="Logout">LogOut</a>
		</td>
	</tr>
</table>

</div>
<div class="gameTab">
<center>
<h1> Gioca</h1>
</center>
<!-- Si include jsp partita -->
<jsp:include page="/include/game.jsp" />
</div>

<!-- Immagine lapissone -->
<div style="margin-left: 57%; margin-top: 20%; z-index: -1;"><img
	width="80%" src="html-img/pencil.png"></div>
<%	}
}else{
	int val = 1;
	session.setAttribute("startgame",val);
	response.sendRedirect("index.jsp");
}%>

</body>

</html>