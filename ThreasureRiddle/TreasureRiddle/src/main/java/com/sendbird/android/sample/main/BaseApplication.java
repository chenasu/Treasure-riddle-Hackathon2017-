package com.sendbird.android.sample.main;


import android.app.Application;

import com.sendbird.android.SendBird;

public class BaseApplication extends Application {

    private static final String APP_ID = "169F6048-D5CD-4F37-86E3-5D6AC0AB4B51";
    public static final String VERSION = "3.0.30";

    @Override
    public void onCreate() {
        super.onCreate();
        SendBird.init(APP_ID, getApplicationContext());
    }
}
