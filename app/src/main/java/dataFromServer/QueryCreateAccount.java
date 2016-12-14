package dataFromServer;

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
 * Created by Klaussius on 14/12/2016.
 */

public class QueryCreateAccount extends Connection{
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private String queryURL;
    private User user;
    private int insertionId;

    public QueryCreateAccount(User user){
        this.user=user;
    }

    /**
     * Post the request to insert the user
     */
    public void createAccount() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("requestName","insertItem");
            params.put("fields","[\"name\",\"publicName\",\"password\",\"phone\",\"eMail\"]");
            params.put("values","[\""+user.getName()+"\",\""+user.getPublicName()+"\",\""+user.getPassword()+"\",\""+user.getPhone()+"\",\""+user.geteMail()+"\"]");
            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Error","Sending data");
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
        this.insertionId = jsonObject.get("insertionId").getAsInt();
    }

    /**
     * Get the insertion id
     * @return insertion id
     */
    public int getInsertionId() {
        return insertionId;
    }
}
