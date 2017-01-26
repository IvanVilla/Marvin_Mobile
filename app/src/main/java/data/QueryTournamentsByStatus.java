package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.host.TournamentHost;
import model.tournament.Tournament;
import model.tournament.TournamentSystem;
import model.utils.MyDate;

/**
 * Returns the tournaments with a status
 * Created by klaus on 26/01/2017.
 */

public class QueryTournamentsByStatus extends Connection {
    private ArrayList<Tournament> queryResult = new ArrayList<>();
    private final static String PHP_QUERY_FILE = "tournamentsQuery.php";
    private String status;

    public QueryTournamentsByStatus(String status){
        this.status=status;
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
            params.put(REQUEST_NAME,"getTournamentsByStatus"); // Custom Search
            params.put("status",status);
            byte[] postDataBytes = putParams(params); // Aux Method to make post

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // "Only Json Objects

            // MAKE OBJECTS
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e("Tournaments","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the objects Tournament from Array
     * @param jarray
     */
    private void makeFromJson(JsonArray jarray){
        for (int i=0; i<jarray.size(); i++){
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            QueryTournamentById queryTournamentById = new QueryTournamentById(jsonobject.get("idTOURNAMENT").getAsInt());
            queryTournamentById.executeQuery();
            this.queryResult.add(queryTournamentById.getQueryResult());
        }
    }

    /**
     * The result of the query
     * @return result of the query
     */
    public ArrayList<Tournament> getQueryResult() {
        return queryResult;
    }
}
