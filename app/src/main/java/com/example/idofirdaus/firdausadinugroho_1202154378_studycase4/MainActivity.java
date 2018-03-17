package com.example.idofirdaus.firdausadinugroho_1202154378_studycase4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button list,pencarigambar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listmahasiswa);
        pencarigambar = findViewById(R.id.carigambar);


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,ListNamaMahasiswa.class);
                startActivity(a);
            }
        });

        pencarigambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this,PencariGambar.class);
                startActivity(b);
            }
        });
    }
}