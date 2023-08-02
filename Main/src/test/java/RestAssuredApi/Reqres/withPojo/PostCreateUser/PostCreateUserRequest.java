package RestAssuredApi.Reqres.withPojo.PostCreateUser;

public class PostCreateUserRequest {

    public String URL_MAIN = "https://reqres.in/";
    public String CREATE_USER_API = "/api/users";

    public String name;
    public String job;

    public PostCreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public PostCreateUserRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}