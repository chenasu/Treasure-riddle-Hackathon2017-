package com.sendbird.android.sample.main;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.sendbird.android.sample.R;
import com.sendbird.android.sample.groupchannel.GroupChatFragment;
import com.sendbird.android.sample.utils.PreferenceUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView list=(ListView)findViewById(R.id.highScore);



        configureNextButton();


//        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
//        setSupportActionBar(mToolbar);

    }



    private void configureNextButton(){
        Button nextButton = (Button)findViewById(R.id.button2);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               // startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void configureNextButton1(){
        Button nextButton = (Button)findViewById(R.id.button4);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
             //   Intent intent=new Intent(MainActivity.this, Clue.class);
             //   startActivity(intent);
            }
        });
    }



    /**
     * Unregisters all push tokens for the current user so that they do not receive any notifications,
     * then disconnects from SendBird.
     */
    private void disconnect() {
        SendBird.unregisterPushTokenAllForCurrentUser(new SendBird.UnregisterPushTokenHandler() {
            @Override
            public void onUnregistered(SendBirdException e) {
                if (e != null) {
                    // Error!
                    e.printStackTrace();
                    return;
                }

                Toast.makeText(MainActivity.this, "All push tokens unregistered.", Toast.LENGTH_SHORT)
                        .show();

                SendBird.disconnect(new SendBird.DisconnectHandler() {
                    @Override
                    public void onDisconnected() {
                        PreferenceUtils.setConnected(MainActivity.this, false);
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }

    public void createGroup(ArrayList userIds) {
        for (Integer i = 0; i < userIds.size(); i++) {
            SendBird.connect(i.toString(), new SendBird.ConnectHandler() {
                @Override
                public void onConnected(User user, SendBirdException e) {
                    // Callback received; hide the progress bar.
                    if (e != null) {
                        // Error!
                        return;
                    }
                }
            });
        }


        String channelUrl = getIntent().getStringExtra("groupChannelUrl");
        if(channelUrl != null) {
            // If started from notification
            Fragment fragment = GroupChatFragment.newInstance(channelUrl);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.container_group_channel, fragment)
                    .addToBackStack(null)
                    .commit();
        }






    }
}