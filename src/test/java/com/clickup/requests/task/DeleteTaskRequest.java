package com.clickup.requests.task;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteTaskRequest {

    public static Response deleteTask(String taskId) {


        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickupUrl.getTaskUrl(taskId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
