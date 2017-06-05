package com.sendbird.android.sample.Game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sendbird.android.sample.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView name=(TextView)findViewById(R.id.textView8);
        name.setText("maoz");
    }
}
