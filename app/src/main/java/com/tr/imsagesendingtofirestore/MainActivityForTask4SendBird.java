package com.tr.imsagesendingtofirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivityForTask4SendBird extends AppCompatActivity {
//MainMenuActivity Layout
//    here we select the channel if the user wants to select Group channel or open channel


    String userID;
  LinearLayout   start_group_channel_list_activity,start_open_channel_list_activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_task4_send_bird);
        start_group_channel_list_activity= findViewById(R.id.start_group_channel_list_activity);
        start_open_channel_list_activity = findViewById(R.id.start_open_channel_list_activity);


        start_group_channel_list_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityForTask4SendBird.this, ChannelListActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("channelType", Constants.groupChannelType);
                startActivity(intent);
            }
        });


        start_open_channel_list_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivityForTask4SendBird.this, ChannelListActivity.class);
                intent.putExtra("userID", userID);
                intent.putExtra("channelType", Constants.openChannelType);
                startActivity(intent);


            }
        });





    }
}