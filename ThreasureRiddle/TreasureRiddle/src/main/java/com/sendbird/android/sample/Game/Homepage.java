package com.sendbird.android.sample.Game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sendbird.android.sample.R;
import com.sendbird.android.sample.main.MainActivity;

public class Homepage extends AppCompatActivity {

    Button wait,profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ListView list=(ListView)findViewById(R.id.highScore);
        wait= (Button)findViewById(R.id.button2);
        profile=(Button)findViewById(R.id.button3);
        wait.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Homepage.this, Main2Activity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Homepage.this, Waiting.class));
            }
        });



    }

    }
