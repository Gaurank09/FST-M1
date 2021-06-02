package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
    
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void addNewPet() {
        String reqBody = "{"
            + "\"id\": 783838,"
            + "\"name\": \"Boston\","
            + " \"status\": \"alive\""
        + "}";

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .body(reqBody) // Add request body
            .when().post(ROOT_URI); // Send POST request

        // Assertion
        response.then().body("id", equalTo(783838));
        response.then().body("name", equalTo("Boston"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=2)
    public void getPetInfo() {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().pathParam("petId", "783838") // Set path parameter
            .get(ROOT_URI + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(783838));
        response.then().body("name", equalTo("Boston"));
        response.then().body("status", equalTo("alive"));
    }
    
    @Test(enabled = false)
    public void deletePet() {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().pathParam("petId", "783838") // Set path parameter
            .delete(ROOT_URI + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("783838"));
    }
}