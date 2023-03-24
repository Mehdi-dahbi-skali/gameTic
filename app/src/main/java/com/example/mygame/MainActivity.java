package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combination = new ArrayList<>();
    private int [] boxPos = {0,0,0,0,0,0,0,0,0};
    private int Tourn =1;
    private int TotalBoxes =1;
    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonRefrech= findViewById(R.id.buttonRefrech);
        final Button buttonHome= findViewById(R.id.buttonHome);

        buttonRefrech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartMatch();
            }
        });
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddPlayer.class);
                startActivity(intent);
            }
        });



        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        combination.add(new int[]{0,1,2});
        combination.add(new int[]{3,4,5});
        combination.add(new int[]{6,7,8});
        combination.add(new int[]{0,3,6});
        combination.add(new int[]{1,4,7});
        combination.add(new int[]{2,5,8});
        combination.add(new int[]{2,4,6});
        combination.add(new int[]{0,4,8});

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(0)){
                    Action(image1,0);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(1)){
                    Action(image2,1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(2)){
                    Action(image3,2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(3)){
                    Action(image4,3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(4)){
                    Action(image5,4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(5)){
                    Action(image6,5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(6)){
                    Action(image7,6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(7)){
                    Action(image8,7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectebele(8)){
                    Action(image9,8);
                }
            }
        });
    }

    private void Action(ImageView imgView,int BoxSelected) {
        boxPos[BoxSelected]=Tourn;

        if (Tourn==1) {
                    if(getIntent().getStringExtra("mode").equals("normal")){
                        imgView.setImageResource(R.drawable.xmark_solid);
                    }
                     if(getIntent().getStringExtra("mode").equals("fr")){
                     imgView.setImageResource(R.drawable.apple_whole_solid);
                     }
            if(getIntent().getStringExtra("mode").equals("star")){
                imgView.setImageResource(R.drawable.star_solid);
            }
            if(getIntent().getStringExtra("mode").equals("fire")){
                imgView.setImageResource(R.drawable.fire_solid);
            }
            if(getIntent().getStringExtra("mode").equals("1")){
                imgView.setImageResource(R.drawable.__solid);
            }
            if(getIntent().getStringExtra("mode").equals("lemons")){
                imgView.setImageResource(R.drawable.lemon_solid);
            }



            if (checkPlayerWin()) {

                Intent intent = new Intent(MainActivity.this,AddPlayer.class);
                intent.putExtra("result","1st Player is the winner");
                startActivity(intent);


            } else if (TotalBoxes == 9) {
                //draw
                Intent intent = new Intent(MainActivity.this,AddPlayer.class);
                intent.putExtra("result","Draw");
                startActivity(intent);

            } else {
                Tourn = 2;
                TotalBoxes++;
            }
        }else {
            if(getIntent().getStringExtra("mode").equals("normal")){
                imgView.setImageResource(R.drawable.o_solid);
            }
            if(getIntent().getStringExtra("mode").equals("fr")){
                imgView.setImageResource(R.drawable.carrot_solid);
            }
            if(getIntent().getStringExtra("mode").equals("star")){
                imgView.setImageResource(R.drawable.clover_solid);
            }
            if(getIntent().getStringExtra("mode").equals("fire")){
                imgView.setImageResource(R.drawable.wind_solid);
            }
            if(getIntent().getStringExtra("mode").equals("1")){
                imgView.setImageResource(R.drawable.solid0);
            }
            if(getIntent().getStringExtra("mode").equals("lemons")){
                imgView.setImageResource(R.drawable.seedling_solid);
            }

            if (checkPlayerWin()) {
                //win
                Intent intent = new Intent(MainActivity.this,AddPlayer.class);
                intent.putExtra("result","2nd Player is the winner");
                startActivity(intent);

            } else if (TotalBoxes == 9) {
                //draw
                Intent intent = new Intent(MainActivity.this,AddPlayer.class);
                intent.putExtra("result","Draw");
                startActivity(intent);

            } else {
                Tourn = 1;
                TotalBoxes++;
            }

        }
    }

    private boolean checkPlayerWin(){
        boolean resp = false;
        for (int i =0;i<combination.size();i++){
            final int[] combinationn = combination.get(i);
            if (boxPos[combinationn[0]]== Tourn && boxPos[combinationn[1]] == Tourn && boxPos[combinationn[2]]== Tourn){
                resp = true;
            }
        }
        return resp;
    }

    private boolean isBoxSelectebele(int BoxPos){
        boolean resp = false;
        if (boxPos[BoxPos]==0) resp = true;

        return resp;
    }

    public void restartMatch(){
         boxPos = new int[]{0,0,0,0,0,0,0,0,0};
         Tourn =1;
         TotalBoxes =1;

        image1.setImageResource(R.drawable.square_solid);
        image2.setImageResource(R.drawable.square_solid);
        image3.setImageResource(R.drawable.square_solid);
        image4.setImageResource(R.drawable.square_solid);
        image5.setImageResource(R.drawable.square_solid);
        image6.setImageResource(R.drawable.square_solid);
        image7.setImageResource(R.drawable.square_solid);
        image8.setImageResource(R.drawable.square_solid);
        image9.setImageResource(R.drawable.square_solid);

    }

}