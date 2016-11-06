package serverData;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.host.TournamentHost;

/**
 * Created by Klaussius on 06/11/2016.
 */
public class QueryHosts {

    public List<TournamentHost> tournamentHosts = new ArrayList<>();

    private final static String URL_TOURNAMENT_HOST_QUERY = "http://10.0.2.2/api/hostsQuery.php";
    private HttpURLConnection con;


    /**
     * Create the connection
     * @param url
     * @param proxy
     * @param postDataBytes
     * @return
     * @throws IOException
     */
    public Reader connect(URL url, Proxy proxy, byte[]postDataBytes) throws IOException {
        if ( proxy == null ){proxy = Proxy.NO_PROXY;}           // direct con
        con = (HttpURLConnection) url.openConnection( proxy );  // default: No proxy
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        return in;
    }

    /**
     * Close the connection
     */
    public void close(){
        con.disconnect();
    }

    /**
     * Post the request, and get the data to our model's objects
     */
    public void findAll() {
        try {
            // URL
            URL url = new URL(URL_TOURNAMENT_HOST_QUERY);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("user", "root"); // User has rights?
            //params.put("param2", "getAllUser");
            //params.put("param3", "Prototip");
            byte[] postDataBytes = putParams(params); // Mètode aux. make POST

            // GET READER FROM CONN (SUPER)
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);

            // PARSER
            JsonArray jarray = getArrayFromJson(in, null); // "users" Only Json Objects

            // MAKE OBJECTS
            makeHostsFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
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
     * Make the objects TournamentHosts from Array
     * @param jarray
     */
    private void makeHostsFromJson(JsonArray jarray){
        for (int i=0; i<jarray.size(); i++){
            TournamentHost tHost = new TournamentHost();
            JsonObject jsonobject = jarray.get(i).getAsJsonObject();
            tHost.setId(jsonobject.get("idTournamentHost").getAsInt());
            tHost.setName(jsonobject.get("name").getAsString());
            this.tournamentHosts.add(tHost);
        }
    }

    /**
     * Read a JSON from the server
     * @return the String without parse
     */
    public String takeHosts(){
        String texto="";
        try {
            URL url = new URL(URL_TOURNAMENT_HOST_QUERY);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            texto = bufferedReader.readLine();
        } catch (Exception e) {
            texto = "Fail!";
            e.printStackTrace();
        } finally {
            return texto;
        }
    }
}