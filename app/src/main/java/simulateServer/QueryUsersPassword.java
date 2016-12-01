package simulateServer;

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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.user.User;
import dataFromServer.Connection;

/**
 * This class is only for the prototype purpouse, on further versions the authentication will be on
 * the server side.
 * @autor Iván Villa
 */

public class QueryUsersPassword extends Connection {
    private List<User> queryResult = new ArrayList<>();
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private String queryURL="";

    /**
     * Post the request, and get the data to our model's objects
     */
    public void findAll() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("",""); // Get all the values
            //params.put("fields[0]", "idTournament");
            //params.put("fields[1]", "name");
            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // "Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Error","Retrieving data");
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
     * Make the objects Tournament from Array
     * @param jarray
     */
    private void makeFromJson(JsonArray jarray){
        for (int i=0; i<jarray.size(); i++){
            User user = new User();
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            user.setName(jsonobject.get("publicName").getAsString());
            user.setPassword(jsonobject.get("password").getAsString());
            this.queryResult.add(user);
        }
    }

    /**
     * Result of the query
     * @return result of the query
     */
    public List<User> getQueryResult() {
        return queryResult;
    }
}
