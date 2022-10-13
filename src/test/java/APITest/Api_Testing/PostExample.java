package APITest.Api_Testing;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostExample {
	
	
	public static void main(String [] args)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").body(body.bodydata())
				.when().log().all().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Response is:"+response);
		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		
		
		
		String addressResponse = given().queryParam("key", "qaclick123").queryParam("place_id", ""+placeid).body(
				"{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\"6/50 Manthoppu street\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}"
				).when().put("/maps/api/place/update/json").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js2 = new JsonPath(addressResponse);
		String Newaddress = js2.getString("address");
		System.out.println(Newaddress);
		
		String getResppnse = given().queryParam("key", "qaclick123").queryParam("place_id", ""+placeid).when().get("/maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().response().asString();
				
				System.out.println("Get Response is:"+getResppnse);
				JsonPath js1 = new JsonPath(getResppnse);
				String address = js1.getString("address");
				System.out.println(address);
		
	}

}
