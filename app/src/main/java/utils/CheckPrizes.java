package utils;

import java.util.Random;

/**
 * Created by Klaussius on 14/12/2016.
 */

public class CheckPrizes {

    /**
     * Check the number of prizes we have
     * TODO Devuelve un número aleatorio entre 0 y 2, debería comprobar en el servidor
     * @return
     */
    public int check(){
        int prizeNumber=0;
        Random R = new Random();
        prizeNumber=R.nextInt(2);
        return prizeNumber;
    }
}
