package acme.org;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PaymentResourceTest {
    @Test
    void testListAllProviders(){
        //List all the 4 initial providers
        given()
                .when().get("/payment_providers")
                .then()
                .statusCode(200)
                .body(
                        containsString("USA"),
                        containsString("UK"),
                        containsString("Bangladesh"),
                        containsString("Turkey"));
        //..Deleting the provider whose ID is 1 (USA)
        given()
                .when().delete("payment_providers/delete/1")
                .then()
                .statusCode(200);
       //...Now USA won't be in the list
        given()
                .when().get("/payment_providers")
                .then()
                .statusCode(200)
                .body(
                        not(containsString("USA")),
                        containsString("UK"),
                        containsString("Bangladesh"),
                        containsString("Turkey")
                );
    }
@Test
    void testRegistration(){
        //Registering a new provider
        assertEquals(5,Integer.parseInt(given()
                .when().post("/payment_providers/registration")
                .then()
                .statusCode(200)
                .body("id",notNullValue())
                .extract().body().jsonPath().getString("id")));


    }
}


