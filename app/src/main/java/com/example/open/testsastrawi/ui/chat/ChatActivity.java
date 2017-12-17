package com.example.open.testsastrawi.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.open.testsastrawi.R;

public class ChatActivity extends AppCompatActivity {
    //view
    private RecyclerView recyclerConversation;
    private EditText etChatInput;
    private Button btnSend;

    //adapter
    private ChatAdapter chatAdapter;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setupUI();
        setupAction();
    }

    private void setupUI() {
        recyclerConversation    = (RecyclerView) findViewById(R.id.recyclerview_conversation);
        etChatInput             = (EditText) findViewById(R.id.et_chat_input);
        btnSend                 = (Button) findViewById(R.id.btn_send);

        setupRecycler();
    }

    private void setupAction() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        if (!etChatInput.getText().toString().isEmpty()) {
            chatAdapter.addUserMessage(etChatInput.getText().toString());
            recyclerConversation.smoothScrollToPosition(0);
        }
    }

    private void setupRecycler() {
        //setup recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);

        chatAdapter = new ChatAdapter(this);
        recyclerConversation.setAdapter(chatAdapter);
        recyclerConversation.setLayoutManager(linearLayoutManager);
        recyclerConversation.setHasFixedSize(true);
    }
}
