package RestAssuredApi.Reqres.withPojo.GetListUsers;

import java.util.ArrayList;

public class GetListUsers {

    public class Datum{
        private final Integer id;
        private final String email;
        private final String first_name;
        private final String last_name;
        private final String avatar;

        public Datum(Integer id, String email, String first_name, String last_name, String avatar) {
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

    public class Root{
        private final Integer page;
        private final Integer per_page;
        private final Integer total;
        private final Integer total_pages;
        private final ArrayList<Datum> data;
        private final Support support;

        public Root(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<Datum> data, Support support) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
            this.data = data;
            this.support = support;
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

        public ArrayList<Datum> getData() {
            return data;
        }

        public Support getSupport() {
            return support;
        }
    }

    public class Support{
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
