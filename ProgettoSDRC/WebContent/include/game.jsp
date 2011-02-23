
<%
	String id = (String) session.getAttribute("PartitaId");
	if (id != null) {
%>
<jsp:useBean id="partita" type="tictactoe.beans.Game" scope="session" />
<jsp:useBean id="user" type="tictactoe.beans.Person" scope="session" />

<!-- Partita già iniziata -->
<center>

<table style="font-size: 48px;"2"">
	<tr>
		<td><span style="font-size: 14px"> <b>X = <jsp:getProperty
			name="user" property="nome" /> </b> <br>
		<b>O = Computer</b> </span> <br>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center" style="font-size: 14px">
		<h5>Stato Partita: <span style="color: red; font-style: italic; font-size:14px">
		&nbsp; <jsp:getProperty name="partita" property="stato" /></span></h5>
		<!-- <input type="hidden"
			value='<jsp:getProperty property="id" name="partita"/>'> --></td>
	</tr>
	<%
	Boolean endGame = false;
	if (partita.getStato()== "haiPerso" || partita.getStato()== "haiVinto" 
			|| partita.getStato()== "haiPareggiato"){
		endGame = true;
	}
	%>
	<!-- Fine intestazione -->
	<tr>
		<td style="text-align: center">
		<%
		if (partita.getCella11() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class= <%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella11" name="partita"/>'
			name="11"> <%
		if (partita.getCella11() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella12() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella12" name="partita"/>'
			name="12"> <%
		if (partita.getCella12() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella13() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella13" name="partita"/>'
			name="13"> <%
		if (partita.getCella13() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
	</tr>
	<!-- Fine prima riga -->
	<tr>
		<td style="text-align: center">
		<%
		if (partita.getCella21() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella21" name="partita"/>'
			name="21"> <%
		if (partita.getCella21() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella22() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella22" name="partita"/>'
			name="22"> <%
		if (partita.getCella22() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella23() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella23" name="partita"/>'
			name="23"> <%
		if (partita.getCella23() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
	</tr>
	<!-- Fine seconda riga -->
	<tr>
		<td style="text-align: center">
		<%
		if (partita.getCella31() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella31" name="partita"/>'
			name="31"> <%
		if (partita.getCella31() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella32()== "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella32" name="partita"/>'
			name="32"> <%
		if (partita.getCella32() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
		<td style="text-align: center">
		<%
		if (partita.getCella33() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("<form action='PlayGame'>");
		}
		%> <input type="submit" class=<%if (endGame == true){out.print("endGame");}else{out.print("buttonGame");} %>
			value='<jsp:getProperty property="cella33" name="partita"/>'
			name="33"> <%
		if (partita.getCella33() == "" && partita.getStato()!= "haiPerso" && partita.getStato() != "haiVinto"){
			out.println("</form>");
		}%>
		</td>
	</tr>
	<!-- Fine terza riga -->

</table>
<br>
<br>
<table>
	<tr>
		<td style="font-size:16px">
		<% if ( partita.getStato() == "inCorso" ) {%>
		<a href="include/newGame.jsp" style="color: red; font-weight: bold">Termina Partita -></a>
		<%}else{ %>
		<a href="include/newGame.jsp" style="color: red; font-weight: bold">Nuova Partita -></a>
		<%} %>
		</td>
	</tr>
</table>
</center>
<%
	} else {
%>
<!-- Si inizializza nuova partita -->
<center>
<table>
	<tr>
		<td><a href="PlayGame"> Inizia nuova partita -> </a></td>
	</tr>
</table>
</center>

<%
	}
%>

