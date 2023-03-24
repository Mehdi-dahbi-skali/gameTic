package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        if(getIntent().getStringExtra("result") != null){
            TextView res = findViewById(R.id.resTxt);
            res.setText(getIntent().getStringExtra("result"));
        }
       final Button buttonModeNormal= findViewById(R.id.buttonmodenormal);
       final Button btnModefruits = findViewById(R.id.buttonModeshape);
        final Button btnModeStar = findViewById(R.id.buttonModeStar);
        final Button btnModefire = findViewById(R.id.buttonmodeFire);
        final Button btnMode1 = findViewById(R.id.buttonMode1);
        final Button btnModeLemons = findViewById(R.id.buttonModeLemons);

       buttonModeNormal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
               intent2.putExtra("mode","normal");
               startActivity(intent2);
           }
       });

        btnModefruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
                intent2.putExtra("mode","fr");
                startActivity(intent2);
            }
        });

        btnModeStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
                intent2.putExtra("mode","star");
                startActivity(intent2);
            }
        });

        btnModefire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
                intent2.putExtra("mode","fire");
                startActivity(intent2);
            }
        });

        btnMode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
                intent2.putExtra("mode","1");
                startActivity(intent2);
            }
        });

        btnModeLemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AddPlayer.this,MainActivity.class);
                intent2.putExtra("mode","lemons");
                startActivity(intent2);
            }
        });


    }
}