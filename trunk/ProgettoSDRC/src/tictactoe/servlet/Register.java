package tictactoe.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tictactoe.beans.Person;
import tictactoe.utility.BeanUtilities;
import tictactoe.utility.UtilityMySql;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//si confronta con Account perchè può essere registrazione di un nuovo utente
		String value = (request.getParameter("Account"));
		if (value != null){
			//si carica il bean con i valori dell'utente
			Person moduser = new Person();
			BeanUtilities.populateBean(moduser, request);
			String pass = request.getParameter("password");
			String repass = request.getParameter("repassword");
			if (pass.equals(repass)){
				//pass uguali
				session.removeAttribute("passMod");
				session.removeAttribute("passAgg");
				if (value.equals("modifica")){
					try{
						//utente da modificare
						Connection connection = getConnection();
						if (connection == null){
							throw new SQLException();
						}
						
						Statement statement = connection.createStatement();
						//System.out.println(UtilityMySql.updateUser(moduser, pass));
						statement.executeUpdate(UtilityMySql.updateUser(moduser, pass));
						//utente modificato si aggiorna il bean user
						Person user = new Person();
						user.setNome(moduser.getNome());
						user.setCognome(moduser.getCognome());
						user.setEta(moduser.getEta());
						user.setUser(moduser.getUser());
						user.setEmail(moduser.getEmail());
						//si aggiunge alla sessione dell'utente
						session.setAttribute("StatusLogin", true);
						session.setAttribute("user", user);

						response.sendRedirect("startgame.jsp");							
					}catch(SQLException e){
						//errore modifica utente
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
						dispatcher.forward(request, response);

					}
				}else{
					//nuovo utente
					//si controlla se il nome utente è disponibile
					try{
						Connection connection = getConnection();
						if (connection == null){
							throw new SQLException();
						}
						
						Statement statement = connection.createStatement();
						String username = moduser.getUser();
						ResultSet resultset = statement.executeQuery(UtilityMySql.isUserFree(username));
						resultset.first();

						if (resultset.getInt("disponibile")== 0){
							//user diponibile si salva
							session.removeAttribute("disponibile");
							statement.execute(UtilityMySql.insertUser(moduser, pass));

							//si logga l'utente e si manda a startgame.jsp
							Person user = new Person();
							user.setNome(moduser.getNome());
							user.setCognome(moduser.getCognome());
							user.setEta(moduser.getEta());
							user.setUser(moduser.getUser());
							user.setEmail(moduser.getEmail());
							//si aggiunge alla sessione dell'utente
							session.setAttribute("StatusLogin", true);
							session.setAttribute("user", user);

							response.sendRedirect("startgame.jsp");

						}else{
							//user non disponibile
							session.setAttribute("moduser", moduser);
							session.setAttribute("disponibile", "no");
							response.sendRedirect("index.jsp");
						}
					} catch (SQLException e) {
						//errore inserimento utente
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
						dispatcher.forward(request, response);
					}
				}
			}else{
				//pass diversi si torna alla form di provenienza			
				if (value.equals("modifica")){
					session.setAttribute("passMod", "err");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
					dispatcher.forward(request, response);
				}else{
					//si ritorna il bean per riempiere la form
					session.setAttribute("moduser", moduser);
					session.setAttribute("passAgg","err");
					response.sendRedirect("index.jsp");
				}
			}
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorLogIn.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	private Connection getConnection() throws SQLException, IOException{
		Connection conn = (Connection)getServletContext().getAttribute("Connection");
		if (conn!=null){
			if (conn.isValid(0)){
				return conn;
			}else{
				InputStream file = getServletContext().getResourceAsStream("/config/config.properties");
				Properties props = new Properties();
				props.load(file);
				conn = UtilityMySql.getConnection(props);
				getServletContext().setAttribute("Connection",conn);
				return conn;
			}
		}else{
			InputStream file = getServletContext().getResourceAsStream("/config/config.properties");
			Properties props = new Properties();
			props.load(file);
			conn = UtilityMySql.getConnection(props);
			getServletContext().setAttribute("Connection",conn);
			return conn;
		}
	}

}
