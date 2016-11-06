package persistanceDAO.HTTPRequest;

import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.user.User;
import persistanceDAO.DAO;

/**
 * Created by boscalent on 04/11/2016.
 */
public class HTTPRequestDAO implements DAO {
    protected HttpURLConnection con;
    byte[] postDataBytes = null;

    private List<User> userList = new ArrayList<>();

    @Override
    public void setup() throws Exception {
        // No populated DB from here
    }

    @Override
    public void connect() throws Exception {
        // WebService with differents url
    }

    public Reader connect(URL url, Proxy proxy, byte[] postDataBytes) throws Exception {
        this.postDataBytes = postDataBytes;

        if ( proxy == null ){proxy = Proxy.NO_PROXY;}           // direct con
        con = (HttpURLConnection) url.openConnection( proxy );  // default: No proxy
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        //con.getOutputStream().write(postDataBytes);
        new RetrievePost().execute("");
        return null;
    }

    @Override
    public void close() throws Exception {
        if ( con != null ){
            con.disconnect();
        }
    }

    private class RetrievePost extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Reader in = null;
            List<User> users = new ArrayList<>();
            try {
                con.getOutputStream().write(postDataBytes);
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                JsonElement jelement = new JsonParser().parse(in);
                JsonArray jarray = jelement.getAsJsonArray();

                User user;
                for (int i = 0; i < jarray.size(); i++) {
                    JsonObject jsonobject = jarray.get(i).getAsJsonObject();
                    user = new User();
                    user.setId(jsonobject.get("idUser").getAsInt());
                    user.setPublicName(jsonobject.get("publicName").getAsString());
                    user.setPassword(jsonobject.get("password").getAsString());
                    users.add(user);
                }
                userList=users;
            } catch (Exception e) {
                e.printStackTrace();
                User fail = new User();
                fail.setName("Error");
                userList.add(fail);
                return "Conexión no establecida.";
            }
            return "Conexión establecida.";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public List<User> getUserList() {
        return userList;
    }
}