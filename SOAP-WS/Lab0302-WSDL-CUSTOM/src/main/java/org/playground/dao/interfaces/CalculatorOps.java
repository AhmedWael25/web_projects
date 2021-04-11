package org.playground.dao.interfaces;


import org.playground.domain.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.playground.model.CalcParams;

//Trials
// 1- Param Style Bare => Exception if method has more than parameter
// com.sun.xml.ws.model.RuntimeModelerException: runtime modeler error: 
//SEI org.playground.dao.impl.CalculatorOpsImpl has method add annotated as BARE but it has more than one parameter bound to body. This is invalid. 
//Please annotate the method with annotation: @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)



//1- : DOCUMENT, LITERAL , WRAPPED   (IS THE DEFAULT)

//2- : DOCUMENT, LITERAL , BARE
    //@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    //    @WebMethod
    //    double add (CalcParams param);

//3- RPC , LIT , WRAPPED
    //@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)

//4- RPC, ENC , WRAPPED
    //@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED  , parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
    //Didnot have any effect on The RESULTED WSDL!!??? => ASK

//5- DOC, ENC, BARE
    //@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.ENCODED  , parameterStyle = SOAPBinding.ParameterStyle.BARE)
    
//6- DOC, ENC, WRAPPED
    //@SOAPBinding( use = SOAPBinding.Use.ENCODED  )


// @WebService(name="CalcPortType", serviceName="MyCalcWS", portName="CalcPortName")
//ServiceName didnot change, name still from the endpoint

//FROM DOC: Not Allowes in INTs (servicename, portName, and ofc endpointInt )
//This member-value is not allowed on endpoint interfaces.
public interface CalculatorOps{

    double add (double x, double y);
    double sub (double x, double y);
    double div (double x, double y);
    double mul(double x, double y);
    void doNothing(double x, double y);
}