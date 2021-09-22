package com.tr.imsagesendingtofirestore;

import android.app.Application;
import android.content.Intent;

import androidx.multidex.MultiDexApplication;

import com.sendbird.android.SendBird;
import com.sendbird.uikit.SendBirdUIKit;
import com.sendbird.uikit.adapter.SendBirdUIKitAdapter;
import com.sendbird.uikit.interfaces.UserInfo;

import java.net.URISyntaxException;

public class BaseApplication extends Application {

    static final  String APP_ID="DC4FAB59-A625-4404-AABE-DD38AA12ECCD";

    String uID,Nk_NM;

//    Task4SendBird task4SendBird;
    Intent i;

    @Override
    public void onCreate() {
        super.onCreate();
//        PreferenceUtils.init(getApplicationContext());
//Ya mare custom bnye hue logic ha kise documentation main nai mile ge , mena pehla object create kra Task 4 ka phir wehan sa variable buliya User Id ka aur Nickname ka then ausa return kra dia ku ka log cat main return null likha a reha tha to mena socha ya kr k dakhu

//        Intent i= Intent.getIntentOld()

//        task4SendBird=new Task4SendBird();

//        task4SendBird.mUserNicknameEditText.getText().toString();
//        task4SendBird.mUserIdEditText.getText().toString();

//no need to create object because variable are static in other file
        SendBirdUIKit.init(new SendBirdUIKitAdapter() {
            @Override
            public String getAppId() {
//                return "2D7B4CDB-932F-4082-9B09-A1153792DC8D";  // The ID of the Sendbird application which UIKit sample app uses.
                return APP_ID;
            }

            @Override
            public String getAccessToken() {
                return "";
            }

            @Override
            public UserInfo getUserInfo() {
                return new UserInfo() {
                    @Override
                    public String getUserId() {
//                        Intent i ;
//                        uID="" ;
//                        try {
//                            //                intent=getIntent();
////                String uID=   intent.getStringExtra("userid");
//                             i = Intent.getIntent("userid");
//
//                              uID= i.getStringExtra("userid");
//
//                        } catch (URISyntaxException e) {
//                            e.printStackTrace();
//                        }
                        return         Task4SendBird.mUserIdEditText.getText().toString();
                    }

                    @Override
                    public String getNickname() {


//                        try {
//                            //                intent=getIntent();
////                String uID=   intent.getStringExtra("userid");
//                            i = Intent.getIntent("nickname");
//
//                            Nk_NM= i.getStringExtra("nickname");
//
//                        } catch (URISyntaxException e) {
//                            e.printStackTrace();
//                        }




                        return Task4SendBird.mUserNicknameEditText.getText().toString(); // The nickname of the user you wish to log in as
                    }

                    @Override
                    public String getProfileUrl() {
                        return "";
                    }
                };
            }
        }, this);





//        SendBird

//        SendBirdUIKit.init(new SendBirdUIKitAdapter() {
//            @Override
//            public String getAppId() {
//                return APP_ID;
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
//                        return PreferenceUtils.getUserId();
//                    }
//
//                    @Override
//                    public String getNickname() {
//                        return PreferenceUtils.getNickname();
//                    }
//
//                    @Override
//                    public String getProfileUrl() {
//                        return PreferenceUtils.getProfileUrl();
//                    }
//                };
//            }
//        }, this);

//        boolean useDarkTheme = PreferenceUtils.isUsingDarkTheme();
//        SendBirdUIKit.setDefaultThemeMode(useDarkTheme ? SendBirdUIKit.ThemeMode.Dark : SendBirdUIKit.ThemeMode.Light);
//        PushUtils.registerPushHandler(new MyFirebaseMessagingService());
//        SendBirdUIKit.setLogLevel(SendBirdUIKit.LogLevel.ALL);
//        SendBirdUIKit.setUseDefaultUserProfile(true);
    }





}
