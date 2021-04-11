
package org.testplayground.consumer;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.testplayground.consumer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteEmployeeById_QNAME = new QName("http://interfaces.dao.playground.org/", "deleteEmployeeById");
    private final static QName _DeleteEmployeeByIdResponse_QNAME = new QName("http://interfaces.dao.playground.org/", "deleteEmployeeByIdResponse");
    private final static QName _Employee_QNAME = new QName("http://interfaces.dao.playground.org/", "employee");
    private final static QName _GetEmployeeById_QNAME = new QName("http://interfaces.dao.playground.org/", "getEmployeeById");
    private final static QName _GetEmployeeByIdResponse_QNAME = new QName("http://interfaces.dao.playground.org/", "getEmployeeByIdResponse");
    private final static QName _SaveEmployee_QNAME = new QName("http://interfaces.dao.playground.org/", "saveEmployee");
    private final static QName _SaveEmployeeResponse_QNAME = new QName("http://interfaces.dao.playground.org/", "saveEmployeeResponse");
    private final static QName _UpdateEmployee_QNAME = new QName("http://interfaces.dao.playground.org/", "updateEmployee");
    private final static QName _UpdateEmployeeResponse_QNAME = new QName("http://interfaces.dao.playground.org/", "updateEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.testplayground.consumer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteEmployeeById }
     * 
     */
    public DeleteEmployeeById createDeleteEmployeeById() {
        return new DeleteEmployeeById();
    }

    /**
     * Create an instance of {@link DeleteEmployeeByIdResponse }
     * 
     */
    public DeleteEmployeeByIdResponse createDeleteEmployeeByIdResponse() {
        return new DeleteEmployeeByIdResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link GetEmployeeById }
     * 
     */
    public GetEmployeeById createGetEmployeeById() {
        return new GetEmployeeById();
    }

    /**
     * Create an instance of {@link GetEmployeeByIdResponse }
     * 
     */
    public GetEmployeeByIdResponse createGetEmployeeByIdResponse() {
        return new GetEmployeeByIdResponse();
    }

    /**
     * Create an instance of {@link SaveEmployee }
     * 
     */
    public SaveEmployee createSaveEmployee() {
        return new SaveEmployee();
    }

    /**
     * Create an instance of {@link SaveEmployeeResponse }
     * 
     */
    public SaveEmployeeResponse createSaveEmployeeResponse() {
        return new SaveEmployeeResponse();
    }

    /**
     * Create an instance of {@link UpdateEmployee }
     * 
     */
    public UpdateEmployee createUpdateEmployee() {
        return new UpdateEmployee();
    }

    /**
     * Create an instance of {@link UpdateEmployeeResponse }
     * 
     */
    public UpdateEmployeeResponse createUpdateEmployeeResponse() {
        return new UpdateEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeById }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "deleteEmployeeById")
    public JAXBElement<DeleteEmployeeById> createDeleteEmployeeById(DeleteEmployeeById value) {
        return new JAXBElement<DeleteEmployeeById>(_DeleteEmployeeById_QNAME, DeleteEmployeeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "deleteEmployeeByIdResponse")
    public JAXBElement<DeleteEmployeeByIdResponse> createDeleteEmployeeByIdResponse(DeleteEmployeeByIdResponse value) {
        return new JAXBElement<DeleteEmployeeByIdResponse>(_DeleteEmployeeByIdResponse_QNAME, DeleteEmployeeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Employee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Employee }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "employee")
    public JAXBElement<Employee> createEmployee(Employee value) {
        return new JAXBElement<Employee>(_Employee_QNAME, Employee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeById }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "getEmployeeById")
    public JAXBElement<GetEmployeeById> createGetEmployeeById(GetEmployeeById value) {
        return new JAXBElement<GetEmployeeById>(_GetEmployeeById_QNAME, GetEmployeeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "getEmployeeByIdResponse")
    public JAXBElement<GetEmployeeByIdResponse> createGetEmployeeByIdResponse(GetEmployeeByIdResponse value) {
        return new JAXBElement<GetEmployeeByIdResponse>(_GetEmployeeByIdResponse_QNAME, GetEmployeeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "saveEmployee")
    public JAXBElement<SaveEmployee> createSaveEmployee(SaveEmployee value) {
        return new JAXBElement<SaveEmployee>(_SaveEmployee_QNAME, SaveEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "saveEmployeeResponse")
    public JAXBElement<SaveEmployeeResponse> createSaveEmployeeResponse(SaveEmployeeResponse value) {
        return new JAXBElement<SaveEmployeeResponse>(_SaveEmployeeResponse_QNAME, SaveEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "updateEmployee")
    public JAXBElement<UpdateEmployee> createUpdateEmployee(UpdateEmployee value) {
        return new JAXBElement<UpdateEmployee>(_UpdateEmployee_QNAME, UpdateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.dao.playground.org/", name = "updateEmployeeResponse")
    public JAXBElement<UpdateEmployeeResponse> createUpdateEmployeeResponse(UpdateEmployeeResponse value) {
        return new JAXBElement<UpdateEmployeeResponse>(_UpdateEmployeeResponse_QNAME, UpdateEmployeeResponse.class, null, value);
    }

}
