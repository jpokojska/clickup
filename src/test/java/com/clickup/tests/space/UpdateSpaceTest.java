package com.clickup.tests.space;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateSpaceTest {

    @Test
    void UpdateSpaceTest() {

        JSONObject space = new JSONObject();
        space.put("name", "Updated Space");

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .body(space.toString())
                .when()
                .put("https://api.clickup.com/api/v2/space/60708843")
                .then()
                .log().all()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("Updated Space");


    }
}
