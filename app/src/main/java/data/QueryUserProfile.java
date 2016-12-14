package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import model.user.User;

/**
 * Retrieve the user's data
 * @autor Iván Villa
 */

public class QueryUserProfile extends Connection {
    private User queryResult;

    private String name;
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private String queryURL;

    public QueryUserProfile (String name){
        this.name=name;
        retrieveAnswer();
    }

    /**
     * Post the request, and get the data to our model's objects
     */
    public void retrieveAnswer() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("requestName","customSearch");
            params.put("fields","[\"idUser\",\"name\",\"publicName\", \"phone\",\"eMail\"]");
            params.put("filterFields","[publicName]");
            params.put("filterArguments","[\""+this.name+"\"]");

            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Error","Retrieving data");
        } finally {
            close();
        }
    }

    /**
     * Build the POST message to send to PHP server
     * @param params parameters of the webservice
     * @return byte[] with the parameters
     */
    private byte[] putParams(Map<String, Object> params) {
        byte[] postDataBytes = null;
        try {
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            postDataBytes = postData.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        return postDataBytes;
    }

    /**
     * Process the JSON and retorn an JSON array to build the objects
     * @param in Reader from the connection
     * @param node Name of the JSON object, null if it's one array
     * @return The array of JSON objects
     */
    private JsonArray getArrayFromJson (Reader in, String node){
        JsonArray jarray = null;
        JsonElement jelement = new JsonParser().parse(in);
        if ( node != null){
            JsonObject jobject = jelement.getAsJsonObject();
            jarray = jobject.getAsJsonArray(node);
        } else {
            jarray = jelement.getAsJsonArray();
        }
        return jarray;
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
