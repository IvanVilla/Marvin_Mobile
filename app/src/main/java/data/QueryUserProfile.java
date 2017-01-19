package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import model.user.User;

/**
 * Retrieve the user's data
 * @autor Iván Villa
 */

public class QueryUserProfile extends Connection {
    private User queryResult;
    private String publicName;
    private final static String PHP_QUERY_FILE = "usersQuery.php";

    public QueryUserProfile (String publicName){
        this.publicName=publicName;
        executeQuery();
    }

    /**
     * Post the request, and get the data to our model's objects
     */
    public void executeQuery() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(REQUEST_NAME,CUSTOM_SEARCH);
            params.put(FIELDS,"[\"idUser\",\"name\",\"publicName\", \"phone\",\"eMail\"]");
            params.put(FILTER_FIELDS,"[publicName]");
            params.put(FILTER_ARGUMENTS,"[\""+this.publicName+"\"]");

            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("User Profile","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        User user = new User();
        user.setId(jsonObject.get("idUser").getAsInt());
        user.setName(jsonObject.get("name").getAsString());
        user.setPublicName(jsonObject.get("publicName").getAsString());
        user.setPhone(jsonObject.get("phone").getAsString());
        user.seteMail(jsonObject.get("eMail").getAsString());
        queryResult=user;
    }

    /**
     * Result of the query
     * @return result of the query
     */
    public User getQueryResult() {
        return queryResult;
    }
}
