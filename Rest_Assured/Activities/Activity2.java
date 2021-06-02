package Activities;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.AfterClass;

public class Activity2 {
	
	
	final static String ROOT_URI = "https://petstore.swagger.io/v2/user";
	
  @Test
  public void Test1() throws IOException {
	 
	  FileInputStream inputJSONFile = new FileInputStream("C:\\Users\\IBMADMIN\\eclipse-workspace\\RESTAssured_Project\\src\\test\\java\\TestFiles\\userinfo.json");
      String POSTreqBody = new String(inputJSONFile.readAllBytes());

      System.out.println(POSTreqBody);
      
      Response response = 
          given().contentType(ContentType.JSON)
          .body(POSTreqBody)
          .when().post(ROOT_URI);

      inputJSONFile.close();

      // Assertion
      response.then().body("code", equalTo(200));
      response.then().body("message", equalTo("92915"));
  }  
  
  @Test
  public void Test2() {
	  File outputJSON = new File("C:\\Users\\IBMADMIN\\eclipse-workspace\\RESTAssured_Project\\src\\test\\java\\TestFiles\\GetResponseActivity2");
	  
	  
      Response response = 
    		  given().contentType(ContentType.JSON) // Set headers
              .pathParam("username", "Jason1") // Pass request body from file
              .when().get(ROOT_URI + "/{username}");
      
      String resBody = response.getBody().asPrettyString();
      
      try {
          outputJSON.createNewFile();
          FileWriter writer = new FileWriter(outputJSON.getPath());
          writer.write(resBody);
          writer.close();
      } 
      catch (IOException excp) {
          excp.printStackTrace();
      }
      
      // Assertion
      response.then().body("id", equalTo(9901));
      response.then().body("username", equalTo("justinc"));
      response.then().body("firstName", equalTo("Justin"));
      response.then().body("lastName", equalTo("Case"));
      response.then().body("email", equalTo("justincase@mail.com"));
      response.then().body("password", equalTo("password123"));
      response.then().body("phone", equalTo("9812763450"));
	  
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
