package com.clickup.requests.task;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {

    public static Response updateTask(JSONObject updatedTask, String taskId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updatedTask.toString())
                .when()
                .put(ClickupUrl.getTaskUrl(taskId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
