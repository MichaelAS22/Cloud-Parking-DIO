package one.digitalinnovation.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import one.digitalinnovation.controller.dto.ParkingCreateDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT extends AbstractContainerBase{

	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	void setUpTest() {
		System.out.println(randomPort);
		RestAssured.port = randomPort;
	}
	
	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given()
				.header("Authorization", "Basic dXNlcjpEaW9AMTIzNDU2")
				.when()
				.get("/parking")
				.then()
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	void whenCreateThenCheckIsCreated() {
		
		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMARELO");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("BRASILIA");
		createDTO.setState("SP");
		
		RestAssured.given()
				.header("authorization"," Basic dXNlcjpEaW9AMTIzNDU2")
				.when()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(createDTO)
				.post("/parking")
				.then()
				.statusCode(HttpStatus.CREATED.value())
				.body("license", Matchers.equalTo("WRT-5555"))
				.body("color", Matchers.equalTo("AMARELO"));
	}	
	
	@Test
	void findAll() {
	}
	
	@Test
	void create() {
	}
	
}

