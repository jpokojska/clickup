package com.clickup.tests.list;

import com.clickup.properties.ClickupProperties;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateListTest {

    @Test
    void createListTest() {
        JSONObject list = new JSONObject();
        list.put("name", "Lista RA");
        list.put("content", "New List Content");
        list.put("priority", 1);
        list.put("status", "red");

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .body(list.toString())
                .when()
                .post("https://api.clickup.com/api/v2/space/60709034/list")
                .then()
                .log().all()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("Lista RA");
        Assertions.assertThat(response.jsonPath().getString("content")).isEqualTo("New List Content");
    }
}
