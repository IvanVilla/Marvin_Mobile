package com.example.klaussius.marvin_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Form to sign in as new user
 * @author Klaussius
 */
public class SignInForm extends AppCompatActivity {
    Button btClear;
    Button btSignIn;
    Button btCancel;
    EditText etNickName;
    EditText etName;
    EditText etPassword;
    EditText etPasswordAgain;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // Inicializo los campos de texto
        etNickName = (EditText)findViewById(R.id.etNickName);
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPasswordAgain = (EditText)findViewById(R.id.etPasswordAgain);
        etEmail = (EditText)findViewById(R.id.etEmail);
        // Inicializo botón de limpieza y añado listener
        btClear = (Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        // Inicializo botón de aceptar y añado listener
        btSignIn = (Button)findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        // Inicializo botón de cancelar y añado listener
        btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    /**
     * Limpia el formulario
     */
    public void clear(){
        etNickName.setText("");
        etName.setText("");
        etPassword.setText("");
        etPasswordAgain.setText("");
        etEmail.setText("");
    }

    /**
     * Acepta el formulario
     */
    public void signIn(){
        this.finish();
    }

    /**
     * Cancela el formulario
     */
    public void cancel() { this.finish(); }

}