<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="java.io.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="html-style/Style.css" rel="stylesheet" />
<script type="text/javascript" src="html-js/myLibrary.js"></script>

<title>Tic-Tac-Toe</title>
</head>
<%
InputStream file = getServletContext().getResourceAsStream("/config/config.properties");
if (file == null){
	response.sendRedirect("install.jsp");
}


%>

<body background="html-img/quadretti.gif" onload="popolaEta()">
<a class="triggerTab">
<center>
<h1>Tic-Tac-Toe</h1>
</center>
<table>
	<tr valign="top">
		<td>
		<form name="login" action="Login" method="get">
		<table style="font-size: 12px;">
			<tr>
				<td colspan="2" align="center"><u><b>Login</b></u></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" id="loginUsername" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="loginPassword" name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
				<center><input type="submit" value="Accedi"></center>
				</td>
			</tr>
			<%
				Boolean status = (Boolean) session.getAttribute("StatusLogin");
				if (status != null) {
					if (status == false) {
						out.print("<tr><td colspan='2'><center><font color='red'>Username e/o Password errati</font></center></td></tr>");
					} else {
						response.sendRedirect("startgame.jsp");
					}
				}
				Integer startgame = (Integer) session.getAttribute("startgame");
				if (startgame != null) {
					if (startgame == 1) {
						out.print("<tr><td colspan='2'><center><font color='red'>Effettuare il login prima di giocare</font></center></td></tr>");
					}
				}
			%>
		</table>
		</form>
		</td>
		<td>
		<div style="background-color: = '#7c7777'; width: 2px; height: 30px">&nbsp;&nbsp;</div>
		</td>
		<td>
		<%
			String pass = (String) session.getAttribute("passAgg");
			String disponibile = (String) session.getAttribute("disponibile");
			if (pass == "err"){
			%> <jsp:useBean id="moduser" type="tictactoe.beans.Person"
			scope="session" /> <%
			}
		%>
		<form id="register" method="get" action="Register" >
		<table style="font-size: 12px;">
			<tr>
				<td colspan="2" align="center"><u><b>Crea Nuovo Account</b></u></td>
			</tr>
			<tr>
				<td>
				<%
				if (disponibile != "no"){
				%> Username* <%
				}else{%> <font color='red'>Username*</font> <%
				}
				%>
				</td>
				<td><input type="text" onchange="checkAbleButton()"
					onkeydown="checkAbleButton()" id="username" name="user"
					<%
					if (pass=="err"){
					%>
					value=<jsp:getProperty name="moduser" property="user" /><%
					}
					%>
				></td>
			</tr>
			<tr>
				<td>Email*</td>
				<td><input type="text" id="email" onkeydown="checkAbleButton()"
					name="email" onchange="checkAbleButton()"
					<%
					if (pass=="err" || disponibile=="no"){
						%>
					value=<jsp:getProperty name="moduser" property="email" />
					<%
					}
					%>>
				</td>
			</tr>
			<tr>
				<td>
				<%
					if (pass != "err") {
						out.println("Password*");
					} else {
						out.println("<font color='red'>Passowrd*</font>");
					}
				%>
				</td>
				<td><input type="password" id="password"
					onkeydown="checkAbleButton()" name="password"
					onchange="checkAbleButton()"></td>
			</tr>
			<tr>
				<td>
				<%
					if (pass != "err") {
						out.println("Conferma Passowrd*");
					}else{
						out.println("<font color='red'>Conferma Passowrd*</font>");
					}
				%>
				</td>
				<td><input type="password" id="repassword" name="repassword"
					onkeydown="checkAbleButton()" onchange="checkAbleButton()"></td>
			</tr>
			<tr>
				<td>Nome*</td>
				<td><input type="text" id="nome" name="nome"
					onkeydown="checkAbleButton()" onchange="checkAbleButton()"
					<%
					if (pass=="err" || disponibile=="no"){
						%>
					value=<jsp:getProperty name="moduser" property="nome" /><%
					}
					%>
				></td>
			</tr>
			<tr>
				<td>Cognome*</td>
				<td><input type="text" id="cognome"
					onkeydown="checkAbleButton()" name="cognome"
					onchange="checkAbleButton()" <%
					if (pass=="err"  || disponibile=="no"){
						%>
					value=<jsp:getProperty name="moduser" property="cognome" /><%
					}
					%>
					></td>
			</tr>
			<tr>
				<td>Età*</td>
				<td>
				<%
					if (pass=="err" || disponibile=="no"){
						%> <input type="text" id="eta" name="eta"
					onchange="checkAbleButton()" onkeydown="checkAbleButton()"
					value=<jsp:getProperty name="moduser" property="eta" />> <% 	
					}else{
						%> <select id="eta" name="eta" onkeydown="checkAbleButton()"
					onchange="checkAbleButton()"></select> <%					
					}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">(*) Campi obbligatori</td>
			</tr>
			<tr>
				<td colspan="2">
				<center>
				<button id="creaAccount" name="Account" value="aggiungi"
					type="submit" disabled>Crea Account</button>
				</center>
				</td>
			</tr>
			<tr>
				<td>
				<%
					if (disponibile == "no") {
						out.print("<tr><td colspan='2'><center><font color='red'>Username non disponibile. Inserire nuovo username</font></center></td></tr>");
					}
				%>
				</td>
			</tr>
			<tr>
				<td>
				<%
					if (pass == "err") {
						out.print("<tr><td colspan='2'><center><font color='red'>Inserire nuovamente la password</font></center></td></tr>");
					}
				%>
				</td>
			</tr>
		</table>
		</form>
		</td>
</table>

</a>
<div
	style="position: absolute; margin-left: 57%; margin-bottom: 0px; z-index: 2;"><img
	width="80%" src="html-img/pencil.png"></div>

</body>
</html>