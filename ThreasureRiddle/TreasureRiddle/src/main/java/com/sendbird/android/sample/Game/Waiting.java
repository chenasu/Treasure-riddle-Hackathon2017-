package com.sendbird.android.sample.Game;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.sendbird.android.sample.R;
import com.sendbird.android.sample.groupchannel.GroupChannelActivity;

import net.atomation.atomationsdk.api.IMultiSenseAtom;
import net.atomation.atomationsdk.api.ISensorsReadListener;
import net.atomation.atomationsdk.api.SensorsData;
import net.atomation.atomationsdk.ble.MultiSenseAtomManager;

import java.text.CollationElementIterator;

public class Waiting extends AppCompatActivity {
    TextView texty;


    //@Override

    ImageView img;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        img =(ImageView)findViewById(R.id.imageView);
        texty = (TextView)findViewById(R.id.textView);

        new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                texty.setText(""+millisUntilFinished / 1000);
                clock(img);
            }

            public void onFinish() {
                texty.setText("done!");
                Intent intent=new Intent(Waiting.this, Clue.class);
                startActivity(intent);
            }
        }.start();

    }

    public void clock(View view)
    {
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        img.startAnimation(animation);
    }

}

