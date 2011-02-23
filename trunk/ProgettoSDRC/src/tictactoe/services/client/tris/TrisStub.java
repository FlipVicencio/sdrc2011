
/**
 * TrisStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package tictactoe.services.client.tris;



/*
 *  TrisStub java implementation
 */


public class TrisStub extends org.apache.axis2.client.Stub
{
	protected org.apache.axis2.description.AxisOperation[] _operations;

	//hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();


	private void populateAxisService() throws org.apache.axis2.AxisFault {

		//creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("Tris" + this.hashCode());

		//creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[2];

		__operation = new org.apache.axis2.description.OutInAxisOperation();


		__operation.setName(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/", "inizializza"));
		_service.addOperation(__operation);




		_operations[0]=__operation;


		__operation = new org.apache.axis2.description.OutInAxisOperation();


		__operation.setName(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/", "gioca"));
		_service.addOperation(__operation);




		_operations[1]=__operation;


	}

	//populates the faults
	private void populateFaults(){



	}

	/**
	 *Constructor that takes in a configContext
	 */

	public TrisStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint)
	throws org.apache.axis2.AxisFault {
		this(configurationContext,targetEndpoint,false);
	}


	/**
	 * Constructor that takes in a configContext  and useseperate listner
	 */
	public TrisStub(org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener)
	throws org.apache.axis2.AxisFault {
		//To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);


		configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
				targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);


	}

	/**
	 * Default Constructor
	 */
	public TrisStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

		this(configurationContext,"http://127.0.0.1:8080/ProgettoSDRC/services/Tris" );

	}

	/**
	 * Default Constructor
	 */
	public TrisStub() throws org.apache.axis2.AxisFault {

		this("http:/127.0.0.1:8080/ProgettoSDRC/services/Tris" );

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public TrisStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null,targetEndpoint);
	}




	/**
	 * Auto generated method signature
	 * @see tictactoe.services.client.tris.Tris#inizializza
	 * @param id1

	 */


	public  tictactoe.services.client.tris.TrisStub.Griglia inizializza(

			tictactoe.services.client.tris.TrisStub.Id id1)


	throws java.rmi.RemoteException

	{

		try{
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("http://www.dsi.unifi.it/Tris/inizializza");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



			addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();



			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;


			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
					id1,
					optimizeContent(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/",
							"inizializza")));

			//adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			//execute the operation client
			_operationClient.execute(true);


			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
					org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement() ,
					tictactoe.services.client.tris.TrisStub.Griglia.class,
					getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (tictactoe.services.client.tris.TrisStub.Griglia)object;

		}catch(org.apache.axis2.AxisFault f){

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt!=null){
				if (faultExceptionNameMap.containsKey(faultElt.getQName())){
					//make the fault by reflection
					try{
						java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex=
							(java.lang.Exception) exceptionClass.newInstance();
						//message class
						java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[]{messageClass});
						m.invoke(ex,new java.lang.Object[]{messageObject});


						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					}catch(java.lang.ClassCastException e){
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}  catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}   catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				}else{
					throw f;
				}
			}else{
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * @see tictactoe.services.client.tris.Tris#startinizializza
	 * @param id1

	 */
	public  void startinizializza(

			tictactoe.services.client.tris.TrisStub.Id id1,

			final tictactoe.services.client.tris.TrisCallbackHandler callback)

	throws java.rmi.RemoteException{

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("http://www.dsi.unifi.it/Tris/inizializza");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



		addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env=null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


		//Style is Doc.


		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
				id1,
				optimizeContent(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/",
						"inizializza")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);



		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							tictactoe.services.client.tris.TrisStub.Griglia.class,
							getEnvelopeNamespaces(resultEnv));
					callback.receiveResultinizializza(
							(tictactoe.services.client.tris.TrisStub.Griglia)object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorinizializza(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt!=null){
						if (faultExceptionNameMap.containsKey(faultElt.getQName())){
							//make the fault by reflection
							try{
								java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex=
									(java.lang.Exception) exceptionClass.newInstance();
								//message class
								java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
										new java.lang.Class[]{messageClass});
								m.invoke(ex,new java.lang.Object[]{messageObject});


								callback.receiveErrorinizializza(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch(java.lang.ClassCastException e){
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorinizializza(f);
							}
						} else {
							callback.receiveErrorinizializza(f);
						}
					} else {
						callback.receiveErrorinizializza(f);
					}
				} else {
					callback.receiveErrorinizializza(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});


		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(
					_callbackReceiver);
		}

		//execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * @see tictactoe.services.client.tris.Tris#gioca
	 * @param mossa3

	 */


	public  tictactoe.services.client.tris.TrisStub.Griglia gioca(

			tictactoe.services.client.tris.TrisStub.Mossa mossa3)


	throws java.rmi.RemoteException

	{

		try{
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction("http://www.dsi.unifi.it/Tris/gioca");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



			addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();



			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;


			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
					mossa3,
					optimizeContent(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/",
							"gioca")));

			//adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			//execute the operation client
			_operationClient.execute(true);


			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
					org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement() ,
					tictactoe.services.client.tris.TrisStub.Griglia.class,
					getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (tictactoe.services.client.tris.TrisStub.Griglia)object;

		}catch(org.apache.axis2.AxisFault f){

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt!=null){
				if (faultExceptionNameMap.containsKey(faultElt.getQName())){
					//make the fault by reflection
					try{
						java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex=
							(java.lang.Exception) exceptionClass.newInstance();
						//message class
						java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[]{messageClass});
						m.invoke(ex,new java.lang.Object[]{messageObject});


						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					}catch(java.lang.ClassCastException e){
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}  catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}   catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original Axis fault
						throw f;
					}
				}else{
					throw f;
				}
			}else{
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * @see tictactoe.services.client.tris.Tris#startgioca
	 * @param mossa3

	 */
	public  void startgioca(

			tictactoe.services.client.tris.TrisStub.Mossa mossa3,

			final tictactoe.services.client.tris.TrisCallbackHandler callback)

	throws java.rmi.RemoteException{

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction("http://www.dsi.unifi.it/Tris/gioca");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



		addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env=null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


		//Style is Doc.


		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
				mossa3,
				optimizeContent(new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/",
						"gioca")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);



		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
							tictactoe.services.client.tris.TrisStub.Griglia.class,
							getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgioca(
							(tictactoe.services.client.tris.TrisStub.Griglia)object);

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgioca(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt!=null){
						if (faultExceptionNameMap.containsKey(faultElt.getQName())){
							//make the fault by reflection
							try{
								java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex=
									(java.lang.Exception) exceptionClass.newInstance();
								//message class
								java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
										new java.lang.Class[]{messageClass});
								m.invoke(ex,new java.lang.Object[]{messageObject});


								callback.receiveErrorgioca(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch(java.lang.ClassCastException e){
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the original Axis fault
								callback.receiveErrorgioca(f);
							}
						} else {
							callback.receiveErrorgioca(f);
						}
					} else {
						callback.receiveErrorgioca(f);
					}
				} else {
					callback.receiveErrorgioca(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});


		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(
					_callbackReceiver);
		}

		//execute the operation client
		_operationClient.execute(false);

	}



	/**
	 *  A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
		}
		return returnMap;
	}



	private javax.xml.namespace.QName[] opNameArray = null;
	private boolean optimizeContent(javax.xml.namespace.QName opName) {


		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;   
			}
		}
		return false;
	}
	//http://192.168.0.3:8080/ProgettoSDRC/services/Tris

	public static class StatusType
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"statusType",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for StatusType
		 */


		protected java.lang.String localStatusType ;

		private static java.util.HashMap _table_ = new java.util.HashMap();

		// Constructor

		protected StatusType(java.lang.String value, boolean isRegisterValue) {
			localStatusType = value;
			if (isRegisterValue){

				_table_.put(localStatusType, this);

			}

		}

		public static final java.lang.String _inizio =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("inizio");

		public static final java.lang.String _inCorso =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("inCorso");

		public static final java.lang.String _haiVinto =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("haiVinto");

		public static final java.lang.String _haiPerso =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("haiPerso");

		public static final java.lang.String _haiPareggiato =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("haiPareggiato");

		public static final java.lang.String _errore =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("errore");

		public static final StatusType inizio =
			new StatusType(_inizio,true);

		public static final StatusType inCorso =
			new StatusType(_inCorso,true);

		public static final StatusType haiVinto =
			new StatusType(_haiVinto,true);

		public static final StatusType haiPerso =
			new StatusType(_haiPerso,true);

		public static final StatusType haiPareggiato =
			new StatusType(_haiPareggiato,true);

		public static final StatusType errore =
			new StatusType(_errore,true);


		public java.lang.String getValue() { return localStatusType;}

		public boolean equals(java.lang.Object obj) {return (obj == this);}
		public int hashCode() { return toString().hashCode();}
		public java.lang.String toString() {

			return localStatusType.toString();


		}



		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		 public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			 boolean isReaderMTOMAware = false;

			 try{
				 isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			 }catch(java.lang.IllegalArgumentException e){
				 isReaderMTOMAware = false;
			 }
			 return isReaderMTOMAware;
		 }


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		 public org.apache.axiom.om.OMElement getOMElement (
				 final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			 org.apache.axiom.om.OMDataSource dataSource =
				 new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					 StatusType.this.serialize(MY_QNAME,factory,xmlWriter);
				 }
			 };
			 return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					 MY_QNAME,factory,dataSource);

		 }



		 public void serialize(final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory,
				 org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		 throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			 //We can safely assume an element has only one type associated with it

			 java.lang.String namespace = parentQName.getNamespaceURI();
			 java.lang.String localName = parentQName.getLocalPart();

			 if (! namespace.equals("")) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespace);

				 if (prefix == null) {
					 prefix = generatePrefix(namespace);

					 xmlWriter.writeStartElement(prefix, localName, namespace);
					 xmlWriter.writeNamespace(prefix, namespace);
					 xmlWriter.setPrefix(prefix, namespace);

				 } else {
					 xmlWriter.writeStartElement(namespace, localName);
				 }

			 } else {
				 xmlWriter.writeStartElement(localName);
			 }

			 if (localStatusType==null){

				 throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

			 }else{

				 xmlWriter.writeCharacters(localStatusType);

			 }


			 xmlWriter.writeEndElement();


		 }

		 /**
		  * Util method to write an attribute with the ns prefix
		  */
		 private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (xmlWriter.getPrefix(namespace) == null) {
				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);

			 }

			 xmlWriter.writeAttribute(namespace,attName,attValue);

		 }

		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (namespace.equals(""))
			 {
				 xmlWriter.writeAttribute(attName,attValue);
			 }
			 else
			 {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace,attName,attValue);
			 }
		 }


		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 java.lang.String attributeNamespace = qname.getNamespaceURI();
			 java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			 if (attributePrefix == null) {
				 attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			 }
			 java.lang.String attributeValue;
			 if (attributePrefix.trim().length() > 0) {
				 attributeValue = attributePrefix + ":" + qname.getLocalPart();
			 } else {
				 attributeValue = qname.getLocalPart();
			 }

			 if (namespace.equals("")) {
				 xmlWriter.writeAttribute(attName, attributeValue);
			 } else {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace, attName, attributeValue);
			 }
		 }
		 /**
		  *  method to handle Qnames
		  */

		 private void writeQName(javax.xml.namespace.QName qname,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			 java.lang.String namespaceURI = qname.getNamespaceURI();
			 if (namespaceURI != null) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				 if (prefix == null) {
					 prefix = generatePrefix(namespaceURI);
					 xmlWriter.writeNamespace(prefix, namespaceURI);
					 xmlWriter.setPrefix(prefix,namespaceURI);
				 }

				 if (prefix.trim().length() > 0){
					 xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 } else {
					 // i.e this is the default namespace
					 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 }

			 } else {
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			 }
		 }

		 private void writeQNames(javax.xml.namespace.QName[] qnames,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 if (qnames != null) {
				 // we have to store this data until last moment since it is not possible to write any
				 // namespace data after writing the charactor data
				 java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				 java.lang.String namespaceURI = null;
				 java.lang.String prefix = null;

				 for (int i = 0; i < qnames.length; i++) {
					 if (i > 0) {
						 stringToWrite.append(" ");
					 }
					 namespaceURI = qnames[i].getNamespaceURI();
					 if (namespaceURI != null) {
						 prefix = xmlWriter.getPrefix(namespaceURI);
						 if ((prefix == null) || (prefix.length() == 0)) {
							 prefix = generatePrefix(namespaceURI);
							 xmlWriter.writeNamespace(prefix, namespaceURI);
							 xmlWriter.setPrefix(prefix,namespaceURI);
						 }

						 if (prefix.trim().length() > 0){
							 stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 } else {
							 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 }
					 } else {
						 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					 }
				 }
				 xmlWriter.writeCharacters(stringToWrite.toString());
			 }

		 }


		 /**
		  * Register a namespace prefix
		  */
		 private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			 java.lang.String prefix = xmlWriter.getPrefix(namespace);

			 if (prefix == null) {
				 prefix = generatePrefix(namespace);

				 while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					 prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				 }

				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);
			 }

			 return prefix;
		 }



		 /**
		  * databinding method to get an XML representation of this object
		  *
		  */
		 public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		 throws org.apache.axis2.databinding.ADBException{




			 //We can safely assume an element has only one type associated with it
			 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					 new java.lang.Object[]{
					 org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
					 org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatusType)
			 },
			 null);

		 }



		 /**
		  *  Factory class that keeps the parse method
		  */
		 public static class Factory{



			 public static StatusType fromValue(java.lang.String value)
			 throws java.lang.IllegalArgumentException {
				 StatusType enumeration = (StatusType)

				 _table_.get(value);


				 if (enumeration==null) throw new java.lang.IllegalArgumentException();
				 return enumeration;
			 }
			 public static StatusType fromString(java.lang.String value,java.lang.String namespaceURI)
			 throws java.lang.IllegalArgumentException {
				 try {

					 return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));


				 } catch (java.lang.Exception e) {
					 throw new java.lang.IllegalArgumentException();
				 }
			 }


			 /**
			  * static method to create the object
			  * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			  *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			  * Postcondition: If this object is an element, the reader is positioned at its end element
			  *                If this object is a complex type, the reader is positioned at the end element of its outer element
			  */
			 public static StatusType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				 StatusType object = null;
				 // initialize a hash map to keep values
				 java.util.Map attributeMap = new java.util.HashMap();
				 java.util.List extraAttributeList = new java.util.ArrayList();


				 int event;
				 java.lang.String nillableValue = null;
				 java.lang.String prefix ="";
				 java.lang.String namespaceuri ="";
				 try {

					 while (!reader.isStartElement() && !reader.isEndElement())
						 reader.next();




					 // Note all attributes that were handled. Used to differ normal attributes
					 // from anyAttributes.
					 java.util.Vector handledAttributes = new java.util.Vector();



					 while(!reader.isEndElement()) {
						 if (reader.isStartElement()  || reader.hasText()){

							 java.lang.String content = reader.getElementText();

							 if (content.indexOf(":") > 0) {
								 // this seems to be a Qname so find the namespace and send
								 prefix = content.substring(0, content.indexOf(":"));
								 namespaceuri = reader.getNamespaceURI(prefix);
								 object = StatusType.Factory.fromString(content,namespaceuri);
							 } else {
								 // this seems to be not a qname send and empty namespace incase of it is
								 // check is done in fromString method
								 object = StatusType.Factory.fromString(content,"");
							 }


						 } else {
							 reader.next();
						 }  
					 }  // end of while loop




				 } catch (javax.xml.stream.XMLStreamException e) {
					 throw new java.lang.Exception(e);
				 }

				 return object;
			 }

		 }//end of factory class



	}



	public static class GrigliaType
	implements org.apache.axis2.databinding.ADBBean{
		/* This type was generated from the piece of schema that had
                name = grigliaType
                Namespace URI = http://www.dsi.unifi.it/Tris/
                Namespace Prefix = ns2
		 */


		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for Cella11
		 */


		protected CellaType localCella11 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella11(){
			return localCella11;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella11
		 */
		public void setCella11(CellaType param){

			this.localCella11=param;


		}


		/**
		 * field for Cella12
		 */


		protected CellaType localCella12 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella12(){
			return localCella12;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella12
		 */
		public void setCella12(CellaType param){

			this.localCella12=param;


		}


		/**
		 * field for Cella13
		 */


		protected CellaType localCella13 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella13(){
			return localCella13;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella13
		 */
		public void setCella13(CellaType param){

			this.localCella13=param;


		}


		/**
		 * field for Cella21
		 */


		protected CellaType localCella21 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella21(){
			return localCella21;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella21
		 */
		public void setCella21(CellaType param){

			this.localCella21=param;


		}


		/**
		 * field for Cella22
		 */


		protected CellaType localCella22 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella22(){
			return localCella22;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella22
		 */
		public void setCella22(CellaType param){

			this.localCella22=param;


		}


		/**
		 * field for Cella23
		 */


		protected CellaType localCella23 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella23(){
			return localCella23;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella23
		 */
		public void setCella23(CellaType param){

			this.localCella23=param;


		}


		/**
		 * field for Cella31
		 */


		protected CellaType localCella31 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella31(){
			return localCella31;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella31
		 */
		public void setCella31(CellaType param){

			this.localCella31=param;


		}


		/**
		 * field for Cella32
		 */


		protected CellaType localCella32 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella32(){
			return localCella32;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella32
		 */
		public void setCella32(CellaType param){

			this.localCella32=param;


		}


		/**
		 * field for Cella33
		 */


		protected CellaType localCella33 ;


		/**
		 * Auto generated getter method
		 * @return CellaType
		 */
		public  CellaType getCella33(){
			return localCella33;
		}



		/**
		 * Auto generated setter method
		 * @param param Cella33
		 */
		public void setCella33(CellaType param){

			this.localCella33=param;


		}


		/**
		 * field for Status
		 */


		protected StatusType localStatus ;


		/**
		 * Auto generated getter method
		 * @return StatusType
		 */
		public  StatusType getStatus(){
			return localStatus;
		}



		/**
		 * Auto generated setter method
		 * @param param Status
		 */
		public void setStatus(StatusType param){

			this.localStatus=param;


		}


		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try{
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			}catch(java.lang.IllegalArgumentException e){
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement (
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					GrigliaType.this.serialize(parentQName,factory,xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName,factory,dataSource);

		}



		public void serialize(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




			java.lang.String prefix = null;
			java.lang.String namespace = null;


			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localCella11==null){
				throw new org.apache.axis2.databinding.ADBException("cella11 cannot be null!!");
			}
			localCella11.serialize(new javax.xml.namespace.QName("","cella11"),
					factory,xmlWriter);

			if (localCella12==null){
				throw new org.apache.axis2.databinding.ADBException("cella12 cannot be null!!");
			}
			localCella12.serialize(new javax.xml.namespace.QName("","cella12"),
					factory,xmlWriter);

			if (localCella13==null){
				throw new org.apache.axis2.databinding.ADBException("cella13 cannot be null!!");
			}
			localCella13.serialize(new javax.xml.namespace.QName("","cella13"),
					factory,xmlWriter);

			if (localCella21==null){
				throw new org.apache.axis2.databinding.ADBException("cella21 cannot be null!!");
			}
			localCella21.serialize(new javax.xml.namespace.QName("","cella21"),
					factory,xmlWriter);

			if (localCella22==null){
				throw new org.apache.axis2.databinding.ADBException("cella22 cannot be null!!");
			}
			localCella22.serialize(new javax.xml.namespace.QName("","cella22"),
					factory,xmlWriter);

			if (localCella23==null){
				throw new org.apache.axis2.databinding.ADBException("cella23 cannot be null!!");
			}
			localCella23.serialize(new javax.xml.namespace.QName("","cella23"),
					factory,xmlWriter);

			if (localCella31==null){
				throw new org.apache.axis2.databinding.ADBException("cella31 cannot be null!!");
			}
			localCella31.serialize(new javax.xml.namespace.QName("","cella31"),
					factory,xmlWriter);

			if (localCella32==null){
				throw new org.apache.axis2.databinding.ADBException("cella32 cannot be null!!");
			}
			localCella32.serialize(new javax.xml.namespace.QName("","cella32"),
					factory,xmlWriter);

			if (localCella33==null){
				throw new org.apache.axis2.databinding.ADBException("cella33 cannot be null!!");
			}
			localCella33.serialize(new javax.xml.namespace.QName("","cella33"),
					factory,xmlWriter);

			if (localStatus==null){
				throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
			}
			localStatus.serialize(new javax.xml.namespace.QName("","status"),
					factory,xmlWriter);

			xmlWriter.writeEndElement();


		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace,attName,attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (namespace.equals(""))
			{
				xmlWriter.writeAttribute(attName,attValue);
			}
			else
			{
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace,attName,attValue);
			}
		}


		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}
		/**
		 *  method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix,namespaceURI);
				}

				if (prefix.trim().length() > 0){
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix,namespaceURI);
						}

						if (prefix.trim().length() > 0){
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}


		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}



		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		throws org.apache.axis2.databinding.ADBException{



			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();


			elementList.add(new javax.xml.namespace.QName("",
			"cella11"));


			if (localCella11==null){
				throw new org.apache.axis2.databinding.ADBException("cella11 cannot be null!!");
			}
			elementList.add(localCella11);

			elementList.add(new javax.xml.namespace.QName("",
			"cella12"));


			if (localCella12==null){
				throw new org.apache.axis2.databinding.ADBException("cella12 cannot be null!!");
			}
			elementList.add(localCella12);

			elementList.add(new javax.xml.namespace.QName("",
			"cella13"));


			if (localCella13==null){
				throw new org.apache.axis2.databinding.ADBException("cella13 cannot be null!!");
			}
			elementList.add(localCella13);

			elementList.add(new javax.xml.namespace.QName("",
			"cella21"));


			if (localCella21==null){
				throw new org.apache.axis2.databinding.ADBException("cella21 cannot be null!!");
			}
			elementList.add(localCella21);

			elementList.add(new javax.xml.namespace.QName("",
			"cella22"));


			if (localCella22==null){
				throw new org.apache.axis2.databinding.ADBException("cella22 cannot be null!!");
			}
			elementList.add(localCella22);

			elementList.add(new javax.xml.namespace.QName("",
			"cella23"));


			if (localCella23==null){
				throw new org.apache.axis2.databinding.ADBException("cella23 cannot be null!!");
			}
			elementList.add(localCella23);

			elementList.add(new javax.xml.namespace.QName("",
			"cella31"));


			if (localCella31==null){
				throw new org.apache.axis2.databinding.ADBException("cella31 cannot be null!!");
			}
			elementList.add(localCella31);

			elementList.add(new javax.xml.namespace.QName("",
			"cella32"));


			if (localCella32==null){
				throw new org.apache.axis2.databinding.ADBException("cella32 cannot be null!!");
			}
			elementList.add(localCella32);

			elementList.add(new javax.xml.namespace.QName("",
			"cella33"));


			if (localCella33==null){
				throw new org.apache.axis2.databinding.ADBException("cella33 cannot be null!!");
			}
			elementList.add(localCella33);

			elementList.add(new javax.xml.namespace.QName("",
			"status"));


			if (localStatus==null){
				throw new org.apache.axis2.databinding.ADBException("status cannot be null!!");
			}
			elementList.add(localStatus);


			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



		}



		/**
		 *  Factory class that keeps the parse method
		 */
		public static class Factory{




			/**
			 * static method to create the object
			 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 *                If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static GrigliaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				GrigliaType object =
					new GrigliaType();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix ="";
				java.lang.String namespaceuri ="";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();


					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						"type");
						if (fullTypeName!=null){
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1){
								nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix==null?"":nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

							if (!"grigliaType".equals(type)){
								//find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GrigliaType)ExtensionMapper.getTypeObject(
										nsUri,type,reader);
							}


						}

					}



					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();




					reader.next();


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella11").equals(reader.getName())){

						object.setCella11(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella12").equals(reader.getName())){

						object.setCella12(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella13").equals(reader.getName())){

						object.setCella13(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella21").equals(reader.getName())){

						object.setCella21(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella22").equals(reader.getName())){

						object.setCella22(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella23").equals(reader.getName())){

						object.setCella23(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella31").equals(reader.getName())){

						object.setCella31(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella32").equals(reader.getName())){

						object.setCella32(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","cella33").equals(reader.getName())){

						object.setCella33(CellaType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","status").equals(reader.getName())){

						object.setStatus(StatusType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}//end of factory class



	}



	public static class Mossa
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"mossa",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for Mossa
		 */


		protected MossaType localMossa ;


		/**
		 * Auto generated getter method
		 * @return MossaType
		 */
		public  MossaType getMossa(){
			return localMossa;
		}



		/**
		 * Auto generated setter method
		 * @param param Mossa
		 */
		public void setMossa(MossaType param){

			this.localMossa=param;


		}


		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try{
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			}catch(java.lang.IllegalArgumentException e){
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement (
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					Mossa.this.serialize(MY_QNAME,factory,xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME,factory,dataSource);

		}



		public void serialize(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			//We can safely assume an element has only one type associated with it

			if (localMossa==null){
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}
			localMossa.serialize(MY_QNAME,factory,xmlWriter);


		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace,attName,attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (namespace.equals(""))
			{
				xmlWriter.writeAttribute(attName,attValue);
			}
			else
			{
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace,attName,attValue);
			}
		}


		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}
		/**
		 *  method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix,namespaceURI);
				}

				if (prefix.trim().length() > 0){
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix,namespaceURI);
						}

						if (prefix.trim().length() > 0){
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}


		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}



		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		throws org.apache.axis2.databinding.ADBException{




			//We can safely assume an element has only one type associated with it
			return localMossa.getPullParser(MY_QNAME);

		}



		/**
		 *  Factory class that keeps the parse method
		 */
		public static class Factory{




			/**
			 * static method to create the object
			 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 *                If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Mossa parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				Mossa object =
					new Mossa();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix ="";
				java.lang.String namespaceuri ="";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();




					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();



					while(!reader.isEndElement()) {
						if (reader.isStartElement() ){

							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/","mossa").equals(reader.getName())){

								object.setMossa(MossaType.Factory.parse(reader));

							}  // End of if for expected property start element

							else{
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}

						} else {
							reader.next();
						}  
					}  // end of while loop




				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}//end of factory class



	}



	public static class Griglia
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"griglia",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for Griglia
		 */


		protected GrigliaType localGriglia ;


		/**
		 * Auto generated getter method
		 * @return GrigliaType
		 */
		public  GrigliaType getGriglia(){
			return localGriglia;
		}



		/**
		 * Auto generated setter method
		 * @param param Griglia
		 */
		public void setGriglia(GrigliaType param){

			this.localGriglia=param;


		}


		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try{
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			}catch(java.lang.IllegalArgumentException e){
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement (
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					Griglia.this.serialize(MY_QNAME,factory,xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME,factory,dataSource);

		}



		public void serialize(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			//We can safely assume an element has only one type associated with it

			if (localGriglia==null){
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}
			localGriglia.serialize(MY_QNAME,factory,xmlWriter);


		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace,attName,attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (namespace.equals(""))
			{
				xmlWriter.writeAttribute(attName,attValue);
			}
			else
			{
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace,attName,attValue);
			}
		}


		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}
		/**
		 *  method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix,namespaceURI);
				}

				if (prefix.trim().length() > 0){
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix,namespaceURI);
						}

						if (prefix.trim().length() > 0){
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}


		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}



		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		throws org.apache.axis2.databinding.ADBException{




			//We can safely assume an element has only one type associated with it
			return localGriglia.getPullParser(MY_QNAME);

		}



		/**
		 *  Factory class that keeps the parse method
		 */
		public static class Factory{




			/**
			 * static method to create the object
			 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 *                If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Griglia parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				Griglia object =
					new Griglia();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix ="";
				java.lang.String namespaceuri ="";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();




					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();



					while(!reader.isEndElement()) {
						if (reader.isStartElement() ){

							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/","griglia").equals(reader.getName())){

								object.setGriglia(GrigliaType.Factory.parse(reader));

							}  // End of if for expected property start element

							else{
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}

						} else {
							reader.next();
						}  
					}  // end of while loop




				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}//end of factory class



	}


	public static class ExtensionMapper{

		public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
				java.lang.String typeName,
				javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{


			if (
					"http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
					"grigliaType".equals(typeName)){

				return  GrigliaType.Factory.parse(reader);


			}


			if (
					"http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
					"statusType".equals(typeName)){

				return  StatusType.Factory.parse(reader);


			}


			if (
					"http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
					"mossaType".equals(typeName)){

				return  MossaType.Factory.parse(reader);


			}


			if (
					"http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
					"cellaType".equals(typeName)){

				return  CellaType.Factory.parse(reader);


			}


			if (
					"http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
					"indiceType".equals(typeName)){

				return  IndiceType.Factory.parse(reader);


			}


			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}

	}


	public static class MossaType
	implements org.apache.axis2.databinding.ADBBean{
		/* This type was generated from the piece of schema that had
                name = mossaType
                Namespace URI = http://www.dsi.unifi.it/Tris/
                Namespace Prefix = ns2
		 */


		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for Id
		 */


		protected java.lang.String localId ;


		/**
		 * Auto generated getter method
		 * @return java.lang.String
		 */
		public  java.lang.String getId(){
			return localId;
		}



		/**
		 * Auto generated setter method
		 * @param param Id
		 */
		public void setId(java.lang.String param){

			this.localId=param;


		}


		/**
		 * field for Riga
		 */


		protected IndiceType localRiga ;


		/**
		 * Auto generated getter method
		 * @return IndiceType
		 */
		public  IndiceType getRiga(){
			return localRiga;
		}



		/**
		 * Auto generated setter method
		 * @param param Riga
		 */
		public void setRiga(IndiceType param){

			this.localRiga=param;


		}


		/**
		 * field for Colonna
		 */


		protected IndiceType localColonna ;


		/**
		 * Auto generated getter method
		 * @return IndiceType
		 */
		public  IndiceType getColonna(){
			return localColonna;
		}



		/**
		 * Auto generated setter method
		 * @param param Colonna
		 */
		public void setColonna(IndiceType param){

			this.localColonna=param;


		}


		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try{
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			}catch(java.lang.IllegalArgumentException e){
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement (
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					MossaType.this.serialize(parentQName,factory,xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					parentQName,factory,dataSource);

		}



		public void serialize(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




			java.lang.String prefix = null;
			java.lang.String namespace = null;


			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";
			if (! namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix,"id", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace,"id");
				}

			} else {
				xmlWriter.writeStartElement("id");
			}


			if (localId==null){
				// write the nil attribute

				throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

			}else{


				xmlWriter.writeCharacters(localId);

			}

			xmlWriter.writeEndElement();

			if (localRiga==null){
				throw new org.apache.axis2.databinding.ADBException("riga cannot be null!!");
			}
			localRiga.serialize(new javax.xml.namespace.QName("","riga"),
					factory,xmlWriter);

			if (localColonna==null){
				throw new org.apache.axis2.databinding.ADBException("colonna cannot be null!!");
			}
			localColonna.serialize(new javax.xml.namespace.QName("","colonna"),
					factory,xmlWriter);

			xmlWriter.writeEndElement();


		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace,attName,attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (namespace.equals(""))
			{
				xmlWriter.writeAttribute(attName,attValue);
			}
			else
			{
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace,attName,attValue);
			}
		}


		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}
		/**
		 *  method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix,namespaceURI);
				}

				if (prefix.trim().length() > 0){
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix,namespaceURI);
						}

						if (prefix.trim().length() > 0){
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}


		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}



		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		throws org.apache.axis2.databinding.ADBException{



			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();


			elementList.add(new javax.xml.namespace.QName("",
			"id"));

			if (localId != null){
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("",
			"riga"));


			if (localRiga==null){
				throw new org.apache.axis2.databinding.ADBException("riga cannot be null!!");
			}
			elementList.add(localRiga);

			elementList.add(new javax.xml.namespace.QName("",
			"colonna"));


			if (localColonna==null){
				throw new org.apache.axis2.databinding.ADBException("colonna cannot be null!!");
			}
			elementList.add(localColonna);


			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



		}



		/**
		 *  Factory class that keeps the parse method
		 */
		public static class Factory{




			/**
			 * static method to create the object
			 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 *                If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static MossaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				MossaType object =
					new MossaType();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix ="";
				java.lang.String namespaceuri ="";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();


					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						"type");
						if (fullTypeName!=null){
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1){
								nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix==null?"":nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

							if (!"mossaType".equals(type)){
								//find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (MossaType)ExtensionMapper.getTypeObject(
										nsUri,type,reader);
							}


						}

					}



					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();




					reader.next();


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","id").equals(reader.getName())){

						java.lang.String content = reader.getElementText();

						object.setId(
								org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","riga").equals(reader.getName())){

						object.setRiga(IndiceType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}


					while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("","colonna").equals(reader.getName())){

						object.setColonna(IndiceType.Factory.parse(reader));

						reader.next();

					}  // End of if for expected property start element

					else{
						// A start element we are not expecting indicates an invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}//end of factory class



	}



	public static class CellaType
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"cellaType",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for CellaType
		 */


		protected java.lang.String localCellaType ;

		private static java.util.HashMap _table_ = new java.util.HashMap();

		// Constructor

		protected CellaType(java.lang.String value, boolean isRegisterValue) {
			localCellaType = value;
			if (isRegisterValue){

				_table_.put(localCellaType, this);

			}

		}

		public static final java.lang.String _vuoto =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("vuoto");

		public static final java.lang.String _croce =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("croce");

		public static final java.lang.String _cerchio =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToString("cerchio");

		public static final CellaType vuoto =
			new CellaType(_vuoto,true);

		public static final CellaType croce =
			new CellaType(_croce,true);

		public static final CellaType cerchio =
			new CellaType(_cerchio,true);


		public java.lang.String getValue() { return localCellaType;}

		public boolean equals(java.lang.Object obj) {return (obj == this);}
		public int hashCode() { return toString().hashCode();}
		public java.lang.String toString() {

			return localCellaType.toString();


		}



		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		 public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			 boolean isReaderMTOMAware = false;

			 try{
				 isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			 }catch(java.lang.IllegalArgumentException e){
				 isReaderMTOMAware = false;
			 }
			 return isReaderMTOMAware;
		 }


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		 public org.apache.axiom.om.OMElement getOMElement (
				 final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			 org.apache.axiom.om.OMDataSource dataSource =
				 new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					 CellaType.this.serialize(MY_QNAME,factory,xmlWriter);
				 }
			 };
			 return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					 MY_QNAME,factory,dataSource);

		 }



		 public void serialize(final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory,
				 org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		 throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			 //We can safely assume an element has only one type associated with it

			 java.lang.String namespace = parentQName.getNamespaceURI();
			 java.lang.String localName = parentQName.getLocalPart();

			 if (! namespace.equals("")) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespace);

				 if (prefix == null) {
					 prefix = generatePrefix(namespace);

					 xmlWriter.writeStartElement(prefix, localName, namespace);
					 xmlWriter.writeNamespace(prefix, namespace);
					 xmlWriter.setPrefix(prefix, namespace);

				 } else {
					 xmlWriter.writeStartElement(namespace, localName);
				 }

			 } else {
				 xmlWriter.writeStartElement(localName);
			 }

			 if (localCellaType==null){

				 throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

			 }else{

				 xmlWriter.writeCharacters(localCellaType);

			 }


			 xmlWriter.writeEndElement();


		 }

		 /**
		  * Util method to write an attribute with the ns prefix
		  */
		 private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (xmlWriter.getPrefix(namespace) == null) {
				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);

			 }

			 xmlWriter.writeAttribute(namespace,attName,attValue);

		 }

		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (namespace.equals(""))
			 {
				 xmlWriter.writeAttribute(attName,attValue);
			 }
			 else
			 {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace,attName,attValue);
			 }
		 }


		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 java.lang.String attributeNamespace = qname.getNamespaceURI();
			 java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			 if (attributePrefix == null) {
				 attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			 }
			 java.lang.String attributeValue;
			 if (attributePrefix.trim().length() > 0) {
				 attributeValue = attributePrefix + ":" + qname.getLocalPart();
			 } else {
				 attributeValue = qname.getLocalPart();
			 }

			 if (namespace.equals("")) {
				 xmlWriter.writeAttribute(attName, attributeValue);
			 } else {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace, attName, attributeValue);
			 }
		 }
		 /**
		  *  method to handle Qnames
		  */

		 private void writeQName(javax.xml.namespace.QName qname,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			 java.lang.String namespaceURI = qname.getNamespaceURI();
			 if (namespaceURI != null) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				 if (prefix == null) {
					 prefix = generatePrefix(namespaceURI);
					 xmlWriter.writeNamespace(prefix, namespaceURI);
					 xmlWriter.setPrefix(prefix,namespaceURI);
				 }

				 if (prefix.trim().length() > 0){
					 xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 } else {
					 // i.e this is the default namespace
					 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 }

			 } else {
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			 }
		 }

		 private void writeQNames(javax.xml.namespace.QName[] qnames,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 if (qnames != null) {
				 // we have to store this data until last moment since it is not possible to write any
				 // namespace data after writing the charactor data
				 java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				 java.lang.String namespaceURI = null;
				 java.lang.String prefix = null;

				 for (int i = 0; i < qnames.length; i++) {
					 if (i > 0) {
						 stringToWrite.append(" ");
					 }
					 namespaceURI = qnames[i].getNamespaceURI();
					 if (namespaceURI != null) {
						 prefix = xmlWriter.getPrefix(namespaceURI);
						 if ((prefix == null) || (prefix.length() == 0)) {
							 prefix = generatePrefix(namespaceURI);
							 xmlWriter.writeNamespace(prefix, namespaceURI);
							 xmlWriter.setPrefix(prefix,namespaceURI);
						 }

						 if (prefix.trim().length() > 0){
							 stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 } else {
							 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 }
					 } else {
						 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					 }
				 }
				 xmlWriter.writeCharacters(stringToWrite.toString());
			 }

		 }


		 /**
		  * Register a namespace prefix
		  */
		 private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			 java.lang.String prefix = xmlWriter.getPrefix(namespace);

			 if (prefix == null) {
				 prefix = generatePrefix(namespace);

				 while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					 prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				 }

				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);
			 }

			 return prefix;
		 }



		 /**
		  * databinding method to get an XML representation of this object
		  *
		  */
		 public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		 throws org.apache.axis2.databinding.ADBException{




			 //We can safely assume an element has only one type associated with it
			 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					 new java.lang.Object[]{
					 org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
					 org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCellaType)
			 },
			 null);

		 }



		 /**
		  *  Factory class that keeps the parse method
		  */
		 public static class Factory{



			 public static CellaType fromValue(java.lang.String value)
			 throws java.lang.IllegalArgumentException {
				 CellaType enumeration = (CellaType)

				 _table_.get(value);


				 if (enumeration==null) throw new java.lang.IllegalArgumentException();
				 return enumeration;
			 }
			 public static CellaType fromString(java.lang.String value,java.lang.String namespaceURI)
			 throws java.lang.IllegalArgumentException {
				 try {

					 return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));


				 } catch (java.lang.Exception e) {
					 throw new java.lang.IllegalArgumentException();
				 }
			 }


			 /**
			  * static method to create the object
			  * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			  *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			  * Postcondition: If this object is an element, the reader is positioned at its end element
			  *                If this object is a complex type, the reader is positioned at the end element of its outer element
			  */
			 public static CellaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				 CellaType object = null;
				 // initialize a hash map to keep values
				 java.util.Map attributeMap = new java.util.HashMap();
				 java.util.List extraAttributeList = new java.util.ArrayList();


				 int event;
				 java.lang.String nillableValue = null;
				 java.lang.String prefix ="";
				 java.lang.String namespaceuri ="";
				 try {

					 while (!reader.isStartElement() && !reader.isEndElement())
						 reader.next();




					 // Note all attributes that were handled. Used to differ normal attributes
					 // from anyAttributes.
					 java.util.Vector handledAttributes = new java.util.Vector();



					 while(!reader.isEndElement()) {
						 if (reader.isStartElement()  || reader.hasText()){

							 java.lang.String content = reader.getElementText();

							 if (content.indexOf(":") > 0) {
								 // this seems to be a Qname so find the namespace and send
								 prefix = content.substring(0, content.indexOf(":"));
								 namespaceuri = reader.getNamespaceURI(prefix);
								 object = CellaType.Factory.fromString(content,namespaceuri);
							 } else {
								 // this seems to be not a qname send and empty namespace incase of it is
								 // check is done in fromString method
								 object = CellaType.Factory.fromString(content,"");
							 }


						 } else {
							 reader.next();
						 }  
					 }  // end of while loop




				 } catch (javax.xml.stream.XMLStreamException e) {
					 throw new java.lang.Exception(e);
				 }

				 return object;
			 }

		 }//end of factory class



	}



	public static class IndiceType
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"indiceType",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for IndiceType
		 */


		protected int localIndiceType ;

		private static java.util.HashMap _table_ = new java.util.HashMap();

		// Constructor

		protected IndiceType(int value, boolean isRegisterValue) {
			localIndiceType = value;
			if (isRegisterValue){

				_table_.put(localIndiceType + "", this);

			}

		}

		public static final int _value1 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToInt("1");

		public static final int _value2 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToInt("2");

		public static final int _value3 =
			org.apache.axis2.databinding.utils.ConverterUtil.convertToInt("3");

		public static final IndiceType value1 =
			new IndiceType(_value1,true);

		public static final IndiceType value2 =
			new IndiceType(_value2,true);

		public static final IndiceType value3 =
			new IndiceType(_value3,true);


		public int getValue() { return localIndiceType;}

		public boolean equals(java.lang.Object obj) {return (obj == this);}
		public int hashCode() { return toString().hashCode();}
		public java.lang.String toString() {

			return localIndiceType + "";


		}



		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		 public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			 boolean isReaderMTOMAware = false;

			 try{
				 isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			 }catch(java.lang.IllegalArgumentException e){
				 isReaderMTOMAware = false;
			 }
			 return isReaderMTOMAware;
		 }


		 /**
		  *
		  * @param parentQName
		  * @param factory
		  * @return org.apache.axiom.om.OMElement
		  */
		 public org.apache.axiom.om.OMElement getOMElement (
				 final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			 org.apache.axiom.om.OMDataSource dataSource =
				 new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					 IndiceType.this.serialize(MY_QNAME,factory,xmlWriter);
				 }
			 };
			 return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					 MY_QNAME,factory,dataSource);

		 }



		 public void serialize(final javax.xml.namespace.QName parentQName,
				 final org.apache.axiom.om.OMFactory factory,
				 org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		 throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			 //We can safely assume an element has only one type associated with it

			 java.lang.String namespace = parentQName.getNamespaceURI();
			 java.lang.String localName = parentQName.getLocalPart();

			 if (! namespace.equals("")) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespace);

				 if (prefix == null) {
					 prefix = generatePrefix(namespace);

					 xmlWriter.writeStartElement(prefix, localName, namespace);
					 xmlWriter.writeNamespace(prefix, namespace);
					 xmlWriter.setPrefix(prefix, namespace);

				 } else {
					 xmlWriter.writeStartElement(namespace, localName);
				 }

			 } else {
				 xmlWriter.writeStartElement(localName);
			 }

			 if (localIndiceType==java.lang.Integer.MIN_VALUE) {

				 throw new org.apache.axis2.databinding.ADBException("property value cannot be null!!");

			 } else {
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndiceType));
			 }


			 xmlWriter.writeEndElement();


		 }

		 /**
		  * Util method to write an attribute with the ns prefix
		  */
		 private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (xmlWriter.getPrefix(namespace) == null) {
				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);

			 }

			 xmlWriter.writeAttribute(namespace,attName,attValue);

		 }

		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			 if (namespace.equals(""))
			 {
				 xmlWriter.writeAttribute(attName,attValue);
			 }
			 else
			 {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace,attName,attValue);
			 }
		 }


		 /**
		  * Util method to write an attribute without the ns prefix
		  */
		 private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 java.lang.String attributeNamespace = qname.getNamespaceURI();
			 java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			 if (attributePrefix == null) {
				 attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			 }
			 java.lang.String attributeValue;
			 if (attributePrefix.trim().length() > 0) {
				 attributeValue = attributePrefix + ":" + qname.getLocalPart();
			 } else {
				 attributeValue = qname.getLocalPart();
			 }

			 if (namespace.equals("")) {
				 xmlWriter.writeAttribute(attName, attributeValue);
			 } else {
				 registerPrefix(xmlWriter, namespace);
				 xmlWriter.writeAttribute(namespace, attName, attributeValue);
			 }
		 }
		 /**
		  *  method to handle Qnames
		  */

		 private void writeQName(javax.xml.namespace.QName qname,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			 java.lang.String namespaceURI = qname.getNamespaceURI();
			 if (namespaceURI != null) {
				 java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				 if (prefix == null) {
					 prefix = generatePrefix(namespaceURI);
					 xmlWriter.writeNamespace(prefix, namespaceURI);
					 xmlWriter.setPrefix(prefix,namespaceURI);
				 }

				 if (prefix.trim().length() > 0){
					 xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 } else {
					 // i.e this is the default namespace
					 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				 }

			 } else {
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			 }
		 }

		 private void writeQNames(javax.xml.namespace.QName[] qnames,
				 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			 if (qnames != null) {
				 // we have to store this data until last moment since it is not possible to write any
				 // namespace data after writing the charactor data
				 java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				 java.lang.String namespaceURI = null;
				 java.lang.String prefix = null;

				 for (int i = 0; i < qnames.length; i++) {
					 if (i > 0) {
						 stringToWrite.append(" ");
					 }
					 namespaceURI = qnames[i].getNamespaceURI();
					 if (namespaceURI != null) {
						 prefix = xmlWriter.getPrefix(namespaceURI);
						 if ((prefix == null) || (prefix.length() == 0)) {
							 prefix = generatePrefix(namespaceURI);
							 xmlWriter.writeNamespace(prefix, namespaceURI);
							 xmlWriter.setPrefix(prefix,namespaceURI);
						 }

						 if (prefix.trim().length() > 0){
							 stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 } else {
							 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						 }
					 } else {
						 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					 }
				 }
				 xmlWriter.writeCharacters(stringToWrite.toString());
			 }

		 }


		 /**
		  * Register a namespace prefix
		  */
		 private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			 java.lang.String prefix = xmlWriter.getPrefix(namespace);

			 if (prefix == null) {
				 prefix = generatePrefix(namespace);

				 while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					 prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				 }

				 xmlWriter.writeNamespace(prefix, namespace);
				 xmlWriter.setPrefix(prefix, namespace);
			 }

			 return prefix;
		 }



		 /**
		  * databinding method to get an XML representation of this object
		  *
		  */
		 public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		 throws org.apache.axis2.databinding.ADBException{




			 //We can safely assume an element has only one type associated with it
			 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					 new java.lang.Object[]{
					 org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
					 org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndiceType)
			 },
			 null);

		 }



		 /**
		  *  Factory class that keeps the parse method
		  */
		 public static class Factory{



			 public static IndiceType fromValue(int value)
			 throws java.lang.IllegalArgumentException {
				 IndiceType enumeration = (IndiceType)

				 _table_.get(value + "");


				 if (enumeration==null) throw new java.lang.IllegalArgumentException();
				 return enumeration;
			 }
			 public static IndiceType fromString(java.lang.String value,java.lang.String namespaceURI)
			 throws java.lang.IllegalArgumentException {
				 try {

					 return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(value));


				 } catch (java.lang.Exception e) {
					 throw new java.lang.IllegalArgumentException();
				 }
			 }


			 /**
			  * static method to create the object
			  * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			  *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			  * Postcondition: If this object is an element, the reader is positioned at its end element
			  *                If this object is a complex type, the reader is positioned at the end element of its outer element
			  */
			 public static IndiceType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				 IndiceType object = null;
				 // initialize a hash map to keep values
				 java.util.Map attributeMap = new java.util.HashMap();
				 java.util.List extraAttributeList = new java.util.ArrayList();


				 int event;
				 java.lang.String nillableValue = null;
				 java.lang.String prefix ="";
				 java.lang.String namespaceuri ="";
				 try {

					 while (!reader.isStartElement() && !reader.isEndElement())
						 reader.next();




					 // Note all attributes that were handled. Used to differ normal attributes
					 // from anyAttributes.
					 java.util.Vector handledAttributes = new java.util.Vector();



					 while(!reader.isEndElement()) {
						 if (reader.isStartElement()  || reader.hasText()){

							 java.lang.String content = reader.getElementText();

							 if (content.indexOf(":") > 0) {
								 // this seems to be a Qname so find the namespace and send
								 prefix = content.substring(0, content.indexOf(":"));
								 namespaceuri = reader.getNamespaceURI(prefix);
								 object = IndiceType.Factory.fromString(content,namespaceuri);
							 } else {
								 // this seems to be not a qname send and empty namespace incase of it is
								 // check is done in fromString method
								 object = IndiceType.Factory.fromString(content,"");
							 }


						 } else {
							 reader.next();
						 }  
					 }  // end of while loop




				 } catch (javax.xml.stream.XMLStreamException e) {
					 throw new java.lang.Exception(e);
				 }

				 return object;
			 }

		 }//end of factory class



	}



	public static class Id
	implements org.apache.axis2.databinding.ADBBean{

		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
				"http://www.dsi.unifi.it/Tris/",
				"id",
		"ns2");



		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if(namespace.equals("http://www.dsi.unifi.it/Tris/")){
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}



		/**
		 * field for Id
		 */


		protected java.lang.String localId ;


		/**
		 * Auto generated getter method
		 * @return java.lang.String
		 */
		public  java.lang.String getId(){
			return localId;
		}



		/**
		 * Auto generated setter method
		 * @param param Id
		 */
		public void setId(java.lang.String param){

			this.localId=param;


		}


		/**
		 * isReaderMTOMAware
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try{
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			}catch(java.lang.IllegalArgumentException e){
				isReaderMTOMAware = false;
			}
			return isReaderMTOMAware;
		}


		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement (
				final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



			org.apache.axiom.om.OMDataSource dataSource =
				new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					Id.this.serialize(MY_QNAME,factory,xmlWriter);
				}
			};
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
					MY_QNAME,factory,dataSource);

		}



		public void serialize(final javax.xml.namespace.QName parentQName,
				final org.apache.axiom.om.OMFactory factory,
				org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
		throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{


			//We can safely assume an element has only one type associated with it

			java.lang.String namespace = "http://www.dsi.unifi.it/Tris/";
			java.lang.String localName = "id";

			if (! namespace.equals("")) {
				java.lang.String prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, localName, namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);

				} else {
					xmlWriter.writeStartElement(namespace, localName);
				}

			} else {
				xmlWriter.writeStartElement(localName);
			}

			if (localId==null){

				throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

			}else{

				xmlWriter.writeCharacters(localId);

			}


			xmlWriter.writeEndElement();


		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);

			}

			xmlWriter.writeAttribute(namespace,attName,attValue);

		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace,java.lang.String attName,
				java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
			if (namespace.equals(""))
			{
				xmlWriter.writeAttribute(attName,attValue);
			}
			else
			{
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace,attName,attValue);
			}
		}


		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
				javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}
		/**
		 *  method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix,namespaceURI);
				}

				if (prefix.trim().length() > 0){
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames,
				javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix,namespaceURI);
						}

						if (prefix.trim().length() > 0){
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}


		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}



		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		throws org.apache.axis2.databinding.ADBException{




			//We can safely assume an element has only one type associated with it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
					new java.lang.Object[]{
					org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
					org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId)
			},
			null);

		}



		/**
		 *  Factory class that keeps the parse method
		 */
		public static class Factory{




			/**
			 * static method to create the object
			 * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
			 *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is positioned at its end element
			 *                If this object is a complex type, the reader is positioned at the end element of its outer element
			 */
			public static Id parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
				Id object =
					new Id();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix ="";
				java.lang.String namespaceuri ="";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();




					// Note all attributes that were handled. Used to differ normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();



					while(!reader.isEndElement()) {
						if (reader.isStartElement() ){

							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.dsi.unifi.it/Tris/","id").equals(reader.getName())){

								java.lang.String content = reader.getElementText();

								object.setId(
										org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

							}  // End of if for expected property start element

							else{
								// A start element we are not expecting indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}

						} else {
							reader.next();
						}  
					}  // end of while loop




				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}//end of factory class



	}


	private  org.apache.axiom.om.OMElement  toOM(tictactoe.services.client.tris.TrisStub.Id param, boolean optimizeContent)
	throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(tictactoe.services.client.tris.TrisStub.Id.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement  toOM(tictactoe.services.client.tris.TrisStub.Griglia param, boolean optimizeContent)
	throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(tictactoe.services.client.tris.TrisStub.Griglia.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement  toOM(tictactoe.services.client.tris.TrisStub.Mossa param, boolean optimizeContent)
	throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(tictactoe.services.client.tris.TrisStub.Mossa.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}


	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tictactoe.services.client.tris.TrisStub.Id param, boolean optimizeContent)
	throws org.apache.axis2.AxisFault{


		try{

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(tictactoe.services.client.tris.TrisStub.Id.MY_QNAME,factory));
			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}


	/* methods to provide back word compatibility */



	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tictactoe.services.client.tris.TrisStub.Mossa param, boolean optimizeContent)
	throws org.apache.axis2.AxisFault{


		try{

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(tictactoe.services.client.tris.TrisStub.Mossa.MY_QNAME,factory));
			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}


	/* methods to provide back word compatibility */




	/**
	 *  get the default envelope
	 */
	 private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
		return factory.getDefaultEnvelope();
	}


	private  java.lang.Object fromOM(
			org.apache.axiom.om.OMElement param,
			java.lang.Class type,
			java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

		try {

			if (tictactoe.services.client.tris.TrisStub.Id.class.equals(type)){

				return tictactoe.services.client.tris.TrisStub.Id.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (tictactoe.services.client.tris.TrisStub.Griglia.class.equals(type)){

				return tictactoe.services.client.tris.TrisStub.Griglia.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (tictactoe.services.client.tris.TrisStub.Mossa.class.equals(type)){

				return tictactoe.services.client.tris.TrisStub.Mossa.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (tictactoe.services.client.tris.TrisStub.Griglia.class.equals(type)){

				return tictactoe.services.client.tris.TrisStub.Griglia.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}




}
