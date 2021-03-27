package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.domain.*;

import javax.persistence.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>START>>>>>>>>>>>>>>>>>>>>");
        Session session = sessionFactory.openSession();
        //1-select all users
        System.out.println("1 ====================================================");
        Query q1 = session.createQuery("from user");
        System.out.println(q1.getResultList());

        //2-Parameter Binding (Named) + (Positional)
        System.out.println("2 ====================================================");
        String query =  "from Product p where p.name like :name";
        Query q2 = session.createQuery(query).setParameter("name","PRODUCT NAME");
        System.out.println(q2.getResultList());

        query = "from Product p where p.name like :name and p.manufacturingDate < :date";
        Query q3 = session.createQuery(query).setParameter("name", "PRODUCT NAME")
                .setParameter("date", new Date(), TemporalType.DATE);
        System.out.println(q3.getResultList());

        //LEGACY (Positional)
        query = "from Product p where p.name like ?1 and p.manufacturingDate < ?2";
        Query q4 = session.createQuery(query).setParameter(1, "PRODUCT NAME")
                .setParameter(2, new Date(), TemporalType.DATE);
        System.out.println(q4.getResultList());



        //3-Parameter Binding Entity
        System.out.println("3 ====================================================");
        Seller s1 = session.get(Seller.class, 26);
        System.out.println(s1);
        Query q5 = session.createQuery("from user u where u.seller = :seller")
                .setParameter("seller", s1);
        System.out.println(q5.getResultList());


        //4-Comparisons
        System.out.println("4 ====================================================");
        query = "from Product p where p.name in ('PRODUCT NAME2','PRODUCT NAME1')";
        Query q6 = session.createQuery(query);
        System.out.println(q6.getResultList());

        query =" from Product p where p.name like '%2' OR  p.name like '%1'";
        Query q7 = session.createQuery(query);
        System.out.println(q7.getResultList());

        query = "from Product p where size(p.categories) > 6";
        Query q8 = session.createQuery(query);
        System.out.println(q8.getResultList());

        query = "from Product p where p.name like '\\PROD%' escape '\'";
        Query q9 = session.createQuery(query);
        System.out.println(q9.getResultList());

        query = "from user u order by u.fullName asc";
        Query q10 = session.createQuery(query);
        System.out.println(q10);

        //Particula El in collection
        Category cat = session.get(Category.class, 33);
        query = "from Product  p where :ca member of  p.categories";
        Query q25 = session.createQuery(query)
                .setParameter("ca", cat);
        System.out.println(q25.getResultList().size());


        //5- Projection
        //Which Obj and Prop we need
        System.out.println("5 ====================================================");
        Query q11 = session.createQuery("from Product  p, BuyerBuyProduct  b");
        Iterator pair = q11.getResultList().listIterator();
        while(pair.hasNext()){
            Object[] rows = (Object[]) pair.next();
            Product prod = (Product) rows[0];
            BuyerBuyProduct buy = (BuyerBuyProduct) rows[1];
            System.out.println(prod);
            System.out.println(buy);
        }


        query = "select u.fullName, u.userName from user u";
        Query q12 = session.createQuery(query);
        System.out.println(q12.getResultList().size());
        Object[] obj = (Object[]) q12.getResultList().get(0);
        System.out.println(obj[0]);
        System.out.println(obj[1]);


        //6-Aggregation
        System.out.println("6 ====================================================");
        query = "select count(p) from Product  p";
        Query q13 = session.createQuery(query);
        System.out.println((Long) q13.getResultList().get(0));


        query="select sum(p.quantity) from Product p";
        Query q14 = session.createQuery(query);
        System.out.println(q14.getSingleResult());


        query = "select min(p.quantity), max(p.quantity) from Product p";
        Query q15 = session.createQuery(query);
        Object[] o = (Object[]) q15.getResultList().get(0);
        System.out.println("min " +o[0]);
        System.out.println("max" + o[1]);



        //7-JOINS
        //(3 kinds implicit, ordinary(el 3ady), theta)
        System.out.println("7 ====================================================");

        query=" from Seller s where s.user.email like '%SELLER'";
        Query q16 = session.createQuery(query);
        System.out.println(q16.getResultList());

        query ="from Product p join p.seller s where s.value like '%SELLER%' and p.name like '%4'";
        Query q17 = session.createQuery(query);
        System.out.println(q17.getResultList().size());
        Object[] objects = (Object[]) q17.getResultList().get(0);
        //Prints Product And Seller
        System.out.println(objects[0]);
        System.out.println(objects[1]);

        //Theta - Whe we want to join non FKs
        query=" from user u, Seller s where u.userName = s.value";
        Query q18 = session.createQuery(query);
        System.out.println(q18.getResultList().size());
        objects = (Object[]) q18.getResultList().get(0);
        System.out.println(objects[0]);
        System.out.println(objects[1]);


        //8-Comparing Idents.
        System.out.println("8 ====================================================");
        //We can compare object references (it will compare ID)
        //This is the thea-style, T.C OF joining tables with both having 2 FKS to a table
        //Example Seller and buyer> prod
        query = "from Product p, Seller s where p.seller = s and s.value like 'USERNAME%'";
        Query q19 = session.createQuery(query);
        System.out.println(q19.getResultList().size());
        System.out.println(q19.getResultList());


        //9-Grouping Aggregate + Restricting
        System.out.println("9 ====================================================");

        query = "select s.value, size(s.products) from Seller s group by s.value HAVING s.value = 'USERNAME SELLER'";
        Query q20 = session.createQuery(query);
        Object[] o2 = (Object[]) q20.getResultList().get(0);
        System.out.println(o2[0]);
        System.out.println(o2[1]);


        //10-Dynamic Inst
        //Fully Q class names
        //Type-Safe
        System.out.println("10 ====================================================");
        query = "select  new org.playground.UserDto(u.userName,u.email) from user  u WHERE u.phone is  not  null";
        Query q21  = session.createQuery(query);
        System.out.println(q21.getResultList().size());
        System.out.println(q21.getResultList().get(0));


        //11-Sub Select
        System.out.println("11 ====================================================");
        query = " from Seller s where ( select count(p) from s.products p where p.name Like '%3') = 1";
        Query q22 = session.createQuery(query);
        System.out.println(q22.getResultList().size());
        System.out.println(q22.getResultList().get(0));

        //We Also have quantificaiton (ALL IN ANY) mixed with sub Q's
        //All tru if match All of results   , false if single value fails to do so
        //ANy/Some true if match Any of results, false if empty or not a single match
        //In ....
        query = "from Product p where p.seller = all( from Seller s where s.value Like '%PROD' )";
        Query q23 = session.createQuery(query);
        System.out.println(q23.getResultList().size());
        System.out.println(q23.getResultList().get(0));


        //12-Hibernate Functions
        System.out.println("12 ====================================================");
        //Finds a product by an element
        //T is hibernate DO hte Refgular JPA standard QL (sub query) using in quantificaiton
        Product p = session.get(Product.class , 9);
        Query q24 = session.createQuery("from Seller s where :givenProduct in elements(s.products)")
            .setParameter("givenProduct", p);
        System.out.println(q24.getResultList().size());
        System.out.println(q24.getResultList().get(0));




        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>END>>>>>>>>>>>>>>>>>>>>");
    }


}


class  UserDto {
    private String name;
    private String email;

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
