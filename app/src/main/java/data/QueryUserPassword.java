package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Authentication on server side
 * @autor Iván Villa
 */

public class QueryUserPassword extends Connection {
    private int queryResult;
    private String name;
    private String password;
    private final static String PHP_QUERY_FILE = "usersQuery.php";

    public QueryUserPassword (String name, String password){
        this.name=name;
        this.password=password;
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
            params.put(REQUEST_NAME,USER_LOGIN); // Get all the values
            params.put(USER_NAME,this.name);
            params.put(USER_PASSWORD,this.password);

            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // "Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("User/Password","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the objects Tournament from Array
     * @param jarray
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        queryResult=jsonObject.get("loginResult").getAsInt();
    }

    /**
     * Result of the query
     * @return result of the query
     */
    public int getQueryResult() {
        return queryResult;
    }
}
