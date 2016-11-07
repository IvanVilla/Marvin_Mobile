package dataFromServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * Makes the connection
 * @Author Klaussius
 */

public class Connection {

    private HttpURLConnection con;

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
        if (con!=null) {con.disconnect();}
    }
}
