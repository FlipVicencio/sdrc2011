<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="html-style/Style.css" rel="stylesheet" />
<script type="text/javascript" src="html-js/myLibrary.js"></script>

<title>Tic-Tac-Toe</title>
</head>
<body background="html-img/quadretti.gif" alink="#1f75cc"
	vlink="#1f75cc" link="#1f75cc">
<%
String pass = (String) session.getAttribute("passMod");
Boolean status = (Boolean)session.getAttribute("StatusLogin");
if (status != null){
	if (status == false){
		response.sendRedirect("index.jsp");
	}else{%>
<jsp:useBean id="user" type="tictactoe.beans.Person" scope="session" />

<div style="position: absolute; top: 0px; right: 0px;"	class="infoTab">
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

<div class="gameTab"> <!-- Pannello Gestione informazioni utente -->
<center>
<form name="account" method="get" action="Register">
<table id="tQuant" style="font-size: 12px;">
	<tr height="45">
		<td colspan="2" align="center"><u><b>Modifica
		Informazioni Account</b></u></td>
	</tr>
	<tr>
		<td>Username</td>
		<td id="username"><jsp:getProperty name="user" property="user" />
		<input type="hidden" name="user"
			value=<jsp:getProperty name="user" property="user" />></td>
	</tr>
	<tr>
		<td>Email*</td>
		<td><input type="text" id="email" name="email"
			onchange="checkModButton()" onkeydown="checkModButton()"
			value=<jsp:getProperty name="user" property="email" />></td>
	</tr>
	<tr>
		<td>
		<%
		if (pass != "err"){
			out.println("Password*");
		}else{
			out.println("<font color='red'>Passowrd*</font>");
		}
		%>
		</td>
		<td><input type="password" id="password" name="password"
			onkeydown="checkModButton()" onchange="checkModButton()"></td>
	</tr>
	<tr>
		<td>
		<%
		if (pass != "err"){
			out.println("Conferma Password*");
		}else{
			out.println("<font color='red'>Conferma Passowrd*</font>");
		}
		%>
		</td>
		<td><input type="password" id="repassword" name="repassword"
			onkeydown="checkModButton()" onchange="checkModButton()"></td>
	</tr>
	<tr>
		<td>Nome*</td>
		<td><input type="text" id="nome" name="nome"
			onchange="checkModButton()" onkeydown="checkModButton()"
			value=<jsp:getProperty name="user" property="nome" />></td>
	</tr>
	<tr>
		<td>Cognome*</td>
		<td><input type="text" id="cognome" name="cognome"
			onchange="checkModButton()" onkeydown="checkModButton()"
			value=<jsp:getProperty name="user" property="cognome" />></td>
	</tr>
	<tr>
		<td>Età*</td>
		<td><input type="text" id="eta" name="eta"
			onchange="checkModButton()" onkeydown="checkModButton()"
			value=<jsp:getProperty name="user" property="eta" />></td>
	</tr>
	<tr>
		<td colspan="2" align="center">(*) Campi obbligatori</td>
	</tr>
	<tr height="45">
		<td colspan="2" align="center">
		<button id="modificaAccount" name="Account" type="submit"
			value="modifica" disabled>Modifica Account</button>
		</td>
	</tr>
	<tr>
	<td>
	<%
		if (pass == "err"){
			out.print("<tr><td colspan='2'><center><font color='red'>Inserire nuovamente la password</font></center></td></tr>");
		}
	%>
	</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="index.jsp">Chiudi
		Pannello Account</a></td>
	</tr>
</table>
</form>
</center>
</div>
<div
	style="position: absolute; margin-left: 57%; margin-bottom: 0px; z-index: 2;"><img
	width="80%" src="html-img/pencil.png"></div>
<%	}
}else{
	response.sendRedirect("index.jsp");
}%>
</body>
</html>