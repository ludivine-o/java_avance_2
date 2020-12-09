package fr.ecolenum.testspring;

import fr.ecolenum.testspring.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		String body = this.restTemplate.getForObject("/cars", String.class);
		assertEquals("{\"0\":{\"brand\":\"Bentley\",\"model\":\"Continental GT\",\"color\":\"Black\",\"id\":0},\"1\":{\"brand\":\"Aston Martin\",\"model\":\"DB9\",\"color\":\"Grey\",\"id\":1},\"2\":{\"brand\":\"Oldsmobile\",\"model\":\"Rocket88\",\"color\":\"Black\",\"id\":2},\"3\":{\"brand\":\"BMW\",\"model\":\"R1200C\",\"color\":\"Grey\",\"id\":3}}\n", body);
	}

	@Test
	public void shouldAddNewCar() {
		Car newcar = new Car(4, "Opel", "Zafira", "caca d'oie");
		this.restTemplate.postForObject("/cars", newcar, String.class);
		String body = this.restTemplate.getForObject("/cars/4", String.class);
		assertEquals("{\"brand\":\"Opel\",\"model\":\"Zafira\",\"color\":\"caca d'oie\",\"id\":3}", body);
	}

	@Test
	public void shouldModifyACar() {
		Car newcar = new Car(4, "Opel", "Zafira", "Rose pailleté");
		this.restTemplate.put("/cars/4", newcar, String.class);
		String body = this.restTemplate.getForObject("/cars/4", String.class);
		assertEquals("{\"brand\":\"Opel\",\"model\":\"Zafira\",\"color\":\"Rose pailleté\",\"id\":3}", body);
	}

	@Test
	public void shouldDeleteACar() {
		this.restTemplate.delete("/cars/3");
		String body = this.restTemplate.getForObject("/cars/3", String.class);
		assertEquals(null, body);
	}

}
