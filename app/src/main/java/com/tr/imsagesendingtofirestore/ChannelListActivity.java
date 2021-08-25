package com.tr.imsagesendingtofirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelListQuery;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.sendbird.uikit.SendBirdUIKit;
import com.sendbird.uikit.adapter.SendBirdUIKitAdapter;
import com.sendbird.uikit.interfaces.UserInfo;

import java.util.List;
//here we implement UI KIT
public class ChannelListActivity extends AppCompatActivity {
    static String USER_ID;
    static String CHANNEL_TYPE;
    static final  String APP_ID="07D33BD9-A9E3-436F-A72D-E385E2383BDB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_list);



//        Intent intent1=getIntent();
//        String uID=   intent1.getStringExtra("userid");
//        mUserIdEditText.setText(uID);

//        String nk_NM =   getIntent().getStringExtra("nickname");
//
//
//
//        USER_ID = getIntent().getStringExtra("userID");
//        CHANNEL_TYPE = getIntent().getStringExtra("channelType");
//        init_sendbird();
//
//
//        SendBirdUIKit.init(new SendBirdUIKitAdapter() {
//            @Override
//            public String getAppId() {
//                return APP_ID;  // Specify your Sendbird application ID.
//            }
//
//            @Override
//            public String getAccessToken() {
//                return "";
//            }
//
//            @Override
//            public UserInfo getUserInfo() {
//                return new UserInfo() {
//                    @Override
//                    public String getUserId() {
//                        return USER_ID;  // Specify your user ID.
//                    }
//
//                    @Override
//                    public String getNickname() {
//                        return nk_NM;  // Specify your user nickname.
//                    }
//
//                    @Override
//                    public String getProfileUrl() {
//                        return "";
//                    }
//                };
//            }
//        }, this);



    }


    @Override
    protected void onResume() {
        super.onResume();
        connect_sendbird();
        switch(CHANNEL_TYPE) {
            case Constants.openChannelType:
                get_open_channels();
                break;
            case Constants.groupChannelType:
                get_group_channels();
                break;
            default:
                Log.e("App", "Invalid Channel Type: " + CHANNEL_TYPE);
                finish();
                break;
        }
    }





    protected void get_group_channels() {
        GroupChannelListQuery channelListQuery = GroupChannel.createMyGroupChannelListQuery();
        channelListQuery.setIncludeEmpty(true);
        channelListQuery.setLimit(100);
        channelListQuery.next(new GroupChannelListQuery.GroupChannelListQueryResultHandler() {
            @Override
            public void onResult(List<GroupChannel> list, SendBirdException e) {
                if (e != null) {    // Error.
                    return;
                }
                populate_group_channel_list(list);
            }
        });
    }




    protected void get_open_channels() {
        OpenChannelListQuery channelListQuery = OpenChannel.createOpenChannelListQuery();
        channelListQuery.setLimit(100);
        channelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
            @Override
            public void onResult(List<OpenChannel> list, SendBirdException e) {
                if (e != null) {    // Error.
                    return;
                }
                populate_open_channel_list(list);
            }
        });
    }



    protected void populate_group_channel_list(List<GroupChannel> list) {
        RecyclerView rvGroupChannelList = findViewById(R.id.channelListRecyclerView);

        GroupChannelListAdapter adapter = new GroupChannelListAdapter(list, CHANNEL_TYPE);
        rvGroupChannelList.setAdapter(adapter);
        rvGroupChannelList.setLayoutManager(new LinearLayoutManager(this));
    }






    protected void populate_open_channel_list(List<OpenChannel> list) {
        RecyclerView rvOpenChannelList = findViewById(R.id.channelListRecyclerView);

        OpenChannelListAdapter adapter = new OpenChannelListAdapter(list, CHANNEL_TYPE);
        rvOpenChannelList.setAdapter(adapter);
        rvOpenChannelList.setLayoutManager(new LinearLayoutManager(this));
    }




    protected void connect_sendbird() {
        SendBird.connect(USER_ID, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {    // Error.
                    return;
                }
            }
        });
    }






    protected void init_sendbird() {
        SendBird.init(Task4SendBird.APP_ID, this);
    }



}