package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.schema.internal.ExceptionHandlerHaltImpl;
import org.playground.domain.*;

import javax.persistence.Column;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


        Session mySession = sessionFactory.openSession();

        // ==================  Lazy Loading ===================

        mySession.beginTransaction();
        //Getting one Seller
        Seller s1 = mySession.find(Seller.class, 24);
        //Printing Them
        System.out.println("Seller : " + s1);

        //Will forcefully get products associated with thats seller
        System.out.println( s1.getProducts() );

        mySession.close();

        Set<Product> p = s1.getProducts();
        System.out.println("products : " + p);

        // ========================================================


        //============EAGER LOADING ==============================

        mySession = sessionFactory.openSession();
        mySession.beginTransaction();


        Product p1 = mySession.find(Product.class, 9);
        System.out.println(p1);

        mySession.getTransaction().commit();

        Set<Category> categorySet = p1.getCategories();
        System.out.println(categorySet);
        // ========================================================

//=============================================================================
//=============================================================================
//=============================================================================

        /*mySession = sessionFactory.openSession();
        mySession.beginTransaction();

        Customer customer =  new Customer();
        Order order1 = new Order();
        Order order2 = new Order();

        order1.setCustomer(customer);
        order2.setCustomer(customer);
        Set<Order> orders = new HashSet<>(Arrays.asList(order1, order2));
        customer.setOrders(orders);

        mySession.persist(customer);

        mySession.getTransaction().commit();
        mySession.beginTransaction();

        mySession.persist(order1);
        mySession.persist(order2);
        mySession.getTransaction().commit();*/

        mySession.beginTransaction();

//        ===== SELECT MODE ================================================
//select customer0_.id as id1_9_0_ from customer customer0_ where customer0_.id=?
//select orders0_.customer_id as customer2_0_0_, orders0_.id as id1_0_0_, orders0_.id as id1_0_1_, orders0_.customer_id as customer2_0_1_
// from biddingschema.order orders0_
// where orders0_.customer_id=?

        //HOW N+1 WHILE ONLY 1 SELECT UP >>>>>>>>>>>>>>>????????????????
//        ============================================================

//        =====JOIN MODE === Loads EEagerly even if it was explicitly set to Lazily, uses oute JOIN
        //Join has duplicatets ??!  >>>>>>>>>>>>??????????????/ Bec each cistomer has multiple orders
//select customer0_.id as id1_9_0_, orders1_.customer_id as customer2_0_1_, orders1_.id as id1_0_1_, orders1_.id as id1_0_2_, orders1_.customer_id as customer2_0_2_
// from customer customer0_
// left outer join biddingschema.order orders1_ on customer0_.id=orders1_.customer_id where customer0_.id=?


//        =====SUB-SELECT========================(Shoud be with collections)
//select customer0_.id as id1_9_0_ from customer customer0_ where customer0_.id=?
//select orders0_.customer_id as customer2_0_0_, orders0_.id as id1_0_0_, orders0_.id as id1_0_1_, orders0_.customer_id as customer2_0_1_ from
//biddingschema.order orders0_ where orders0_.customer_id=?


//========================Diff between SUB-SEL and SEL
//  ================ Batch Fetching =======================
//FETCHES ALL ?? >>>>>>>>>>>>>>>>>>>>>HOW?!


        Customer c = mySession.get(Customer.class, Integer.valueOf(19).longValue());

        System.out.println(c.getOrders()); //This and .size will force it to get the Orders from DB
//      c.getOrders().size();//In case of lazy loading
//      Collection<Order> cOrders= c.getOrders();


//        ===============================================================================

        mySession.close();
        sessionFactory.close();
    }
}
