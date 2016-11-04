package com.example.klaussius.marvin_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import data.ReadTournamentHost;
import model.host.TournamentHost;

public class TestHost extends AppCompatActivity {

    public TextView tvHost;
    public String texto="Lista de Hosts...\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_host);
        tvHost = (TextView)findViewById(R.id.tvHost);
        takeTheHostList();
        tvHost.setText(texto);
    }

    public void takeTheHostList(){
        ReadTournamentHost lectura = new ReadTournamentHost();
        ArrayList<TournamentHost> misHosts = lectura.getMisHosts();
        for (TournamentHost tHost : misHosts){
            this.texto=this.texto+"id: "+tHost.getId()+", nombre: "+tHost.getName();
        }
    }
}