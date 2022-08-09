package com.clickup.tests.task;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetTasksTest {

    @Test
    void getTasksTest(){

        final var response = given()
                .header("Authorization", ClickupProperties.getToken())
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.clickup.com/api/v2/list/198612878/task")
                .then()
                .log().all()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
}
