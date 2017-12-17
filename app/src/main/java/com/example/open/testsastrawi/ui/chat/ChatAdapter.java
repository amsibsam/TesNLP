package com.example.open.testsastrawi.ui.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.open.testsastrawi.R;
import com.example.open.testsastrawi.model.Message;
import com.example.open.testsastrawi.storage.CacheManager;
import com.example.open.testsastrawi.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rahardyan on 12/15/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int MY_COMMENT = 0;
    private static final int ANOTHER_COMMENT = 1;
    private Context context;
    private List<Message> messages = new ArrayList<>();

    public ChatAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Message> message) {
        this.messages = message;
    }

    public void addUserMessage(String message) {
        Message newMessage = new Message(message,
                DateUtils.getFormattedDate(System.currentTimeMillis(), "hh:mm"),
                CacheManager.getInstance(context).getUser().getUsername());
        this.messages.add(0, newMessage);
        notifyItemInserted(0);
        notifyItemRangeChanged(0, messages.size());
    }

    public void addMarineMessage(String message) {
        Message newMessage = new Message(message,
                DateUtils.getFormattedDate(System.currentTimeMillis(), "hh:mm"), "Marine");
        this.messages.add(0, newMessage);
        notifyItemInserted(0);
        notifyItemRangeChanged(0, messages.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ANOTHER_COMMENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_another_message_text, parent, false);
            return new AnotherMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_message_text, parent, false);
            return new MyMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String content = messages.get(position).getContent();
        String sender = messages.get(position).getSender();
        String createdAt = messages.get(position).getCreatedAt();

        switch (getItemViewType(position)) {
            case MY_COMMENT:
                MyMessageViewHolder myViewHolder = (MyMessageViewHolder) holder;
                myViewHolder.tvContent.setText(content);
                break;
            case ANOTHER_COMMENT:
                AnotherMessageViewHolder anotherViewHolder = (AnotherMessageViewHolder) holder;
                anotherViewHolder.tvContent.setText(content);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).getSender().equals(CacheManager.getInstance(context).getUser().getUsername()) ? 0 : 1;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MyMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        public MyMessageViewHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    class AnotherMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        public AnotherMessageViewHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
