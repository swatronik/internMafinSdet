package RestAssuredApi.Reqres.withPojo.GetSingleUser;

public class GetSingleUserPojo {

    public String URL_MAIN = "https://reqres.in/";
    public String USER_ONE = "/api/users/1";

    public class Data{
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public Data(Integer id, String email, String first_name, String last_name, String avatar) {
            this.id = id;
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getAvatar() {
            return avatar;
        }
    }

    public class Root{
        public Data data;
        public Support support;

        public Root(Data data, Support support) {
            this.data = data;
            this.support = support;
        }

        public Data getData() {
            return data;
        }

        public Support getSupport() {
            return support;
        }
    }

    public class Support{
        public String url;
        public String text;

        public Support(String url, String text) {
            this.url = url;
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }
    }
}
