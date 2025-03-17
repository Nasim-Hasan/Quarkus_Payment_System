package acme.org;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class TransactionResourceTest {
    @Test
    void testListAllTransactions(){
        given()
                .when().get("/payment_transactions")
                .then()
                .statusCode(200)
                .body("size()", notNullValue());
    }

    @Test
    void testSingleTransaction(){
        given()
                .when().post("/payment_transactions")
                .then()
                .statusCode(500);
    }
}
