package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import listeners.TestListener;
import requestModels.LoginRequest;
import responseModels.LoginResponse;
import services.AuthService;

@Listeners(TestListener.class)
public class LoginTest {

	@Test
	public void verifyLogin() {
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getId(), 1);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
	}
}
