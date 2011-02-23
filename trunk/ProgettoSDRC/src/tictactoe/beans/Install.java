package tictactoe.beans;

public class Install {
	private String host = "localhost";
	private String port = "3306";
	private String userMySql = "";
	private String user = "";

	public Install(){

	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserMySql() {
		return userMySql;
	}
	public void setUserMySql(String userMySql) {
		this.userMySql = userMySql;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	

}
