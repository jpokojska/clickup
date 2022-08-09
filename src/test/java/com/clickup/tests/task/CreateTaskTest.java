package com.clickup.tests.task;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateTaskTest {

    @Test
    void createTaskTest() {

        JSONObject task = new JSONObject();
        task.put("name", "Task RA");
        task.put("description", "It is just a sample task");


        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .body(task.toString())
                .when()
                .post("https://api.clickup.com/api/v2/list/198613012/task")
                .then()
                .log().all()
                .extract()
                .response();
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("Task RA");
        Assertions.assertThat(response.jsonPath().getString("description")).isEqualTo("It is just a sample task");
    }
}
