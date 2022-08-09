package com.clickup.requests.list;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteListRequest {
    public static Response deleteList(String listId) {


        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickupUrl.getListUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
