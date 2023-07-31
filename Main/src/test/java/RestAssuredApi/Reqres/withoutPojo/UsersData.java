package RestAssuredApi.Reqres.withoutPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersData {

    public String URL_MAIN = "https://reqres.in/";
    public String USERS_LIST_PAGE1 = "/api/users?page=1";
    public String USER_TWO = "/api/users/5";
    public String REGISTER_USER_API = "/api/register";

    public List<String> getFirstNameDataList() {
        List<String> first_name_Data = new ArrayList<>();
        first_name_Data.add("George");
        first_name_Data.add("Janet");
        first_name_Data.add("Emma");
        first_name_Data.add("Eve");
        first_name_Data.add("Charles");
        first_name_Data.add("Tracey");
        return first_name_Data;
    }

    public List<String> getLastNameDataList() {
        List<String> last_name_Data = new ArrayList<String>();
        last_name_Data.add("Bluth");
        last_name_Data.add("Weaver");
        last_name_Data.add("Wong");
        last_name_Data.add("Holt");
        last_name_Data.add("Morris");
        last_name_Data.add("Ramos");
        return last_name_Data;
    }

    public Map<String, String> getRegistrationUserDataList() { //json в запросе отправляется как хэшмап
        Map<String, String> registrationUserData = new HashMap<>();
        registrationUserData.put("email", "eve.holt@reqres.in");
        registrationUserData.put("password", "pistol");
        return registrationUserData;
    }
}
