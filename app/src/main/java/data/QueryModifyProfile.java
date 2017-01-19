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
 * Modify data from one profile
 * Created by Klaussius on 15/12/2016.
 */
public class QueryModifyProfile extends Connection{
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private User user;
    private int modifiedRowsNum;

    public QueryModifyProfile(User user){
        this.user=user;
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
            params.put(REQUEST_NAME,MODIFY_ITEM);
            params.put(ITEM_ID,user.getId());

            if (user.getPassword()!=""){
                params.put(FIELDS,"[\"name\",\"password\",\"phone\",\"eMail\"]");
                params.put(VALUES,"[\""+user.getName()+"\",\""+user.getPassword()+"\",\""+user.getPhone()+"\",\""+user.geteMail()+"\"]");
            } else {
                params.put(FIELDS,"[\"name\",\"phone\",\"eMail\"]");
                params.put(VALUES,"[\""+user.getName()+"\",\""+user.getPhone()+"\",\""+user.geteMail()+"\"]");
            }
            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Modify Profile","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        this.modifiedRowsNum = jsonObject.get("modifiedRowsNum").getAsInt();
    }

    /**
     * Get the insertion id
     * @return insertion id
     */
    public int getModifiedRowsNum() {
        return modifiedRowsNum;
    }
}
