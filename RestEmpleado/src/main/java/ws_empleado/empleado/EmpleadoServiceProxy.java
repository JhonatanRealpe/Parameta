package ws_empleado.empleado;

public class EmpleadoServiceProxy implements ws_empleado.empleado.EmpleadoService {
  private String _endpoint = null;
  private ws_empleado.empleado.EmpleadoService empleadoService = null;
  
  public EmpleadoServiceProxy() {
    _initEmpleadoServiceProxy();
  }
  
  public EmpleadoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmpleadoServiceProxy();
  }
  
  private void _initEmpleadoServiceProxy() {
    try {
      empleadoService = (new com.wsempleado.webservice.EmpleadoServiceImplServiceLocator()).getEmpleadoPort();
      if (empleadoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)empleadoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)empleadoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (empleadoService != null)
      ((javax.xml.rpc.Stub)empleadoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws_empleado.empleado.EmpleadoService getEmpleadoService() {
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService;
  }
  
  public boolean createEmpleado(ws_empleado.empleado.Empleado arg0) throws java.rmi.RemoteException{
    if (empleadoService == null)
      _initEmpleadoServiceProxy();
    return empleadoService.createEmpleado(arg0);
  }
  
  
}