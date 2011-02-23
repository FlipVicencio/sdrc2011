package tictactoe.install;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tictactoe.beans.Install;
import tictactoe.utility.BeanUtilities;
import tictactoe.utility.UtilityServlet;

/**
 * Servlet implementation class install
 */
public class install extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public install() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//installazione applicazione
		//controllo dati inseriti e password uguali
		HttpSession session = request.getSession();
		//si crea bean dalla form
		Install install = new Install();
		BeanUtilities.populateBean(install, request);
		session.setAttribute("install", install);
		String procedi = request.getParameter("procedi");
		if (procedi != null){
			String passMySql = request.getParameter("passMySql");
			String repassMySql = request.getParameter("repassMySql");
			if (passMySql.equals(repassMySql)){
				session.removeAttribute("passMySql");
				String passGame = request.getParameter("passUser");
				String repassGame = request.getParameter("repassUser");
				if (passGame.equals(repassGame)){
					session.removeAttribute("passGame");
					//si testa credenziali accesso mysql
					String host = install.getHost();		
					String port = install.getPort();
					String mySqlUrl = "jdbc:mysql://" + host + ":" + port;
					
					PrintWriter out = response.getWriter();
					out.println(UtilityServlet.getHead("Installazione Tic-Tac-Toe"));
					
					Connection connection = null;
					try {
						Class.forName("com.mysql.jdbc.Driver");

						connection = DriverManager.getConnection(mySqlUrl, install.getUserMySql(), passMySql);

						if(connection.isValid(0)){
							session.removeAttribute("mysqlconn");
							Statement statement = connection.createStatement();

							//si crea il db e si da i diritti al client
							out.println("Start Install <br><br>");
							executeScript(statement,out);
							
							out.println("Create Database: Ok");
							String accesUser = " GRANT ALL PRIVILEGES ON tictactoe.* TO "+ 
							install.getUser()+"@" + install.getHost() +" IDENTIFIED BY '"+ passMySql+ "';";

							statement.execute(accesUser);
							
							//connessione con db appena creato
							connection.close();
							
							connection = DriverManager.getConnection(mySqlUrl+"/tictactoe", install.getUserMySql(), passMySql);
							statement = connection.createStatement();
							
							//si inserisce il primo utente
							String firstUser = "INSERT INTO utente VALUES(" +
									"'"+install.getUser() +"','"+ passGame +"','nome','cognome',18,'mail@mail.it',0,0,0)";
							
							statement.execute(firstUser);
							out.println("<br><br> Add New User: OK");
							//si crea il file di property 
							Properties props = new Properties(); 
							props.setProperty("host", install.getHost());
							props.setProperty("port", install.getPort());
							props.setProperty("userMySql", install.getUserMySql());
							props.setProperty("passMySql", passMySql);
							
							props.setProperty("hostService", request.getServerName());
							props.setProperty("portService", String.valueOf(request.getServerPort()));
							props.setProperty("nameApp", request.getContextPath());

							out.print(props.toString());
							String path = getServletContext().getRealPath("/config");

							File file = new File(path +"/config.properties");
							file.createNewFile();

							props.store(new FileOutputStream(file), "configuration");

							out.println("<br><br><b>Installazione completa con successo<b>");
							out.println("<a href=\"index.jsp\">Continua -> </a>");

						}else{
							throw new SQLException();
						}
					} catch (SQLException e) {
						session.setAttribute("mysqlconn", "err");
						response.sendRedirect("install.jsp");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}else{
					session.setAttribute("passGame", "err");
					response.sendRedirect("install.jsp");
				}
			}else{
				session.setAttribute("passMySql", "err");
				response.sendRedirect("install.jsp");
			}
		}else{
			//la richiesta non proviene da install.jsp
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	private void executeScript(Statement statement, PrintWriter out){
		String s = new String();  
		StringBuffer sb = new StringBuffer();  

		try  
		{  
			String path = getServletContext().getRealPath("/config");
			
			FileReader fr = new FileReader(new File(path + "/tictactoe.sql"));  
			// be sure to not have line starting with "--" or "/*" or any other non aplhabetical character  

			BufferedReader br = new BufferedReader(fr);  

			while((s = br.readLine()) != null)  
			{  
				sb.append(s);  
			}  
			br.close();  

			// here is our splitter ! We use ";" as a delimiter for each request  
			// then we are sure to have well formed statements  
			String[] inst = sb.toString().split(";");  

			for(int i = 0; i<inst.length; i++)  
			{  
				// we ensure that there is no spaces before or after the request string  
				// in order to not execute empty statements  
				if(!inst[i].trim().equals(""))  
				{  
					statement.execute(inst[i]);  
					out.println("-"+inst[i]+ "<br>");  
				}  
			}  

		}  
		catch(Exception e)  
		{  
			out.println("*** Error : "+e.toString());  
			out.println("*** ");  
			out.println("*** Error : ");  
			e.printStackTrace();  
			out.println("################################################");  
			out.println(sb.toString());  
		}  
	}
}
