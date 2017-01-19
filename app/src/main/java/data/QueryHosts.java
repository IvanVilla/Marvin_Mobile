package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import model.host.TournamentHost;
import model.utils.GPS;

/**
 * Connect and retrieve the hosts
 * @author Iván Villa
 */
public class QueryHosts extends Connection{

    private TournamentHost queryResult = new TournamentHost();
    private final static String PHP_QUERY_FILE = "hostsQuery.php";
    private int idTournamentHost;

    public QueryHosts(int idTournamentHost){
        this.idTournamentHost=idTournamentHost;
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
            params.put(REQUEST_NAME,CUSTOM_SEARCH); // Get all the values
            params.put(FIELDS,"[\"name\",\"phone\",\"adress\",\"eMail\",\"latitude\",\"longitude\"]");
            params.put(FILTER_FIELDS,"\"idTournamentHost\"");
            params.put(FILTER_ARGUMENTS,this.idTournamentHost);
            //params.put("param2", "getAllUser");
            //params.put("param3", "Prototip");
            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // "Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Hosts","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the objects TournamentHosts from Array
     * @param jarray
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonobject = jarray.get(0).getAsJsonObject();
        this.queryResult.setName(jsonobject.get("name").getAsString());
        this.queryResult.setPhone(jsonobject.get("phone").getAsString());
        this.queryResult.setAdress(jsonobject.get("adress").getAsString());
        this.queryResult.seteMail(jsonobject.get("eMail").getAsString());
        // GPS of the host
        GPS gps = new GPS();
        gps.setLatitude(jsonobject.get("latitude").getAsFloat());
        gps.setLongitude(jsonobject.get("longitude").getAsFloat());
        queryResult.setGps(gps);
        Log.i("Host",this.queryResult.getName()+" "+this.queryResult.getPhone()+" "+this.queryResult.getAdress()+" "+this.queryResult.geteMail()+" "+this.queryResult.getGps().getLatitude()+" "+this.queryResult.getGps().getLongitude());
    }

    /**
     * Returns the query result
     * @return the query result
     */
    public TournamentHost getQueryResult() {
        return queryResult;
    }
}