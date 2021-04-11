
package org.playground.consumer.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "EmployeeImplService", targetNamespace = "http://impl.dao.playground.org/", wsdlLocation = "http://localhost:9191/SOAP-D1/ws/employee?wsdl")
public class EmployeeImplService
    extends Service
{

    private final static URL EMPLOYEEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEIMPLSERVICE_EXCEPTION;
    private final static QName EMPLOYEEIMPLSERVICE_QNAME = new QName("http://impl.dao.playground.org/", "EmployeeImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9191/SOAP-D1/ws/employee?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEIMPLSERVICE_WSDL_LOCATION = url;
        EMPLOYEEIMPLSERVICE_EXCEPTION = e;
    }

    public EmployeeImplService() {
        super(__getWsdlLocation(), EMPLOYEEIMPLSERVICE_QNAME);
    }

    public EmployeeImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEIMPLSERVICE_QNAME, features);
    }

    public EmployeeImplService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEIMPLSERVICE_QNAME);
    }

    public EmployeeImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEIMPLSERVICE_QNAME, features);
    }

    public EmployeeImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeDao
     */
    @WebEndpoint(name = "EmployeeImplPort")
    public EmployeeDao getEmployeeImplPort() {
        return super.getPort(new QName("http://impl.dao.playground.org/", "EmployeeImplPort"), EmployeeDao.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeDao
     */
    @WebEndpoint(name = "EmployeeImplPort")
    public EmployeeDao getEmployeeImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.dao.playground.org/", "EmployeeImplPort"), EmployeeDao.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEIMPLSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEIMPLSERVICE_EXCEPTION;
        }
        return EMPLOYEEIMPLSERVICE_WSDL_LOCATION;
    }

}
