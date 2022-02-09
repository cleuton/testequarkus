package guru.desenvolvedor.wbindex;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class PaisTest {

	@Test
	public void testeListaPaises() {
		given()
			.when().get("/pais")
				.then()
					.statusCode(200);
	}
}
