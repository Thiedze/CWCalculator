package de.cw.configuration;

import de.cw.domain.CalculatorUser;
import de.cw.service.CalculatorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jndi.JndiLocatorDelegate;

@Configuration
class CalculatorConfiguration {

    private static final JndiLocatorDelegate jndi = JndiLocatorDelegate.createDefaultResourceRefLocator();

    @Value("${applicationId}")
    private String awsApplicationIdAsString;

    @Value("${users}")
    private String usernameAndPasswordsString;

    private Map<String, CalculatorUser> users = null;

    private List<String> awsApplicationIds = null;

    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer() throws NamingException {
        String propertyLocation = jndi.lookup("environment_properties", String.class);
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(propertyLocation));
        return propertyPlaceholderConfigurer;
    }

    @Bean(name = "users")
    public Map<String, CalculatorUser> users() {
        if (users == null) {
            users = new HashMap<>();

            String[] usernamePasswordString = usernameAndPasswordsString.split(";");

            for (String usernamePassword : usernamePasswordString) {
                String[] parts = usernamePassword.split(",");
                users.put(parts[0], new CalculatorUser(parts[0], parts[1], parts[2]));
            }
        }
        return users;
    }

    @Bean
    public List<String> applicationIds() {
        if (awsApplicationIds == null) {
            awsApplicationIds = new ArrayList<>();
            Collections.addAll(awsApplicationIds, awsApplicationIdAsString.split(";"));
        }
        return awsApplicationIds;
    }

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService();
    }
}
