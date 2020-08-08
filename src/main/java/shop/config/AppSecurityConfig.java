package shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] ENABLE_ADDRESSES
            = {"/", "/user/register", "/user/login", "/home", "/home-r",
                "/about", "/faq", "/contact", "/delivery-information",
            "/privacy-policy", "/return-query", "/term-and-conditions", "/category/selected/**",
                "/test", "/random/**"};

    private static final String[] ENABLE_RESOURCES
            = {"/static/**", "/css/**", "/js/**", "/img/**"};

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(ENABLE_ADDRESSES).permitAll()
                .antMatchers(ENABLE_RESOURCES).permitAll()
                .anyRequest().authenticated()
//                .antMatchers("/bartender/**").hasRole("BARTENDER") //??
//                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/user/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                //.logoutUrl("/user/logout/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/user/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized");

        http.headers().disable();
    }
}