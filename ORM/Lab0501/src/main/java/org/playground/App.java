package org.playground;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.*;
import org.playground.domain.*;

import javax.persistence.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Criteria myCriteria1 = session.createCriteria(Product.class)
                .addOrder(Order.asc("id"));



        //Restrictions -- Criterion

        Criterion nameCriterion = Restrictions.eq("name","PRODUCT NAME").ignoreCase();
        Criteria criteria2 = session.createCriteria(Product.class, "p")
                .add(nameCriterion);
        System.out.println("c2 : " +criteria2.list());

        //=================================Property of component=========================
//        Criteria c3 = session.createCriteria(Seller.class,"s")
//                .add( Restrictions.eq("s.user.userName", "BUYER") );
//        System.out.println(c3.list());

//        Criterion nameCrit3 = Restrictions.eq("seller.value", "USERNAME SELLER");
//        Criteria c4 = session.createCriteria(Product.class, "p")
//                .add(nameCrit3);
//        System.out.println(c4.list());
        //===============================================================================
        Criterion cr4 = Restrictions.isNotNull("phone");
        Criteria c5 = session.createCriteria(User.class)
                .add(cr4);
        System.out.println("c5 : " +c5.list());

        Criterion cr5 = Restrictions.isNull("phone");
        Criteria c6 = session.createCriteria(User.class)
                .add(cr5);
        System.out.println("c6 : " +c6.list());

//        Criteria c7  = session.createCriteria(Seller.class)
//                .add( Restrictions.sizeGt("products", 1) );
//        System.out.println("c7 : " + c7.list());

        Criteria c8 = session.createCriteria(Product.class)
                .add( Restrictions.like( "name", "4", MatchMode.END ) );
        System.out.println("c8 : " +c8.list());


        //Can use add/or or COnju/DisJun
        Criteria c9 = session.createCriteria(Product.class)
                .add( Restrictions.disjunction(
                        Restrictions.conjunction(
                            Restrictions.like("name", "%4"),
                            Restrictions.like("name", "\\%")
                        ),
                        Restrictions.like("name", "%3")
                ) );
        System.out.println("c9 : " +c9.list());

        //===============================================================
        //===============================================================
        //========================SUB Q==================================


        DetachedCriteria subQ = DetachedCriteria.forClass(User.class)
                .setProjection(Projections.id());



        Criteria c10 =  session.createCriteria(Product.class,"p")
                .add(Property.forName("p.seller.id").in(subQ));
        System.out.println("C10 " + c10.list());

        //===============================================================
        Criteria sellerCriteria = session.createCriteria(Seller.class);

        sellerCriteria.add(
                Restrictions.in("id",24, 26, 28,30)
        );

        Criteria prodCriteria = sellerCriteria.createCriteria("products");
        prodCriteria = prodCriteria.add(
                Restrictions.like("name", "4", MatchMode.END)
        );

        System.out.println("JOIN 1 RES:" +  prodCriteria.list());
        Seller s = (Seller) sellerCriteria.list().get(0);
        System.out.println("JOIN 1 RES:" + s.getProducts());


//        WE CAN ALSO NEST SUBQQQs
        List result = session.createCriteria(Seller.class)
                .createCriteria("user")
                .add( Restrictions.like("email", "%SELLER") ).list();
        System.out.println("JOIN 2 RES:" +  result);



        Criteria c11 = session.createCriteria(Seller.class, "s")
                .createAlias("products", "pp")
                .add( Restrictions.eq("s.id", 30) )
                .add( Restrictions.like("pp.name", "%4") );
        System.out.println("JOIN 3 RES:" + c11.list());

        //================================================================

        Criteria c12 = session.createCriteria(Seller.class, "s")
                .setProjection( Projections.id() );
        System.out.println("c12 : " +c12.list());

        Criteria c13 = session.createCriteria(User.class)
                .setProjection( Projections.projectionList()
                        .add(Projections.id())
                        .add(Projections.property("userName"))
                );
        System.out.println("c13 : " +c13.list());


        Criteria c14 = session.createCriteria(User.class)
                .setProjection(Projections.rowCount());
        System.out.println("c14 : " +c14.list());


        Criteria c15 = session.createCriteria(Seller.class)
                .createAlias("products","pp").setProjection(
                  Projections.projectionList()
                        .add(Property.forName("id").group())
                        .add(Property.forName("pp.name").group())
                );
        System.out.println("c15 : " +c15.list());

//        ============================================================================
//        ============================================================================
//        ============================================================================
            session.close();

            session = sessionFactory.openSession();
            session.beginTransaction();
            User  myU = session.get(User.class, 30);


        System.out.println(myU);


        Seller myExampleUser = new Seller();
//        System.out.println(myExampleUser);
//            myExampleUser.setValue("USERNAME SELLER");
        myExampleUser.setUser(myU);

        System.out.println("ex: "+myExampleUser);


        Example exampleUser = Example.create(myExampleUser)
                .excludeProperty("id")
                .excludeProperty("value")
                .excludeProperty("products");


            Criteria c16 = session.createCriteria(Seller.class)
                    .add(exampleUser);
        System.out.println("c16 : " +c16.list());



    }

}



