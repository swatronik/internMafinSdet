package RestAssuredApi.Reqres.withPojo.GetListUsers;

//это в будещем переделать с помощью аннотаций lombok

public class GetListUsersPojo {

    public String URL_MAIN = "https://reqres.in/";
    public String USERS_LIST_PAGE1 = "/api/users?page=1";

    public class UserData {
        private Integer id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public UserData(Integer id, String email, String first_name, String last_name, String avatar) {
            this.id = id;
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }

        public Integer getId() {
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
        private Integer page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private Support support;

        public Root(Integer page, Integer per_page, Integer total, Integer total_pages, Support support) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
            this.support = support;
        }

        public Root(Integer page, Integer per_page, Integer total, Integer total_pages) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
        }

        public Integer getPage() {
            return page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public Integer getTotal() {
            return total;
        }

        public Integer getTotal_pages() {
            return total_pages;
        }

        public Support getSupport() {
            return support;
        }
    }

    public class Support {
        private String url;
        private String text;

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