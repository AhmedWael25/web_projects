package org.playground.dao.impl;

import org.playground.dao.interfaces.CalculatorOps;

import org.playground.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jakarta.jws.WebService;
import org.playground.model.CalcParams;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;
import jakarta.jws.Oneway;
import jakarta.jws.WebResult;
import jakarta.jws.soap.SOAPBinding;
//2-DOC - LIT - BARE
//    @Override
//    public double add (CalcParams param){
//     return param.getParam1()  + param.getParam2();
// }




@WebService(serviceName ="MyCalcService", name="CalcPortType", portName="CalcPort" ,
            targetNamespace = "MyCustom.Name.Space.xxx")

@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL  , parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CalculatorOpsImpl implements CalculatorOps{


    //if RPC with no partName speciefied in webparam =>  This will be part rep. parameter

    //IF RPC AND partName Spec  =>  partName="MyParamPartName"
    //Will ONLY be applied/USED if RPC or DOC with Bare

    @Override
    @WebMethod(operationName = "myAddMethod")
    @WebResult(header = true, name="MyResult")
   public double add ( @WebParam(name ="myParam") double x, double y ){

        return x + y;
    }
    /*
    POST http://localhost:9191/SOAP-D302-WSDL-CUSTOM/ws/calc HTTP/1.1
    Content-Type: text/xml
        
    <soap:Envelope
        xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
        xmlns:ns="MyCustom.Name.Space.xxx">
        
        <soap:Body>
            <ns:myAddMethod>
                <myParam>4</myParam>
                <arg1>10</arg1>
            </ns:myAddMethod>
        </soap:Body>

    </soap:Envelope>
    */

    @Override
    @WebMethod
    public double sub (double x, double y){
        return x - y;
    }

    @Override
    @WebMethod
    public double div (double x, double y){
        if(y == 0) throw new IllegalArgumentException("Div By ZeRo");
        return x/y;
    }

    @Override
    @WebMethod(exclude = true)
    public double mul(double x, double y){
        return x*y;
    }

    @Override
    @WebMethod
    @Oneway
    public void doNothing(double x, double y){
        
    }

}