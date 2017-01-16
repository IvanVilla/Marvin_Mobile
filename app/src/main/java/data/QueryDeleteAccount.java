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
 * Given a publicName, we delete the user on the server side
 * Created by Klaussius on 14/12/2016.
 */

public class QueryDeleteAccount extends Connection {
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private String queryURL;
    private int idUser;
    private int deleteRowsNum;

    public QueryDeleteAccount(String publicName)
    {
        // We get the user id
        QueryUserProfile queryUserProfile = new QueryUserProfile(publicName);
        User user = queryUserProfile.getQueryResult();
        idUser = user.getId();
    }

    /**
     * Post the request to insert the user
     */
    public void deleteAccount() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(REQUEST_NAME,DELETE_ITEM);
            params.put(ITEM_ID,"\""+idUser+"\"");
            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Delete user","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        this.deleteRowsNum = jsonObject.get("deleteRowsNum").getAsInt();
    }

    /**
     * Get the number of rows deleted
     * @return number of rows deleted
     */
    public int getDeleteRowsNum() {
        return deleteRowsNum;
    }

    /**
     * Get the user id
     * @return user id
     */
    public int getIdUser() { return idUser; }
}
