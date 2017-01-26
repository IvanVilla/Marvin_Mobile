package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import model.benefit.Prize;

/**
 * Retuns user's prizes
 * Created by Klaussius on 17/01/2017.
 */

public class QueryUserPrizes extends Connection {
    private final static String PHP_QUERY_FILE = "prizesQuery.php";
    private int idUser;
    private ArrayList<Prize> queryResult;

    public QueryUserPrizes(String publicName){
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
            params.put(REQUEST_NAME,CUSTOM_SEARCH);
            params.put(FIELDS,"[\"name\",\"description\"]");
            params.put(FILTER_FIELDS,"\"USER_idUSER\"");
            params.put(FILTER_ARGUMENTS,"\""+idUser+"\"");

            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("User Prizes","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        queryResult=new ArrayList<>();
        for (int i=0; i<jarray.size(); i++){
            Prize prize = new Prize(); // For the prize
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            prize.setName(jsonobject.get("name").getAsString());
            prize.setDescription(jsonobject.get("description").getAsString());
            // We add the object prize
            this.queryResult.add(prize);
        }
    }

    /**
     * Get the result of the query
     * @return queryResult
     */
    public ArrayList<Prize> getQueryResult() {
        return queryResult;
    }
}
