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
 * Given a publicName, we delete the user on the server side
 * Created by Klaussius on 14/12/2016.
 */

public class QueryDeleteAccount extends Connection {
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private int idUser;
    private int deleteRowsNum;

    public QueryDeleteAccount(String publicName)
    {
        this.idUser = getUserId(publicName);
    }

    /**
     * Post the request to insert the user
     */
    public void executeQuery() {
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
