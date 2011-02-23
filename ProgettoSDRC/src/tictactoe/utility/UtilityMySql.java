package tictactoe.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import tictactoe.beans.Person;

public class UtilityMySql {
	
	private static String makeUrl(Properties props){
		//si recupera i dati dal file di configurazione
		//String host = "localhost";
		String host = props.getProperty("host");		
		String dbName = "tictactoe";
		//int port = 3306;
		String port = props.getProperty("port");
		String mySqlUrl = "jdbc:mysql://" + host + ":" + port +
		"/" + dbName;
		return mySqlUrl;
	}
	private static Properties getUserInfo(){
		Properties userInfo = new Properties();
		userInfo.put("user", "root");
		userInfo.put("password", "");
		return userInfo;
	}

	public static Connection getConnection(Properties props){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//connection = DriverManager.getConnection(makeUrl(props), getUserInfo());
			connection = DriverManager.getConnection(makeUrl(props), 
					props.getProperty("userMySql"),props.getProperty("passMySql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	
	public static String checkUser(String username, String password){
		StringBuffer query = new StringBuffer();
		query.insert(0, "SELECT utente.username, utente.nome, utente.cognome, utente.eta, utente.email FROM utente");
		query.insert(query.length(), " WHERE utente.username = '"+ username + "' AND utente.password = '" + password + "';");
		return query.toString();
	}
	public static String isUserFree(String username){
		String query = "SELECT COUNT(*)as disponibile FROM utente WHERE utente.username = '"+ username + "';"; 
		return query;
	}
	public static String insertUser(Person newuser, String pass){
		StringBuffer insert = new StringBuffer();
		insert.insert(0, "INSERT INTO utente VALUES ('"+ newuser.getUser() + "','" + pass + "','"+ newuser.getNome());
		insert.insert(insert.length(), "','"+ newuser.getCognome()+"', "+newuser.getEta()+" ,'"+newuser.getEmail()+"',0,0,0);");
		return insert.toString();
	}
	public static String updateUser(Person moduser, String pass){
		StringBuffer update = new StringBuffer();
		update.insert(0, "UPDATE utente SET utente.nome = '"+moduser.getNome()+"', utente.cognome = '"+moduser.getCognome()+"', utente.eta = " + moduser.getEta()+" ,");
		update.insert(update.length(), "utente.email = '"+moduser.getEmail()+"', utente.password = '" + pass+"' ");
		update.insert(update.length(),"WHERE utente.username='"+ moduser.getUser()+"';");
		return update.toString();
	}
	public static String statistic(String user){
		StringBuffer statistic = new StringBuffer();
		statistic.insert(0, "SELECT utente.nVinte as vinte, utente.nPerse as perse, utente.nPari as pari ");
		statistic.insert(statistic.length(), "FROM utente WHERE utente.username = '" + user+"';");
		return statistic.toString();
	}
	public static String updateVinte (String user){
		return "UPDATE utente SET utente.nVinte = utente.nVinte +1 WHERE utente.username = '" + user +"';";
	}
	public static String updatePari (String user){
		return "UPDATE utente SET utente.nPari = utente.nPari +1 WHERE utente.username = '" + user +"';";
	}
	public static String updatePerse (String user){
		return "UPDATE utente SET utente.nPerse = utente.nPerse +1 WHERE utente.username = '" + user +"';";
	}
}
