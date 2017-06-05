package com.sendbird.android.sample.Game;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.atomation.atomationsdk.api.ConfigurationData;
import net.atomation.atomationsdk.api.IConfigReadListener;
import net.atomation.atomationsdk.api.IMultiSenseAtom;
import net.atomation.atomationsdk.api.IOnButtonPressedListener;
import net.atomation.atomationsdk.api.ISensorsReadListener;
import net.atomation.atomationsdk.api.SensorsData;
import net.atomation.atomationsdk.ble.MultiSenseAtomManager;

import com.sendbird.android.sample.R;

public class MSButton extends AppCompatActivity {

    private MSButton current;
    private final String token;

    public MSButton(){
        super();
        this.token="48:1A:84:00:14:A1";

    }
    public MSButton(String token) {
        super();
        this.token=token;
    }

    public IMultiSenseAtom getAtom() {
        return atom;
    }

    private IMultiSenseAtom atom;
    private final String TAG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "], persistentState = [" + persistentState + "]");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        current=this;
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_msbutton);
        MultiSenseAtomManager mgr = MultiSenseAtomManager.getInstance(this);
        atom = mgr.getMultiSenseAtom(token);
        if(atom == null){
            atom = mgr.createMultiSenseDevice(token);
        }
        /*atom.setSensorsReadListener(new ISensorsReadListener() {
            @Override
            public void onRead(SensorsData sensorsData) {
                Log.d(TAG, "onRead() called with: sensorsData = [" + sensorsData + "]");
            }

            @Override
            public void onError(int errorCode) {

            }
        });*/

        Log.d(TAG, "onCreate: activate");
        atom.activate(new IConfigReadListener() {
            @Override
            public void onRead(ConfigurationData configData) {
                Log.d(TAG, "onRead() called with: configData = [" + configData + "]");
                Intent intent=new Intent(MSButton.this,Found.class);
                startActivity(intent);
            }

            @Override
            public void onError(int errorCode) {
                Log.d(TAG, "onError() called with: errorCode = [" + errorCode + "]");
            }
        }, new ISensorsReadListener() {
            @Override
            public void onRead(SensorsData sensorsData) {
                Log.d(TAG, "onRead() called with: sensorsData = [" + sensorsData + "]");
            }

            @Override
            public void onError(int errorCode) {
                Log.d(TAG, "onError() called with: errorCode = [" + errorCode + "]");
            }
        });

    }
}
