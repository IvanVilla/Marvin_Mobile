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
import model.tournament.Tournament;
import model.tournament.TournamentSystem;
import model.utils.MyDate;

/**
 * Get a Tournament with one id
 * Created by klaus on 26/01/2017.
 */

public class QueryTournamentById extends Connection {
    private Tournament queryResult;
    private final static String PHP_QUERY_FILE = "tournamentsQuery.php";
    private int id;

    public QueryTournamentById(int id){
        this.id=id;
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
            params.put(REQUEST_NAME,CUSTOM_SEARCH); // Custom Search
            params.put(FIELDS,"[\"idTOURNAMENT\",\"name\",\"publicDes\",\"date\",\"maxPlayers\",\"minPlayers\",\"TOURNAMENT_HOST_idTournamentHost\"]");
            params.put(FILTER_FIELDS,"idTOURNAMENT");
            params.put(FILTER_ARGUMENTS,id);
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
            tournament.setDate(new MyDate(jsonobject.get("date").getAsString()));
            // We take the system for the tournament
            TournamentSystem tournamentSystem = new TournamentSystem();
            tournamentSystem.setMaxPlayers(jsonobject.get("maxPlayers").getAsInt());
            tournamentSystem.setMinPlayers(jsonobject.get("minPlayers").getAsInt());
            tournament.setTournamentSystem(tournamentSystem);
            // We take the host for the tournament            ;
            int host_id = jsonobject.get("TOURNAMENT_HOST_idTournamentHost").getAsInt();
            QueryHosts queryHosts = new QueryHosts(host_id);
            queryHosts.executeQuery();
            TournamentHost tournamentHost = queryHosts.getQueryResult();
            tournament.setHost(tournamentHost);

            // We add the object Tournament
            this.queryResult=tournament;
        }
    }

    /**
     * The result of the query
     * @return result of the query
     */
    public Tournament getQueryResult() {
        return queryResult;
    }
}
