package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * Makes the connection
 * @Author Iván Villa
 */

public class Connection {

    private HttpURLConnection con;
    protected final static String API_URL="http://marvin-server.duckdns.org/";
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
}
