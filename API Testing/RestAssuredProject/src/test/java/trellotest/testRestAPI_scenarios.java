package trellotest;


import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.*;
import org.json.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;


public class testRestAPI_scenarios {
	
	@Test
	public void test() throws UnirestException
	{
	
		// Create new board 
		
	HttpResponse<String> response = Unirest.post("https://api.trello.com/1/boards/")
			  .queryString("name", "{Clean the house}")         //Name the new board to be created
			  .queryString("key", "2593eee476af07a8d228b30a42e3d623") // Pass the APIKey value here
			  .queryString("token", "Token")                         // Pass the Token value here
			  .asString();

			System.out.println("Board body " + response.getBody()); //Print the response body
			assertEquals(200, response.getStatus());                //Verify the status code
			 
	}		
	
	
	
	//@Test  //Remove the comments to execute this test
	public void test1() throws UnirestException
	{
	
		// Get board details
		
		HttpResponse<String> response = Unirest.get("https://api.trello.com/1/boards/{id}")
				.routeParam("id", "63f3db7d9a3b3e1920354eea")     // Pass the board id to get details
						  .header("Accept", "application/json")
						  .queryString("key", "2593eee476af07a8d228b30a42e3d623") // Pass the APIKey value here
						  .queryString("token", "Token") // Pass the Token value here
						  .asString();

						System.out.println(response.getBody());  //Print the response body
						assertEquals(200, response.getStatus());  //Verify the status code
			
	}		
	
	//@Test  //Remove the comments to execute this test
	public void test2() throws UnirestException

	{
		//Create List in the board mentioned 
		
	HttpResponse<String> response = Unirest.post("https://api.trello.com/1/boards/{idBoard}/lists")
			
	  .routeParam("idBoard", "63f3db7d9a3b3e1920354eea")  // Pass the board id where the list has to be created
			
	  .queryString("name", "Rice Menu")
	  .queryString("key", "2593eee476af07a8d228b30a42e3d623") // Pass the APIKey value here
	  .queryString("token", "Token") // Pass the Token value here
	  .asString();

	System.out.println(response.getBody());    //Print the response body
	assertEquals(200, response.getStatus());  //Verify the status code

	}
	
	
	//@Test   //Remove the comments to execute this test
	public void test3() throws UnirestException

	{
		//Delete a board 
		
		HttpResponse<String> response = Unirest.delete("https://api.trello.com/1/boards/{id}")
				.routeParam("id", "63f359a6d1c24e3210f8b054")      // Pass the board id to be deleted
				  .queryString("key", "2593eee476af07a8d228b30a42e3d623") // Pass the APIKey value here
				  .queryString("token", "Token")                           // Pass the Token value here
				  .asString();

				System.out.println(response.getBody());    //Print the response body   
				assertEquals(200, response.getStatus());    //Verify the status code

	}
	
	

	//@Test   //Remove the comments to execute this test
	public void test4() throws UnirestException

	{
		//Create a card in the list mentioned
		
		HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/lists/{id}/cards")
				  .routeParam("id", "63f4b6ac3d0afcb69d6c016b") // Pass the list id where the card has to be created
				  .header("Accept", "application/json")
				  .queryString("name", "Lemon rice")
				  .queryString("key", "2593eee476af07a8d228b30a42e3d623") // Pass the APIKey value here
				  .queryString("token", "Token")                          // Pass the Token value here
				  .asJson();

				System.out.println(response.getBody());    //Print the response body
				
				assertEquals(200, response.getStatus());   //Verify the status code

	}
	
	
   //@Test  //Remove the comments to execute this test
	public void test5() throws UnirestException

	{
		//Delete a card using card id
		
		HttpResponse<String> response = Unirest.delete("https://api.trello.com/1/cards/{id}")
				  .routeParam("id", "63f4b8ffa5422cb840868cc7")  // Pass the card id to be deleted
				  .queryString("key", "APIKey")  // Pass the APIKey value here
				  .queryString("token", "Token")  // Pass the Token value here
				  .asString();

				System.out.println(response.getBody());      //Print the response body
				assertEquals(200, response.getStatus());     //Verify the status code

	}
	

}
