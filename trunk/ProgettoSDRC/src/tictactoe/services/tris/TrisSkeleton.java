
/**
 * TrisSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package tictactoe.services.tris;

import java.util.ArrayList;
import java.util.HashMap;

import tictactoe.utility.GrigliaGame;
import tictactoe.services.client.tris.TrisStub;
import tictactoe.services.tris.Griglia;

/**
 *  TrisSkeleton java skeleton for the axisService
 */
public class TrisSkeleton{
	private static HashMap<String,Griglia> games  = new HashMap<String,Griglia>();

	public tictactoe.services.tris.Griglia inizializza
	(
			tictactoe.services.tris.Id id
	) throws Exception
	{
		Griglia griglia = GrigliaGame.nuovaGriglia();
		//decisione casuale per chi inizia
		int i = (int)(Math.random()*100);
		if (i % 2 == 0){
			//inizia il pc
			int x = (int)(Math.random()*10)+1;
			while (x > 3){
				x = (int)(Math.random()*10)+1;
			}
			int y = (int)(Math.random()*10)+1;
			while (y > 3){
				y = (int)(Math.random()*10)+1;
			}
			//si esegue mossa calcolatore
			griglia = GrigliaGame.setCella(griglia, x, 
					y, CellaType.cerchio);
			griglia.getGriglia().setStatus(StatusType.inCorso);
		}
		games.put(id.getId(), griglia);

		return griglia;

	}


	/**
	 * Auto generated method signature
	 * @param mossa
	 * @throws Exception 
	 */
	public tictactoe.services.tris.Griglia gioca
	(
			tictactoe.services.tris.Mossa mossa
	) throws Exception
	{
		Griglia grigliaG = null;
		if (games.containsKey(mossa.getMossa().getId())){

			grigliaG = games.get(mossa.getMossa().getId());
			//CROCE UMANO, CERCHIO CALCOLATORE
			try{
				//si esegue la mossa del giocatore umano
				grigliaG = GrigliaGame.setCella(grigliaG, mossa.getMossa().getRiga().getValue(), 
						mossa.getMossa().getColonna().getValue(), CellaType.croce);

				grigliaG.getGriglia().setStatus(StatusType.inCorso);

				//si controlla se umano ha vinto
				int check = GrigliaGame.checkWin(grigliaG);
				if (check != -1){
					grigliaG.getGriglia().setStatus(StatusType.haiVinto);
				}else{
					//si fa la mossa del calcolatore, si sceglie a caso tra le celle libere
					ArrayList<String> free = GrigliaGame.freeCell(grigliaG);
					if (free.size() == 0){
						grigliaG.getGriglia().setStatus(StatusType.haiPareggiato);
					}else{
						//indCella = x,y
						int indCella = (int)(Math.random()*10);
						while(indCella >= free.size() ){
							indCella = (int)(Math.random()*10);
						}
						int x = Integer.parseInt(free.get(indCella).substring(0, 1));
						int y = Integer.parseInt(free.get(indCella).substring(2,3));

						//si esegue mossa calcolatore
						grigliaG = GrigliaGame.setCella(grigliaG, x, 
								y, CellaType.cerchio);
						//si controlla se calcolatore ha vinto
						check = GrigliaGame.checkWin(grigliaG);
						if (check != -1){
							grigliaG.getGriglia().setStatus(StatusType.haiPerso);
						}else{
							//se celle finite allora pareggiato
							free = GrigliaGame.freeCell(grigliaG);
							if (free.size() == 0){
								grigliaG.getGriglia().setStatus(StatusType.haiPareggiato);
							}
						}
					}
				}
			}catch(Exception e){
				grigliaG.getGriglia().setStatus(StatusType.errore);
				return grigliaG;
			}
		}else{
			throw new Exception("Errore griglia non trovata" + mossa.getMossa().getId() );
		}
		return grigliaG;
	}

}
