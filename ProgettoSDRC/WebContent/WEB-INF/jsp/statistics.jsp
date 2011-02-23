<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="html-js/myLibrary.js"></script>
<link type="text/css" href="html-style/Style.css" rel="stylesheet" />

<!-- jsProgressBarHandler prerequisites : prototype.js -->
<script type="text/javascript" src="html-js/prototype/prototype.js"></script>

<!-- jsProgressBarHandler core -->
<script type="text/javascript"
	src="html-js/bramus/jsProgressBarHandler.js"></script>

<title>Tic-Tac-Toe</title>
<body background="html-img/quadretti.gif" alink="#1f75cc"
	vlink="#1f75cc" link="#1f75cc">

<jsp:useBean id="user" type="tictactoe.beans.Person" scope="session" />
<jsp:useBean id="statistic" type="tictactoe.beans.Statistic"
	scope="session" />
<%
	Integer percVinte, percPerse, percPari;
	Integer tot = statistic.getnPari() + statistic.getnPerse()
			+ statistic.getnVinte();
	if (tot != 0) {
		percVinte = 100 * statistic.getnVinte() / tot;
		percPerse = 100 * statistic.getnPerse() / tot;
		percPari = 100 * statistic.getnPari() / tot;
	} else {
		percVinte = 0;
		percPerse = 0;
		percPari = 0;
	}
%>
<div style="position: absolute; top: 0px; right: 0px;" class="infoTab">
<table>
	<tr>
		<td>Benvenuto</td>
		<td><span style="color: blue; font-weight: bold"><jsp:getProperty
			name="user" property="nome" /> <jsp:getProperty name="user"
			property="cognome" /></span></td>
		<td><b>|</b></td>
		<td><a href="startgame.jsp">Gioca</a>
		<td><b>|</b></td>
		<td><a href="Account">Gestione Account</a></td>
		<td><b>|</b></td>
		<td><a href="Statistics">Rank e Statistiche</a></td>
		<td><b>|</b></td>
		<td><a href="Logout">LogOut</a></td>
	</tr>
</table>
</div>

<div class="gameTab">
<center>
<h2>Statistiche</h2>
</center>
<h3>Totale Partite: <%
	out.print(tot);
%>
</h3>
<p>Partite Vinte: <%
	out.print(statistic.getnVinte());
%>
</p>
<br>
<span id="element1"> <%
 	out.print(percVinte + "%");
 %> </span> <br>
<br>
<p>Partite Pareggiate: <%
	out.print(statistic.getnPari());
%>
</p>
<br>
<span id="element2">
<%
	out.print(percPari + "%");
%>
</span> <br>
<br>
<p>Partite Perse: <%
	out.print(statistic.getnPerse());
%>
</p>
<br>
<span id="element3"> <%
 	out.print(percPerse + "%");
 %> </span> <br>
<br>

</div>

<script>

	document.observe('dom:loaded', function() {

		//manual example : multicolor (and take all other default paramters)
		manualPB2 = new JS_BRAMUS.jsProgressBar($('element1'),
				<%out.print(percVinte);%>, 
	{
					barImage : Array('html-img/bramus/percentImage_back4.png',
							'html-img/bramus/percentImage_back3.png',
							'html-img/bramus/percentImage_back2.png',
							'html-img/bramus/percentImage_back1.png')
				});
		manualPB2 = new JS_BRAMUS.jsProgressBar($('element2'),
				<%out.print(percPari);%>, 
	{
					barImage : Array('html-img/bramus/percentImage_back4.png',
							'html-img/bramus/percentImage_back3.png',
							'html-img/bramus/percentImage_back2.png',
							'html-img/bramus/percentImage_back1.png')
				});
		manualPB2 = new JS_BRAMUS.jsProgressBar($('element3'),
				<%out.print(percPerse);%>
	, {
					barImage : Array('html-img/bramus/percentImage_back4.png',
							'html-img/bramus/percentImage_back3.png',
							'html-img/bramus/percentImage_back2.png',
							'html-img/bramus/percentImage_back1.png')
				});

	}, false);
</script>

</body>
</html>