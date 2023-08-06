package RestAssuredApi.Reqres.withPojo.GetSingleUser;

public class GetSingleUser {

    public class Data {
        private final Integer id;
        private final String email;
        private final String first_name;
        private final String last_name;
        private final String avatar;

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

    public class Root {
        private final Data data;
        private final Support support;

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

    public class Support {
        private final String url;
        private final String text;

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
