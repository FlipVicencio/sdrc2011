package tictactoe.servlet;

import java.io.IOException;
import java.io.InputStream;
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
import tictactoe.beans.Statistic;
import tictactoe.utility.UtilityMySql;

/**
 * Servlet implementation class Statistics
 */
public class Statistics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Statistics() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllo che sia loggato
		HttpSession session = request.getSession();
		Boolean status = (Boolean)session.getAttribute("StatusLogin");
		if (status!= null && status == true ){ 
			//si carica le statistiche
			Person user = (Person)session.getAttribute("user");

			Connection connection;
			try {
				connection = getConnection();

				Statement statement = connection.createStatement();

				ResultSet resultset = statement.executeQuery(UtilityMySql.statistic(user.getUser()));
				if (resultset.first()){
					//si popola oggetto statistiche
					Statistic statistic = new Statistic();
					statistic.setnVinte(resultset.getInt("vinte"));
					statistic.setnPari(resultset.getInt("pari"));
					statistic.setnPerse(resultset.getInt("perse"));
					session.setAttribute("statistic", statistic);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/statistics.jsp");
					dispatcher.forward(request, response);
				}else{
					throw new SQLException();
				}
			} catch (SQLException e) {
				//errore mysql
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
				dispatcher.forward(request, response);
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
