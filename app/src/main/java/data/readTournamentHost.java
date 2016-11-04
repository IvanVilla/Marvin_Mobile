package data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.host.TournamentHost;

/**
 * Read the hosts and store them in one ArrayList
 * Created by Klaussius on 04/11/2016.
 */
public class ReadTournamentHost {

    private static String url = "http://localhost/api/hostsQuery.php";
    private ArrayList<TournamentHost> misHosts = new ArrayList<>();

    /**
     * Constructor
     */
    public ReadTournamentHost() {
        leerHost();
    }

    /**
     * Lee las entradas
     */
    public void leerHost(){
        HttpHandler sh = new HttpHandler();
        //Making the request to url and getting response
        String jsonStr = sh.makeServiceCall(url);
        if (jsonStr != null){
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                // Getting JSON Array noide
                JSONArray hostArray = jsonObj.getJSONArray("host");

                // Looping through all entries
                for (int i = 0; i<hostArray.length(); i++){
                    JSONObject h = hostArray.getJSONObject(i);
                    // Taking the data
                    int id = Integer.parseInt(h.getString("idTournamentHost"));
                    String name = h.getString("name");
                    // Creating the object and pushing into the arraylist
                    TournamentHost miHost = new TournamentHost();
                    miHost.setId(id);
                    miHost.setName(name);
                    misHosts.add(miHost);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<TournamentHost> getMisHosts() {
        return misHosts;
    }
}
