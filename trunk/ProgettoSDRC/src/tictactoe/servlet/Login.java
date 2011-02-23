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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tictactoe.beans.Person;
import tictactoe.utility.UtilityMySql;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = getConnection();
			if (connection == null){
				throw new SQLException();
			}
			Statement statement = connection.createStatement();

			//credenziali di accesso inserite
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			ResultSet resultset = statement.executeQuery(UtilityMySql.checkUser(username, password));

			if (!resultset.first()){
				//dati sbagliati
				HttpSession session = request.getSession();
				session.setAttribute("StatusLogin", false);
				response.sendRedirect("index.jsp");
			}else{
				//dati corretti si crea il bean con i dati della persona
				Person user = new Person();
				user.setNome(resultset.getString("nome"));
				user.setCognome(resultset.getString("cognome"));
				user.setEta(resultset.getInt("eta"));
				user.setUser(resultset.getString("username"));
				user.setEmail(resultset.getString("email"));
				//si aggiunge alla sessione dell'utente
				HttpSession session = request.getSession();
				session.setAttribute("StatusLogin", true);
				session.setAttribute("user", user);

				response.sendRedirect("startgame.jsp");
			}
		} catch (SQLException e) {
			//errore mysql
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			//errore mysql driver
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
			dispatcher.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		InputStream file = getServletContext().getResourceAsStream("/config/config.properties");
		Properties props = new Properties();
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getServletContext().setAttribute("Connection",UtilityMySql.getConnection(props));
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
