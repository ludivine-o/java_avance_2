package fr.ecolenum.testspring;

import fr.ecolenum.testspring.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JavaAvance2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldFindAllCars() {
		String body = restTemplate.getForObject("/cars", String.class);
		assertEquals("[{\"id\":0,\"brand\":\"Bentley\",\"model\":\"Black\",\"color\":\"Continental GT\"},{\"id\":2,\"brand\":\"OldsMobile\",\"model\":\"Black\",\"color\":\"Rocket88\"},{\"id\":3,\"brand\":\"BMW\",\"model\":\"Grey\",\"color\":\"R1200C\"}]", body);
	}

	@Test
	public void shouldAddNewCar() {
		Car newcar = new Car(1, "Opel", "Zafira", "caca d'oie");
		this.restTemplate.postForObject("/cars", newcar, String.class);
		String body = restTemplate.getForObject("/cars/1", String.class);
		assertEquals("{\"id\":1,\"brand\":\"Opel\",\"model\":\"Zafira\",\"color\":\"caca d'oie\"}", body);
	}

	@Test
	public void shouldModifyACar() {
		Car newcar = new Car(1, "Opel", "Zafira", "Rose pailleté");
		this.restTemplate.put("/cars/4", newcar, String.class);
		String body = restTemplate.getForObject("/cars/1", String.class);
		assertEquals("{\"id\":1,\"brand\":\"Opel\",\"model\":\"Zafira\",\"color\":\"Rose pailleté\"}", body);
	}

	@Test
	public void shouldDeleteACar() {
		this.restTemplate.delete("/cars/1");
		String body = restTemplate.getForObject("/cars/1", String.class);
		assertEquals(null, body);
	}

}
