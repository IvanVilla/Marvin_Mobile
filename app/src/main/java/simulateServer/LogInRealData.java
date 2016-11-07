package simulateServer;

import android.os.AsyncTask;
import android.util.Log;

import model.user.User;

/**
 * Log in with a real account
 * @autor Klaussius
 */

public class LogInRealData {

    // Connection data
    private QueryUsersPassword myData;

    /**
     * Constructor
     */
    public LogInRealData() {
        myData = new QueryUsersPassword();
        myData.findAll();
    }

    /**
     * Authentication method
     * @param name user's nickname
     * @param password user's password
     * @return true if success, false if not
     */
    public boolean login(String name, String password){
        for (User user:myData.getQueryResult()){
            if (user.getName().equals(name) && user.getPassword().equals(password)){
                Log.i("Autenthication","Success");
                return true;
            }
        }
        Log.e("Error","User/Password incorrecto");
        return false;
    }

    /**
     * Takes the data from the server
     */
    private class leerDatos extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            return "done";
        }
    }
}