package data;

import android.util.Log;

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
import java.util.Map;

import model.user.User;

/**
 * Makes the connection
 * @Author Iván Villa
 */

public class Connection {

    private HttpURLConnection con;
    protected final static String API_URL="http://marvin-server.duckdns.org/";
    protected String queryURL;
    // Request Names
    protected final static String REQUEST_NAME="requestName";
    protected final static String CUSTOM_SEARCH="customSearch";
    protected final static String ALL_VALUES="allValues";
    protected final static String VALUE_EXISTS="valueExists";
    // Insert, delete, modify operations
    protected final static String INSERT_ITEM="insertItem";
    protected final static String DELETE_ITEM="deleteItem";
    protected final static String MODIFY_ITEM="modifyItem";
    // Login
    protected final static String USER_LOGIN="userLogin";
    protected final static String USER_NAME="userPublicName";
    protected final static String USER_PASSWORD="userPassword";
    // Filters
    protected final static String FILTER_FIELDS="filterFields";
    protected final static String FILTER_ARGUMENTS="filterArguments";
    // Names for fields
    protected final static String FIELD="field";
    protected final static String VALUE="value";
    protected final static String FIELDS="fields";
    protected final static String VALUES="values";
    protected final static String ITEM_ID="itemId";

    /**
     * Connect method
     * @param url the url
     * @param proxy proxy
     * @param postDataBytes dataBytes
     * @return the reader
     * @throws IOException exeption of In/Out data
     */
    public Reader connect(URL url, Proxy proxy, byte[]postDataBytes) throws IOException {
        if ( proxy == null ){proxy = Proxy.NO_PROXY;}           // direct con
        con = (HttpURLConnection) url.openConnection( proxy );  // default: No proxy
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "Latin1"));
        return in;
    }

    /**
     * Close the connection
     */
    public void close(){
        if (con!=null) {con.disconnect();}
    }

    /**
     * Build the POST message to send to PHP server
     * @param params parameters of the webservice
     * @return byte[] with the parameters
     */
    protected byte[] putParams(Map<String, Object> params) {
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
            Log.i("Posting...",postData.toString());
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
    protected JsonArray getArrayFromJson (Reader in, String node){
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
     * Returns the user's id from publicName
     * @param  publicName public name
     * @return user's id
     */
    protected int getUserId(String publicName){
        QueryUserProfile queryUserProfile = new QueryUserProfile(publicName);
        User user = queryUserProfile.getQueryResult();
        return user.getId();
    }
}
