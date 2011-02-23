package tictactoe.utility;

import java.util.ArrayList;

import tictactoe.beans.Game;
import tictactoe.services.client.tris.TrisStub;
import tictactoe.services.tris.*;

public class GrigliaGame {


	GrigliaGame (){
	}

	static public Griglia nuovaGriglia(){
		GrigliaType grigliaT = new GrigliaType();
		Griglia grigliaG = new Griglia();

		//si azzerano tutte le caselle della griglia
		grigliaT.setCella11(CellaType.vuoto);
		grigliaT.setCella12(CellaType.vuoto);
		grigliaT.setCella13(CellaType.vuoto);
		grigliaT.setCella21(CellaType.vuoto);
		grigliaT.setCella22(CellaType.vuoto);
		grigliaT.setCella23(CellaType.vuoto);
		grigliaT.setCella31(CellaType.vuoto);
		grigliaT.setCella32(CellaType.vuoto);
		grigliaT.setCella33(CellaType.vuoto);

		grigliaT.setStatus(StatusType.inizio);
		grigliaG.setGriglia(grigliaT);
		return grigliaG;
	}

	static public CellaType getCella (Griglia grigliaG,int x, int y){
		GrigliaType grigliaT = grigliaG.getGriglia();
		CellaType cella = CellaType.vuoto;
		switch(x){
		case 1: {
			switch(y){
			case 1:{
				cella = grigliaT.getCella11();
				break;
			}
			case 2:{
				cella = grigliaT.getCella12();
				break;
			}
			case 3:{
				cella = grigliaT.getCella13();
				break;
			}
			}
			break;
		}
		case 2:{
			switch(y){
			case 1:{
				cella = grigliaT.getCella21();
				break;
			}
			case 2:{
				cella = grigliaT.getCella22();
				break;
			}
			case 3:{
				cella = grigliaT.getCella23();
				break;
			}
			}
			break;
		}
		case 3:{
			switch(y){
			case 1:{
				cella = grigliaT.getCella31();
				break;
			}
			case 2:{
				cella = grigliaT.getCella32();
				break;
			}
			case 3:{
				cella = grigliaT.getCella33();
				break;
			}
			}
			break;
		}
		}
		return cella;	
	}

	static public Griglia setCella(Griglia grigliaG, int x, int y, CellaType segno){
		GrigliaType grigliaT = grigliaG.getGriglia();
		switch(x){
		case 1: {
			switch(y){
			case 1:{
				grigliaT.setCella11(segno);
				break;
			}
			case 2:{
				grigliaT.setCella12(segno);
				break;
			}
			case 3:{
				grigliaT.setCella13(segno);
				break;
			}
			}
			break;
		}
		case 2:{
			switch(y){
			case 1:{
				grigliaT.setCella21(segno);
				break;
			}
			case 2:{
				grigliaT.setCella22(segno);
				break;
			}
			case 3:{
				grigliaT.setCella23(segno);
				break;
			}
			}
			break;
		}
		case 3:{
			switch(y){
			case 1:{
				grigliaT.setCella31(segno);
				break;
			}
			case 2:{
				grigliaT.setCella32(segno);
				break;
			}
			case 3:{
				grigliaT.setCella33(segno);
				break;
			}
			}
			break;
		}
		}
		grigliaG.setGriglia(grigliaT);
		return grigliaG;
	}

	private static String itemCella (String val){
		if (val == "croce"){
			return "X";
		}
		if (val == "cerchio"){
			return "O";
		}
		if (val == "vuoto"){
			return "";
		}
		return null;
	}
	public static Game buildBeanGame (TrisStub.Griglia griglia){
		Game partitaBean = new Game();
		TrisStub.GrigliaType grigliaType = griglia.getGriglia();
		partitaBean.setStato(grigliaType.getStatus().toString());
		partitaBean.setCella11(itemCella(grigliaType.getCella11().toString()));
		partitaBean.setCella12(itemCella(grigliaType.getCella12().toString()));
		partitaBean.setCella13(itemCella(grigliaType.getCella13().toString()));
		partitaBean.setCella21(itemCella(grigliaType.getCella21().toString()));
		partitaBean.setCella22(itemCella(grigliaType.getCella22().toString()));
		partitaBean.setCella23(itemCella(grigliaType.getCella23().toString()));
		partitaBean.setCella31(itemCella(grigliaType.getCella31().toString()));
		partitaBean.setCella32(itemCella(grigliaType.getCella32().toString()));
		partitaBean.setCella33(itemCella(grigliaType.getCella33().toString()));
		return partitaBean;
	}

	private static ArrayList<String> getRow(Griglia griglia,int x){
		ArrayList<String> row = new ArrayList<String>();
		row.add(getCella(griglia, x, 1).getValue());
		row.add(getCella(griglia, x, 2).getValue());
		row.add(getCella(griglia, x, 3).getValue());
		return row;
	}
	private static ArrayList<String> getCol(Griglia griglia,int y){
		ArrayList<String> col = new ArrayList<String>();
		col.add(getCella(griglia, 1, y).getValue());
		col.add(getCella(griglia, 2, y).getValue());
		col.add(getCella(griglia, 3, y).getValue());
		return col;
	}
	private static ArrayList<String> getDiag(Griglia griglia, int d){
		ArrayList<String> diag = new ArrayList<String>();
		//si numera le diagonali 1= principale 2=l'altra diagonale
		if (d==1){
			diag.add(getCella(griglia, 1, 1).getValue());
			diag.add(getCella(griglia, 2, 2).getValue());
			diag.add(getCella(griglia, 3, 3).getValue());
		}else{
			diag.add(getCella(griglia, 3, 1).getValue());
			diag.add(getCella(griglia, 2, 2).getValue());
			diag.add(getCella(griglia, 1, 3).getValue());
		}
		return diag;
	}
	public static Integer checkWin (Griglia griglia){
		ArrayList<String> vicini;
		Boolean win;
		//si controlla le righe
		for (int i =1 ; i<=3; i++){
			vicini = getRow(griglia,i);
			win = checkVicini(vicini);
			if (win == true){
				return i;
			}
		}
		//si controlla le colonne
		for (int y =1 ; y<=3; y++){
			vicini = getCol(griglia,y);
			win = checkVicini(vicini);
			if (win == true){
				return y+100;
			}
		}
		//si controlla le diagonali
		for (int d = 1 ; d<=2; d++){
			vicini = getDiag(griglia,d);
			win = checkVicini(vicini);
			if (win == true){
				return d+200;
			}
		}
		return -1;
	}

	private static Boolean checkVicini (ArrayList<String> vicini){
		Boolean win = true;
		for (int i = 1; i<vicini.size(); i++){
			if (vicini.get(i)!= vicini.get(i-1) || (vicini.get(i)== CellaType.vuoto.toString())){
				win = false;
				break;
			}
		}
		return win;
	}
	public static ArrayList<String> freeCell (Griglia griglia){
		ArrayList<String> free = new ArrayList<String>();
		for (int i = 1; i<=3; i++){
			for (int y = 1; y<=3 ; y++){
				if (getCella(griglia,i,y).getValue()==(CellaType.vuoto.toString())){
					free.add(i+","+y);
				}
			}
		}
		return free;
	}

}
