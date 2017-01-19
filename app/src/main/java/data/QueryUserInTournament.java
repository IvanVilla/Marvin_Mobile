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
 * To know if our user is in a tournament
 * Created by Klaussius on 17/01/2017.
 */

public class QueryUserInTournament extends Connection{
    private final static String PHP_QUERY_FILE = "tournamentsQuery.php";
    private int idUser;
    private int idTournament;
    private boolean signed;

    public QueryUserInTournament(String publicName, int idTournament){
        this.idUser = getUserId(publicName);
        this.idTournament = idTournament;
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
            params.put(REQUEST_NAME,"tournamentHasUser");
            params.put("tournamentId",idTournament);
            params.put("userId",idUser);
            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("User in Tournament","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        this.signed = jsonObject.get("tournamentHasUser").getAsBoolean();
    }

    /**
     * Get the insertion id
     * @return insertion id
     */
    public boolean getSigned() {
        return signed;
    }
}
