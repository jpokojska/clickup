package com.clickup.tests.task;

import com.clickup.properties.ClickupProperties;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateTaskTest {

    @Test
    void updateTaskTest() {

        JSONObject task = new JSONObject();
        task.put("name", "Update task RA");
        task.put("description", "It is just a updated task");

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .body(task.toString())
                .when()
                .put("https://api.clickup.com/api/v2/task/2q372wk")
                .then()
                .log().all()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("Update task RA");
        Assertions.assertThat(response.jsonPath().getString("description")).isEqualTo("It is just a updated task");
    }
}
