package com.sendbird.android.sample.Game;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.luolc.emojirain.EmojiRainLayout;
import com.sendbird.android.sample.R;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Found extends AppCompatActivity {


    private static final String TAG = "";
    private EmojiRainLayout mContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        Log.v(TAG, "Initializing sounds...");
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.tada);
        Log.v(TAG, "Playing sound...");
        mp.start();
        mContainer = (EmojiRainLayout)findViewById(R.id.activity_found);
        fracts(mContainer);
    }

    public void fracts(EmojiRainLayout mContainer)
    {
        mContainer.addEmoji(R.drawable.emoji_1_3);
        mContainer.addEmoji(R.drawable.emoji_2_3);
        mContainer.addEmoji(R.drawable.emoji_3_3);
        mContainer.addEmoji(R.drawable.emoji_4_3);
        mContainer.addEmoji(R.drawable.emoji_5_3);

        mContainer.stopDropping();
        mContainer.setPer(10);
        mContainer.setDuration(7200);
        mContainer.setDropDuration(2400);
        mContainer.setDropFrequency(500);

        mContainer.startDropping();
    }
    }

