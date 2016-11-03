package fakeThings;

/**
 * Simula un servicio de Login
 * Created by Klaussius on 03/11/2016.
 */

public class LoginInfo {
    private final String USER_NAME="Marvin";
    private final String USER_PASSWORD="42";

    /**
     * Si el nombre y el pass coinciden, perfecto
     * @param name nombre
     * @param password contraseña
     * @return false si correcto, true si incorrecto
     */
    public boolean login (String name, String password){
        return name.equals(this.USER_NAME) && password.equals(this.USER_PASSWORD);
    }
}
