package tictactoe.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;

import edu.emory.mathcs.backport.java.util.Arrays;

import tictactoe.beans.Game;
import tictactoe.beans.Person;
import tictactoe.services.client.newid.NewIdStub;
import tictactoe.services.client.newid.NewIdStub.NewGameResponse;
import tictactoe.services.client.tris.TrisStub;
import tictactoe.services.tris.IndiceType;
import tictactoe.services.tris.StatusType;
import tictactoe.utility.GrigliaGame;
import tictactoe.utility.UtilityMySql;

/**
 * Servlet implementation class PlayGame
 */
public class PlayGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static NewIdStub stubNewGame;
	private static TrisStub stub;


	@Override
	public void init() throws ServletException{

		super.init();
		try {
			stubNewGame = new NewIdStub("http://localhost:8080/ProgettoSDRC/services/newId");

			stub = new TrisStub("http://localhost:8080/ProgettoSDRC/services/Tris");
		} catch (AxisFault e) {

		}
	}

	public PlayGame() {
		super();
	}

	private Integer[] getCellaClick (HttpServletRequest request){
		Integer[] cella = new Integer[2];
		if (request.getParameter("11") != null){
			cella[0] = 1;
			cella[1] = 1;
			return cella;
		}
		if (request.getParameter("12") != null){
			cella[0] = 1;
			cella[1] = 2;
			return cella;
		}
		if (request.getParameter("13") != null){
			cella[0] = 1;
			cella[1] = 3;
			return cella;
		}
		if (request.getParameter("21") != null){
			cella[0] = 2;
			cella[1] = 1;
			return cella;
		}
		if (request.getParameter("22") != null){
			cella[0] = 2;
			cella[1] = 2;
			return cella;
		}
		if (request.getParameter("23") != null){
			cella[0] = 2;
			cella[1] = 3;
			return cella;
		}
		if (request.getParameter("31") != null){
			cella[0] = 3;
			cella[1] = 1;
			return cella;
		}
		if (request.getParameter("32") != null){
			cella[0] = 3;
			cella[1] = 2;
			return cella;
		}
		if (request.getParameter("33") != null){
			cella[0] = 3;
			cella[1] = 3;
			return cella;
		}
		return cella;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("PartitaId");
		Person user = (Person)session.getAttribute("user");
		Game partita;
		if (id != null){
			session.removeAttribute("startPc");
			try{
				TrisStub.Mossa mossaUser = new TrisStub.Mossa();
				TrisStub.MossaType paramMossa = new TrisStub.MossaType();
				paramMossa.setId(id);

				//si fa la mossa del user e si fa una nuova mossa
				//si ricerca il bottom cliccato
				Integer[] click = getCellaClick(request);
				partita = (Game)session.getAttribute("partita");

				//si setta riga e colonna mossa
				if (click[0] == 1){
					paramMossa.setRiga(TrisStub.IndiceType.value1);
				}else{
					if (click[0] == 2){
						paramMossa.setRiga(TrisStub.IndiceType.value2);
					}else{
						paramMossa.setRiga(TrisStub.IndiceType.value3);
					}
				}
				if (click[1] == 1){
					paramMossa.setColonna(TrisStub.IndiceType.value1);
				}else{
					if (click[1] == 2){
						paramMossa.setColonna(TrisStub.IndiceType.value2);
					}else{
						paramMossa.setColonna(TrisStub.IndiceType.value3);
					}
				}

				mossaUser.setMossa(paramMossa);
				//si esegue la mossa dell'utente e si fa quella del pc
				TrisStub.Griglia griglia = stub.gioca(mossaUser);
				//controllo che stato partita non sia errore
				if (griglia.getGriglia().getStatus().equals(StatusType.errore)){
					throw new Exception("Errore sevizio web");
				}
				partita = GrigliaGame.buildBeanGame(griglia);
				partita.setId(id);
				session.setAttribute("partita", partita);

				//controllo stato partita, si aggiornano statistiche
				String status = griglia.getGriglia().getStatus().toString();
				try{
					if (status.equals(StatusType.haiPareggiato.toString())){
						Connection connection = getConnection();
						Statement statement = connection.createStatement();
						statement.executeUpdate(UtilityMySql.updatePari(user.getUser()));
					}
					if (status.equals(StatusType.haiPerso.toString())){
						Connection connection = getConnection();
						Statement statement = connection.createStatement();
						statement.executeUpdate(UtilityMySql.updatePerse(user.getUser()));
					}
					if (status.equals(StatusType.haiVinto.toString())){
						Connection connection = getConnection();
						Statement statement = connection.createStatement();
						statement.executeUpdate(UtilityMySql.updateVinte(user.getUser()));
					}
					response.sendRedirect("startgame.jsp");
				}catch (SQLException e) {
					//errore mysql
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorSql.jsp");
					dispatcher.forward(request, response);
				}
			}catch(Exception e){
				//gestione eccezzioni servizio web
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorAxis.jsp");
				dispatcher.forward(request, response);

			}
		}else{
			//si deve fare nuova partita
			try{
				NewGameResponse genId = stubNewGame.newGame();

				session.setAttribute("PartitaId", genId.get_return());
				TrisStub.Id idPartita = new TrisStub.Id();
				idPartita.setId(genId.get_return());

				TrisStub.Griglia griglia = stub.inizializza(idPartita);

				partita = GrigliaGame.buildBeanGame(griglia);
				partita.setId(genId.get_return());

				session.setAttribute("partita", partita);
				response.sendRedirect("startgame.jsp");
			}catch(Exception e){
				//gestione ecezzioni servizio web
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errorAxis.jsp");
				dispatcher.forward(request, response);
			}
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
