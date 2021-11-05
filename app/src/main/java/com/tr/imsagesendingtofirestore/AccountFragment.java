package com.tr.imsagesendingtofirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sendbird.android.SendBird;

public class AccountFragment extends Fragment {
    View rootLayout;
    private ImageView profileImage;
    private TextView userName, userInfo;

    public AccountFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_account, container, false);
        profileImage = (ImageView) rootLayout.findViewById(R.id.profile_image);
        userName = (TextView) rootLayout.findViewById(R.id.profile_name);
        userInfo = (TextView) rootLayout.findViewById(R.id.profile_info);


        //TODO SENDBIRD
        Glide.with(this).load(SendBird.getCurrentUser().getProfileUrl()).fitCenter().into(profileImage);
        userName.setText(SendBird.getCurrentUser().getNickname());
        userInfo.setText("About Me: Likes " + SendBird.getCurrentUser().getMetaData("Likes"));
        // END
        return rootLayout;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.fragment_account);
//
//    }


}