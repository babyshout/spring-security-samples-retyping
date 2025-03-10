package ga.agency.hellosecuritywebflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient(timeout = "36000")
class HelloSecurityWebfluxApplicationTests {

    @Autowired
    WebTestClient rest;

    @Test
    void indexWhenUnAuthenticatedThenRedirect() {
        // @formatter:off
        this.rest.get()
                .uri("/")
                .exchange()
                .expectStatus().isUnauthorized();
        // @formatter:on
    }

    @Test
    @WithMockUser
    void indexWhenAuthenticatedThenOk() {
        // @formatter:off
        this.rest.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk();
        // @formatter:on
    }
}
