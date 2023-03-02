package model;

import java.util.List;

public class BatchModifyMessagesRequest {
    private List<String> ids;
    private List<String> addLabelIds;
    private List<String> removeLabelIds;

    public BatchModifyMessagesRequest() {
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getAddLabelIds() {
        return addLabelIds;
    }

    public void setAddLabelIds(List<String> addLabelIds) {
        this.addLabelIds = addLabelIds;
    }

    public List<String> getRemoveLabelIds() {
        return removeLabelIds;
    }

    public void setRemoveLabelIds(List<String> removeLabelIds) {
        this.removeLabelIds = removeLabelIds;
    }

    @Override
    public String toString() {
        return "MessageListModify{" +
                "ids=" + ids +
                ", addLabelIds=" + addLabelIds +
                ", removeLabelIds=" + removeLabelIds +
                '}';
    }
}
