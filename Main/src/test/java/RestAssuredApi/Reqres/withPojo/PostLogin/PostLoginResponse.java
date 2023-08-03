package RestAssuredApi.Reqres.withPojo.PostLogin;

public class PostLoginResponse {
    private String token;

    public PostLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}