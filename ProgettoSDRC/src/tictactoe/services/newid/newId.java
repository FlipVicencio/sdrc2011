package tictactoe.services.newid;

public class newId {

	/*
	public String newGame(){
		return String.valueOf((int)(Math.random()*100000));
	}
	*/
	
	public String newGame(){
		return java.util.UUID.randomUUID().toString();
	}
	
}

