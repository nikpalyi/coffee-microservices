//package com.np.coffeeeurekaserver;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//class CoffeeEurekaServerApplicationTests {
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Test
//	void eurekaServerIsRunning() {
//		ResponseEntity<String> response = restTemplate.getForEntity("/actuator/health", String.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//	}
//
//	@Test
//	void eurekaServerReturnsNotFoundForInvalidEndpoint() {
//		ResponseEntity<String> response = restTemplate.getForEntity("/invalid-endpoint", String.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//	}
//}
