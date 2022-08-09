package com.clickup.requests.space;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetSpacesRequest {

    public static Response getSpaces(String teamId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body("")
                .when()
                .get(ClickupUrl.getSpacesUrl(teamId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
