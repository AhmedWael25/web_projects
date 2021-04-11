package org.playground.dao.impl;

import org.playground.dao.interfaces.CalculatorOps;

import org.playground.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jakarta.jws.WebService;
import org.playground.model.CalcParams;


//2-DOC - LIT - BARE
//    @Override
//    public double add (CalcParams param){
//     return param.getParam1()  + param.getParam2();
// }




@WebService(endpointInterface = "org.playground.dao.interfaces.CalculatorOps")
public class CalculatorOpsImpl implements CalculatorOps{


    @Override
   public double add (CalcParams param){
    return param.getParam1()  + param.getParam2();
}

//     @Override
//    public double add (double x, double y ){
//         return x + y;
//     }

//     @Override
//     public double sub (double x, double y){
//         return x - y;
//     }

//     @Override
//     public double div (double x, double y){
//         if(y == 0) throw new IllegalArgumentException("Div By ZeRo");
//         return x/y;
//     }

//     @Override
//     public double mul(double x, double y){
//         return x*y;
//     }

}