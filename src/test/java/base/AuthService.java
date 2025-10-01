package base;

import io.restassured.response.Response;
import requestModels.LoginRequest;

public class AuthService extends BaseService {
	
	private static final String BASE_PATH = "/api/auth";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "/login");
	}
	

}
