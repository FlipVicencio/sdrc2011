
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:58 LKT)
 */

            package it.unifi.dsi.www.tris;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
                  "grigliaType".equals(typeName)){
                   
                            return  it.unifi.dsi.www.tris.GrigliaType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
                  "statusType".equals(typeName)){
                   
                            return  it.unifi.dsi.www.tris.StatusType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
                  "mossaType".equals(typeName)){
                   
                            return  it.unifi.dsi.www.tris.MossaType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
                  "cellaType".equals(typeName)){
                   
                            return  it.unifi.dsi.www.tris.CellaType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.dsi.unifi.it/Tris/".equals(namespaceURI) &&
                  "indiceType".equals(typeName)){
                   
                            return  it.unifi.dsi.www.tris.IndiceType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    