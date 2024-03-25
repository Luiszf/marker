package com.luis.biscoin;

import com.luis.biscoin.model.User;
import com.luis.biscoin.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BiscoinApplicationTests {

    @Test
    void authRoutesWorking(@Autowired WebTestClient client){

        User user = new User(new Random().toString(),new Random().toString(), UserRole.COSTUMER);

        client.post().uri("api/v1/auth/register")
                .bodyValue(user)
                .exchange()
                .expectStatus().isCreated();

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

        client.get().uri("/api/v1/product/1")
                .exchange()
                .expectStatus().isOk();

        client.post().uri("/api/v1/product")
                .exchange()
                .expectStatus().isUnauthorized();
    }

    @Test
    void postRouteExists(@Autowired WebTestClient client) {
        client.get().uri("/api/v1/post")
                .exchange()
                .expectStatus().isOk();

        client.get().uri("/api/v1/post/1")
                .exchange()
                .expectStatus().isOk();
    }
}
