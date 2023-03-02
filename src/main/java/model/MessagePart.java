package model;

import java.util.List;

public class MessagePart {
    private String partId;
    private String mimeType;
    private String filename;
    private List<Header> headers;
    private MessagePartBody body;
    private List<MessagePart> parts;

    public MessagePart() {
    }

    public MessagePart(String partId, String mimeType, String filename, List<Header> headers, MessagePartBody body, List<MessagePart> parts) {
        this.partId = partId;
        this.mimeType = mimeType;
        this.filename = filename;
        this.headers = headers;
        this.body = body;
        this.parts = parts;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public MessagePartBody getBody() {
        return body;
    }

    public void setBody(MessagePartBody body) {
        this.body = body;
    }

    public List<MessagePart> getParts() {
        return parts;
    }

    public void setParts(List<MessagePart> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "MessagePart{" +
                "partId='" + partId + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", filename='" + filename + '\'' +
                ", headers=" + headers +
                ", body=" + body +
                ", parts=" + parts +
                '}';
    }
}
