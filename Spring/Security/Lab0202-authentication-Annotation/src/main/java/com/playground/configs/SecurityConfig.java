package com.playground.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.criteria.Root;

@Configuration
//@ImportResource("/WEB-INF/spring/security-configs.xml")
@EnableWebSecurity
//Using THis we will create a default AuthenticationManager
//BUT NOT Auth provider or user service, those will have to be manually configured.
//

//1-We defined the DelegatingFilterProxy
//2-Defined auth manager, and configed default provider and in memory auth
//3-Define FIlterChainProxy --
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    RootAppConfig rootAppConfig;


    //Instead of XML defining, we can inject AuthenticationManagerBuilder a,d start configuring it
    //the same way we did in XML
    //We used the default authenticaton provider, and in memory user detil service
    //The most common approach is not to use this method, but to OVERRIDE BOTH Configure Methods
    //inhereted from WebSecurityConfigurerAdapter
    /*
        @Autowired
    public  void configureAuthManager(AuthenticationManagerBuilder authBuilder)throws  Exception{
        PasswordEncoder encoder = passwordEncoder();
        authBuilder.inMemoryAuthentication()
                    .withUser("user")
                    .password(encoder.encode("1234"))
                    .roles("ROLES_USER")
                .and()
                    .withUser("admin")
                    .password(encoder.encode("1234"))
                    .roles("ROLES_USER","ROLES_ADMIN")
                .and()
                    .passwordEncoder(encoder)
                ;
    }
    * */


    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        PasswordEncoder encoder = passwordEncoder();

        authBuilder
                .jdbcAuthentication()
                .passwordEncoder(encoder)
                .dataSource(rootAppConfig.dataSource());

//        authBuilder.inMemoryAuthentication()
//                .withUser("user")
//                    .password(encoder.encode("1234"))
//                    .authorities("ROLE_USER")
//                .and()
//                    .withUser("admin")
//                    .password(encoder.encode("1234"))
//                    .authorities("ROLE_USER","ROLE_ADMIN")
//                .and()
//                    .passwordEncoder(encoder)
//        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/profile/**").hasAuthority("ROLE_USER")
                .antMatchers("/**").permitAll()

            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/submitlogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
            .and()
                .rememberMe()
                    .key("key")
                    .rememberMeParameter("remember-me")
                    .tokenValiditySeconds(2149000)
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()

            .and()
                .csrf()
                    .disable();

            //CSRF mys be disabled to send /logout as a get request
            //otherwise send it as POST

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
