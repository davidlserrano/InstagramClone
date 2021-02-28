package com.example.instagramclone;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        //Register parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("rxvgHhPmCUm5Gm7TAT6F6PFxPvtoAXxGnF4nURps")
                .clientKey("6IFzc3TD5tJqH1ysGudo08KfEYJ94sAIKcYZbobe")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}