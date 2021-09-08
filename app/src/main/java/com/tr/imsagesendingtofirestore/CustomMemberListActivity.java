package com.tr.imsagesendingtofirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sendbird.uikit.activities.MemberListActivity;
import com.sendbird.uikit.fragments.MemberListFragment;
public class CustomMemberListActivity extends MemberListActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_member_list);
//    }


    @Override
    protected MemberListFragment createMemberListFragment(@NonNull String channelUrl) {
        return new MemberListFragment.Builder(channelUrl)
                .setCustomMemberListFragment(new CustomMemberListFragment())
                .setUseHeader(true)
                .setUseHeaderLeftButton(true)
                .setUseHeaderRightButton(false)
                .setHeaderLeftButtonListener(null)
//                .setUserListAdapter(null)
                .setItemClickListener(null)
                .setItemLongClickListener(null)
                .build();
    }


}