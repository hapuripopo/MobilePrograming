package com.example.android_tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost myTabHost = null;
    TabHost.TabSpec myTabSpec;
    Drawable imgIcon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTabHost = (TabHost) findViewById(R.id.tabhost);
        myTabHost.setup();  //Not use tabActivity Call

        //Add Tab
        myTabSpec = myTabHost.newTabSpec("Artists")
                .setIndicator("Artists")                //Tab subject
                .setContent(R.id.tab1);                 //Tab Content
        myTabHost.addTab(myTabSpec);

        myTabSpec = myTabHost.newTabSpec("Albums")
                .setIndicator("Albums")                 //Tab subject
                .setContent(R.id.tab2);                 //Tab Content
        myTabHost.addTab(myTabSpec);

        myTabSpec = myTabHost.newTabSpec("Songs")
                .setIndicator("Songs")                  //Tab subject
                .setContent(R.id.tab3);                 //Tab Content
        myTabHost.addTab(myTabSpec);

        myTabHost.setCurrentTab(0);                     //Setting First Tab

        //Change tab's Color
        myTabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#FF0000"));
        myTabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#00FF00"));
        myTabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#0000FF"));

        //Change tab's Height
        for (int i=0; i<3; i++) {
            myTabHost.getTabWidget().getChildAt(i).getLayoutParams().height=150;
        }
    }
}