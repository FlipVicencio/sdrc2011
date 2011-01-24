
/**
 * TrisMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
        package serviceWeb;

        /**
        *  TrisMessageReceiverInOut message receiver
        */

        public class TrisMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutSyncMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        TrisSkeleton skel = (TrisSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("inizializza".equals(methodName)){
                
                it.unifi.dsi.www.tris.Griglia griglia2 = null;
	                        it.unifi.dsi.www.tris.Id wrappedParam =
                                                             (it.unifi.dsi.www.tris.Id)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    it.unifi.dsi.www.tris.Id.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               griglia2 =
                                                   
                                                   
                                                         skel.inizializza(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), griglia2, false);
                                    } else 

            if("gioca".equals(methodName)){
                
                it.unifi.dsi.www.tris.Griglia griglia4 = null;
	                        it.unifi.dsi.www.tris.Mossa wrappedParam =
                                                             (it.unifi.dsi.www.tris.Mossa)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    it.unifi.dsi.www.tris.Mossa.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               griglia4 =
                                                   
                                                   
                                                         skel.gioca(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), griglia4, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(it.unifi.dsi.www.tris.Id param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.unifi.dsi.www.tris.Id.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.unifi.dsi.www.tris.Griglia param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.unifi.dsi.www.tris.Griglia.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(it.unifi.dsi.www.tris.Mossa param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(it.unifi.dsi.www.tris.Mossa.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, it.unifi.dsi.www.tris.Griglia param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(it.unifi.dsi.www.tris.Griglia.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    


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
        
                if (it.unifi.dsi.www.tris.Id.class.equals(type)){
                
                           return it.unifi.dsi.www.tris.Id.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.unifi.dsi.www.tris.Griglia.class.equals(type)){
                
                           return it.unifi.dsi.www.tris.Griglia.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.unifi.dsi.www.tris.Mossa.class.equals(type)){
                
                           return it.unifi.dsi.www.tris.Mossa.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (it.unifi.dsi.www.tris.Griglia.class.equals(type)){
                
                           return it.unifi.dsi.www.tris.Griglia.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
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

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    