package de.cw.configuration;

import de.cw.domain.CalculatorUser;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CalculatorSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Resource(name = "users")
    private Map<String, CalculatorUser> users;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        for (CalculatorUser calculatorUser : users.values()) {
            auth.inMemoryAuthentication().withUser(calculatorUser.getUsername()).password(calculatorUser.getPassword())
                .roles(calculatorUser.getRole());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated();
        http.httpBasic();
        http.csrf().disable();
    }

}

