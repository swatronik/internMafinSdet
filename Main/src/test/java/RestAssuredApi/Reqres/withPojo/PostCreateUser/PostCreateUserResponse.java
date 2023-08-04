package RestAssuredApi.Reqres.withPojo.PostCreateUser;

import java.util.Date;

public class PostCreateUserResponse {

    private final String name;
    private final String job;
    private final String id;
    private final Date createdAt;

    public PostCreateUserResponse(String name, String job, String id, Date createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}