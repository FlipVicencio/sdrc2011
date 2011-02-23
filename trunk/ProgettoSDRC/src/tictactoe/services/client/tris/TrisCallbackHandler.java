
/**
 * TrisCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

    package tictactoe.services.client.tris;

    /**
     *  TrisCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TrisCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TrisCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TrisCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for inizializza method
            * override this method for handling normal response from inizializza operation
            */
           public void receiveResultinizializza(
                    tictactoe.services.client.tris.TrisStub.Griglia result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from inizializza operation
           */
            public void receiveErrorinizializza(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for gioca method
            * override this method for handling normal response from gioca operation
            */
           public void receiveResultgioca(
                    tictactoe.services.client.tris.TrisStub.Griglia result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from gioca operation
           */
            public void receiveErrorgioca(java.lang.Exception e) {
            }
                


    }
    