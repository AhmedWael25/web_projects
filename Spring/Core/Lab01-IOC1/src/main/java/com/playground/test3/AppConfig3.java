package com.playground.test3;


import com.playground.test3.models.Account;
import com.playground.test3.models.DataSource;
import com.playground.test3.repositories.AccountDao;
import com.playground.test3.repositories.AccountDaoImpl;
import com.playground.test3.services.AccountService;
import com.playground.test3.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


@Configuration
@ImportResource("classpath:/beans8.xml")
@PropertySource("classpath:prop2.properties")
public class AppConfig3 {

    public AppConfig3() {
        System.out.println("AppConfig3 @Configuraiton: AppConfig3()");
    }

    @Value("${jdbc.url}")
    private String url ;

    @Value("${jdbc.admin}")
    private String admin ;

    @Value("${jdbc.password}")
    private String password ;


    @Autowired
    Environment env;

    @Autowired
    private  AppConfig2 appConfig2;


    @Bean
   @Scope("prototype") //When Proto. ONLY Sees myAccount1 from config 3, even if i expliclty called
    //that of config 2 still calls that of 3.
    public Account myAccount1(){

        System.out.println("Creating Account() from App Config 3");
        return new Account();
    }

    @Bean
    public AccountDaoImpl accountDao3(){
        System.out.println("Entered accountDao3() From Config 3, but EXPLICITLY called that of config2");
        return  new AccountDaoImpl(appConfig2.myAccount1());
    }

    @Bean
    public DataSource dataSource1(){
        return new DataSource(admin, url, password);
    }

    @Bean(name = "accountServiceBean1")
    public AccountService accountService1(){
        return  new AccountServiceImpl(appConfig2.accountDao1());
    }

}
