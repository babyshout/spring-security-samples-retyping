package ga.agency.hellosecuritywebflux;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

@Configuration
public class SecurityConfiguration {
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(csrfConfigurer -> csrfConfigurer.disable())
                .headers(headersConfigurer -> headersConfigurer.xssProtection(
                        xssProtectionConfigurer -> xssProtectionConfigurer.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
                ))
                .build();
    }

}
