package services;

import io.restassured.response.Response;
import requestModels.LoginRequest;
import requestModels.SignUpRequest;

public class AuthService extends BaseService {
	
	private static final String BASE_PATH = "/api/auth";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "/login");
	}
	
	public Response signUp(SignUpRequest payload) {
		return postRequest(payload, BASE_PATH + "/signup");
	}
	

}
