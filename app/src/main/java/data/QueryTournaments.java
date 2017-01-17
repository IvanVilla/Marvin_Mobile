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

/**
 * Connect and retrieve the tournaments
 * @author Iván Villa
 */
public class QueryTournaments extends Connection{
    private List<Tournament> queryResult = new ArrayList<>();
    private final static String PHP_QUERY_FILE = "tournamentsQuery.php";

    /**
     * Post the request, and get the data to our model's objects
     */
    public void findAll() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(REQUEST_NAME,ALL_VALUES); // Get all the values
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
            Tournament tournament = new Tournament(); // For the tournament
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            tournament.setId(jsonobject.get("idTOURNAMENT").getAsInt());
            tournament.setName(jsonobject.get("name").getAsString());
            tournament.setPublicDes(jsonobject.get("publicDes").getAsString());
            // We take the system for the tournament
            TournamentSystem tournamentSystem = new TournamentSystem();
            tournamentSystem.setMaxPlayers(jsonobject.get("maxPlayers").getAsInt());
            tournamentSystem.setMinPlayers(jsonobject.get("minPlayers").getAsInt());
            tournament.setTournamentSystem(tournamentSystem);
            // We take the host for the tournament            ;
            int host_id = jsonobject.get("TOURNAMENT_HOST_idTournamentHost").getAsInt();
            QueryHosts queryHosts = new QueryHosts(host_id);
            queryHosts.findHost();
            TournamentHost tournamentHost = queryHosts.getQueryResult();
            tournament.setHost(tournamentHost);

            // We add the object Tournament
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