package com.clickup.requests.task;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {
    public static Response createTask(JSONObject task, String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(task.toString())
                .when()
                .post(ClickupUrl.getTasksUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
