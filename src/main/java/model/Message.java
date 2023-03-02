package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {
    private String id;
    private String threadId;
    @JsonProperty("labelIds")
    private List<String> labelsIds;
    private String snippet;
    private String historyId;
    private String internalDate;
    private MessagePart payload;
    private int sizeEstimate;
    private String raw;

    public Message() {
    }


    public Message(String id, String threadId, List<String> labelsIds, String snippet, String historyId, String internalDate, MessagePart payload, int sizeEstimate, String raw) {
        this.id = id;
        this.threadId = threadId;
        this.labelsIds = labelsIds;
        this.snippet = snippet;
        this.historyId = historyId;
        this.internalDate = internalDate;
        this.payload = payload;
        this.sizeEstimate = sizeEstimate;
        this.raw = raw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public List<String> getLabelsIds() {
        return labelsIds;
    }

    public void setLabelsIds(List<String> labelsIds) {
        this.labelsIds = labelsIds;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getInternalDate() {
        return internalDate;
    }

    public void setInternalDate(String internalDate) {
        this.internalDate = internalDate;
    }

    public MessagePart getPayload() {
        return payload;
    }

    public void setPayload(MessagePart payload) {
        this.payload = payload;
    }

    public int getSizeEstimate() {
        return sizeEstimate;
    }

    public void setSizeEstimate(int sizeEstimate) {
        this.sizeEstimate = sizeEstimate;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", threadId='" + threadId + '\'' +
                ", labelsIds=" + labelsIds +
                ", snippet='" + snippet + '\'' +
                ", historyId='" + historyId + '\'' +
                ", internalDate='" + internalDate + '\'' +
                ", payload=" + payload +
                ", sizeEstimate=" + sizeEstimate +
                ", raw='" + raw + '\'' +
                '}';
    }
}
