package com.tr.imsagesendingtofirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

// sendbird works on User authentication so this is Login form part
// this is login Activity
public class Task4SendBird extends AppCompatActivity {



    private LinearLayout mLoginLayout;
    private EditText mUserIdEditText, mUserNicknameEditText;
    private Button mConnectButton;
    private SharedPreferences mPrefs;
//OK we need to create channel from our dashboard then it will show
//    I dont know why my group channel is not showing I had created in my dashboard I might have done something wron in my dash board
//my id

    static final  String APP_ID="07D33BD9-A9E3-436F-A72D-E385E2383BDB";


//    sample id
//    this sample APP_ID is working
//    static final  String APP_ID="9DA1B1F4-0BE6-4DA8-82C5-2E81DAB56F23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_send_bird);

        mPrefs = getSharedPreferences("label", 0);
        mLoginLayout = findViewById(R.id.layout_login);
        mUserIdEditText = findViewById(R.id.edittext_login_user_id);
        mUserNicknameEditText = findViewById(R.id.edittext_login_user);
        mConnectButton=findViewById(R.id.button_login_connect);



        Intent  intent1=getIntent();
        String uID=   intent1.getStringExtra("userid");
        mUserIdEditText.setText(uID);

        String nk_NM =   intent1.getStringExtra("nickname");
        mUserNicknameEditText.setText(nk_NM);

//        mUserIdEditText.setText(PreferenceUtils.getUserId());
//        mUserNicknameEditText.setText(PreferenceUtils.getNickname());

//        String savedUserID = mPrefs.getString("userId","");




        SendBird.init(APP_ID, this.getApplicationContext());

        mConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userId = mUserIdEditText.getText().toString();
                userId = userId.replaceAll("\\s", "");

                String userNickname = mUserNicknameEditText.getText().toString();
                SharedPreferences.Editor mEditor = mPrefs.edit();
                mEditor.putString("userId", userId).commit();
                mEditor.putString("userNickName", userNickname).commit();
                connectToSendBird(userId, userNickname);





            }
        });





    }



    /**
     * Attempts to connect a user to SendBird.
     * @param userId The unique ID of the user.
     * @param userNickname The user's nickname, which will be displayed in chats.
     */


    private void connectToSendBird( final String userId,final  String userNickname) {
        mConnectButton.setEnabled(false);





        SendBird.connect(userId, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {
                    // Error!
                    Toast.makeText(
                            Task4SendBird.this, "" + e.getCode() + ": " + e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();

                    // Show login failure snackbar
                    mConnectButton.setEnabled(true);
                    return;
                }

                // Update the user's nickname
                updateCurrentUserInfo(userNickname);
//                Intent intent = getIntent();
//                String mobile = intent.getStringExtra("mobile");


//                 here we will make it to go to UI kit
                Intent intent = new Intent(Task4SendBird.this, MainActivityForTask4SendBird.class);

//                intent=getIntent();
//                String uID=   intent.getStringExtra("userid");

                intent.putExtra("userID", userId);
//                intent.putExtra(uID, userId);

//                String nk_NM =   intent.getStringExtra("nickname");

                intent.putExtra("userNickname", userNickname);
//                intent.putExtra(nk_NM, userNickname);
                startActivity(intent);
                finish();
            }
        });
    }










    /**
     * Updates the user's nickname.
     * @param userNickname The new nickname of the user.
     */
    private void updateCurrentUserInfo(String userNickname) {
        SendBird.updateCurrentUserInfo(userNickname, null, new SendBird.UserInfoUpdateHandler() {
            @Override
            public void onUpdated(SendBirdException e) {
                if (e != null) {
                    // Error!
                    Toast.makeText(
                            Task4SendBird.this, "" + e.getCode() + ":" + e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();

                    return;
                }

            }
        });
    }






}