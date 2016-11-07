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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.tournament.Tournament;

/**
 * @author Klaussius
 */

public class QueryTournaments extends Connection{
    private List<Tournament> queryResult = new ArrayList<>();
    private final static String URL_QUERY = "http://10.0.2.2/api/tournamentsQueryOld.php";

    /**
     * Post the request, and get the data to our model's objects
     */
    public void findAll() {
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(URL_QUERY);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("user",""); // Get all the values
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
            Tournament tournament = new Tournament();
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            tournament.setId(jsonobject.get("idTOURNAMENT").getAsInt());
            tournament.setName(jsonobject.get("name").getAsString());
            tournament.setPublicDes(jsonobject.get("publicDes").getAsString());
            this.queryResult.add(tournament);
        }
    }

    /**
     * The result of the query
     * @return result of the query
     */
    public List<Tournament> getQueryResult() {
        return queryResult;
    }
}