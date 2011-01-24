package serviceWebClient;

import java.rmi.RemoteException;

import serviceWebClient.GenerateIdStub.NewGameResponse;
import org.apache.axis2.AxisFault;

public class GenerateIdClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			 GenerateIdStub stub = new GenerateIdStub();
			 NewGameResponse genId = stub.newGame();
			 System.out.println("Id Partita: "+ genId.get_return());
		 } catch (AxisFault e) {
             e.printStackTrace();
         } catch (RemoteException e) {
             e.printStackTrace();
     }
	}

}
