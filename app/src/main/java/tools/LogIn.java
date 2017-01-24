package tools;

import android.os.AsyncTask;
import android.util.Log;

import data.QueryUserPassword;

/**
 * Log in with a real account
 * @autor Iván Villa
 */

public class LogIn {

    // Connection data
    private QueryUserPassword myData;
    private String name;
    private String password;

    /**
     * Constructor
     */
    public LogIn(String name, String password) {
        myData = new QueryUserPassword(name,password);
        myData.executeQuery();
    }

    /**
     * Authentication method
     * @return true if success, false if not
     */
    public boolean login(){
        if (myData.getQueryResult()!=0){
            Log.i("LogIn","User/Password correcto");
            return true;
        } else {
            Log.i("LogIn","User/Password incorrecto");
            return false;
        }
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