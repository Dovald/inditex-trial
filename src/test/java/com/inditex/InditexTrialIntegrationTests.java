package com.inditex;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.inditex.dto.ErrorDTO;
import com.inditex.dto.PriceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InditexTrialIntegrationTests {

	@Autowired
    private WebTestClient webTestClient;

    @Test
    public void test1() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2020-06-14-10.00.00&brandId=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(PriceDTO.class)
        .value(response -> {
        	assertTrue(response.getPrice().equals(35.5));
        });
    }
    
    @Test
    public void test2() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2020-06-14-16.00.00&brandId=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(PriceDTO.class)
        .value(response -> {
        	assertTrue(response.getPrice().equals(25.45));
        });
    }
    
    @Test
    public void test3() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2020-06-14-21.00.00&brandId=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(PriceDTO.class)
        .value(response -> {
        	assertTrue(response.getPrice().equals(35.5));
        });
    }
    
    @Test
    public void test4() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2020-06-15-10.00.00&brandId=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(PriceDTO.class)
        .value(response -> {
        	assertTrue(response.getPrice().equals(30.5));
        });
    }
    
    @Test
    public void test5() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2020-06-16-21.00.00&brandId=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(PriceDTO.class)
        .value(response -> {
        	assertTrue(response.getPrice().equals(38.95));
        });
    }
    
    @Test
    public void test6() {
        
        webTestClient.get().uri("/inditex/price/35456?date=2020-06-16-21.00.00&brandId=1")
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(ErrorDTO.class)
        .value(response -> {
        	assertTrue(response.getErrorMessage().equals("No existe esa combinacion producto/cadena"));
        });
    }
    
    @Test
    public void test7() {
        
        webTestClient.get().uri("/inditex/price/35455?date=2021-06-16-21.00.00&brandId=1")
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(ErrorDTO.class)
        .value(response -> {
        	assertTrue(response.getErrorMessage().equals("No hay un precio definido para esa fecha"));
        });
    }

}
