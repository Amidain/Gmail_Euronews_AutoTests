package util;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.BatchModifyMessagesRequest;
import model.Message;
import model.MessageList;
import model.ModifyMessageRequest;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ApiRequests {

    private static final ISettingsFile CREDENTIALS_READER = new JsonSettingsFile("credentials.json");
    private static final ISettingsFile CONFIG_READER = new JsonSettingsFile("config.json");
    private static final ISettingsFile END_POINTS_READER = new JsonSettingsFile("end-points.json");
    private static RequestSpecification httpRequest = given();
    private static final String BASE_URI = END_POINTS_READER.getValue("/gmail_Api_resources/base_URI").toString();
    private static final String ACCESS_TOKEN = CREDENTIALS_READER.getValue("/authentication/access_token").toString();
    private static final String EMAIL = CONFIG_READER.getValue("/gmail/mail").toString();

    public static Response get(String endPoint) {
        httpRequest.baseUri(BASE_URI);
        return httpRequest
                    .auth().oauth2(ACCESS_TOKEN)
                    .contentType(ContentType.JSON)
                .when()
                    .get(endPoint);
    }

    public static Response post(String endPoint, Object object){
        httpRequest.baseUri(BASE_URI);
        return httpRequest
                    .auth().oauth2(ACCESS_TOKEN)
                .given()
                    .contentType("application/json")
                    .body(object)
                .when()
                    .post(endPoint);
    }

    public static MessageList getAllMessages (){

        String endPoint = String.format(END_POINTS_READER.getValue("/gmail_Api_resources/get_all_messages").toString(), EMAIL);
        return get(endPoint).as(new TypeRef<MessageList>() {});
    }

    public static Message getMessageById(String id){
        String endPoint = String.format(END_POINTS_READER.getValue("/gmail_Api_resources/get_message_by_id").toString(), EMAIL, id);
        return get(endPoint).as(new TypeRef<Message>() {});
    }

    public static Response markAllMessagesAsRead(){
        String endPoint = String.format(END_POINTS_READER.getValue("/gmail_Api_resources/post_batch_modify").toString(), EMAIL);
        String labelToRemove = "UNREAD";
        MessageList messageList = getAllMessages();
        List<String> messageIdsInInbox;

        if(messageList.getMessages() != null) {
            messageIdsInInbox = messageList.getMessages().stream().map(Message::getId).collect(Collectors.toList());
            BatchModifyMessagesRequest batchModifyMessages = new BatchModifyMessagesRequest();
            batchModifyMessages.setIds(messageIdsInInbox);
            batchModifyMessages.setRemoveLabelIds(List.of(labelToRemove));
            return post(endPoint, batchModifyMessages);
        }
        return null;
    }

    public static Response markMessageAsRead(String id){
        String endPoint = String.format(END_POINTS_READER.getValue("/gmail_Api_resources/post_message_modify").toString(), EMAIL, id);
        String labelToRemove = "UNREAD";
        ModifyMessageRequest modifyMessageRequest = new ModifyMessageRequest();
        modifyMessageRequest.setRemoveLabelIds(List.of(labelToRemove));
        return post(endPoint, modifyMessageRequest);
    }

    public static String extractLatestMessageId(){
        MessageList messageList = getAllMessages();
        while(messageList.getMessages() == null){
            messageList = getAllMessages();
        }
        return messageList.getMessages().get(0).getId();
    }
}
