package uiScripts;

import static io.restassured.RestAssured.given;

import java.math.BigInteger;

import org.testng.annotations.Test;

import com.google.common.math.BigIntegerMath;

import org.json.*;  

public class APIScript {

	@Test
	public void getAPI() {
	// TODO Auto-generated method stub
		
		String str = "{\"isbn\":\"9781449325862\",\"title\":\"Git Pocket Guide\",\"subTitle\":\"A Working Introduction\",\"author\":\"Richard E. Silverman\",\"publish_date\":\"2020-06-04T08:48:39.000Z\",\"publisher\":\"O'Reilly Media\",\"pages\":234,\"description\":\"This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp\",\"website\":\"http://chimera.labs.oreilly.com/books/1230000000561/index.html\"}";
		long n = 9781449325862L;		
		JSONObject obj = new JSONObject("{\"isbn\":\"9781449325862\",\"title\":\"Git Pocket Guide\",\"subTitle\":\"A Working Introduction\",\"author\":\"Richard E. Silverman\",\"publish_date\":\"2020-06-04T08:48:39.000Z\",\"publisher\":\"O'Reilly Media\",\"pages\":234,\"description\":\"This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp\",\"website\":\"http://chimera.labs.oreilly.com/books/1230000000561/index.html\"}");
		
		System.out.println(obj.get("title"));
	Object isbnValue = obj.get("title");
	
	if(obj.get("title") instanceof String)	
	{
		System.out.println("Its a String");
	}
	
	if(obj.get("pages") instanceof Number)
	{
		System.out.println("Its a number");
	}
	
	
		//System.out.println(Character.isDigit((Character) obj.get("isbn")));
		
		//System.out.println(str);
//		
//		given().
//		when().
//		get("https://bookstore.toolsqa.com/BookStore/v1/Books").
//		then().assertThat().statusCode(200);
	}

}
