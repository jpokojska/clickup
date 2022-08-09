package com.clickup.requests.task;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class GetTasksRequest {

    public static Response getTasks(String listId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body("")
                .when()
                .get(ClickupUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
