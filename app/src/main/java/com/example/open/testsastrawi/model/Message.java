package com.example.open.testsastrawi.model;

/**
 * Created by Rahardyan on 12/15/2017.
 */

public class Message {
    private String content;
    private String createdAt;
    private String sender;

    public Message(String content, String createdAt, String sender) {
        this.content = content;
        this.createdAt = createdAt;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getSender() {
        return sender;
    }
}
