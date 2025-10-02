package services;

import static io.restassured.RestAssured.given;

import filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	/* Wrapper Class for Rest Assured (Abstraction)
	 * handles:
	 * 	baseURI
	 * 	creating the request
	 * 	response
	 */
	
	public static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification reqSpec;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		this.reqSpec = given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return reqSpec.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

}
