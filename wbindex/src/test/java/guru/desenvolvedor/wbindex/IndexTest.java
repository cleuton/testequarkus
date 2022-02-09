package guru.desenvolvedor.wbindex;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class IndexTest {
	@Test
	public void testeListaPaises() {
		given()
			.when().get("/index/CHN")
				.then()
					.statusCode(200);
	}
}
