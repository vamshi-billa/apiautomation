package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.AuthService;
import io.restassured.response.Response;
import requestModels.LoginRequest;
import responseModels.LoginResponse;

public class LoginTest {

	@Test
	public void verifyLogin() {
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getId(), 1);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
	}
}
