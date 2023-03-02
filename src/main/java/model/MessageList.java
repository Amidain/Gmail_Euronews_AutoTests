package model;

import java.util.List;

public class MessageList {
    private List<Message> messages;
    private String nextPageToken;
    int resultSizeEstimate;

    public MessageList() {
    }

    public MessageList(List<Message> messages, String nextPageToken, int resultSizeEstimate) {
        this.messages = messages;
        this.nextPageToken = nextPageToken;
        this.resultSizeEstimate = resultSizeEstimate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public int getResultSizeEstimate() {
        return resultSizeEstimate;
    }

    public void setResultSizeEstimate(int resultSizeEstimate) {
        this.resultSizeEstimate = resultSizeEstimate;
    }

    @Override
    public String toString() {
        return "MessageList{" +
                "messages=" + messages +
                ", nextPageToken='" + nextPageToken + '\'' +
                ", resultSizeEstimate=" + resultSizeEstimate +
                '}';
    }
}
