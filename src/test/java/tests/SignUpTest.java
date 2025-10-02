package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import requestModels.SignUpRequest;
import services.AuthService;

public class SignUpTest {
	
	@Test
	public void verifySignUpRequest() {
		
//		SignUpRequest signUpRequest = new SignUpRequest();
//		signUpRequest.setUsername("vamshi");
//		signUpRequest.setPassword("vamshi123");
//		signUpRequest.setFirstName("vamshi");
//		signUpRequest.setLastName("krishna");
//		signUpRequest.setEmail("vamshibilla211@gmail.com");
//		signUpRequest.setMobileNumber("8712145400");
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.username("vamshi123")
				.password("vamshi123")
				.firstName("vamshi")
				.lastName("krishna")
				.email("vamshibilla211@gmail.com")
				.mobileNumber("8712145400")
				.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println("Actual response:\n" + response.asPrettyString());
	}

}
