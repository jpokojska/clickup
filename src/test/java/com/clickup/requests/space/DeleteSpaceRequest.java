package com.clickup.requests.space;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteSpaceRequest {
    public static Response deleteSpace(String spaceId) {


        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickupUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
