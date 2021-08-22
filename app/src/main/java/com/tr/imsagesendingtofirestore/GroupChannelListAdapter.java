package com.tr.imsagesendingtofirestore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import com.sendbird.android.GroupChannel;

import java.util.List;

public class GroupChannelListAdapter extends RecyclerView.Adapter<GroupChannelListAdapter.GroupChannelListViewHolder> {
    private List<GroupChannel> mList;
    private String mChannelType;

    public GroupChannelListAdapter(List<GroupChannel> list, String channelType) {
        mList = list;
        mChannelType = channelType;
}

    @NonNull
    @Override
    public GroupChannelListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channel_item, parent, false);
        GroupChannelListViewHolder vh = new GroupChannelListViewHolder(v);



        return vh;
    }







    @Override
    public void onBindViewHolder(@NonNull GroupChannelListViewHolder holder, int position) {

        holder.channelUrl = mList.get(position).getUrl();
        holder.channelUrlTextView.setText(holder.channelUrl);
        final String channelUrl = holder.channelUrl;



        holder.joinChannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ChatActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("channelUrl", channelUrl);
                bundle.putString("channelType", mChannelType);
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }





    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class GroupChannelListViewHolder extends RecyclerView.ViewHolder{
        public TextView channelUrlTextView;
        public Button joinChannelButton;
        private String channelUrl;

        public GroupChannelListViewHolder(LinearLayout v) {
            super(v);
            channelUrlTextView = itemView.findViewById(R.id.channel_url_text_view);
            joinChannelButton = itemView.findViewById(R.id.join_channel_button);
        }
    }

}
