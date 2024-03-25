package com.luis.biscoin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BiscoinApplicationTests {

    @Test
    void productRouteExists(@Autowired WebTestClient webTestClient) {

        webTestClient.get().uri("/api/v1/product")
                .exchange()
                .expectStatus().isOk();

        webTestClient.get().uri("/api/v1/product/1")
                .exchange()
                .expectStatus().isOk();

        webTestClient.post().uri("/api/v1/product")
                .exchange()
                .expectStatus().isUnauthorized();
    }

    @Test
    void postRouteExists(@Autowired WebTestClient webTestClient) {
        webTestClient.get().uri("/api/v1/post")
                .exchange()
                .expectStatus().isOk();

        webTestClient.get().uri("/api/v1/post/1")
                .exchange()
                .expectStatus().isOk();
    }
}
