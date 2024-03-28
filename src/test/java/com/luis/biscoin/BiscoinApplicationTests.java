package com.luis.biscoin;

import com.luis.biscoin.model.User;
import com.luis.biscoin.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Random;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BiscoinApplicationTests {

    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(List.of(UserRole.COSTUMER).toString());

    @Test
    void authRoutesWorking(@Autowired WebTestClient client){

        User user = new User();

        client.post().uri("api/v1/auth/register")
                .bodyValue(user)
                .exchange()
                .expectAll();

        client.post().uri("api/v1/auth/login")
                .bodyValue(user)
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    void productRouteExists(@Autowired WebTestClient client) {

        client.get().uri("/api/v1/product")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void postRouteExists(@Autowired WebTestClient client) {
        client.get().uri("/api/v1/post")
                .exchange()
                .expectStatus().isOk();

    }
}
