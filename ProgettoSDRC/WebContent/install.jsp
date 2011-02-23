<%@page import="java.io.FileNotFoundException"%>
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

<%
	String passMySql = (String) session.getAttribute("passMySql");
	String passGame = (String) session.getAttribute("passGame");
	String mysql = (String) session.getAttribute("mysqlconn");
	if (passMySql == "err" || passGame == "err" || mysql=="err"){
		%>
<jsp:useBean id="install" type="tictactoe.beans.Install" scope="session" />
<%
		}
%>
<body background="html-img/quadretti.gif">
<a class="triggerTab">
<center>
<h1>Tic-Tac-Toe - Installazione</h1>
</center>
<form method="get" action="install">
<table style="font-size: 12px">
	<tr>
		<td colspan="2">
		<h2>Host MySql</h2>
		</td>
	</tr>
	<tr>
		<td colspan="2"><i>Se MySql installato sulla macchina locale:
		Host=localhost e Port=3306</i></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td>Host MySql</td>
		<td><input type="text" id="host" name="host"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"
			<% if (passMySql == "err" || passGame == "err" || mysql=="err"){
		%>value=<jsp:getProperty name="install" property="host" /> <%
		}
		%> ></td>
	</tr>
	<tr>
		<td>Port MySql</td>
		<td><input type="text" id="port" name="port"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"
			<% if (passMySql == "err" || passGame == "err" || mysql=="err"){
		%>value=<jsp:getProperty name="install" property="port" /> <%
		}
		%>></td>
	</tr>
	<tr>
		<td colspan="2">
		<h2>User MySql</h2>
		</td>
	</tr>
	<tr>
		<td>Nome Utente MySql</td>
		<td><input type="text" id="userMySql" name="userMySql"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"
			<% if (passMySql == "err" || passGame == "err" || mysql=="err"){
		%>value=<jsp:getProperty name="install" property="userMySql" /> <%
		}
		%>
			></td>
	</tr>
	<tr>
		<td>
		<%
			if (passMySql == "err") {
				out.print("<span style=\"color:red;\">");
			}
		%> Password Utente MySql <%
			if (passMySql == "err") {
				out.print("</span>");
			}
		%>
		</td>
		<td><input type="password" id="passMySql" name="passMySql"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"></td>
	</tr>
	<tr>
		<td>
		<%
			if (passMySql == "err") {
				out.print("<span style=\"color:red;\">");
			}
		%> Conferma Password Utente MySql <%
			if (passMySql == "err") {
				out.print("</span>");
			}
		%>
		</td>
		<td><input type="password" id="repassMySql" name="repassMySql"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"></td>

	</tr>
	<tr>
		<td>
		<hr width=100%>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<h2>Accesso Al Gioco</h2>
		</td>
	</tr>
	<tr>
		<td>Username</td>
		<td><input type="text" id="user" name="user"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"
			<% if (passMySql == "err" || passGame == "err" ||mysql=="err"){
		%>value=<jsp:getProperty name="install" property="user" /> <%
		}
		%>></td>
	</tr>
	<tr>
		<td>
		<%
			if (passGame == "err") {
				out.print("<span style=\"color:red;\">");
			}
		%> Password <%
			if (passGame == "err") {
				out.print("</span>");
			}
		%>
		</td>
		<td><input type="password" id="pass" name="passUser"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"></td>
	</tr>
	<tr>
		<td>
		<%
			if (passGame == "err") {
				out.print("<span style=\"color:red;\">");
			}
		%> Conferma Password <%
			if (passGame == "err") {
				out.print("</span>");
			}
		%>
		</td>
		<td><input type="password" id="repass" name="repassUser"
			onkeydown="checkInstallButton()" onchange="checkInstallButton()"></td>
	</tr>
	<tr>
	<td colspan="3">
	<br>
	Le informazioni aggiuntive sull'utente si possono inserire dopo la fase di installazione nell'apposita sezione <i>Gestione Account</i>
	<br>
	</td>
	</tr>
	<tr>
		<td></td>

		<td><input type="submit" id="procedi" name="procedi"
			title="Procedi" value="Procedi" disabled></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<%
			if (passGame == "err" || passMySql == "err") {
				out.println("<span style=\"color:red\"> Controllare Password </span>");
			}
		%>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
		<%
			if (mysql == "err") {
				out.println("<span style=\"color:red\"> Errore Connessione MySql <br>Controllare Credenziali di Accesso e che il Servizio sia Attivo </span>");
			}
		%>
		</td>
	</tr>
</table>
</form>
</a>
</body>
</html>