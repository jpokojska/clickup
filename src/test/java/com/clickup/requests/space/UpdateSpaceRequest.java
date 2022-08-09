package com.clickup.requests.space;

import com.clickup.requests.BaseRequest;
import com.clickup.url.ClickupUrl;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateSpaceRequest {
    public static Response updateSpace(JSONObject updatedSpace, String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updatedSpace.toString())
                .when()
                .put(ClickupUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
