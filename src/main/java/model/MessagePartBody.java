package model;

public class MessagePartBody {
    private String attachmentId;
    private int size;
    private String data;

    public MessagePartBody() {
    }

    public MessagePartBody(String attachmentId, int size, String data) {
        this.attachmentId = attachmentId;
        this.size = size;
        this.data = data;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessagePartBody{" +
                "attachmentId='" + attachmentId + '\'' +
                ", size=" + size +
                ", data='" + data + '\'' +
                '}';
    }
}
