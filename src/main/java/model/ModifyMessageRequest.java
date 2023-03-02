package model;

import java.util.List;

public class ModifyMessageRequest {
    private List<String> addLabelIds;
    private List<String> removeLabelIds;

    public ModifyMessageRequest() {
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
}
