/**
 * EmpleadoServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wsempleado.webservice;

public class EmpleadoServiceImplServiceLocator extends org.apache.axis.client.Service implements com.wsempleado.webservice.EmpleadoServiceImplService {

    public EmpleadoServiceImplServiceLocator() {
    }


    public EmpleadoServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmpleadoServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmpleadoPort
    private java.lang.String EmpleadoPort_address = "http://localhost:8080/ws-empleado/EmpleadoServiceImpl";

    public java.lang.String getEmpleadoPortAddress() {
        return EmpleadoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmpleadoPortWSDDServiceName = "EmpleadoPort";

    public java.lang.String getEmpleadoPortWSDDServiceName() {
        return EmpleadoPortWSDDServiceName;
    }

    public void setEmpleadoPortWSDDServiceName(java.lang.String name) {
        EmpleadoPortWSDDServiceName = name;
    }

    public ws_empleado.empleado.EmpleadoService getEmpleadoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmpleadoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmpleadoPort(endpoint);
    }

    public ws_empleado.empleado.EmpleadoService getEmpleadoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.wsempleado.webservice.EmpleadoServiceImplServiceSoapBindingStub _stub = new com.wsempleado.webservice.EmpleadoServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmpleadoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmpleadoPortEndpointAddress(java.lang.String address) {
        EmpleadoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws_empleado.empleado.EmpleadoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.wsempleado.webservice.EmpleadoServiceImplServiceSoapBindingStub _stub = new com.wsempleado.webservice.EmpleadoServiceImplServiceSoapBindingStub(new java.net.URL(EmpleadoPort_address), this);
                _stub.setPortName(getEmpleadoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmpleadoPort".equals(inputPortName)) {
            return getEmpleadoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.wsempleado.com/", "EmpleadoServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.wsempleado.com/", "EmpleadoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmpleadoPort".equals(portName)) {
            setEmpleadoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
